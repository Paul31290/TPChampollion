package champollion;
import java.util.*;

public class Intervention {
    
    private final Date debut;
    private final int duree;
    private boolean annulee = false;
    private final int heureDebut;
    private final TypeIntervention intervention;
    private final Salle salle;
    private UE ue;

    public Intervention(Date debut, int duree, int heureDebut, TypeIntervention intervention, Salle salle, UE ue) {
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
        this.intervention = intervention;
        this.salle = salle;
        this.ue = ue;
    } 
    
    
    public Intervention(TypeIntervention intervention, UE ue, int duree) {
        this.debut = new Date("01/01/2001");
        this.duree = duree;
        this.intervention = intervention;
        this.heureDebut = 10;
        this.salle = new Salle("101", 36);
        this.ue = ue;
    }
    
    public Date getDebut() {
        return debut;
    }
    
    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public TypeIntervention getTypeIntervention() {
        return intervention;
    }

    public Salle getSalle() {
        return salle;
    }

    public UE getUe() {
        return ue;
    }
    
    
}
