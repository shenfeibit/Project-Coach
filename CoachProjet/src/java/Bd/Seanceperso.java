package Bd;
// Generated 30 mars 2019 16:35:04 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Seanceperso generated by hbm2java
 */
public class Seanceperso  implements java.io.Serializable {


     private Integer idsea;
     private Programmeperso programmeperso;
     private String libsea;
     private String descrisea;
     private String typesea;
     private Integer ordresea;
     private int semainesea;

     private Double bras;
     private Double poitrine;
     private Double taille;
     private Double hanches;
     private Double cuisses;
     private Date datesea;
     private Set exercisepersos = new HashSet(0);

    public Seanceperso() {
    }

	
    public Seanceperso(Programmeperso programmeperso, String libsea, int semainesea) {
        this.programmeperso = programmeperso;
        this.libsea = libsea;
        this.semainesea = semainesea;
    }
    public Seanceperso(Programmeperso programmeperso, String libsea, String descrisea, String typesea, Integer ordresea, int semainesea, Double bras, Double poitrine, Double taille, Double hanches, Double cuisses, Date datesea, Set exercisepersos) {

       this.programmeperso = programmeperso;
       this.libsea = libsea;
       this.descrisea = descrisea;
       this.typesea = typesea;
       this.ordresea = ordresea;

       this.semainesea = semainesea;

       this.bras = bras;
       this.poitrine = poitrine;
       this.taille = taille;
       this.hanches = hanches;
       this.cuisses = cuisses;
       this.datesea = datesea;
       this.exercisepersos = exercisepersos;
    }
   
    public Integer getIdsea() {
        return this.idsea;
    }
    
    public void setIdsea(Integer idsea) {
        this.idsea = idsea;
    }
    public Programmeperso getProgrammeperso() {
        return this.programmeperso;
    }
    
    public void setProgrammeperso(Programmeperso programmeperso) {
        this.programmeperso = programmeperso;
    }
    public String getLibsea() {
        return this.libsea;
    }
    
    public void setLibsea(String libsea) {
        this.libsea = libsea;
    }
    public String getDescrisea() {
        return this.descrisea;
    }
    
    public void setDescrisea(String descrisea) {
        this.descrisea = descrisea;
    }
    public String getTypesea() {
        return this.typesea;
    }
    
    public void setTypesea(String typesea) {
        this.typesea = typesea;
    }
    public Integer getOrdresea() {
        return this.ordresea;
    }
    
    public void setOrdresea(Integer ordresea) {
        this.ordresea = ordresea;
    }

    public int getSemainesea() {
        return this.semainesea;
    }
    
    public void setSemainesea(int semainesea) {
        this.semainesea = semainesea;
    }

    public Double getBras() {
        return this.bras;
    }
    
    public void setBras(Double bras) {
        this.bras = bras;
    }
    public Double getPoitrine() {
        return this.poitrine;
    }
    
    public void setPoitrine(Double poitrine) {
        this.poitrine = poitrine;
    }
    public Double getTaille() {
        return this.taille;
    }
    
    public void setTaille(Double taille) {
        this.taille = taille;
    }
    public Double getHanches() {
        return this.hanches;
    }
    
    public void setHanches(Double hanches) {
        this.hanches = hanches;
    }
    public Double getCuisses() {
        return this.cuisses;
    }
    
    public void setCuisses(Double cuisses) {
        this.cuisses = cuisses;
    }
    public Date getDatesea() {
        return this.datesea;
    }
    
    public void setDatesea(Date datesea) {
        this.datesea = datesea;
    }
    public Set getExercisepersos() {
        return this.exercisepersos;
    }
    
    public void setExercisepersos(Set exercisepersos) {
        this.exercisepersos = exercisepersos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idsea);
        hash = 37 * hash + Objects.hashCode(this.libsea);
        hash = 37 * hash + Objects.hashCode(this.descrisea);
        hash = 37 * hash + Objects.hashCode(this.typesea);
        hash = 37 * hash + Objects.hashCode(this.ordresea);
        hash = 37 * hash + this.semainesea;
        hash = 37 * hash + Objects.hashCode(this.bras);
        hash = 37 * hash + Objects.hashCode(this.poitrine);
        hash = 37 * hash + Objects.hashCode(this.taille);
        hash = 37 * hash + Objects.hashCode(this.hanches);
        hash = 37 * hash + Objects.hashCode(this.cuisses);
        hash = 37 * hash + Objects.hashCode(this.datesea);
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
        final Seanceperso other = (Seanceperso) obj;
        if (this.semainesea != other.semainesea) {
            return false;
        }
        if (!Objects.equals(this.libsea, other.libsea)) {
            return false;
        }
        if (!Objects.equals(this.descrisea, other.descrisea)) {
            return false;
        }
        if (!Objects.equals(this.typesea, other.typesea)) {
            return false;
        }
        if (!Objects.equals(this.idsea, other.idsea)) {
            return false;
        }
        if (!Objects.equals(this.ordresea, other.ordresea)) {
            return false;
        }
        if (!Objects.equals(this.bras, other.bras)) {
            return false;
        }
        if (!Objects.equals(this.poitrine, other.poitrine)) {
            return false;
        }
        if (!Objects.equals(this.taille, other.taille)) {
            return false;
        }
        if (!Objects.equals(this.hanches, other.hanches)) {
            return false;
        }
        if (!Objects.equals(this.cuisses, other.cuisses)) {
            return false;
        }
        if (!Objects.equals(this.datesea, other.datesea)) {
            return false;
        }
        return true;
    }




}


