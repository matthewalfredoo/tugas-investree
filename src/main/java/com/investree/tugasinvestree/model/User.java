package com.investree.tugasinvestree.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;

    @OneToMany(mappedBy = "userMeminjam")
    private List<Transaksi> transaksiUserMeminjam;

    @OneToMany(mappedBy = "userPeminjam")
    private List<Transaksi> transaksiUserPeminjam;

}
