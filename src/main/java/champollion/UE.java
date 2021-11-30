package champollion;

public class UE {
    private final String myIntitule;
    private int heuresTD;
    private int heuresCM;
    private int heuresTP;
    private Enseignant enseignant;
    private Intervention intervention;

    public UE(String intitule) {
        myIntitule = intitule;
    }

    public String getIntitule() {
        return myIntitule;
    }

    public int getHeuresTD() {
        return heuresTD;
    }

    public int getHeuresCM() {
        return heuresCM;
    }

    public int getHeuresTP() {
        return heuresTP;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public Intervention getIntervention() {
        return intervention;
    }
    
    public void setHeuresTD(int heuresTD) {
        this.heuresTD = heuresTD;
    }

    public void setHeuresCM(int heuresCM) {
        this.heuresCM = heuresCM;
    }

    public void setHeuresTP(int heuresTP) {
        this.heuresTP = heuresTP;
    }
    

    
}
