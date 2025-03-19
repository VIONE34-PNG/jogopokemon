package jogopokemonado;

public class Jogador {
    private String nome;
    private PokemonImpl pokemon;

    public Jogador(String nome, PokemonImpl pokemon) {
        this.nome = nome;
        this.pokemon = pokemon;
    }

    public String getNome() { return nome; }
    public PokemonImpl getPokemon() { return pokemon; }
}
