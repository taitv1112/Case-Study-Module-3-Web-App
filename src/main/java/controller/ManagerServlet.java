package controller;

import model.*;
import service.CategoryService;
import service.ManagerServiceImpl;
import service.ProductService;
import service.SupplierService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/admin")
public class ManagerServlet extends HttpServlet {
    ManagerServiceImpl managerService = new ManagerServiceImpl();
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    SupplierService supplierService = new SupplierService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "product":
                dispatcher= request.getRequestDispatcher("/views/products.jsp");
                List<Product> productList = null;
                try {
                    productList = productService.getList();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("productList", productList);
                dispatcher.forward(request, response);
                break;
            case "editProduct":
                dispatcher = request.getRequestDispatcher("/views/edit-product.jsp");
                String name = request.getParameter("name");
                try {
                    HttpSession session = request.getSession();
                    Product product = productService.getProductByName(name);
                    session.setAttribute("product",product);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dispatcher.forward(request, response);

                break;
            case "addProduct":
                dispatcher = request.getRequestDispatcher("/views/add-product.jsp");
                try {
                    List<Category> categoryList = categoryService.getList();
                    List<Supplier> supplierList = supplierService.getList();
                    request.setAttribute("categoryList", categoryList);
                    request.setAttribute("supplierList", supplierList);
                    dispatcher.forward(request, response);
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;

            default:response.sendRedirect("/views/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                String user = request.getParameter("username");
                String password = request.getParameter("password");
                Manager manager = managerService.checkLoginManager(user,password);
                session.setAttribute("manager",manager);
                if(manager == null){
                    response.sendRedirect("/views/login.jsp");
                }else {
                    System.out.println("Login success ");
                    request.getRequestDispatcher("/views/homeAdmin.jsp").forward(request,response);
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
            case "createProduct":

            default: response.sendRedirect("/views/cart.jsp");
        }
    }
}
