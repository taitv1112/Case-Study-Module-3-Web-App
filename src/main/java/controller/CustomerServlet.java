package controller;

import model.Customer;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    RequestDispatcher requestDispatcher;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                List<Customer> customerList = customerService.getList();
                request.setAttribute("customer", customerList);
                request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
                break;

//            case "edit":
//                customerList = customerService.getList();
//                request.setAttribute("customer", customerList);
//                request.getRequestDispatcher("editCustomer.jsp").forward(request, response);
//                break;
//
//            case "delete":
//                try {
//                    deleteCustomer(request, response);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
//            default:
//                showList(request, response);
            default:response.sendRedirect("/views/loginCustomer.jsp");
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
                String user = request.getParameter("userName");
                String password = request.getParameter("password");
                Customer customer = customerService.checkLoginCustomer(user,password);
                if(customer == null){
                    response.sendRedirect("/loginCustomer.jsp");
                }else {
                    System.out.println("Login success ");
                    request.getRequestDispatcher("/home.jsp").forward(request,response);
                }
                break;
            case "register":
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String passwords = request.getParameter("passwords");
                String full_name = request.getParameter("full_name");
                String img = request.getParameter("img");
                customerService.save(new Customer( full_name,  passwords,  email,  phone,  address,  img));
                response.sendRedirect("/views/home.jsp");
                break;
            default: response.sendRedirect("/views/cart.jsp");
        }
    }
}
