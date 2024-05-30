package fr.syzonia.core.math;

import java.util.Arrays;

public class MathUtils {

	  // Constantes
    public static final double EPSILON = 1e-15;
    public static final double SAFE_MIN = Double.MIN_VALUE / 2;

    // Méthodes utilitaires

    public static double arrondi(double nombre, int nombreDeChiffres) {
        return Math.round(nombre * Math.pow(10, nombreDeChiffres)) / Math.pow(10, nombreDeChiffres);
    }

    public static double moduloPositif(double nombre, double diviseur) {
        double modulo = nombre % diviseur;
        return modulo < 0 ? modulo + diviseur : modulo;
    }

    public static double normaliserAngle(double angle, double reference) {
        double angleNormalise = moduloPositif(angle - reference, 2 * Math.PI);
        return angleNormalise < Math.PI ? angleNormalise : angleNormalise - 2 * Math.PI;
    }

    public static double angleEntreDeuxPoints(double x1, double y1, double x2, double y2) {
        return Math.atan2(y2 - y1, x2 - x1);
    }

    // Méthodes pour les statistiques

    public static double moyenne(double[] valeurs) {
        double somme = 0;
        for (double valeur : valeurs) {
            somme += valeur;
        }
        return somme / valeurs.length;
    }

    public static double ecartType(double[] valeurs) {
        double moyenne = moyenne(valeurs);
        double variance = 0;
        for (double valeur : valeurs) {
            variance += Math.pow(valeur - moyenne, 2);
        }
        return Math.sqrt(variance / valeurs.length);
    }

    // Trigonométrie

    public static double sin(double angle) {
        return Math.sin(angle);
    }

    public static double cos(double angle) {
        return Math.cos(angle);
    }

    public static double tan(double angle) {
        return Math.tan(angle);
    }

    public static double asin(double valeur) {
        return Math.asin(valeur);
    }

    public static double acos(double valeur) {
        return Math.acos(valeur);
    }

    public static double atan(double valeur) {
        return Math.atan(valeur);
    }

	public int x(int n, int l) {
		return n * l;
	}
	
	public static double mediane(double[] valeurs) {
	    if (valeurs.length == 0) {
	        throw new IllegalArgumentException("Le tableau de valeurs est vide");
	    }

	    // Tri des valeurs
	    Arrays.sort(valeurs);

	    int milieu = valeurs.length / 2;
	    if (valeurs.length % 2 == 0) {
	        return (valeurs[milieu - 1] + valeurs[milieu]) / 2;
	    } else {
	        return valeurs[milieu];
	    }
	}
	
	public static double quartile(double[] valeurs, double quantile) {
	    if (valeurs.length == 0) {
	        throw new IllegalArgumentException("Le tableau de valeurs est vide");
	    }

	    if (quantile < 0 || quantile > 1) {
	        throw new IllegalArgumentException("Le quantile doit être compris entre 0 et 1");
	    }

	    // Tri des valeurs
	    Arrays.sort(valeurs);

	    int index = (int) Math.round(valeurs.length * quantile);
	    if (index == valeurs.length) {
	        return valeurs[index - 1];
	    } else {
	        return (valeurs[index - 1] + valeurs[index]) / 2;
	    }
	}
	
	public static double covariance(double[] valeurs1, double[] valeurs2) {
	    if (valeurs1.length != valeurs2.length) {
	        throw new IllegalArgumentException("Les tableaux de valeurs doivent avoir la même longueur");
	    }

	    double moyenne1 = moyenne(valeurs1);
	    double moyenne2 = moyenne(valeurs2);

	    double covariance = 0;
	    for (int i = 0; i < valeurs1.length; i++) {
	        covariance += (valeurs1[i] - moyenne1) * (valeurs2[i] - moyenne2);
	    }

	    return covariance / (valeurs1.length - 1);
	}
	
	public static double correlation(double[] valeurs1, double[] valeurs2) {
	    if (valeurs1.length != valeurs2.length) {
	        throw new IllegalArgumentException("Les tableaux de valeurs doivent avoir la même longueur");
	    }

	    double covariance = covariance(valeurs1, valeurs2);
	    double ecartType1 = ecartType(valeurs1);
	    double ecartType2 = ecartType(valeurs2);

	    if (ecartType1 == 0 || ecartType2 == 0) {
	        return 0.0;
	    }

	    return covariance / (ecartType1 * ecartType2);
	}
	
	public static double produitScalaire(double[] vec1, double[] vec2) {
	    if (vec1.length != vec2.length) {
	        throw new IllegalArgumentException("Les vecteurs doivent avoir la même longueur");
	    }

	    double produitScalaire = 0;
	    for (int i = 0; i < vec1.length; i++) {
	        produitScalaire += vec1[i] * vec2[i];
	    }

	    return produitScalaire;
	}
	
	public static double normeVecteur(double[] vec) {
	    return Math.sqrt(produitScalaire(vec, vec));
	}
	
	public static double distanceEuclidienne(double[] vec1, double[] vec2) {
	    if (vec1.length != vec2.length) {
	        throw new IllegalArgumentException("Les vecteurs doivent avoir la même longueur");
	    }

	    double distance = 0;
	    for (int i = 0; i < vec1.length; i++) {
	        distance += Math.pow(vec1[i] - vec2[i], 2);
	    }

	    return Math.sqrt(distance);
	}
	
    
}
