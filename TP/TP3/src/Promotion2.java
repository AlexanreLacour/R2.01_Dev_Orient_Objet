/**
 * Promotion
 */
public class Promotion2 {
    private String nom;
    private Etudiant[] listeEtudiants;
    private int nbInscrits;

    public Promotion2(String nom, Etudiant[] liste){
        nbInscrits = liste.length;
        if((nom!=null)&&(nbInscrits != 0)){
            this.nom = nom;
            this.listeEtudiants = liste; /* Pas de copie defensive */
        }else{
            System.out.println("Il faut passer des valeurs en parametre");
            this.nom="";
            this.listeEtudiants = new Etudiant[0];
        }
    }

    public static void main(String[] args) {
        String[] matieres = {"Math", "Physique", "Chimie"};
        double[] coefficients = {0.3, 0.4, 0.3};
        int nbNotes = 5;
        Etudiant[] etudiant = new Etudiant[10];
        for (int i = 0; i < etudiant.length; i++) {
            etudiant[i] = new Etudiant("etudiant"+i, matieres, coefficients, nbNotes);
        }

        Promotion2 test = new Promotion2("test", etudiant);

        System.out.println(test.toString());
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public double moyenne(){
        double res = -1;

        if(this.listeEtudiants.length>0){
            res = 0;
            for (int i = 0; i < this.listeEtudiants.length; i++) {
                res = res + this.listeEtudiants[i].moyenneGeneral();
            }
            res = res/this.listeEtudiants.length;
        }

        return res;
    }

    public double moyenneMax(){
        double res = -1, moy;

        if(listeEtudiants.length>0){
            res = this.listeEtudiants[0].moyenneGeneral();
            for (int i = 1; i < this.listeEtudiants.length; i++) {
                moy = this.listeEtudiants[i].moyenneGeneral();
                if (moy>res) {
                    res = moy;
                }
            }
        }

        return res;
    }

    public double moyenneMin(){
        double res = 21, moy;

        if(listeEtudiants.length>0){
            res = this.listeEtudiants[0].moyenneGeneral();
            for (int i = 1; i < this.listeEtudiants.length; i++) {
                moy = this.listeEtudiants[i].moyenneGeneral();
                if (moy<res) {
                    res = moy;
                }
            }
        }

        return res;
    }

    public double moyenneMatiere(int i){
        double res = -1;

        if((this.listeEtudiants.length>0)&(i>=0)&(i<this.listeEtudiants[0].getNbMatieres())){
            res = 0;
            for (int j = 0; j < this.listeEtudiants.length; j++) {
                res = res + this.listeEtudiants[j].moyenneMatiere(i);
            }
            res = res / this.listeEtudiants.length;
        }

        return res;
    }

    public Etudiant getMajor(){
        Etudiant res = null, e;

        if (this.listeEtudiants.length>0) {
            res = this.listeEtudiants[0];
            for (int i = 0; i < this.listeEtudiants.length; i++) {
                e  =this.listeEtudiants[i];
                if (e.moyenneGeneral()>res.moyenneGeneral()){
                    res = e;
                }
            }
        }

        return res;
    }

    public Etudiant getEtudiant(String nom){
        Etudiant res = null;
        boolean trouve = false;
        int i = 0;

        if ((nom != null)&(this.listeEtudiants.length>0)) {
            while ((!trouve)&(i<this.listeEtudiants.length)) {
                if(this.listeEtudiants[i].getNom().equals(nom)){
                    res = this.listeEtudiants[i];
                    trouve = true;
                }else{
                    trouve = false;
                }
            }
        }

        return res;
    }

    public String toString(){
        String res = "";

        res += "------ "+getNom()+"------\n";
        res += "Nombre d'Etudiant : "+this.listeEtudiants.length + "\n";
        res += "Moyenne de la promotion : "+ this.moyenne()+"\n";
        res += "Moyenne Min promotion : " + this.moyenneMin() + "\n";
        res += "Moyenne Max promotion : " + this.moyenneMax() + "\n";
        res += "Major Promotion : " + this.getMajor().getNom() + "\n";
        res += "--------------------------\n";

        return res;
    }
}