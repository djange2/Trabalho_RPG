package jogo;

import areas.Area;
import personagens.*;
import personagens.Drake;
import personagens.Inimigo;
import personagens.Kendrick;
import personagens.Thugger;

import java.util.Scanner;

public class Jogo {
    private Scanner scanner = new Scanner(System.in);
    private Personagem jogador;
    private Area[] areas = {
            new Area("Seu Bairro",1),
            new Area("Chicago",3),
            new Area("Houston",5),
            new Area("Las Vegas",8)
    };
    private Area areaAtual = areas[0];

    private void mostrarNarrativaArea() {
        switch (areaAtual.getNome()) {
            case "Seu Bairro" ->
                    System.out.println("Você está de volta ao seu bairro, onde tudo começou. Hora de praticar suas rimas!");
            case "Chicago" ->
                    System.out.println("As ruas de Chicago estão cheias de rappers querendo provar seu flow. Cuidado!");
            case "Houston" ->
                    System.out.println("Houston é um território brutal. Use seu talento para enfrentar desafios!");
            case "Las Vegas" ->
                    System.out.println("As ruas de Las Vegas são frias! DJ Khaled está por aqui...");
            default ->
                    System.out.println("Inválido!");
        }
    }

    public void iniciar() {
        System.out.println("=======================================");
        System.out.println("BOAS VINDAS AO RPG DOS RAPPERS!");
        System.out.println("Após uma grande treta entre gravadoras, Metro Boomin foi sequestrado por DJ Khaled.");
        System.out.println("Cabe a você — com suas rimas afiadas e flow mortal — atravessar cidades e resgatar Metro Boomin antes que seja tarde demais!");
        System.out.println("=======================================");
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

        System.out.println("=======================================");
        System.out.println("O jogo começou!");
        System.out.println("Você está no seu bairro, onde tudo começou.");
        System.out.println("As ruas estão silenciosas... até que alguém se aproxima com um olhar desafiador.");
        System.out.println("É um MC local querendo testar suas rimas!");
        System.out.println("Prepare-se para a primeira batalha!");
        System.out.println("=======================================");

        Inimigo inimigo = new Inimigo("Rapper Local", 1);

        System.out.println("\n" + jogador.getNome() + " X " + inimigo.getNome());
        System.out.println(inimigo.getNome() + ": \"Acha que consegue rimar comigo? Vamos ver!\"");
        System.out.println(jogador.getNome() + " se posiciona, sentindo a tensão no ar...");
        System.out.println("A batalha começa!\n");

        jogador.batalhar(inimigo, false);

        System.out.println("\nParabéns! Você venceu sua primeira batalha e começou sua jornada rumo a resgatar Metro Boomin!");
        System.out.println("Agora, prepare-se para explorar outras áreas e enfrentar desafios cada vez maiores.\n");

        loopPrincipal();
    }

    private void loopPrincipal() {
        for (;;) {
            menu();
            System.out.print("Escolha: ");
            byte opcao = scanner.nextByte();

            switch (opcao) {
                case 1 -> encontrarBatalha();
                case 2 -> viajar();
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
        System.out.println(jogador.getNome());
        System.out.println("Vida: " + jogador.getPontosVida() + "/" + jogador.getPontosVidaMax());
        System.out.println("Nível: "+ jogador.getNivel());
        System.out.println(jogador.getXp()+"/"+jogador.getXpProximoNivel());
        System.out.println("==================");
    }

    private void verInventario() {
        if (jogador.getInventario().getItens().isEmpty()) {
            System.out.println("================");
            System.out.println("Seu inventário está vazio.");
            return;
        }
        System.out.println("\n===== INVENTÁRIO =====");
        jogador.getInventario().listarItens();
    }

    private void descansar() {
        jogador.setPontosVida(jogador.getPontosVidaMax());
        System.out.println(jogador.getNome() + " descansou e recuperou toda a vida!");
    }


    private void viajar() {
        System.out.println("\n===== VIAGEM =====");
        System.out.println("Áreas disponíveis:");

        for (int i = 0; i < areas.length; i++) {
            if (jogador.getNivel() >= areas[i].getMinLvl()) {
                System.out.println((i + 1) + " - " + areas[i].getNome());
            }
        }

        System.out.print("Escolha um destino: ");
        byte escolha = scanner.nextByte();

        if (escolha < 1 || escolha > areas.length || jogador.getNivel() < areas[escolha - 1].getMinLvl()) {
            System.out.println("Destino inválido!");
            return;
        }
        if (areaAtual == areas[escolha - 1]) {
            System.out.println("Você já está nessa área!");
            return;
        }
        areaAtual = areas[escolha - 1];
        mostrarNarrativaArea();
    }

    private void encontrarBatalha() {
        if (areaAtual == areas[0]) {
            Inimigo inimigo = new Inimigo("Rapper Local", (int) (Math.random() * 3) + 1);
            jogador.batalhar(inimigo,true);
        }
        if (areaAtual == areas[1]) {
            Inimigo inimigo = new Inimigo("Rapper Local", (int) (Math.random() * (7 - 5 + 1)) + 5);
            jogador.batalhar(inimigo,true);
        }
        if (areaAtual == areas[2]) {
            Inimigo inimigo = new Inimigo("Rapper Local", (int) (Math.random() * (10 - 7 + 1)) + 7);
            jogador.batalhar(inimigo,true);
        }
        if (areaAtual == areas[3]) {
            Inimigo inimigo = new Inimigo("DJ Khaled", 15);
            jogador.batalhar(inimigo,false);
        }
    }
}
