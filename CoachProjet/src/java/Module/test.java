/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.Client;
import Bd.Exerciseperso;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author 21611945
 */
public class test {
     public static void main (String[] args) throws Exception
        {
            Exerciseperso ep = HibernateMethode.showExe(21);
                String photo;
                if(ep.getPhotoexe().equals("")){
                    photo = "Bon Courage";
                }else{
                    photo = ep.getPhotoexe();
                }
                System.out.println("<photoexe>"+photo+"</photoexe>");

}
}
