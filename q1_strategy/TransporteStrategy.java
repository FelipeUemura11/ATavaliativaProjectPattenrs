public interface TransporteStrategy {

    // Calcula o valor da tarifa para uma determinada entrega.
    double calcularTarifa(double distanciaKm, double pesoKg);

    // retorna o nome da modalidade de transporte(terrestre, aereo, maritimo)
    String getTipoTransporte();
}

