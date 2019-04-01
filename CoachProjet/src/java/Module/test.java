/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 21611924
 */
public class test {
     public static void main (String[] args) throws Exception
        {
            HashMap<Integer,Exerciseperso> mexp = HibernateMethode.showExePersoBySea(1);
            for (Integer i : mexp.keySet()){
                System.out.println(i+mexp.get(i).getLibexe());
            }
            

        }
}
