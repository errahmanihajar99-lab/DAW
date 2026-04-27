/**
 * Producte electrònic amb recàrrec per garantia.
 */
class Electronics extends Producte {
    private int diesGarantia;

    public Electronics(String nom, double preuBase, String codiBarres, int diesGarantia) {
        super(nom, preuBase, codiBarres);
        this.diesGarantia = diesGarantia;
    }

    @Override
    public double getPreuReal() {
        return preuBase + preuBase * (diesGarantia / 365.0) * 0.1;
    }

    public int getDiesGarantia() { return diesGarantia; }
    public void setDiesGarantia(int diesGarantia) { this.diesGarantia = diesGarantia; }
}
