package com.miaskor.todo_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Length(min = 3, max = 128, message = "login is incorrect")
    @Column(name = "login")
    String login;
    @Length(max = 128, message = "email is incorrect")
    @Column(name = "email")
    String email;
    @Length(min = 8, max = 32, message = "password is incorrect")
    @Column(name = "password")
    String password;
    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "role_id")
    ClientRole clientRole;
}
