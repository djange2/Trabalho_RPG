public class Drake extends Personagem {

    public Drake(String nome) {
        super(nome,110  ,9,14);
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 5;
        this.ataque += 2;
        this.defesa += 2;
    }
}

