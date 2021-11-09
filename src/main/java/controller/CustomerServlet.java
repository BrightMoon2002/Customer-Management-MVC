package controller;

import model.Customer;
import service.CustomerServiceImpl;
import service.ICustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {

    private ICustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateCustomer(request, response);
                break;
            case "edit":
                showEditCustomer(request, response);
                break;
            case "delete":
                showDeleteCustomer(request, response);
                break;
            case "view":
                showAllCustomer(request, response);
                break;
            default:
                break;
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                CreateNewCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.remove(customerService.findById(id));
        showAllCustomer(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int newId = Integer.parseInt(request.getParameter("newId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        try {
            Customer newCustomer = new Customer(newId, name, email, address);
            customerService.update(customerService.findIndexById(id), newCustomer);
        } catch (Exception e) {
            e.getMessage();
        }
        showAllCustomer(request, response);
    }

    private void CreateNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer newCustomer = inputInfoCustomer(request, response);
        customerService.save(newCustomer);
        showAllCustomer(request, response);
    }

    private Customer inputInfoCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        return new Customer(id, name, email, address);
    }
    private void showAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("ds", customerList);
        RequestDispatcher dispatcherCreat = request.getRequestDispatcher("customer/index.jsp");
        dispatcherCreat.forward(request, response);
    }

    private void showDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("ds", customerList);

        RequestDispatcher dispatcherCreat = request.getRequestDispatcher("customer/delete.jsp");
        dispatcherCreat.forward(request, response);
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcherCreat = request.getRequestDispatcher("customer/edit.jsp");
        dispatcherCreat.forward(request, response);
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcherCreat = request.getRequestDispatcher("customer/create.jsp");
        dispatcherCreat.forward(request, response);

    }


}
