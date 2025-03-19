package jogopokemonado;

import java.util.Scanner;

public class BatalhaFacade {
    private Jogador jogador1, jogador2;
    private Scanner scanner;

    public BatalhaFacade(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarBatalha() {
        System.out.println("Batalha entre " + jogador1.getNome() + " e " + jogador2.getNome());
        while (jogador1.getPokemon().getHP() > 0 && jogador2.getPokemon().getHP() > 0) {
            executarTurno();
        }

        if (jogador1.getPokemon().getHP() <= 0) {
            System.out.println(jogador2.getNome() + " venceu!");
        } else {
            System.out.println(jogador1.getNome() + " venceu!");
        }
    }

    private void executarTurno() {
        System.out.println("Escolha um movimento: 1. Ataque  2. Defesa  3. Especial");
        int escolha1 = scanner.nextInt();
        int escolha2 = scanner.nextInt();

        calcularDano(jogador1, jogador2, escolha1, escolha2);
        calcularDano(jogador2, jogador1, escolha2, escolha1);

        System.out.println(jogador1.getNome() + " HP: " + jogador1.getPokemon().getHP());
        System.out.println(jogador2.getNome() + " HP: " + jogador2.getPokemon().getHP());
    }

    private void calcularDano(Jogador atacante, Jogador defensor, int escolhaAtaque, int escolhaDefesa) {
        int dano = atacante.getPokemon().getAtaque();
        if (escolhaDefesa == 2) {
            dano /= 2;
        } else if (escolhaDefesa == 3) {
            dano = 0;
        }
        defensor.getPokemon().reduzirHP(dano);
    }
}
