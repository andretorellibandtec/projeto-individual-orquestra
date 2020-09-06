package bandtec.projeto.individual;

public class Percussao extends Instrumento {


    public Percussao(String nome, double altura, double largura, String material, double preco, String marca) {
        super(nome, altura, largura, material, preco, marca);
    }

    @Override
    public String sairSom() {
        return "Tocando instrumento de percussão tu tu tu tu tu";
    }

}
