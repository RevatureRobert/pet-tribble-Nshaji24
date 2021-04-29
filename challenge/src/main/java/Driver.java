import DAO.LabDAOImpl;
import DAO.TribbleDAOImpl;
import model.Lab;
import model.Tribble;

import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) throws SQLException {
        TribbleDAOImpl tribbleDAO = new TribbleDAOImpl();
        LabDAOImpl labDAO = new LabDAOImpl();

        Lab l = new Lab(1,22,"NJ",50);
        Tribble t = new Tribble(1,3,4,"Noel");

       // labDAO.save(l);
        //tribbleDAO.save(t);
    }

}
