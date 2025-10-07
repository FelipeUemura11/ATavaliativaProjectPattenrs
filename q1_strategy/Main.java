public class Main {

    public static void main(String[] args) {

        SistemaLogistica sistema = new SistemaLogistica();

        // DADOS EXEMPLO PARA UMA ENTREGA
        double distancia = 100.0; // km
        double peso = 50.0; // kg

        System.out.println("=== Sistema de Calculo de Tarifas de Transporte ===\n");
        System.out.println("Dados da entrega:");
        System.out.println(">> distancia: " + distancia + " km");
        System.out.println(">> peso: " + peso + " kg\n");

        // demonstrar transporte terrestre
        sistema.setEstrategiaTransporte(new TransporteTerrestre());
        double tarifaTerrestre = sistema.calcularTarifa(distancia, peso);
        System.out.println("Transporte Terrestre:");
        System.out.printf("tipo: %s\n", sistema.getTipoTransporteAtual());
        System.out.printf("tarifa: R$ %.2f%n%n", tarifaTerrestre);

        // demonstrar transporte aereo
        sistema.setEstrategiaTransporte(new TransporteAereo());
        double tarifaAerea = sistema.calcularTarifa(distancia, peso);
        System.out.println("Transporte Aereo:");
        System.out.printf("tipo: %s\n", sistema.getTipoTransporteAtual());
        System.out.printf("tarifa: R$ %.2f%n%n", tarifaAerea);

        // demonstrar transporte maritimo
        sistema.setEstrategiaTransporte(new TransporteMaritimo());
        double tarifaMaritima = sistema.calcularTarifa(distancia, peso);
        System.out.println("Transporte Maritimo:");
        System.out.printf("tipo: %s\n", sistema.getTipoTransporteAtual());
        System.out.printf("tarifa: R$ %.2f%n%n", tarifaMaritima);

        // comparacao das tarifas
        System.out.println("=== Comparacao de Tarifas ===");
        System.out.printf("terrestre: R$ %.2f%n", tarifaTerrestre);
        System.out.printf("aereo: R$ %.2f%n", tarifaAerea);
        System.out.printf("maritimo: R$ %.2f%n", tarifaMaritima);

        // identificar opcao mais economica
        double menorTarifa = Math.min(tarifaTerrestre, Math.min(tarifaAerea, tarifaMaritima)); // funcao para encontrar o menor valor
        String tipoMaisEconomico = "";

        if (menorTarifa == tarifaTerrestre) {
            tipoMaisEconomico = "Terrestre";
        } else if (menorTarifa == tarifaAerea) {
            tipoMaisEconomico = "Aereo";
        } else {
            tipoMaisEconomico = "Maritimo";
        }

        System.out.printf("\nOpcao mais economica: %s (R$ %.2f)%n", tipoMaisEconomico, menorTarifa);
    }
}
