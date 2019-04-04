/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.Client;
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
            ArrayList<Client> c = HibernateMethode.consultClientPgrm();
            Map<String,Client> mc= new TreeMap<String, Client>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj1.compareTo(obj2);
                    }
                });
            for(Client cli : c){
                mc.put(cli.getNomc().toString(), cli);
            }
         for (Map.Entry<String, Client> cc: mc.entrySet()) {
             System.out.println(cc.getKey());
         }


}
}
