
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
import Bd.Seanceperso;
import java.util.ArrayList;
import java.util.HashMap;

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

                boolean c = HibernateMethode.verifCoach(1,"David");
                if(c)
                {
                    System.out.println("Dave");
                }
                else
                {
                    System.out.println("Non");
                }

        }

        }

