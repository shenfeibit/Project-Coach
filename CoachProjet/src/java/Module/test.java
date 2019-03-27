
package Module;


import Bd.Programmeperso;



public class test {
     public static void main (String[] args){
        Programmeperso pp = new Programmeperso();
        pp = HibernateMethode.consultProgramClient(1);
        System.out.print(pp);
     }
}
