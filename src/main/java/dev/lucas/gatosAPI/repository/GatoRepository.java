package dev.lucas.gatosAPI.repository;

import dev.lucas.gatosAPI.model.Gato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatoRepository extends JpaRepository<Short, Gato> {
}
