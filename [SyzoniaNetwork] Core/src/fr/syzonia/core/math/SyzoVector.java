package fr.syzonia.core.math;

public class SyzoVector {

    private double[] valeurs;
    private int taille;

    // Constructeurs

    public SyzoVector(int taille) {
        this.valeurs = new double[taille];
        this.taille = taille;
        for (int i = 0; i < taille; i++) {
            valeurs[i] = 0.0;
        }
    }

    public SyzoVector(int taille, double valeur) {
        this.valeurs = new double[taille];
        this.taille = taille;
        for (int i = 0; i < taille; i++) {
            valeurs[i] = valeur;
        }
    }

    public SyzoVector(double[] valeurs) {
        this.valeurs = valeurs;
        this.taille = valeurs.length;
    }

    // Accesseurs

    public double get(int index) {
        if (index < 0 || index >= taille) {
            throw new IndexOutOfBoundsException("Index invalide : " + index);
        }
        return valeurs[index];
    }

    public void set(int index, double valeur) {
        if (index < 0 || index >= taille) {
            throw new IndexOutOfBoundsException("Index invalide : " + index);
        }
        valeurs[index] = valeur;
    }

    // Méthodes de manipulation

    public void ajouter(double valeur) {
        double[] nouveauTableau = new double[taille + 1];
        for (int i = 0; i < taille; i++) {
            nouveauTableau[i] = valeurs[i];
        }
        nouveauTableau[taille] = valeur;
        valeurs = nouveauTableau;
        taille++;
    }

    public void supprimer(int index) {
        if (index < 0 || index >= taille) {
            throw new IndexOutOfBoundsException("Index invalide : " + index);
        }
        double[] nouveauTableau = new double[taille - 1];
        for (int i = 0; i < index; i++) {
            nouveauTableau[i] = valeurs[i];
        }
        for (int i = index + 1; i < taille; i++) {
            nouveauTableau[i - 1] = valeurs[i];
        }
        valeurs = nouveauTableau;
        taille--;
    }

    // Informations

    public int taille() {
        return taille;
    }

    public boolean estVide() {
        return taille == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < taille; i++) {
            sb.append(valeurs[i]);
            if (i < taille - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Opérations vectorielles

    public SyzoVector additionner(SyzoVector autreVecteur) {
        if (taille != autreVecteur.taille) {
            throw new IllegalArgumentException("Les vecteurs doivent avoir la même taille");
        }
        SyzoVector resultat = new SyzoVector(taille);
        for (int i = 0; i < taille; i++) {
            resultat.valeurs[i] = valeurs[i] + autreVecteur.valeurs[i];
        }
        return resultat;
    }

    public SyzoVector soustraire(SyzoVector autreVecteur) {
        if (taille != autreVecteur.taille) {
            throw new IllegalArgumentException("Les vecteurs doivent avoir la même taille");
        }
        SyzoVector resultat = new SyzoVector(taille);
        for (int i = 0; i < taille; i++) {
            resultat.valeurs[i] = valeurs[i] - autreVecteur.valeurs[i];
        }
        return resultat;
    }

    public SyzoVector multiplier(double scalaire) {
    	SyzoVector resultat = new SyzoVector(taille);
        for (int i = 0; i < taille; i++) {
            resultat.valeurs[i] = valeurs[i] * scalaire;
        }
        return resultat;
    }

    public double produitScalaire(SyzoVector autreVecteur) {
        if (taille != autreVecteur.taille) {
            throw new IllegalArgumentException("Les vecteurs doivent avoir la même taille");
        }
        double produitScalaire = 0.0;
        for (int i = 0; i < taille; i++) {
            produitScalaire += valeurs[i] * autreVecteur.valeurs[i];
        }
        return produitScalaire;
    }

    public double norme() {
        double norme = 0.0;
        for (int i = 0; i < taille; i++) {
            norme += valeurs[i] * valeurs[i];
        }
        return Math.sqrt(norme);
    }
}
