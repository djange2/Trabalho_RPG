package personagens;

public class Thugger extends Personagem {

    public Thugger() {
        super("Young Thug", 80, 13, 11);
        poderUsado = false;
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVidaMax += 2;
        this.ataque += 3;
        this.defesa += 1;
        if (this.nivel == 3 || this.nivel == 5 || this.nivel == 8) {
            System.out.println("====================================");
            System.out.println("Você pode viajar para uma nova área!");
            System.out.println("====================================");
        }
    }

    @Override
    public void usarPoderEspecial(Inimigo inimigo) {
        if (poderUsado) {
            System.out.println("Você já usou seu poder especial!");
            return;
        }
        System.out.println("Young Thug entra no 'Slime Mode'! Ele preparou um ataque duplo!");
        rimar(inimigo);
        int dado = ((int) (Math.random() * 10)) + 1;
        if (dado >= 5) rimar(inimigo);
        poderUsado = true;
    }
}

