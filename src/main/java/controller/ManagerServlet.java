package controller;

import model.Customer;
import model.Manager;
import service.ManagerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/admin")
public class ManagerServlet extends HttpServlet {
    ManagerServiceImpl managerService = new ManagerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("view/createCategory.jsp");
            default:response.sendRedirect("/views/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                String user = request.getParameter("username");
                String password = request.getParameter("password");
                Manager manager = managerService.checkLoginManager(user,password);
                if(manager == null){
                    response.sendRedirect("/views/login.jsp");
                }else {
                    System.out.println("Login success ");
                    request.getRequestDispatcher("/views/homeadmin.jsp").forward(request,response);
                }
                break;
            case "register": break;
//                String email = request.getParameter("email");
//                String address = request.getParameter("address");
//                String phone = request.getParameter("phone");
//                String passwords = request.getParameter("passwords");
//                String full_name = request.getParameter("full_name");
//                String img = request.getParameter("img");
//                customerService.save(new Customer( full_name,  passwords,  email,  phone,  address,  img));
//                response.sendRedirect("/views/home.jsp");
//                break;
            default: response.sendRedirect("/views/cart.html");
        }
    }
}
