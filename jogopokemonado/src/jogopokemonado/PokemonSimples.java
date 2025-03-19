

 class PokemonSimples  extends CartaPokemon {
    private String nome;

    public PokemonSimples (String nome){
        this.nome = nome;
    }


    @Override
    public void exibirInfo(){
        System.out.println("Carta Pokemon: " + nome);
        
    }

    
}
