import java.time.temporal.Temporal;
import java.util.Objects;

/**
 * Classe abstracta que representa l'entitat base d'un producte.
 * Implementa {@link Comparable} per a una ordenació natural basada en el nom.
 * * @author El Teu Nom
 * @version 1.0
 */
public abstract class Producte implements Comparable<Producte> {
    public Temporal getData;
    protected String nom;
    protected double preuBase;
    protected String codiBarres;

    /**
     * Constructor principal de Producte.
     * @param nom Nom descriptiu del producte.
     * @param preuBase Preu de venda original.
     * @param codiBarres Identificador únic (String).
     */
    public Producte(String nom, double preuBase, String codiBarres) {
        this.nom = nom;
        this.preuBase = preuBase;
        this.codiBarres = codiBarres;
    }

    /**
     * Mètode abstracte que cada subclasse ha d'implementar segons la seva lògica de negoci.
     * @return El preu final calculat.
     */
    public abstract double getPreuReal();

    /**
     * Defineix l'ordenació natural: alfabètica per nom ignorant majúscules.
     */
    @Override
    public int compareTo(Producte altre) {
        //return this.nom.compareToIgnoreCase(altre.nom);
        //exr3
        return this.codiBarres.compareToIgnoreCase(altre.getCodiBarres());
    }

    //exr 2
    /**
     * Mètode per verificar egualitat de productes
     * @param altre Producte para comparar
     * @return true o false
     */
    public boolean equals(Producte altre){
        return Objects.equals(this.nom, altre.getNom()) && Objects.equals(this.codiBarres, altre.getCodiBarres());
    }

    public int HashCode(Producte altre){
        return altre.HashCode(this);
    }


    // --- Getters i Setters ---
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPreuBase() { return preuBase; }
    public void setPreuBase(double preuBase) { this.preuBase = preuBase; }

    public String getCodiBarres() { return codiBarres; }
    public void setCodiBarres(String codiBarres) { this.codiBarres = codiBarres; }


}