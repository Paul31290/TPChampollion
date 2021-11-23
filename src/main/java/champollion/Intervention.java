package champollion;
import java.util.*;

public class Intervention {
    
    private final Date debut;
    private final int duree;
    private boolean annulee = false;
    private final int heureDebut;
    private final TypeIntervention intervention;
    private final Salle salle;

    public Intervention(Date debut, int duree, int heureDebut, TypeIntervention intervention, Salle salle) {
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
        this.intervention = intervention;
        this.salle = salle;
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

    public TypeIntervention getIntervention() {
        return intervention;
    }

    public Salle getSalle() {
        return salle;
    }
    
    
}
