public abstract class Personagem {
    protected String nome;
    protected int pontosVida;
    protected int ataque;
    protected int defesa;
    protected int nivel;
    protected Inventario inventario;

    public Personagem(String nome, int pontosVida, int ataque, int defesa) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nivel = 1;
        this.inventario = new Inventario();
    }

    public void batalhar(Inimigo inimigo) {
        while (segueBatalha(inimigo)) {
            int valorDado = rolarDado();
            if ((valorDado + this.ataque) > inimigo.defesa) {
                inimigo.pontosVida -= this.ataque + valorDado;
            }
            int valorDadoInimigo = rolarDado();
            if ((valorDadoInimigo + inimigo.ataque) > this.defesa) {
                this.pontosVida -= inimigo.ataque + valorDadoInimigo;
            }
        }

        if (isNotDerrotado()) {
            System.out.println(this.nome + " venceu a batalha!");
            aumentarNivel();
        } else {
            System.out.println(inimigo.nome + " venceu a batalha!");
        }
    }

    public int rolarDado() {
        return ((int) (Math.random() * 10)) + 1;
    }

    public boolean segueBatalha(Inimigo inimigo) {
        return (this.pontosVida > 0 && inimigo.pontosVida > 0);
    }

    public boolean isNotDerrotado() {
        return (this.pontosVida > 0);
    }

    public void aumentarNivel() {
        this.nivel++;
    }

    @Override
    public String toString() {
        return nome + " (Nível: " + nivel + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Personagem p = (Personagem) obj;
        return this.nome.equals(p.nome)
                && this.pontosVida == p.pontosVida
                && this.ataque == p.ataque
                && this.defesa == p.defesa
                && this.nivel == p.nivel
                && this.inventario.equals(p.inventario);
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret = ret * 2 + nome.hashCode();
        ret = ret * 2 + Integer.hashCode(pontosVida);
        ret = ret * 2 + Integer.hashCode(ataque);
        ret = ret * 2 + Integer.hashCode(defesa);
        ret = ret * 2 + Integer.hashCode(nivel);
        ret = ret * 2 + inventario.hashCode();
        return ret;
    }
}
