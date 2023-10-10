package br.com.feapolina.todolist.user;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUserRepository extends JpaRepository<ModeloUsuario, UUID>{ // <> recebe um generator
    ModeloUsuario findByUsername(String username);
    
}
