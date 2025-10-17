public class Arqueiro extends Personagem {

    public Arqueiro(String nome) {
        this.nome = nome;
        this.pontosVida = 100;
        this.ataque = 15;
        this.defesa = 10;
        this.nivel = 1;
        this.inventario = new Inventario();
    }

    @Override
    public void batalhar(Inimigo inimigo) {

    }
}

