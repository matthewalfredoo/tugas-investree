package com.investree.tugasinvestree.repository;

import com.investree.tugasinvestree.model.PaymentHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentHistoryRepository extends PagingAndSortingRepository<PaymentHistory, Long> {

    @Query("SELECT c FROM PaymentHistory c")
    public List<PaymentHistory> getAllData();

    @Query("SELECT c FROM PaymentHistory c where c.id = :id")
    PaymentHistory getbyID(
            @Param("id")
            Long id
    );

    @Query("SELECT c FROM PaymentHistory c where c.transaksi.id = :id_transaksi")
    List<PaymentHistory> getbyIDTransaksi(
            @Param("id_transaksi")
            Long id_transaksi
    );

}
