package DAO;

import model.Lab;
import model.Tribble;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static config.ConnectionUtil.getConnection;

public class LabDAOImpl implements labDAO {



    private static final String INSERT_LAB = "INSERT INTO labs" + "(id,employee_number,location,capacity) VALUES" +
            "(?,?,?,?);";

    private static final String SELECT_LAB_BY_ID = "select id,employee_number,location,capacity from labs where id =?";
    private static final String SELECT_ALL_LABS = "select * from labs";
    private static final String DELETE_LAB = "delete from labs where id = ?;";
    private static final String UPDATE_LAB = "update labs set id=?,employee_number=?,location=?,capacity=? where id = ?;";


    @Override
    public void save(Lab lab) throws SQLException {
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_LAB);
            preparedStatement.setInt(1,lab.getLabId());
            preparedStatement.setInt(2,lab.getNumOfEmployees());
            preparedStatement.setString(3,lab.getLocation());
            preparedStatement.setInt(4,lab.getCapacity());
            preparedStatement.executeUpdate();
            System.out.println("Lab created!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Lab lab) throws SQLException {
        boolean updated = false;
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE_LAB);
            preparedStatement.setInt(1,lab.getLabId());
            preparedStatement.setInt(2,lab.getNumOfEmployees());
            preparedStatement.setString(3,lab.getLocation());
            preparedStatement.setInt(4,lab.getCapacity());
            updated = preparedStatement.executeUpdate() >0;
            System.out.println("Lab updated!");

        }catch (SQLException e){
            e.printStackTrace();
        }

        return updated;
    }

    @Override
    public Lab get(Integer id) {
        Lab lab = null;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_LAB_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int labId = rs.getInt("id");
                int numOfEmployees = rs.getInt("employee_number");
                String location = rs.getString("location");
                int capacity = rs.getInt("capacity");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lab;
    }

    @Override
    public boolean delete(Integer id) {
        boolean deleted = false;
        try {
            PreparedStatement preparedStatement= getConnection().prepareStatement(DELETE_LAB);
            preparedStatement.setInt(1,id);
            deleted =  preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deleted;
    }

    @Override
    public List<Lab> list() {
        List<Lab> lab = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =  getConnection().prepareStatement(SELECT_ALL_LABS);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int labId = rs.getInt("id");
                int numOfEmployees = rs.getInt("employee_number");
                String location = rs.getString("location");
                int capacity = rs.getInt("capacity");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lab;
    }
}


