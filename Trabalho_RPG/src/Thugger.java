public class Thugger extends Personagem {

    public Thugger(String nome) {
        super(nome,80,14,11);
        this.nivel = 1;
        this.inventario = new Inventario();
    }

    @Override
    public void batalhar(Inimigo inimigo) {

    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 3;
        this.ataque += 3;
        this.defesa += 1;
        System.out.println(this.nome + " subiu para o nível " + this.nivel + "!");
    }
}

