public class Kendrick extends Personagem {

    public Kendrick() {
        super("Kendrick",90,12,13);
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 4;
        this.ataque += 2;
        this.defesa += 2;
    }
}
