package DAO;
import config.ConnectionUtil;
import model.Tribble;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionUtil;

public class TribbleDAOImpl implements tribbleDAO{


    private static final String INSERT_TRIBBLES = "INSERT INTO tribble" + "(id,weight,height,name) VALUES" +
            "(?,?,?,?);";

    private static final String SELECT_TRIBBLE_BY_ID = "select id,weight,height,name from tribble where id =?";
    private static final String SELECT_ALL_TRIBBLES = "select * from tribble";
    private static final String DELETE_TRIBBLE = "delete from tribble where id = ?;";
    private static final String UPDATE_TRIBBLE = "update tribble set id=?,weight=?,height=?,name=? where id = ?;";






    @Override
    public void save(Tribble tribble) throws SQLException {
        try{
            PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(INSERT_TRIBBLES);
            preparedStatement.setInt(1,tribble.getId());
            preparedStatement.setInt(2,tribble.getWeight());
            preparedStatement.setInt(3,tribble.getHeight());
            preparedStatement.setString(4,tribble.getName());
            preparedStatement.executeUpdate();
            System.out.println("Tribble created!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Tribble tribble) throws SQLException {
        boolean updated = false;
        try{
            PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(UPDATE_TRIBBLE);
            preparedStatement.setInt(1,tribble.getId());
            preparedStatement.setInt(2,tribble.getWeight());
            preparedStatement.setInt(3,tribble.getHeight());
            preparedStatement.setString(4,tribble.getName());
            preparedStatement.setInt(5,tribble.getId());
            updated =  preparedStatement.executeUpdate()  > 0;
            System.out.println("Tribble updated!");

        }catch (SQLException e){
            e.printStackTrace();
        }

        return updated;
    }

    @Override
    public Tribble get(Integer id) {
        Tribble tribble = null;
        try {
            PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(SELECT_TRIBBLE_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int tribbleId = rs.getInt("id");
                int weight = rs.getInt("weight");
                int height = rs.getInt("height");
                String name = rs.getString("name");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tribble;
    }

    @Override
    public boolean delete(Integer id) {
        boolean deleted = false;
        try {
            PreparedStatement preparedStatement= ConnectionUtil.getConnection().prepareStatement(DELETE_TRIBBLE);
            preparedStatement.setInt(1,id);
            deleted =  preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deleted;
    }

    @Override
    public List<Tribble> list() {
        List<Tribble> tribbles = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =  ConnectionUtil.getConnection().prepareStatement(SELECT_ALL_TRIBBLES);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int tribbleId = rs.getInt("id");
                int weight = rs.getInt("weight");
                int height = rs.getInt("height");
                String name = rs.getString("name");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tribbles;
    }
}
