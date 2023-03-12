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

    private static final String SQL_REQUEST = "";

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
