package bandtec.projeto.individual;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orquestras")
@Api("Orquestra API REST")
@CrossOrigin("*")
public class Orquestra {

    private String nome;
    private String contato;

    private List<Musico> musicos;

    public Orquestra() {
        this.musicos = new ArrayList<Musico>();
    }


    @GetMapping("/tocar")
    @ApiOperation("Retorna uma String sinalizando que a orquestra está tocando.")
    public String tocar(){
        if(this.musicos.size() > 0){
            return "pa pa pa pa pa pa pa";
        }else{
            return "Não á músicos para tocar.";
        }
    }


    @GetMapping("/musicos")
    @ApiOperation("Retorna todos os músicos da orquestra.")
    public ResponseEntity meusMusicos() {
        if (this.musicos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(musicos);
        }
    }

    @ApiOperation("Adiciona um músico na orquestra.")
    @PostMapping("/musicos")
    public ResponseEntity contratarMusico(@RequestBody Musico musico) {
        this.musicos.add(musico);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/musicos/{id}")
    @ApiOperation("Remove um músico da orquestra.")
    public ResponseEntity demitirMusico(@PathVariable int id) {
        if (this.musicos.size() >= id) {
            this.musicos.remove(id - 1);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }


}
