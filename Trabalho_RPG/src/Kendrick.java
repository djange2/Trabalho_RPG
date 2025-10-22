public class Kendrick extends Personagem {

    public Kendrick(String nome) {
        super(nome,90,12,13);
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 4;
        this.ataque += 2;
        this.defesa += 2;
    }
}
