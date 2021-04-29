package controller;

import DAO.TribbleDAOImpl;
import DAO.tribbleDAO;
import model.Tribble;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class ControllerServlet extends HttpServlet {
   private TribbleDAOImpl td;



   public ControllerServlet(){
       this.td =  new TribbleDAOImpl();
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       this.doGet(request,response);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       String action = request.getServletPath();

       switch (action){
           case "/new":
               showNewForm(request,response);
               break;
           case "/insert":
               try {
                   insertTribble(request,response);
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
               break;
           case "/delete":
               deleteTribble(request,response);
               break;
           case "/edit":
               showEditForm(request,response);
               break;
           case "/update":
               try {
                   updateTribble(request,response);
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
               break;
           default:
               listTribble(request,response);
               break;
       }
    }

    private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("tribble-form.jsp");
        dispatcher.forward(request,response);
    }

    private void insertTribble(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {
       int id = Integer.parseInt(request.getParameter("id"));
       int weight = Integer.parseInt(request.getParameter("weight"));
       int height = Integer.parseInt(request.getParameter("height"));
       String name = request.getParameter("name");
       Tribble newTribble = new Tribble(id,weight,height,name);
       td.save(newTribble);
       response.sendRedirect("list");
    }

    private void deleteTribble(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
       int id = Integer.parseInt(request.getParameter("id"));
       td.delete(id);
       response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
       int id = Integer.parseInt(request.getParameter("id"));
       Tribble existingTribble = td.get(id);
       RequestDispatcher dispatcher = request.getRequestDispatcher("tribble-form.jsp");
       request.setAttribute("tribble", existingTribble);
       dispatcher.forward(request,response);
    }

    private void updateTribble(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        int height = Integer.parseInt(request.getParameter("height"));
        String name = request.getParameter("name");
        Tribble tribble = new Tribble(id,weight,height,name);
        td.update(tribble);
        response.sendRedirect("list");

    }

    private void listTribble(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
       List<Tribble> listTribble = td.list();
       request.setAttribute("listTribble", listTribble);
       RequestDispatcher dispatcher = request.getRequestDispatcher("tribble-list.jsp");
       dispatcher.forward(request,response);
    }
}
