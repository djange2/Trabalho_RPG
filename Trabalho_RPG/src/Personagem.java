import java.sql.SQLOutput;
import java.util.Scanner;

public abstract class Personagem {
    Scanner scanner = new Scanner(System.in);
    protected String nome;
    protected int pontosVida;
    protected int pontosVidaMax;
    protected int ataque;
    protected int defesa;
    protected int nivel;
    protected Inventario inventario;
    protected int xp;
    protected int xpProximoNivel;

    public Personagem(String nome, int pontosVida, int ataque, int defesa) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.pontosVidaMax = pontosVida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nivel = 1;
        this.inventario = new Inventario();
        this.xp = 0;
        this.xpProximoNivel = 100;
    }

    public String getNome(){
        return this.nome;
    }

    public void batalhar(Inimigo inimigo) {
        while (segueBatalha(inimigo)) {
            System.out.println("1 - Rimar");
            System.out.println("2 - Usar Item");
            System.out.println("3 - Fugir");
            System.out.print("Digite: ");
            byte choice = scanner.nextByte();

            switch (choice) {
                case 1 -> rimar(inimigo);
                case 2 -> {
                    boolean itemFoiUsado = usarItem(inimigo);
                    if (!itemFoiUsado) continue;
                }
                case 3 -> {
                    if (run()) {
                        System.out.println("Você fugiu com sucesso!");
                        return;
                    } else {
                        System.out.println("Falha ao fugir!");
                    }
                }
                default -> System.out.println("Opção Inválida");
            }

            if (inimigo.pontosVida <= 0) break;

            int valorDadoInimigo = rolarDado();
            if ((valorDadoInimigo + inimigo.ataque) > this.defesa) {
                this.pontosVida -= inimigo.ataque + valorDadoInimigo;
                System.out.println(inimigo.nome + " acertou causando " + (inimigo.ataque + valorDadoInimigo) + " de dano!");
            } else {
                System.out.println(inimigo.nome + " errou o ataque!");
            }
            System.out.println("================");
            System.out.println(this.nome+":"+this.pontosVida);
            System.out.println(inimigo.nome+":"+inimigo.pontosVida);
        }


        if (isNotDerrotado()) {
            System.out.println(this.nome + " venceu a batalha!");
            int xpGanho = inimigo.getXpDrop();
            System.out.println(nome + " ganhou " + xpGanho + " XP!");
            ganharXp(xpGanho);
            this.pontosVida = pontosVidaMax;
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

    public void rimar(Inimigo inimigo) {
        int valorDado = rolarDado();
        if ((valorDado + this.ataque) > inimigo.defesa) {
            inimigo.pontosVida -= this.ataque + valorDado;
            System.out.println(this.nome+" rimou e deu " +(this.ataque + valorDado)+" de dano");
        } else System.out.println(this.nome+" errou a rima!");
    }

    public boolean usarItem(Inimigo inimigo) {
        if (inventario.isEmpty()) {
            System.out.println("Você não tem itens para usar!");
            return false;
        }

        System.out.println("Escolha um item para usar:");
        for (int i = 0; i < inventario.getItens().size(); i++) {
            Item item = inventario.getItens().get(i);
            System.out.println((i + 1) + " - " + item.getNome() + " (" + item.getQuantidade() + ")");
        }

        int escolha = scanner.nextByte();
        if (escolha < 1 || escolha > inventario.getItens().size()) {
            System.out.println("Escolha inválida!");
            return false;
        }

        Item escolhido = inventario.getItens().get(escolha - 1);

        aplicarEfeitoItem(escolhido);

        escolhido.setQuantidade(escolhido.getQuantidade() - 1);
        if (escolhido.getQuantidade() <= 0) {
            inventario.removerItem(escolhido);
        }
        return true;
    }

    private void aplicarEfeitoItem(Item item) {
        switch (item.getEfeito().toLowerCase()) {
            case "cura" -> {
                pontosVida += 10;
                System.out.println(nome + " usou " + item.getNome() + " e recuperou 10 pontos de vida!");
            }
            case "ataque" -> {
                ataque += 2;
                System.out.println(nome + " usou " + item.getNome() + " e aumentou o ataque em 2!");
            }
            case "defesa" -> {
                defesa += 2;
                System.out.println(nome + " usou " + item.getNome() + " e aumentou a defesa em 2!");
            }
            default -> System.out.println("O item não teve efeito...");
        }
    }



    public boolean run() {
        int tentativa = (int) ((Math.random() * 10)) + 1;
        return tentativa > 6;

    }

    public void ganharXp(int quantidade) {
        xp += quantidade;
        while (xp >= xpProximoNivel) {
            xp -= xpProximoNivel;
            aumentarNivel();
            xpProximoNivel += 50;
            System.out.println(nome + " subiu para o nível " + nivel + "!");
        }
    }


    public abstract void aumentarNivel();


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
