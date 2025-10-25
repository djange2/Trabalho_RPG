import java.util.Scanner;

public class Jogo {
    Scanner scanner = new Scanner(System.in);

    public void iniciar(){
        System.out.println("BOAS VINDAS AO RPG DOS RAPPERS!");
        System.out.println("Para iniciarmos, escolha o seu rapper: ");
        System.out.println("1 - Kendrick Lamar\n2 - Drake\n3 - Young Thug");
        //TODO: fazer história
        byte escolha = scanner.nextByte();
        Personagem jogador = null;
        while (jogador == null){
            switch (escolha){
                case 1 -> jogador = new Kendrick();
                case 2 -> jogador =new Drake();
                case 3 -> jogador =new Thugger();
                default -> System.out.println("Escolha um personagem");
            }
        }
        System.out.println("O jogo começou!");
        System.out.println("vc ta no seu bairro e aparece um menor quente querendo batalhar com vc!");
        Inimigo inimigo = new Inimigo("Rapper local", 1);
        System.out.println(jogador.getNome() + " X " + inimigo.getNome());
        jogador.batalhar(inimigo);
    }

}
