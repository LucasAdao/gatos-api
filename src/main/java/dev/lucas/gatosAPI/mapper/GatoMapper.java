package dev.lucas.gatosAPI.mapper;

import dev.lucas.gatosAPI.dtos.GetGato;
import dev.lucas.gatosAPI.dtos.PatchGato;
import dev.lucas.gatosAPI.dtos.PostGato;
import dev.lucas.gatosAPI.model.Gato;
import org.springframework.stereotype.Component;

@Component
public class GatoMapper {

    public GetGato toGetGato(Gato gato) {
        if( gato == null ) {
            return null;
        }
        return new GetGato(
            gato.getId(),
            gato.getNome(),
            gato.getRaca(),
            gato.getIdade()
        );
    }

    public Gato toGato(PostGato postgato){
        if( postgato == null ) {
            return null;
        }
        Gato gato = new Gato();
        gato.setNome( postgato.nome() );
        gato.setRaca( postgato.raca() );
        gato.setIdade( postgato.idade() );
        return gato;
    }

    public void atualizarGatoComPatch(Gato gato, PatchGato patchGato) {
        if (patchGato == null || gato == null) {
            return;
        }

        if (patchGato.nome() != null) {
            gato.setNome(patchGato.nome());
        }
        if (patchGato.raca() != null) {
            gato.setRaca(patchGato.raca());
        }
        if (patchGato.idade() != null) {
            gato.setIdade(patchGato.idade());
        }


    }

}
