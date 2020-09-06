package bandtec.projeto.individual;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/instrumentos")
public class Musico {

    private String nome;
    private Integer idade;
    private String cpf;
    private String contato;

    private ArrayList<Instrumento> instrumentos;

    public Musico() {
        instrumentos = new ArrayList<Instrumento>();
    }

    @PostMapping("/percussao")
    @ApiOperation("Comprar um instrumento de percussão.")
    public ResponseEntity comprarInstrumentoPercussao(@RequestBody Percussao instrumento) {
        this.instrumentos.add(instrumento);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/sopro")
    @ApiOperation("Comprar um instrumento de sopro.")
    public ResponseEntity comprarInstrumentoSopro(@RequestBody Sopro instrumento) {
        this.instrumentos.add(instrumento);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/corda")
    @ApiOperation("Comprar um instrumento de corda.")
    public ResponseEntity comprarInstrumentoCorda(@RequestBody Corda instrumento) {
        this.instrumentos.add(instrumento);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna a especificação do instrumento.")
    public ResponseEntity instrumentoDetalhado(@PathVariable int id) {
        if (this.instrumentos.size() > 0 && id != 0) {
            return ResponseEntity.status(200).body(this.instrumentos.get(id - 1));
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/percussao")
    @ApiOperation("Retorna todos instrumentos de percussão.")
    public ResponseEntity instrumentosPercussao() {
        ArrayList<Instrumento> instrumentosPercussao = new ArrayList<Instrumento>();
        if (this.instrumentos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            for (Instrumento i : this.instrumentos) {
                if (i instanceof Percussao) {
                    instrumentosPercussao.add(i);
                }
            }
            if (instrumentosPercussao.isEmpty()) {
                return ResponseEntity.status(204).build();
            } else {
                return ResponseEntity.status(200).body(instrumentosPercussao);
            }
        }
    }

    @GetMapping("/Sopro")
    @ApiOperation("Retorna todos instrumentos de sopro.")
    public ResponseEntity instrumentosSopro() {
        ArrayList<Instrumento> instrumentosSopro = new ArrayList<Instrumento>();
        if (this.instrumentos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            for (Instrumento i : this.instrumentos) {
                if (i instanceof Sopro) {
                    instrumentosSopro.add(i);
                }
            }
            if (instrumentosSopro.isEmpty()) {
                return ResponseEntity.status(204).build();
            } else {
                return ResponseEntity.status(200).body(instrumentosSopro);
            }
        }
    }

    @GetMapping("/corda")
    @ApiOperation("Retorna todos instrumentos de corda.")
    public ResponseEntity instrumentosCorda() {
        ArrayList<Instrumento> instrumentosCorda = new ArrayList<Instrumento>();
        if (this.instrumentos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            for (Instrumento i : this.instrumentos) {
                if (i instanceof Corda) {
                    instrumentosCorda.add(i);
                }
            }
            if (instrumentosCorda.isEmpty()) {
                return ResponseEntity.status(204).build();
            } else {
                return ResponseEntity.status(200).body(instrumentosCorda);
            }
        }
    }

    @GetMapping
    @ApiOperation("Retorna todos os instrumentos cadastrados.")
    public ResponseEntity todosInstrumentos() {
        if (this.instrumentos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(instrumentos);
        }
    }

    @GetMapping("/tocar/{id}")
    @ApiOperation("Tocar um instrumento ")
    public ResponseEntity tocarInstrumento(@PathVariable int id) {
        return ResponseEntity.status(200).body(instrumentos.get(id).sairSom());
    }

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

    @Override
    public String toString() {
        return "Musico{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}
