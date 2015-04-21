package edu.iit.sat.itmd4515.cmunegow.mp4.web;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Customer;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.CustomerAddress;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Items;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.OrderItems;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Orders;
import edu.iit.sat.itmd4515.cmunegow.mp4.service.CustomerService;
import edu.iit.sat.itmd4515.cmunegow.mp4.service.ItemService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chetan Munegowda
 */
@WebServlet(name = "CustomerPortalTestServlet", urlPatterns = {"/customerportal", "/customerportal/"})
public class CustomerPortalTestServlet extends HttpServlet {

    @EJB
    private CustomerService custService;

    @EJB
    private ItemService itmService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Also displays the customer information
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerPortalTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Servlet CustomerPortalTestServlet at " + request.getContextPath() + "</h3>");

            if (request.isUserInRole("customer")) {

                Customer cust = custService.findByUserName(request.getRemoteUser());
                CustomerAddress custAddr = cust.getCustAddress();
                List<Orders> ordList = cust.getOrder();

                out.println("<h4>" + "Details Of Customer -" + cust.getCustName() + "</h4>");
                out.println("<table border='1px'><thead><tr>");
                out.println("<th>" + "Customer Phone" + "</th>");
                out.println("<th>" + "Customer Card Number" + "</th>");
                out.println("<th>" + "Customer Email" + "</th>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td>" + cust.getCustPhone() + "</td>");
                out.println("<td>" + cust.getCardNumber() + "</td>");
                out.println("<td>" + cust.getCustEmail() + "</td>");
                out.println("</tr>");
                out.println("</table>");

                out.println("<h4>" + "Details Of Customer Address: " + "<h4>");
                out.println("<ul>");
                out.println("<li>" + "City:" + custAddr.getCity() + "</li>");
                out.println("<li>" + "State:" + custAddr.getState() + "</li>");
                out.println("<li>" + "Country:" + custAddr.getCountry() + "</li>");
                out.println("<li>" + "Pin Code:" + custAddr.getZipcode() + "</li>");
                out.println("</ul>");

                out.println("<h4>" + "Customer Order Details: " + "<h4>");
                for (int i = 0; i < ordList.size(); i++) {
                    Orders order = ordList.get(i);
                    out.println("<h4>" + "Order Id:" + order.getOrderId() + "</h4>");

                    out.println("<h4>" + "Order Item Details: " + "</h4>");

                    out.println("<table><thead><tr>");
                    out.println("<th>" + "Item Id" + "</th>");
                    out.println("<th>" + "Order Item Cost" + "</th>");
                    out.println("<th>" + "Order Item Quantity" + "</th>");
                    out.println("<th>" + "Item Name" + "</th>");
                    out.println("</tr>");
                    List<OrderItems> oiList = order.getOrdItems();
                    for (int j = 0; j < oiList.size(); j++) {
                        OrderItems ordItem = oiList.get(j);
                        Items item = itmService.findItemById(ordItem.getItemId());
                        out.println("<tr>");
                        out.println("<td>" + ordItem.getItemId() + "</td>");
                        out.println("<td>" + ordItem.getOrdItemCost() + "</td>");
                        out.println("<td>" + ordItem.getOrdItemQuantity() + "</td>");
                        out.println("<td>" + item.getItemName() + "</td>");
                        out.println("</tr><br/>");
                    }
                }
                out.println("</table>");

            }
            out.println("<a href=\"" + request.getContextPath() + "/logout\">Logout</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
