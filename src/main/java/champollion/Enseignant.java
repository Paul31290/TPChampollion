package champollion;
import java.util.*;

public class Enseignant extends Personne {
    
    private final List<ServicePrevu> listService = new LinkedList<>();   
    private final Set<Intervention> listIntervention = new HashSet<>();

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
       Iterator<ServicePrevu> it =  listService.iterator();
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
        int somme = 0;
        for(ServicePrevu s : listService){
            if(s.getUe() == ue){
                somme += (int) (s.getVolumeCM()*1.5 + s.getVolumeTD() + s.getVolumeTP()*0.75);
            }
        }
        return somme;
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
        listService.add(new ServicePrevu(volumeCM,volumeTD,volumeTP,ue,this));        
    }
        
        
    public boolean estEnSousService(){
            if (heuresPrevues() < 192){
                return true;
            }
            return false;
    }
    
    public void ajouteIntervention(Intervention inter){
            listIntervention.add(inter);
    }
    
    public int resteAPlanifier(UE ue, TypeIntervention type){
        int sommePlanifier = 0;
        
        for(Intervention inter : listIntervention){
            if (inter.getTypeIntervention().equals(type) && inter.getUe().equals(ue)){
                sommePlanifier += inter.getDuree();
            }
        }
        
        for(ServicePrevu s : listService){
           if(s.getUe().equals(ue)){
               switch (type){
                   case TP: sommePlanifier -= s.getVolumeTP();
                   case TD: sommePlanifier -= s.getVolumeTD();
                   case CM: sommePlanifier -= s.getVolumeCM();
                   break;
               }
           } 
        }
           
        return (int) sommePlanifier;
        
    }
}
