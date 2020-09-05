package bandtec.projeto.individual;

public abstract class Instrumento {

    private String nome;
    private Double altura;
    private String largura;
    private String material;
    private String preco;
    private String marca;

    public abstract String sairSom(String letra);

}
