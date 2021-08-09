package com.miaskor.todo_spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "client_id")
    Integer clientId;
    @Length(max = 512, message = "task is huge")
    @Column(name = "task_name")
    String taskName;
    @Column(name = "done")
    Boolean done;
    @Column(name = "date")
    LocalDate date;
}
