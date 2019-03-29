/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CtrlServlet;

import Bd.Client;
import Bd.Objectif;
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
public class ServletClientEnPgrm extends HttpServlet {

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
                out.println("<list_idPgrm>");
                //get the param

                try{
                    //get the result
                    ArrayList<Client> c = HibernateMethode.consultClientPgrm();

                    for (Client ci : c)
                    {
                    out.println("<client>");
                    out.print("<id>"+ci.getIdc()+"</id>");
                    out.println("<nom>"+ci.getNomc()+"</nom>");
                    out.println("<prenom>"+ci.getPrenomc()+"</prenom>");
                    out.println("<sexe>"+ci.getSexec()+"</sexe>");
                    out.println("<image>"+ci.getPhotoc()+"</image>");

                    
                    out.println("</client>");

                    }
                }
                catch (Exception ex)
		{
                    out.println("<erreur>ServletShowInfoCli Erreur - " + ex.getMessage() + "</erreur>");
		}
                    out.println("</list_idPgrm>");





//            out.println("<?xml version=\"1.0\"?>");
//            out.println("<list_idPgrm>");
//            ArrayList<Client> listid = HibernateMethode.consultClientPgrm();
//
//            for(Client l : listid){
//                out.print("<client>");
//               out.print("<id>"+l.getIdc()+"</id>");
//               out.print("<nom>"+l.getNomc()+"</nom>");
//               out.print("</client>");
//            }
//
//            out.println("</list_idPgrm>");
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
