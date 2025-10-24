public class Thugger extends Personagem {

    public Thugger() {
        super("Young Thug", 70, 13, 11);
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 3;
        this.ataque += 2;
        this.defesa += 1;
    }
}

