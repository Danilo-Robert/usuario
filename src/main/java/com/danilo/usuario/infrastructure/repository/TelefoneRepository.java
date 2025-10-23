package com.danilo.usuario.infrastructure.repository;

import com.danilo.usuario.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Informando que se trata de um repositório.
@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
