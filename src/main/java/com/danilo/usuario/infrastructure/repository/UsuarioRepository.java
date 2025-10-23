package com.danilo.usuario.infrastructure.repository;

import com.danilo.usuario.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Informando que se trata de um repositório.
@Repository
//Repositóri criamos como uma interface e ela herda(extends) a classe JpaRepository (para casos de banco de dados SQL) e entre o <> passamos o nome da Classe e o tipo do Id (no caso nosso Id é Long)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Script de banco de dados que verifica se o dado passado existe no banco de dados ou não.
    boolean existsByEmail(String email);

    //O Optional é uma classe do Java Util.
    //Serve para evitar retorno de informações nulas (Ajuda a tratar o retorno nulo e que nosso programa não quebre)
    //Ele trata com o .orElseThrow uma Exception no Spring Security
    Optional<Usuario> findByEmail(String email);

    //Função para deletar por e-mail
    @Transactional
    void deleteByEmail(String email);
}