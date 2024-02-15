import java.util.Map;
import java.util.HashMap;

public class Journee{
    private Map<String,Integer> nbSpec;
    private Map<String,Style> style;


    public Journee(Style matin, int specMatin, Style apresMidi, int specApresMidi, Style soiree, int specSoiree) {
        this.nbSpec = new HashMap<>();
        this.style = new HashMap<>();
        
        this.nbSpec.put("Matin",specMatin);
        this.nbSpec.put("ApresMidi",specApresMidi);
        this.nbSpec.put("Soiree",specSoiree);

        this.style.put("Matin",matin);
        this.style.put("ApresMidi",apresMidi);
        this.style.put("Soiree",soiree);
    }

    public Style getStyle(Periode periode) {
        return this.style.get(periode.toString());
    }

    public int getNbSpec(Periode periode) {
        return this.nbSpec.get(periode.toString());
    }

    public int scoreJournee( Auteur auteur ){
        return this.scoreAuteur(auteur, Periode.MATIN)+this.scoreAuteur(auteur, Periode.APRESMIDI)+this.scoreAuteur(auteur, Periode.SOIREE);
    }

    public int scoreAuteur(Auteur auteur, Periode periode){
        return auteur.qualiteStyle(this.style.get(periode.toString()))*this.getNbSpec(periode);
    }

    public Auteur vainqueur(Auteur auteur1 , Auteur auteur2) {
        if (scoreJournee(auteur1)>scoreJournee(auteur2)) {
            return auteur1;
        }
        else {
            return auteur2;
        }
    }
}