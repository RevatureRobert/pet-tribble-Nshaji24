import DAO.TribbleDAOImpl;
import model.Tribble;

import java.sql.SQLException;

public class Driver {

    public static void main(String[] args) throws SQLException {
        TribbleDAOImpl tribbleDAO = new TribbleDAOImpl();

        Tribble t = new Tribble(1,3,4,"Noel");

        tribbleDAO.save(t);
    }

}
