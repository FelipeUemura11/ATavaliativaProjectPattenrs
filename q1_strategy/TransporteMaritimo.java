public class TransporteMaritimo implements TransporteStrategy {

    private static final double TAXA_FIXA_POR_KM = 1.20; // por km
    private static final double TAXA_POR_KG = 3.00; // por kg
    private static final double TAXA_VOLUME_MINIMO = 50.00; // taxa minima de volume

    @Override
    public double calcularTarifa(double distanciaKm, double pesoKg) {
        double tarifaPorPeso = pesoKg * TAXA_POR_KG;
        double tarifaPorDistancia = distanciaKm * TAXA_FIXA_POR_KM;

        return Math.max(tarifaPorPeso + tarifaPorDistancia, TAXA_VOLUME_MINIMO);
    }

    @Override
    public String getTipoTransporte() {
        return "Maritimo";
    }
}

