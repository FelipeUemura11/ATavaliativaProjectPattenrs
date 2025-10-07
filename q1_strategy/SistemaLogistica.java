public class SistemaLogistica {

    private TransporteStrategy estrategiaTransporte;

    // define a estrategia de transporte a ser utilizada
    public void setEstrategiaTransporte(TransporteStrategy estrategia) {
        this.estrategiaTransporte = estrategia;
    }

    // calcula a tarifa usando a estrategia definida
    public double calcularTarifa(double distanciaKm, double pesoKg) {
        if (estrategiaTransporte == null) {
            throw new IllegalStateException("Estrategia de transporte nao definida");
        }

        return estrategiaTransporte.calcularTarifa(distanciaKm, pesoKg);
    }

    public String getTipoTransporteAtual() {
        return estrategiaTransporte != null ? estrategiaTransporte.getTipoTransporte() : "Nao definido";
    }
}

