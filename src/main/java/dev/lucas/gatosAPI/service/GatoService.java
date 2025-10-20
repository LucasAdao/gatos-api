package dev.lucas.gatosAPI.service;

import dev.lucas.gatosAPI.dtos.GetGato;
import dev.lucas.gatosAPI.dtos.PatchGato;
import dev.lucas.gatosAPI.dtos.PostGato;
import dev.lucas.gatosAPI.mapper.GatoMapper;
import dev.lucas.gatosAPI.model.Gato;
import dev.lucas.gatosAPI.repository.GatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GatoService {

    private final GatoRepository repository;
    private final GatoMapper mapper;

    public GatoService(GatoRepository repository, GatoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<GetGato> buscarTodosOsGatos(){
        List<Gato> gatos = repository.findAll();
        return gatos.stream()
                .map(mapper::toGetGato)
               .collect(Collectors.toList());
    }

    public GetGato buscarGatoPorId(Short id){
        Optional<Gato> gato = repository.findById(id);
        return gato.map(mapper::toGetGato).orElse(null);
    }

    public GetGato cadastrarGato(PostGato postGato){
        if(postGato == null){
            throw new IllegalArgumentException("O gato não pode ser nulo");
        }
        Gato gato = mapper.toGato(postGato);
        Gato gatoSalvo = repository.save(gato);
        return mapper.toGetGato(gato);
    }

    public GetGato atualizarGato(Short id, PatchGato patchGato){
        Optional<Gato> dadosAntigos = repository.findById(id);
        if(dadosAntigos.isPresent()){
        Gato dadosParaAtualizar = dadosAntigos.get();

        mapper.atualizarGatoComPatch(dadosParaAtualizar, patchGato);

        Gato gatoAtualizado = repository.save(dadosParaAtualizar);

        return mapper.toGetGato(gatoAtualizado);
        }
        return null;
    }

    public void deletarGato(Short id){
        repository.deleteById(id);
    }

}
