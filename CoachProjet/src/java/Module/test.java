
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.Client;
import Bd.Objectif;
import Bd.Programmeperso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21611924
 */
public class test {
     public static void main (String[] args) throws Exception
             {
//            ArrayList<String> lss =HibernateMethode.verifCli(6);
//            for(String m : lss){
//                System.out.println(m);
//            }
//            ArrayList<String> l = HibernateMethode.verifCoach(1);
//            for(String ma : l){
//                System.out.println(ma);
//            }

//                boolean c = HibernateMethode.verifCoach(1,"David");
//                if(c)
//                {
//                    System.out.println("Dave");
//                }
//                else
//                {
//                    System.out.println("Non");
//                }
            List<Client> lstclients = HibernateMethode.verifierClient("Shen");
            List<Client> lstcliP = HibernateMethode.consultClientPgrm();
            ArrayList<Integer> listid = new ArrayList<Integer>();

            for(Client cp : lstcliP){
                listid.add(cp.getIdc());
                System.out.println(cp.getIdc() + "-");
            }
            for(Client c : lstclients){
                System.out.println(c.getIdc());
                System.out.println(listid.contains(c.getIdc()));
            }

        }

        }

