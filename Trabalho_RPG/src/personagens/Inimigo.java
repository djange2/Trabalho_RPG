package personagens;

import itens.Inventario;
import itens.Item;

public class Inimigo extends Personagem {
        private int xpDrop;

        public Inimigo(String nome, int nivel) {
            super(nome,80,8,12);
            this.nivel = nivel;
            this.inventario = new Inventario();
            ajustarStatsPorNivel();
            this.xpDrop = calcularXpDrop();

// Raridade 1 (comum)
            inventario.adicionarItem(new Item("Copo usado de Lean", "Recupera 40 de vida.", "cura", 1, 40, 1));
            inventario.adicionarItem(new Item("Corrente Falsa", "Aumenta 2 de defesa.", "defesa", 1, 2, 1));
            inventario.adicionarItem(new Item("Caneta Velha", "Aumenta 2 de ataque.", "ataque", 1, 2, 1));

// Raridade 2 (raro)
            inventario.adicionarItem(new Item("Copo de Lean", "Recupera 70 de vida.", "cura", 1, 70, 2));
            inventario.adicionarItem(new Item("Corrente de Aço", "Aumenta 3 de defesa.", "defesa", 1, 3, 2));
            inventario.adicionarItem(new Item("Caneta Comum", "Aumenta 3 de ataque.", "ataque", 1, 3, 2));

// Raridade 3 (épico)
            inventario.adicionarItem(new Item("Garrafa de Lean", "Recupera 100 de vida.", "cura", 1, 100, 3));
            inventario.adicionarItem(new Item("Corrente de Diamantes", "Aumenta 5 de defesa.", "defesa", 1, 5, 3));
            inventario.adicionarItem(new Item("Caneta Dourada da Louis Vuitton", "Aumenta 5 de ataque.", "ataque", 1, 5, 3));

        }

        private int calcularXpDrop() {
            return (ataque + defesa + pontosVida / 4);
        }

        public int getXpDrop() {
            return xpDrop;
        }

        private void ajustarStatsPorNivel() {
            if (this.nivel == 1) return;
            int lvlups = nivel - 1;
            this.pontosVida += 4 * lvlups;
            this.ataque += 2 *lvlups;
            this.defesa += 2 * lvlups;
        }

        @Override
        public void aumentarNivel() {}

        @Override
        public void usarPoderEspecial(Inimigo inimigo) {}
}

