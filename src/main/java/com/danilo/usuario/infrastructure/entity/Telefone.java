package com.danilo.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

//Anotações de Getters, Setters e Constructor usando o lombok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//Entity para apontar pro Spring que é uma tabela do banco de dados
@Entity
//Table para indicar o nome da nossa tabela (aconselhado sempre indicar o nome da tabela)
@Table(name = "telefone")
@Builder
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero", length = 10)
    private String numero;
    @Column(name = "ddd", length = 3)
    private String ddd;
}
