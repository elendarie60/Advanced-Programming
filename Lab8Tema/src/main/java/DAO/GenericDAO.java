package DAO;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public abstract class GenericDAO<T extends AbstractModel> {
    protected Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract void create(T model) throws SQLException;

    public abstract List<T> findAll() throws SQLException;

    public abstract T findByName(String name) throws SQLException;

    public abstract T findById(int id) throws SQLException;
}