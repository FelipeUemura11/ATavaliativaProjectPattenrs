public class TransporteTerrestre implements TransporteStrategy {

    private static final double TAXA_POR_KM = 2.50;
    private static final double TAXA_POR_KG = 0.50;

    @Override
    public double calcularTarifa(double distanciaKm, double pesoKg) {
        return (distanciaKm * TAXA_POR_KM) + (pesoKg * TAXA_POR_KG);
    }

    @Override
    public String getTipoTransporte() {
        return "Terrestre";
    }
}

