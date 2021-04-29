package DAO;

import model.Tribble;

import java.sql.SQLException;
import java.util.List;

public interface tribbleDAO {
    public void save(Tribble tribble) throws SQLException;

    public boolean update(Tribble tribble) throws SQLException;

    public Tribble get(Integer id);

    public boolean delete(Integer id);

    public List<Tribble> list();

}
