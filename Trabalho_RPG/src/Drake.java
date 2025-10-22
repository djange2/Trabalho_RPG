public class Drake extends Personagem {

    public Drake(String nome) {
        super(nome,110  ,9,16);
        this.nivel = 1;
        this.inventario = new Inventario();
    }

    @Override
    public void batalhar(Inimigo inimigo) {

    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 5;
        this.ataque += 1;
        this.defesa += 3;
    }
}

