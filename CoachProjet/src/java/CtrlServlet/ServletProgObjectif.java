/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CtrlServlet;

import Bd.Programmestandard;
import Module.HibernateMethode;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 21511708
 */
public class ServletProgObjectif extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
            response.setContentType("application/xml;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                //write the page XML
                out.println("<?xml version=\"1.0\"?>");
		out.println("<list_progO>");
		//get the param
		String nom = request.getParameter("nomObj");
                //get the result
                try
                {
                    //get the result
                        ArrayList<Programmestandard> lps = HibernateMethode.lireProgObj(nom);

                        for (Programmestandard ps : lps)

                        {
                            out.println("<prog>");
                            out.println("<nom>" + ps.getLibps() + "</nom>");
                            out.println("<id>"+ps.getIdps()+"</id>");
                            out.println("</prog>");
                        }
                }
                catch (Exception ex)
                {
                    out.println("<erreur>ServletProgObjectif Erreur - " + ex.getMessage() + "</erreur>");
                }
            out.println("</list_progO>");
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
