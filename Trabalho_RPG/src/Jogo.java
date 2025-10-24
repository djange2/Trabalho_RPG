import java.util.Scanner;

public class Jogo {
    Scanner scanner = new Scanner(System.in);

    public void iniciar(){
        System.out.println("BOAS VINDAS AO RPG DOS RAPPERS!");
        System.out.println("Para iniciarmos, escolha o seu rapper: ");
        System.out.println("1 - Kendrick Lamar\n 2 - Drake\n 3 - Young Thug (Thugger)");
        byte escolha = scanner.nextByte();
        Personagem jogador = null;
        switch (escolha){
            case 1 -> jogador = new Kendrick();
            case 2 -> jogador =new Drake();
            case 3 -> jogador =new Thugger();
        }
        Personagem inimigo = new Inimigo("Rapper local", 1);
        System.out.println("O jogo começou!");
        System.out.println(jogador.getNome());
        

    }

    public void gameover(){

    }


}
