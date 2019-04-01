package Bd;
// Generated 30 mars 2019 16:35:04 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Seancestandard generated by hbm2java
 */
public class Seancestandard  implements java.io.Serializable {


     private Integer idseas;
     private String libseas;
     private String descripseas;
     private String typeseas;
     private Set possederseas = new HashSet(0);
     private Set possederpses = new HashSet(0);

    public Seancestandard() {
    }

    public Seancestandard(String libseas, String descripseas, String typeseas, Set possederseas, Set possederpses) {
       this.libseas = libseas;
       this.descripseas = descripseas;
       this.typeseas = typeseas;
       this.possederseas = possederseas;
       this.possederpses = possederpses;
    }
   
    public Integer getIdseas() {
        return this.idseas;
    }
    
    public void setIdseas(Integer idseas) {
        this.idseas = idseas;
    }
    public String getLibseas() {
        return this.libseas;
    }
    
    public void setLibseas(String libseas) {
        this.libseas = libseas;
    }
    public String getDescripseas() {
        return this.descripseas;
    }
    
    public void setDescripseas(String descripseas) {
        this.descripseas = descripseas;
    }
    public String getTypeseas() {
        return this.typeseas;
    }
    
    public void setTypeseas(String typeseas) {
        this.typeseas = typeseas;
    }
    public Set getPossederseas() {
        return this.possederseas;
    }
    
    public void setPossederseas(Set possederseas) {
        this.possederseas = possederseas;
    }
    public Set getPossederpses() {
        return this.possederpses;
    }
    
    public void setPossederpses(Set possederpses) {
        this.possederpses = possederpses;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.idseas);
        hash = 83 * hash + Objects.hashCode(this.libseas);
        hash = 83 * hash + Objects.hashCode(this.descripseas);
        hash = 83 * hash + Objects.hashCode(this.typeseas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seancestandard other = (Seancestandard) obj;
        if (!Objects.equals(this.libseas, other.libseas)) {
            return false;
        }
        if (!Objects.equals(this.descripseas, other.descripseas)) {
            return false;
        }
        if (!Objects.equals(this.typeseas, other.typeseas)) {
            return false;
        }
        if (!Objects.equals(this.idseas, other.idseas)) {
            return false;
        }
        return true;
    }




}


