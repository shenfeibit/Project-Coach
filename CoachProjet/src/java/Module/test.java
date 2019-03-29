/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.Exerciseperso;
import Bd.Programmeperso;
import Bd.Programmestandard;
import Bd.Seancestandard;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 21611924
 */
public class test {
     public static void main (String[] args) throws Exception
        {
            HashMap<Integer,Exerciseperso> lex = HibernateMethode.showExePersoBySea(1);
            for(int i :lex.keySet()){
                System.out.println(lex.get(i).getOrdreexe());
                System.out.println(lex.get(i).getLibexe());
            }
//            System.out.println(HibernateMethode.seeProgressionProg(1));
        }
}
