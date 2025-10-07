public class TransporteAereo implements TransporteStrategy {

    private static final double TAXA_POR_KG = 15.00;
    private static final double TAXA_BASE_POR_KM = 5.00;

    @Override
    public double calcularTarifa(double distanciaKm, double pesoKg) {
        return (pesoKg * TAXA_POR_KG) + (distanciaKm * TAXA_BASE_POR_KM);
    }

    @Override
    public String getTipoTransporte() {
        return "Aereo";
    }
}

