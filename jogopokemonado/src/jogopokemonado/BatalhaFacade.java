package jogopokemonado;

import java.util.Scanner;

public class BatalhaFacade {
    private static BatalhaFacade instancia;
    private static Jogador jogador1Atual, jogador2Atual;
    private Jogador jogador1, jogador2;
    private Scanner scanner;

    public BatalhaFacade(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.scanner = new Scanner(System.in);
    }

    
    public static synchronized BatalhaFacade getInstancia(Jogador jogador1, Jogador jogador2) {
        if (instancia == null || jogador1 != jogador1Atual || jogador2 != jogador2Atual) {
            instancia = new BatalhaFacade(jogador1, jogador2);
            jogador1Atual = jogador1;
            jogador2Atual = jogador2;
        }
        return instancia;
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
        System.out.println("Escolha um movimento para " + jogador1.getNome() + ": 1. Ataque  2. Defesa  3. Especial");
        int escolha1 = obterEscolhaValida();

        System.out.println("Escolha um movimento para " + jogador2.getNome() + ": 1. Ataque  2. Defesa  3. Especial");
        int escolha2 = obterEscolhaValida();

        calcularDano(jogador1, jogador2, escolha1, escolha2);
        calcularDano(jogador2, jogador1, escolha2, escolha1);

        System.out.println(jogador1.getNome() + " HP: " + jogador1.getPokemon().getHP());
        System.out.println(jogador2.getNome() + " HP: " + jogador2.getPokemon().getHP());
    }

    private int obterEscolhaValida() {
        int escolha;
        while (true) {
            escolha = scanner.nextInt();
            if (escolha >= 1 && escolha <= 3) {
                break;
            } else {
                System.out.println("Escolha inválida. Por favor, escolha 1, 2 ou 3.");
            }
        }
        return escolha;
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
