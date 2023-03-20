package edu.jcourse.city.dao.impl;

import edu.jcourse.city.config.Config;
import edu.jcourse.city.dao.ConnectionBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DirectConnectionBuilder implements ConnectionBuilder {

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD)
        );
    }
}