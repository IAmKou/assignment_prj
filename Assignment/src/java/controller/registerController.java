/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAO.userDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ACER
 */
@WebServlet(name="registerController", urlPatterns={"/registerController"})
public class registerController extends HttpServlet {
   
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
        userDAO dao = new userDAO();
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String cfpass = request.getParameter("cfpassword");
        String mail = request.getParameter("email");
        String DoB = request.getParameter("dob");
        SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
        int phonenum = Integer.parseInt(request.getParameter("phone"));
        String gender = request.getParameter("gender");
        String purpose = request.getParameter("purpose");
        if(pass.equals(cfpass)){
            if(purpose.equals("Seeker")){
                int tid = 1;
                try {        
                    java.util.Date date = availDate.parse(DoB);
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    dao.insertUser(user, pass, mail,sqlDate, phonenum, gender, tid);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
        }
            }else{
                int tid = 2;
                try {        
                 java.util.Date date = availDate.parse(DoB);
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    dao.insertUser(user, pass, mail,sqlDate, phonenum, gender, tid);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
        }
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
