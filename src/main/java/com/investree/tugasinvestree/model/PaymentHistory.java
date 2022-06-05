package com.investree.tugasinvestree.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "payment_history")
public class PaymentHistory implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pembayaran_ke")
    private Integer pembayaranKe;

    @Column(name = "jumlah")
    private Double jumlah;

    @Column(name = "bukti_pembayaran")
    private String buktiPembayaran;

    @ManyToOne
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;

}
