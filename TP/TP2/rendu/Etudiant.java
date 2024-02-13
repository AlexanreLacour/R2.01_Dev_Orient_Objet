/**
 * Etudiant
 */
public class Etudiant {
    private String nom;
    private double[][] bulletin;
    private final String[] MATIERES;
    private final double[] COEFFICIENTS;

    /**
     * Constructs a new student 
     *
     * @param nom The name of the student.
     * @param matieres The array of lecon names.
     * @param coeff The array of coefficients for each lecon.
     * @param nbNotes The number of notes for each lecon.
     */
    public Etudiant(String nom, String[] matieres, double[] coeff, int nbNotes) {
        if((nom != null) && (matieres != null) && (coeff != null)){
            if((matieres.length == coeff.length) && (nbNotes > 0) && (coeff.length > 0)){
                this.nom = nom; // Pas de copie defensive a faire car string est un type immutable
                this.MATIERES = new String[matieres.length]; //Copie defensive du tableau
                for(int i = 0; i<matieres.length; i++){
                    this.MATIERES[i]=matieres[i];
                }
                this.COEFFICIENTS = new double[coeff.length];
                for(int i = 0; i<coeff.length; i++){
                    this.COEFFICIENTS[i] = coeff[i];
                }
                this.bulletin = new double[coeff.length][nbNotes];
                this.initialisation();
            }else{
                System.out.println("Il faut passer des parametres valides");
                this.nom = nom;
                this.MATIERES = new String[0];
                this.COEFFICIENTS = new double[0];
                this.bulletin = new double[0][0];
            }            
        }else{
            System.out.println("Il faut passer des parametres valides");
            this.nom = "";
            this.MATIERES = new String[0];
            this.COEFFICIENTS = new double[0];
            this.bulletin = new double[0][0];
        }
        
    }

    /**
     * Main method
     *
     * @param args an args
     */
    public static void main(String[] args) {
        // Création d'un objet Etudiant
        String[] matieres = {"Math", "Physique", "Chimie", "SVT"};
        double[] coefficients = {0.3, 0.4, 0.3, 05};
        int nbNotes = 5;
    
        Etudiant etudiant = new Etudiant("John Doe", matieres, coefficients, nbNotes);
    
        // Affichage complet de l'objet Etudiant
        System.out.println(etudiant.toString());

    }
    
    /**
     * Sets the name of the student.
     *
     * @param nom New name for the student.
     */
    public void setNom(String nom){
        if(nom != null){
            this.nom = nom;
        }else{
            System.out.println("Il faut rentrer une valeur non nul pour le nom");
            this.nom = null;
        }

    }

    /**
     * Gets the name of the student.
     *
     * @return Name of the student.
     */
    public String getNom(){
        String res;
        if(this.nom != null){
           res = this.nom;
        }else{
            System.out.println("Il faut rentrer une valeur non nul pour le nom");
            res = null;
        }
        return res;
    }

    /**
     * Gets the number of lecon.
     *
     * @return The number of lecon.
     */
    public int getNbMatieres(){
        return this.MATIERES.length;
    }

    /**
     * Gets the grade of the student.
     *
     * @param iMatiere The index of the lecon.
     * @param i        The index of the note.
     * @return The grade for the specified lecon and note.
     */
    public double getUneNote(int iMatiere, int i){
        double res = 0;
        if((iMatiere >= 0)&&(i >= 0)&&(iMatiere < bulletin.length)&&(i< bulletin[iMatiere].length)){
            res = this.bulletin[iMatiere][i];
        }else{
            System.out.println("Erreur, merci de saisir des parametres valides");
            res = -1;
        }
        return res;
    }

    /**
     * Initializes the grades for each lecon randomly.
     */
    private void initialisation() {
        for (int i = 0; i < bulletin.length; i++) {
            for (int j = 0; j < bulletin[i].length; j++) {
                this.bulletin[i][j] = 20 * Math.random();
            }
        }
    }

    /**
     * Calculates the average grade for a specific lecon.
     *
     * @param iMatiere The index of the lecon.
     * @return The average grade for the specified lecon.
     */
    public double moyenneMatiere(int iMatiere){
        double res = 0;

        if((iMatiere>=0)&&(iMatiere<this.MATIERES.length)&&(this.bulletin[iMatiere].length>0)){
            for(int i = 0; i < this.bulletin[iMatiere].length; i++){
                res += this.bulletin[iMatiere][i];
            }
            res = res/this.bulletin[iMatiere].length;
        }else{
            System.out.println("Il faut donner un numéro existant");
        }
        return res;
    }

    /**
     * Calculates the overall average grade.
     *
     * @return The overall average grade for the student.
     */
    public double moyenneGeneral(){
        double res = 0;
        double coeff = 0;

        for(int i = 0; i < this.bulletin.length; i++){
            res += this.moyenneMatiere(i) * this.COEFFICIENTS[i];
            coeff += this.COEFFICIENTS[i];
        }
        res = res/coeff;

        return res;
    }

    /**
     * Finds and returns information about the best grade.
     *
     * @return Information about the best grade.
     */
    public String meilleurNote(){
        String res;
        int matiereBest = -1;
        double best = 0;

        for(int i = 0; i<this.bulletin.length;i++){
            for(int j = 0; j<this.bulletin[i].length;j++){
                if(this.bulletin[i][j]>best){
                    best = this.bulletin[i][j];
                    matiereBest = i;
                }
            }
        }
        if(matiereBest != -1){
            res = "La meilleur note du bulletin est " + best + " dans la matiere "+ MATIERES[matiereBest]+".";
        }else{
            res = "Il n'y a pas de note où l'élève est les meilleur";
        }
        
        return res;
    }

    /**
     * Generates a string representation of the student's record.
     *
     * @return A string representation of the student's record.
     */
    public String toString(){
        String res;
        
        res = "--- Bulletin de "+nom+" ---\n\n\n";

        for(int i = 0; i<MATIERES.length;i++){
            res += "Matiere : "+MATIERES[i] +"\n ";
            for(int k = 0; k < bulletin[i].length; k++){
                res += bulletin[i][k] + "  ";
            }            
            res += "\n Moyenne : "+moyenneMatiere(i);
            res += "\n\n";
        }
        res += "Moyenne General :  "+moyenneGeneral();
        res += "\n \n"+meilleurNote();
        
        return res;
    }
}
