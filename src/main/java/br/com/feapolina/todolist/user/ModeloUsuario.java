package br.com.feapolina.todolist.user;
import lombok.Data;

import java.util.UUID;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Data // importa os getters e os setters automaticamente 
@Entity(name = "tabela_usuarios")
public class ModeloUsuario {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true) // restringe a um valor unico no banco de dados.
    private String username;
    private String name;
    private String password;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    
}
