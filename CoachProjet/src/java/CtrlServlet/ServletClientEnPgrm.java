/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CtrlServlet;

import Bd.Client;
import Bd.Programmeperso;
import Module.HibernateMethode;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
                out.println("<list_idClient>");
                //get the param

                try{
                    //get the result
                    ArrayList<Client> c = HibernateMethode.consultClientPgrm();
                    HashMap<String,Client> listecli=new HashMap<>();
                    for(Client cli : c){
                        listecli.put(cli.getNomc(), cli);
                    }
                    
                    for (String nomci : listecli.keySet())
                    {
                    out.println("<client>");
                    out.print("<id>"+listecli.get(nomci).getIdc()+"</id>");
                    out.println("<nom>"+listecli.get(nomci).getNomc()+"</nom>");
                    out.println("<prenom>"+listecli.get(nomci).getPrenomc()+"</prenom>");
                    out.println("<sexe>"+listecli.get(nomci).getSexec()+"</sexe>");
                    out.println("<image>"+listecli.get(nomci).getPhotoc()+"</image>");
                    Programmeperso prog=HibernateMethode.seeProgrammeCli(listecli.get(nomci).getIdc());
                    out.println("<nomprog>"+prog.getLibpp()+"</nomprog>");
                    float k = 0;
                    k = HibernateMethode.seeProgressionProg(listecli.get(nomci).getIdc());
                    int res = Math.round(k*100);
                    out.println("<percent>"+res+"</percent>");
                    out.println("</client>");                    
                    }
                }
                catch (Exception ex)
		{
                    out.println("<erreur>ServletClientEnPgrm Erreur - " + ex.getMessage() + "</erreur>");
		}
                    out.println("</list_idClient>");

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
