package edu.iit.sat.itmd4515.cmunegow.mp4.web;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Items;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Shipper;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Supplier;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.SupplierAddress;
import edu.iit.sat.itmd4515.cmunegow.mp4.service.SupplierService;
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
@WebServlet(name = "SupplierPortalTestServlet", urlPatterns = {"/supplierportal/", "/supplierportal"})
public class SupplierPortalTestServlet extends HttpServlet {

    @EJB
    private SupplierService supplierservice;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Displays Supplier Information.
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SupplierPortalTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h4>Servlet SupplierPortalTestServlet at " + request.getContextPath() + "</h4>");
            if (request.isUserInRole("supplier")) {
                Supplier s = supplierservice.findByUserName(request.getRemoteUser());
                
                SupplierAddress supAddr = s.getSupAddress();
                

                out.println("<h4>" + "Details Of Supplier" + "</h4>");
                out.println("<ul>");
                out.println("<li>" + "Supplier Email Address: " + s.getSupEmail() + "</li>");
                out.println("<li>" + "Supplier Phone: " + s.getSupPhone() + "</li>");
                out.println("<li>" + "Supplier Address: "  + "</li>");
                out.println("<ul>");
                out.println("<li>" + "City:" + supAddr.getCity()+"</li>");
                out.println("<li>" + "State:" + supAddr.getState()+"</li>");
                out.println("<li>" + "Pincode:" + supAddr.getZipcode()+"</li>");
                out.println("<li>" + "Country:" + supAddr.getCountry()+"</li>");
                out.println("</ul>");
                out.println("</ul>");
                
                
                List<Items> itemList = s.getSupItems();
                out.println("<h4>" + "Supplier Item List:" + "</h4>");
                out.println("<table border='1px'><thead><tr>");
                out.println("<th>" + "Item Name" + "</th>");
                out.println("<th>" + "Item Availability" + "</th>");
                out.println("</tr></thead>");
                
                for (int i = 0; i < itemList.size(); i++) {
                    Items item = itemList.get(i);
                    out.println("<tbody><tr>");
                    out.println("<td>" + item.getItemName() + "</td>");
                    out.println("<td>" + item.getItemAvailability() + "</td>");
                    out.println("</tr></tbody>");
                }
                out.println("</table>");

                out.println("<h4>" + "Shippers List:" + "</h4>");
                out.println("<table border='1px'><thead><tr>");
                out.println("<th>" + "Shipe Name" + "</th>");
                out.println("<th>" + "Ship PhoneNumber" + "</th>");
                out.println("<th>" + "Ship Id" + "</th>");
                out.println("</tr></thead>");
               
                List<Shipper> shipList = s.getShippers();
                for (int i = 0; i < shipList.size(); i++) {
                    Shipper ship = shipList.get(i);
                    out.println("<tbody><tr>");
                    out.println("<td>" + ship.getShipName() + "</td>");
                    out.println("<td>" + ship.getShipPhone() + "</td>");
                    out.println("<td>" + ship.getShipId() + "</td>");
                    out.println("</tr></tbody>");
                }
                out.println("</table><br><br>");
            }
            
            out.println("<a href=\"" + request.getContextPath() + "/logout\">Logout</a>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
