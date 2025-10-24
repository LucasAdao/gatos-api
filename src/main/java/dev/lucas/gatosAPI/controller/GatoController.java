package dev.lucas.gatosAPI.controller;

import dev.lucas.gatosAPI.dtos.GetGato;
import dev.lucas.gatosAPI.dtos.PatchGato;
import dev.lucas.gatosAPI.dtos.PostGato;
import dev.lucas.gatosAPI.service.GatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gato")
public class GatoController {

    private final GatoService service;

    public GatoController( GatoService service){
        this.service = service;
    }

    @GetMapping("/helloworld")
    public String getGato() {
        return "Miau!";
    }

    @PostMapping
    public ResponseEntity<?> cadastrarGato(@RequestBody PostGato postGato){
        service.cadastrarGato(postGato);
        return new ResponseEntity<>(postGato, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarGatoPorId(@PathVariable Short id){
        GetGato gato = service.buscarGatoPorId(id);
        return ResponseEntity.ok(gato);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosGatos(){
        List<GetGato> gatos = service.buscarTodosOsGatos();
        return ResponseEntity.ok(gatos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizarGato(@PathVariable Short id, @RequestBody PatchGato gatoAtualizado){
        GetGato gatoParaAtualizar = service.atualizarGato(id, gatoAtualizado);
        return ResponseEntity.ok(gatoParaAtualizar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarGato(@PathVariable Short id){
        service.deletarGato(id);
        return ResponseEntity.noContent().build();
    }
}
