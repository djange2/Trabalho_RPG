public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        this.nome = nome;
        this.pontosVida = 100;
        this.ataque = 15;
        this.defesa = 10;
        this.nivel = 1;
        this.inventario = new Inventario();
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println( this.nome + " atacando");
    }

    @Override
    public void defender(Personagem inimigo) {
        System.out.println( this.nome + " defendendo");
    }
}
