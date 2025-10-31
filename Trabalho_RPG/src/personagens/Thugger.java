package personagens;

public class Thugger extends Personagem {

    public Thugger() {
        super("Young Thug", 80, 13, 11);
        poderUsado = false;
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVidaMax += 3;
        this.ataque += 2;
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
        inimigo.defesa +=5;
        rimar(inimigo);
        inimigo.defesa -=5;
        poderUsado = true;
    }
}

