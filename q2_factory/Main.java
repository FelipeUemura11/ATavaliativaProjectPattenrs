import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Plataforma de Pagamentos ===\n");

        // EXIBIR OPÇÕES DISPONIVEIS
        System.out.println("Meios de pagamento disponiveis:");
        String[] tiposDisponiveis = FabricaPagamento.getTiposDisponiveis();
        for (int i = 0; i < tiposDisponiveis.length; i++) {
            System.out.printf("%d - %s%n", i + 1, tiposDisponiveis[i]);
        }

        // Solicitar escolha do usuario
        System.out.print("\nEscolha o meio de pagamento (1-3): ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        if (opcao < 1 || opcao > tiposDisponiveis.length) {
            System.out.println("Opcao invalida!");
            return;
        }

        String tipoEscolhido = tiposDisponiveis[opcao - 1];
        double valor = 150.00;

        System.out.printf("\nVoce escolheu: %s%n", tipoEscolhido);
        System.out.printf("Valor do pagamento: R$ %.2f%n%n", valor);

        // Usar a fabrica para criar o processador
        try {
            ProcessadorPagamento processador = FabricaPagamento.criarProcessador(tipoEscolhido);

            // Coletar dados necessarios para o pagamento
            String dadosPagamento = coletarDadosPagamento(scanner, tipoEscolhido);

            if (dadosPagamento != null) {
                // Processar o pagamento
                String resultado = processador.processarPagamento(valor, dadosPagamento);

                System.out.println("=== Resultado do Pagamento ===");
                System.out.println(resultado);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        scanner.close();
    }

    private static String coletarDadosPagamento(Scanner scanner, String tipoPagamento) {
        switch (tipoPagamento) {
            case "Cartao de Credito":
                System.out.println("\nDados do Cartao:");
                System.out.print("Numero (16 digitos): ");
                String numero = scanner.nextLine();
                System.out.print("Validade (MM/AA): ");
                String validade = scanner.nextLine();
                System.out.print("CVV (3 digitos): ");
                String cvv = scanner.nextLine();
                return numero + "," + validade + "," + cvv;

            case "Boleto Bancario":
                System.out.println("\nDados do Boleto (opcional):");
                System.out.print("Nome do pagador: ");
                return scanner.nextLine();

            case "Pix":
                System.out.println("\nDados do PIX:");
                System.out.print("Chave PIX (CPF, telefone, email ou chave aleatoria): ");
                return scanner.nextLine();
            default:
                return null;
        }
    }
}


