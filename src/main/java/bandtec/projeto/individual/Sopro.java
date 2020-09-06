package bandtec.projeto.individual;

public class Sopro extends Instrumento {


    public Sopro(String nome, double altura, double largura, String material, double preco, String marca) {
        super(nome, altura, largura, material, preco, marca);
    }

    @Override
    public String sairSom() {
        return "Tocando instrumento de Sopro";
    }

}
