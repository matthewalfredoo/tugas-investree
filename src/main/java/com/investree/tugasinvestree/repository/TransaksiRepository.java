package com.investree.tugasinvestree.repository;

import com.investree.tugasinvestree.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {

    @Query("select c from Transaksi c")
    public List<Transaksi> getAllData();

    @Query("select c from Transaksi c WHERE c.id = :id")
    public Transaksi getbyID(
            @Param("id")
            Long id
    );

    @Query("select c from Transaksi c WHERE c.userPeminjam.id = :id_peminjam")
    public List<Transaksi> getbyIDPeminjam(
            @Param("id_peminjam")
            Long id_peminjam
    );

    @Query("select c from Transaksi c WHERE c.userMeminjam.id = :id_meminjam")
    public List<Transaksi> getbyIDMeminjam(
            @Param("id_meminjam")
            Long id_meminjam
    );

}
