package personagens;

public class Kendrick extends Personagem {

    public Kendrick() {
        super("Kendrick",90,11,12);
        poderUsado = false;
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 4;
        this.ataque += 2;
        this.defesa += 2;
    }

    @Override
    public void usarPoderEspecial(Inimigo inimigo) {
        if (poderUsado) {
            System.out.println("Você já usou seu poder especial!");
            return;
        }
        System.out.println(" Kendrick ativa o 'DAMN. Flow'! Ele preparou um ataque duplo!");
        rimar(inimigo);
        inimigo.defesa +=5;
        rimar(inimigo);
        inimigo.defesa -=5;
        poderUsado = true;
    }

}
