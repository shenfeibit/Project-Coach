
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.Client;
import Bd.Programmeperso;
import java.util.ArrayList;


/**
 *
 * @author 21611924
 */
public class test {
     public static void main (String[] args) throws Exception

             {
                 ArrayList<Client> listcli = HibernateMethode.consultClientNonPgrm();
                 for(Client c: listcli){
                     System.out.println(c.getNomc());
                 }
                 

        }
}

