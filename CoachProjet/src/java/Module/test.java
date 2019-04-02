
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
                 HashMap<Integer,Seanceperso> res = HibernateMethode.consultSeancesIdProgPerso(58);
            for(Integer i:res.keySet()){
                System.out.println(res.get(i).getLibsea() + "---"+ res.get(i).getTypesea());
            }
                
            
            
        }
}

