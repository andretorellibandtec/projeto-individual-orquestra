package bandtec.projeto.individual;

public abstract class Instrumento {

    private String nome;
    private double altura;
    private double largura;
    private String material;
    private double preco;
    private String marca;

    public Instrumento(String nome, double altura, double largura, String material, double preco, String marca) {
        this.nome = nome;
        this.altura = altura;
        this.largura = largura;
        this.material = material;
        this.preco = preco;
        this.marca = marca;
    }

    public abstract String sairSom();

    public String getNome() {
        return nome;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public String getMaterial() {
        return material;
    }

    public double getPreco() {
        return preco;
    }

    public String getMarca() {
        return marca;
    }
}
