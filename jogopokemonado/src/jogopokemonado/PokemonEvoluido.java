import java.util.ArrayList;
import java.util.List;

class PokemonEvoluido extends CartaPokemon {
    private String nome;
    private List<CartaPokemon> evolucoes = new ArrayList<>();

    public PokemonEvoluido(String nome) {
        this.nome = nome;
    }

    public void adicionarEvolucao(CartaPokemon evolucao) {
        evolucoes.add(evolucao);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Carta Pokémon (com evolução): " + nome);
        for (CartaPokemon evolucao : evolucoes) {
            evolucao.exibirInfo();
        }
    }
}
