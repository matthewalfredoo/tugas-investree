package com.investree.tugasinvestree.view.impl;

import com.investree.tugasinvestree.model.Transaksi;
import com.investree.tugasinvestree.repository.TransaksiRepository;
import com.investree.tugasinvestree.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class TransaksiPaymentImple implements TransaksiService {

    @Autowired
    public TransaksiRepository transaksiRepository;

    @Override
    public Map save(Transaksi transaksi) {
        Map map = new HashMap();
        try{
            Transaksi insertTransaksi = transaksiRepository.save(transaksi);
            map.put("data", insertTransaksi);
            map.put("status", "sukses");
            map.put("code", "200");
            return map;
        } catch (Exception e){
            map.put("status", "gagal");
            map.put("code", "500");
            return map;
        }
    }

    @Override
    public Map updateStatus(Transaksi transaksi) {
        Map map = new HashMap();
        try{
            Transaksi updateTransaksi = transaksiRepository.getbyID(transaksi.getId());
            // updateTransaksi.setStatus(transaksi.getStatus());
            updateTransaksi.setStatus("Lunas");
            Transaksi savedUpdatedTransaksi = transaksiRepository.save(updateTransaksi);
            map.put("data", savedUpdatedTransaksi);
            map.put("status", "sukses");
            map.put("code", "200");
            return map;
        } catch (Exception e){
            map.put("status", "gagal");
            map.put("code", "500");
            return map;
        }
    }
}
