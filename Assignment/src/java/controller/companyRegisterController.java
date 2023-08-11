/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAO.companyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name="companyRegisterController", urlPatterns={"/companyRegisterController"})
public class companyRegisterController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String name = request.getParameter("cname");
       String pass = request.getParameter("password");
       String cfpass = request.getParameter("cfpassword");
       String mail = request.getParameter("email");
       int telephone = Integer.parseInt(request.getParameter("phone"));
       String ps = request.getParameter("printstream");
       
       companyDAO dao = new companyDAO();
       
       if(pass.equals(cfpass)){
           if(ps.equals("IT")){
               int cpid = 1;
               dao.insertCompany(name, pass, mail, telephone, cpid);
               request.getRequestDispatcher("login.jsp").forward(request, response);
           }else if(ps.equals("Mechanical")){
               int cpid = 2;
               dao.insertCompany(name, pass, mail, telephone, cpid);
               request.getRequestDispatcher("login.jsp").forward(request, response);
           }else{
               int cpid = 3;
               dao.insertCompany(name, pass, mail, telephone, cpid);
               request.getRequestDispatcher("login.jsp").forward(request, response);
           }
       }else{
           request.setAttribute("wrong", "confirm pass not match. Enter again");
           request.getRequestDispatcher("userRegister.jsp").forward(request, response);
       }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
