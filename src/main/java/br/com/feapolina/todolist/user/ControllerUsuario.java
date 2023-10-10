package br.com.feapolina.todolist.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/users") // rota

public class ControllerUsuario {
    
    @PostMapping("/") 
    /* Request body significa que o que eu tô recebendo dentro do criar() no ModeloUsuario vem dentro do Body */
    public void criar(@RequestBody ModeloUsuario modeloUsuario) {
        /* receber dados do usuario  */
        System.out.println(modeloUsuario.nome);
    }
}
