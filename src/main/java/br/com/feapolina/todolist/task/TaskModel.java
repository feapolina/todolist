package br.com.feapolina.todolist.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tabela_tasks")
public class TaskModel {
    /*
     * tem que ter usuario(ID_USUARIO), descrição, título, data de inicio, data de
     * fim, ID, prioridade
     */

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50)
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;
    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
