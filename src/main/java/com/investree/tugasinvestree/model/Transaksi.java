package com.investree.tugasinvestree.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "transaksi")
public class Transaksi implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tenor")
    private Integer tenor;

    @Column(name = "total_pinjaman")
    private Double totalPinjaman;

    @Column(name = "bunga_persen")
    private Double bungaPersen;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_meminjam")
    private User userMeminjam;

    @ManyToOne
    @JoinColumn(name = "id_peminjam")
    private User userPeminjam;

    @OneToMany(mappedBy = "transaksi")
    private List<PaymentHistory> paymentHistories;

}
