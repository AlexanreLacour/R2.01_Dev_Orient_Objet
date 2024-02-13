/**
 * Rationnel class represents rational numbers with a numerator and a denominator.
 */
public class Rationnel {
    private int numerateur;
    private int denominateur;


    public static void main(String[] args) {

    }
    

    /**
     * Constructs a Rationnel object with a given numerator and denominator.
     * 
     * @param n An integer representing the numerator.
     * @param d An integer representing the denominator.
     */
    public Rationnel(int n, int d) {
        if (d == 0) {
            System.out.println("Erreur : Le dénominateur ne peut pas être égal à 0.");
        } else if (d < 0) {
            // Si le dénominateur est < 0, change le signe du numérateur
            this.numerateur = -n;
            this.denominateur = -d;
        } else {
            this.numerateur = n;
            this.denominateur = d;
        }
        this.reduit();
    }
    



    /**
     * Gets the numerator of the rational number.
     * 
     * @return The numerator as an integer.
     */
    public int getNumerateur(){
        int res;

        res = this.numerateur;

        return res;
    }

    /**
     * Sets the numerator of the rational number.
     * 
     * @param numerateur The new numerator.
     */
    public void setNumerateur(int numerateur){
        this.numerateur = numerateur;
        this.reduit();

        //verifier si c'est reductible

        
    }

    /**
     * Gets the denominator of the rational number.
     * 
     * @return The denominator as an integer.
     */
    public int getDenominateur(){
        int res;

        res  = this.denominateur;

        return res;
    }

    /**
     * Sets the denominator of the rational number.
     * 
     * @param denominateur The new denominator.
     */
    public void setDenominateur(int denominateur){
        if(denominateur == 0){
            System.out.println("Erreur un denominateur ne peut etre egale a 0.");
        }else{
            this.denominateur = denominateur;
        }
        this.reduit();
        // verifier si reductible

    }

    /**
     * Returns the inverse of the rational number.
     * 
     * @return A new Rationnel object representing the inverse.
     */
    public Rationnel inverse(){
        int temp, n, d;
        Rationnel res = null;

        temp = getNumerateur();
        n  = getDenominateur();
        d = temp;

        res = new Rationnel(n, d);

        return res;
    }

    /**
     * Adds another rational number to this rational number.
     * 
     * @param autre Another Rationnel object to add.
     * @return A new Rationnel object representing the sum.
     */
    public Rationnel ajoute(Rationnel autre) {
        int nouveauNumerateur = numerateur * autre.getDenominateur() + autre.getNumerateur() * denominateur;
        int nouveauDenominateur = denominateur * autre.getDenominateur();
        return new Rationnel(nouveauNumerateur, nouveauDenominateur);
    }

    /**
     * Subtracts another rational number from this rational number.
     * 
     * @param autre Another Rationnel object to subtract.
     * @return A new Rationnel object representing the difference.
     */
    public Rationnel soustrait(Rationnel autre) {
        int nouveauNumerateur = numerateur * autre.getDenominateur() - autre.getNumerateur() * denominateur;
        int nouveauDenominateur = denominateur * autre.getDenominateur();
        return new Rationnel(nouveauNumerateur, nouveauDenominateur);
    }

    /**
     * Multiplies this rational number by another rational number.
     * 
     * @param autre Another Rationnel object to multiply by.
     * @return A new Rationnel object representing the product.
     */
    public Rationnel multiplie(Rationnel autre) {
        int nouveauNumerateur = numerateur * autre.getNumerateur();
        int nouveauDenominateur = denominateur * autre.getDenominateur();
        return new Rationnel(nouveauNumerateur, nouveauDenominateur);
    }

    /**
     * Checks if this rational number is equal to another rational number.
     * 
     * @param r Another Rationnel object to compare.
     * @return True if they are equal, false otherwise.
     */
    @SuppressWarnings("null")
    public Boolean egale(Rationnel r){
        boolean res;
        int rDenominateur, rNumerateur;

        if(r != null){
            rDenominateur = r.getDenominateur();
            rNumerateur =r.getNumerateur();
            if(rDenominateur == this.denominateur && rNumerateur== this.numerateur){
                res = true;
            }else{
                res = false;
            }

        }else{
            res = (Boolean) null;
        }

        return res;
    }

    /**
     * Reduces the rational number to its simplest form.
     */
    private void reduit() {
        int pgcd = this.pgcd(this.numerateur, this.denominateur);
        
        if (pgcd != 0) {
            this.numerateur = this.numerateur / pgcd;
            this.denominateur = this.denominateur / pgcd;
        } else {
            // Gestion de l'exception ou affichage d'un message
            System.out.println("Erreur : Division par zéro dans la méthode reduit.");
        }
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers.
     * 
     * @param n First integer.
     * @param d Second integer.
     * @return The GCD of the two integers.
     */
    private int pgcd(int n, int d){
        int res;

        if(n<0){
            n = -n;
        }else if(d<0){
            d = -d;
        }

        if(d ==0){
            res = n;
        }else{
            res = pgcd(d, n%d);
        }

        return res;
    }

    /**
     * Returns a string representation of the rational number.
     * 
     * @return A string in the form "numerator/denominator".
     */
    public String toString() {
        return numerateur + "/" + denominateur;
    }
}