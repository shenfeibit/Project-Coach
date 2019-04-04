/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import java.util.HashMap;

/**
 *
 * @author 21611945
 */
public class test {
     public static void main (String[] args) throws Exception
        {

             HashMap<String,Double[]> mres = HibernateMethode.evoluationBilan(3);
             for (String mes : mres.keySet()){
                 System.out.println(mes+" :"+ mres.get(mes)[0]+"/"+ mres.get(mes)[1]+"/"+ mres.get(mes)[2]);
             }
             
          

}
}
