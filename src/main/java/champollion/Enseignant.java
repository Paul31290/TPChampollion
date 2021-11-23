package champollion;
import java.util.*;

public class Enseignant extends Personne {
    
    private final List<ServicePrevu> service = new ArrayList<>();    

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
       int heures = 0;
       Iterator<ServicePrevu> it =  service.iterator();
       while(it.hasNext()){
            ServicePrevu s=it.next();
            heures += (int) (s.getVolumeCM()*1.5 + s.getVolumeTD() + s.getVolumeTP()*0.75);
       }
       return heures;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        return (int) (ue.getHeuresCM()*1.5 + ue.getHeuresTD() + ue.getHeuresTP()*0.5);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
           ue.getIntitule();
           ServicePrevu s = new ServicePrevu(volumeCM,volumeTD,volumeTP);
           service.add(s);
           }
    
    public boolean estEnSousService(){
            if (heuresPrevues() < 192){
                return true;
            }
            return false;
        } 
    }
