import java.util.Scanner;

public class Jogo {
    private Scanner scanner = new Scanner(System.in);
    private Personagem jogador;
    private Area[] areas = {
            new Area("Seu Bairro"),
            new Area("Centro de Los Angeles"),
            new Area("Centro de Toronto"),
            new Area("Atlanta")
    };
    private Area areaAtual = areas[0];

    public void iniciar() {
        System.out.println("BOAS VINDAS AO RPG DOS RAPPERS!");
        System.out.println("Para iniciarmos, escolha o seu rapper:");
        System.out.println("1 - Kendrick Lamar");
        System.out.println("2 - Drake");
        System.out.println("3 - Young Thug");

        while (jogador == null) {
            System.out.print("Digite sua escolha: ");
            byte escolha = scanner.nextByte();

            switch (escolha) {
                case 1 -> jogador = new Kendrick();
                case 2 -> jogador = new Drake();
                case 3 -> jogador = new Thugger();
                default -> System.out.println("Escolha inválida! Tente novamente.");
            }
        }

        System.out.println("O jogo começou!");
        System.out.println("Você está no seu bairro e aparece um menor quente querendo batalhar com você!");
        Inimigo inimigo = new Inimigo("Rapper local", 1);
        System.out.println(jogador.getNome() + " X " + inimigo.getNome());
        jogador.batalhar(inimigo, false);

        loopPrincipal();
    }

    private void loopPrincipal() {
        for (;;) {
            menu();
            System.out.print("Escolha: ");
            byte opcao = scanner.nextByte();

            switch (opcao) {
                //case 1 -> encontrarBatalha();
                //case 2 -> viajar()
                case 3 -> verStatus();
                case 4 -> verInventario();
                case 5 -> descansar();
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void menu() {
        System.out.println("\n===== MENU =====");
        System.out.println("Área atual: "+areaAtual.getNome()+"\n");
        System.out.println("1 - Encontrar Batalha");
        System.out.println("2 - Viajar");
        System.out.println("3 - Ver Status");
        System.out.println("4 - Ver Inventário");
        System.out.println("5 - Descansar");
    }

    private void verStatus() {
        System.out.println("\n===== STATUS =====");
        System.out.println(jogador.nome);
        System.out.println("Vida: " + jogador.pontosVida + "/" + jogador.pontosVidaMax);
        System.out.println("==================");
    }

    private void verInventario() {
        if (jogador.inventario.getItens().isEmpty()) {
            System.out.println("================");
            System.out.println("Seu inventário está vazio.");
            return;
        }
        System.out.println("\n===== INVENTÁRIO =====");
        System.out.println(jogador.inventario.getItens());
    }

    private void descansar() {
        jogador.pontosVida = jogador.pontosVidaMax;
        System.out.println(jogador.getNome() + " descansou e recuperou toda a vida!");
    }

    //TODO: ANDERSON OU DANIEL FAVOR FAZER MÉTODO VIAJAR E ENCONTRAR BATALHA
    //TODO: VOCES PODEM ADICIONAR NOVAS AREAS OU FAZER MODIFICACOES TBM
}
