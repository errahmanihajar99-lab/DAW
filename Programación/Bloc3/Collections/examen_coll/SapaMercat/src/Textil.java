/**
 * Producte tèxtil. Inclou restriccions de no duplicitat al carret.
 */
class Textil extends Producte {
    private String composicio;

    public Textil(String nom, double preuBase, String codiBarres, String composicio) {
        super(nom, preuBase, codiBarres);
        this.composicio = composicio;
    }

    @Override
    public double getPreuReal() { return preuBase; }



    public String getComposicio() { return composicio; }
    public void setComposicio(String composicio) { this.composicio = composicio; }
}
