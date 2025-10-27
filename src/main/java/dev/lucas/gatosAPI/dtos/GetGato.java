package dev.lucas.gatosAPI.dtos;

public record GetGato(Short id,
                      String nome,
                      String raca,
                      byte idade,
                      String sexo) {
}
