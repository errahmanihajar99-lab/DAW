import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

/**
 * Producte d'alimentació amb lògica de preu basada en la caducitat.
 */
abstract class Alimentacio extends Producte implements Comparator<Alimentacio> {
    private LocalDate dataCaducitat;

    public Alimentacio(String nom, double preuBase, String codiBarres, LocalDate dataCaducitat) {
        super(nom, preuBase, codiBarres);
        this.dataCaducitat = dataCaducitat;
    }

    @Override
    public double getPreuReal() {
        long dies = ChronoUnit.DAYS.between(LocalDate.now(), dataCaducitat);
        if (dies < 0) dies = 0;
        double descompte = preuBase * (1.0 / (dies + 1));
        return Math.max(preuBase*(1-descompte),0);
    }

    public LocalDate getData(){
        return dataCaducitat;
    }

    public LocalDate getDataCaducitat() { return dataCaducitat; }
    public void setDataCaducitat(LocalDate dataCaducitat) { this.dataCaducitat = dataCaducitat; }


}