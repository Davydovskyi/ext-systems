package edu.jcourse.city.dao.impl;

import edu.jcourse.city.dao.ConnectionBuilder;
import edu.jcourse.city.dao.PersonCheckDAO;
import edu.jcourse.city.domain.PersonRequest;
import edu.jcourse.city.domain.PersonResponse;
import edu.jcourse.city.exception.PersonCheckDAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCheckDAOImpl implements PersonCheckDAO {

    private static final String SQL_REQUEST = "SELECT temporal " +
            "FROM cr_address_person ap " +
            "         INNER JOIN cr_address ad ON ap.address_id = ad.address_id " +
            "         INNER JOIN cr_person pr ON ap.person_id = pr.person_id " +
            "WHERE upper(pr.sur_name) = upper(?) " +
            "  and upper(pr.given_name) = upper(?) " +
            "  and upper(pr.patronymic) = upper(?) " +
            "  and pr.date_of_birth = ? " +
            "  and ad.street_code = ? " +
            "  and upper(ad.building) = upper(?) " +
            "  and upper(ad.extension) = upper(?) " +
            "  and upper(ad.apartment) = upper(?)";

    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckDAOException {
        PersonResponse response = new PersonResponse();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_REQUEST)) {

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
