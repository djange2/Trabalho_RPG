public class Inimigo extends Personagem {

    public Inimigo(String nome) {
        this.nome = nome;
        this.pontosVida = 100;
        this.ataque = 15;
        this.defesa = 10;
        this.nivel = 1;
        this.inventario = new Inventario();
    }

    @Override
    public void atacar(Personagem personagem) {
        System.out.println( this.nome + " atacando");
        // implementar lógica
    }

    @Override
    public void defender(Personagem personagem) {
        System.out.println( this.nome + " defendendo");
        // implementar lógica
    }
}

