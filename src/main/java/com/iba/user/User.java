package com.iba.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iba.Game.GameParty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String Lastname;
    @Column(
            nullable = false,
            unique=true
    )
    private String email;
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    List<GameParty> parties ;


    public User(long id, String firstname, String lastname, String mail, String password) {
        this.id=id;
        this.firstname=firstname;
        this.Lastname=lastname;
        this.password=password;
        this.email=mail;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
