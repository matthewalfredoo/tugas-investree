package com.investree.tugasinvestree.view;

import com.investree.tugasinvestree.model.Transaksi;

import java.util.Map;

public interface TransaksiService {
    Map save(Transaksi transaksi);

    Map updateStatus(Transaksi transaksi);
}
