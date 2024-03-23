package user;

public class User {
    private String nom;
    private String prenom;
    private int compte;
    private int eNum;
    private String eAdresse;
    private String adresse;
    
    public User() {
        this.adresse = null;
        this.compte = -1;
        this.eAdresse = null;
        this.eNum = 0;
        this.nom = null;
        this.prenom = null;
    }

    public User(String nom, String prenom, int compte, int eNum, String eAdresse, String adresse){
        this.nom = nom;
        this.prenom = prenom;
        this.compte = compte;
        this.eNum = eNum;
        this.eAdresse = eAdresse;
        this.adresse = adresse;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public int getCompte() {
        return this.compte;
    }

    public int getENum() {
        return this.eNum;
    }

    public String getEAdresse() {
        return this.eAdresse;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCompte(int compte) {
        this.compte = compte;
    }

    public void setENum(int eNum) {
        this.eNum = eNum;
    }

    public void setEAdresse(String eAdresse) {
        this.eAdresse = eAdresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String toString() {
        return "Nom: " + this.nom + "\nPrenom: " + this.prenom + "\nCompte: " + this.compte + "\nENum: " + this.eNum + "\nEAdresse: " + this.eAdresse + "\nAdresse: " + this.adresse;
    }

    public boolean equals(User user) {
        return this.nom.equals(user.getNom()) && this.prenom.equals(user.getPrenom()) && this.compte == user.getCompte() && this.eNum == user.getENum() && this.eAdresse.equals(user.getEAdresse()) && this.adresse.equals(user.getAdresse());
    }

    public static void main(String[] args) {
        User user = new User();
        user.setNom("Doe");
        user.setPrenom("John");
        user.setCompte(123456);
        System.out.println(user.toString());
    }
}
