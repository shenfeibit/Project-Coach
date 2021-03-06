package Bd;
// Generated 30 mars 2019 16:35:04 by Hibernate Tools 4.3.1



/**
 * PossederseaId generated by hbm2java
 */
public class PossederseaId  implements java.io.Serializable {


     private int idseas;
     private int idexes;
     private int ordreExo;

    public PossederseaId() {
    }

    public PossederseaId(int idseas, int idexes, int ordreExo) {
       this.idseas = idseas;
       this.idexes = idexes;
       this.ordreExo = ordreExo;
    }
   
    public int getIdseas() {
        return this.idseas;
    }
    
    public void setIdseas(int idseas) {
        this.idseas = idseas;
    }
    public int getIdexes() {
        return this.idexes;
    }
    
    public void setIdexes(int idexes) {
        this.idexes = idexes;
    }
    public int getOrdreExo() {
        return this.ordreExo;
    }
    
    public void setOrdreExo(int ordreExo) {
        this.ordreExo = ordreExo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PossederseaId) ) return false;
		 PossederseaId castOther = ( PossederseaId ) other; 
         
		 return (this.getIdseas()==castOther.getIdseas())
 && (this.getIdexes()==castOther.getIdexes())
 && (this.getOrdreExo()==castOther.getOrdreExo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdseas();
         result = 37 * result + this.getIdexes();
         result = 37 * result + this.getOrdreExo();
         return result;
   }   


}


