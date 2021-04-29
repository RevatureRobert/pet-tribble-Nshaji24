package DAO;
import model.Lab;

import java.sql.SQLException;
import java.util.List;

public interface labDAO {
    public void save(Lab lab) throws SQLException;

    public boolean update(Lab lab) throws SQLException;

    public Lab get(Integer id);

    public boolean delete(Integer id);

    public List<Lab> list();
}

