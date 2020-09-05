package bandtec.projeto.individual;

import java.util.ArrayList;

public class Musico {

    private String nome;
    private Integer idade;
    private String cpf;
    private String contato;

    private ArrayList<Musica> musicas;
    private ArrayList<Instrumento> instrumentos;


    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getContato() {
        return contato;
    }
}
