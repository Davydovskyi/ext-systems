package edu.jcourse.city.dao.impl;

import edu.jcourse.city.dao.ConnectionBuilder;
import edu.jcourse.city.dao.PersonCheckDAO;
import edu.jcourse.city.domain.PersonRequest;
import edu.jcourse.city.domain.PersonResponse;
import edu.jcourse.city.exception.PersonCheckDAOException;

import java.sql.*;

public class PersonCheckDAOImpl implements PersonCheckDAO {

    private static final String SQL_REQUEST = "SELECT temporal " +
            "FROM cr_address_person ap " +
            "         INNER JOIN cr_address ad ON ap.address_id = ad.address_id " +
            "         INNER JOIN cr_person pr ON ap.person_id = pr.person_id " +
            "WHERE CURRENT_DATE >= ap.start_date " +
            "  and (CURRENT_DATE <= ap.end_date or ap.end_date is null) " +
            "  and upper(pr.sur_name) = upper(?) " +
            "  and upper(pr.given_name) = upper(?) " +
            "  and upper(pr.patronymic) = upper(?) " +
            "  and pr.date_of_birth = ? " +
            "  and ad.street_code = ? " +
            "  and upper(ad.building) = upper(?) ";

    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckDAOException {
        PersonResponse response = new PersonResponse();

        String sql = SQL_REQUEST;
        if (request.getExtension() != null) {
            sql += "and upper(ad.extension) = upper(?) ";
        } else {
            sql += "and ad.extension is null ";
        }

        if (request.getApartment() != null) {
            sql += "and upper(ad.apartment) = upper(?)";
        } else {
            sql += "and ad.apartment is null";
        }

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            int index = 1;
            preparedStatement.setString(index++, request.getSurName());
            preparedStatement.setString(index++, request.getGivenName());
            preparedStatement.setString(index++, request.getPatronymic());
            preparedStatement.setDate(index++, Date.valueOf(request.getDateOfBirth()));
            preparedStatement.setInt(index++, request.getStreetCode());
            preparedStatement.setString(index++, request.getBuilding());
            if (request.getExtension() != null) {
                preparedStatement.setString(index++, request.getExtension());
            }
            if (request.getApartment() != null) {
                preparedStatement.setString(index, request.getApartment());
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                response.setRegistered(true);
                response.setTemporal(resultSet.getBoolean("temporal"));
            }

            resultSet.close();
        } catch (SQLException e) {
            throw new PersonCheckDAOException(e);
        }
        return response;
    }

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }
}
