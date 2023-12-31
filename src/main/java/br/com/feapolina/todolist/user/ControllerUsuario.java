package br.com.feapolina.todolist.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/users") // rota

public class ControllerUsuario {

    @Autowired
    private iUserRepository userRepository;

    @PostMapping("/")
    /*
     * Request body significa que o que eu tô recebendo dentro do criar() no
     * ModeloUsuario vem dentro do Body
     */

    public ResponseEntity criar(@RequestBody ModeloUsuario modeloUsuario) {

        var usuario = this.userRepository.findByUsername(modeloUsuario.getUsername());

        if (usuario != null) {
            // Mensagem de erro
            // Status code (exemplo: 200 [sucesso])
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe.");
        }

        //criptografando a senha para dificultar a facilidade de acesso
        var senhaHashada = BCrypt.withDefaults().hashToString(12, modeloUsuario.getPassword().toCharArray());
        modeloUsuario.setPassword(senhaHashada);

        var usuarioCriado = this.userRepository.save(modeloUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioCriado);
    }
}
