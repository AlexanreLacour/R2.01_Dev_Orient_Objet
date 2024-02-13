/**
 * Class representing a Promotion.
 */


public class Promotion {
    /**
     * The name of the promotion.
     */
    private String nom;
    /**
     * Array containing the students in the promotion.
     */
    private Etudiant[] listeEtudiants;

    /**
     * Constructor for Promotion class.
     * @param nom The name of the promotion.
     * @param liste The array of students in the promotion.
     */
    public Promotion(String nom, Etudiant[] liste){
        if((nom != null) && (liste != null)){
            this.nom = nom;
            this.listeEtudiants = liste; /* No defensive copy */
        }else{
            System.out.println("Values must be passed as parameters");
            this.nom = "";
            this.listeEtudiants = new Etudiant[0];
        }
    }

    /**
     * Main method.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

    }

    /**
     * Get the name of the promotion.
     * @return The name of the promotion.
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Set the name of the promotion.
     * @param nom The name of the promotion.
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Calculate the average grade of the promotion.
     * @return The average grade of the promotion.
     */
    public double moyenne(){
        double res = -1;

        if(this.listeEtudiants.length > 0){
            res = 0;
            for (int i = 0; i < this.listeEtudiants.length; i++) {
                res = res + this.listeEtudiants[i].moyenneGeneral();
            }
            res = res / this.listeEtudiants.length;
        }

        return res;
    }

    /**
     * Calculate the maximum average grade in the promotion.
     * @return The maximum average grade in the promotion.
     */
    public double moyenneMax(){
        double res = -1, moy;

        if(listeEtudiants.length > 0){
            res = this.listeEtudiants[0].moyenneGeneral();
            for (int i = 1; i < this.listeEtudiants.length; i++) {
                moy = this.listeEtudiants[i].moyenneGeneral();
                if (moy > res) {
                    res = moy;
                }
            }
        }

        return res;
    }

    /**
     * Calculate the minimum average grade in the promotion.
     * @return The minimum average grade in the promotion.
     */
    public double moyenneMin(){
        double res = 21, moy;

        if(listeEtudiants.length > 0){
            res = this.listeEtudiants[0].moyenneGeneral();
            for (int i = 1; i < this.listeEtudiants.length; i++) {
                moy = this.listeEtudiants[i].moyenneGeneral();
                if (moy < res) {
                    res = moy;
                }
            }
        }

        return res;
    }

    /**
     * Calculate the average grade of a specific subject in the promotion.
     * @param i The index of the subject.
     * @return The average grade of the subject.
     */
    public double moyenneMatiere(int i){
        double res = -1;

        if((this.listeEtudiants.length > 0) && (i >= 0) && (i < this.listeEtudiants[0].getNbMatieres())){
            res = 0;
            for (int j = 0; j < this.listeEtudiants.length; j++) {
                res = res + this.listeEtudiants[j].moyenneMatiere(i);
            }
            res = res / this.listeEtudiants.length;
        }

        return res;
    }

    /**
     * Get the student with the highest average grade in the promotion.
     * @return The student with the highest average grade.
     */
    public Etudiant getMajor(){
        Etudiant res = null, e;

        if (this.listeEtudiants.length > 0) {
            res = this.listeEtudiants[0];
            for (int i = 0; i < this.listeEtudiants.length; i++) {
                e = this.listeEtudiants[i];
                if (e.moyenneGeneral() > res.moyenneGeneral()){
                    res = e;
                }
            }
        }

        return res;
    }

    /**
     * Get the student with the given name from the promotion.
     * @param nom The name of the student.
     * @return The student with the given name.
     */
    public Etudiant getEtudiant(String nom){
        Etudiant res = null;
        boolean trouve = false;
        int i = 0;

        if ((nom != null) && (this.listeEtudiants.length > 0)) {
            while ((!trouve) && (i < this.listeEtudiants.length)) {
                if(this.listeEtudiants[i].getNom().equals(nom)){
                    res = this.listeEtudiants[i];
                    trouve = true;
                } else {
                    trouve = false;
                }
            }
        }

        return res;
    }

    /**
     * Generate string representation of the Promotion object.
     * @return String representation of the Promotion object.
     */
    public String toString(){
        String res = "";

        res += "------ " + getNom() + " ------\n";
        res += "Number of Students: " + this.listeEtudiants.length + "\n";
        res += "Promotion Average: " + this.moyenne() + "\n";
        res += "Promotion Minimum Average: " + this.moyenneMin() + "\n";
        res += "Promotion Maximum Average: " + this.moyenneMax() + "\n";
        res += "Promotion Major: " + this.getMajor().getNom() + "\n";
        res += "--------------------------\n";

        return res;
    }
}