package com.danilo.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//Anotações de Getters, Setters e Constructor usando o lombok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//Entity para apontar pro Spring que é uma tabela do banco de dados
@Entity
//Table para indicar o nome da nossa tabela (aconselhado sempre indicar o nome da tabela)
@Table(name = "usuario")
//Estamos implementando a classe UserDetails que é do Spring Security que irá gerenciar os acessos.
@Builder
public class Usuario implements UserDetails {

    //Usando o @Id para criar o nosso identificar único.
    @Id
    //Generated para o Id ser gerado automaticamente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Column para identificar o nome da nossa coluna e algumas outras informações.
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;
    //OneToMany = uma para muitos, nesse caso iremos usar para que o usuario possa cadastrar mais de um telefone e mais de um endereço.
    //Quando o usuario pode cadastrar apenas um endereço/telefone (alguma coisa outra informação) usa-se o OneToOne
    //Anotação cascade: faz o relacionamento em cascata, no momento que o usuario for excluido tanto o endereço como o telefone será excluído automaticamente.
    @OneToMany(cascade = CascadeType.ALL)
    //O JoinColumn usamos com parametro para referenciar que tal nome referencia o usuario de tal id
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Endereco> enderecos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
