package com.investree.tugasinvestree.controller;

import com.investree.tugasinvestree.model.Transaksi;
import com.investree.tugasinvestree.repository.TransaksiRepository;
import com.investree.tugasinvestree.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {

    @Autowired
    public TransaksiRepository transaksiRepository;

    @Autowired
    public TransaksiService transaksiService;

    @PostMapping("")
    ResponseEntity<Map> save(
            @RequestBody
            Transaksi transaksi
    ) {
        Map responseMap = transaksiService.save(transaksi);
        return new ResponseEntity<Map>(responseMap, HttpStatus.OK);
    }

    @PutMapping("")
    ResponseEntity<Map> updateStatus(
            @RequestBody
            Transaksi transaksi
    ) {
        Map responseMap = transaksiService.updateStatus(transaksi);
        return new ResponseEntity<Map>(responseMap, HttpStatus.OK);
    }

    @GetMapping("/list")
    ResponseEntity<Page<Transaksi>> list(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "status", defaultValue = "") String status
    ) {
        if(status.equals("")) {
            Page<Transaksi> transaksiPage = transaksiRepository.getAllData(PageRequest.of(page, size));
            return new ResponseEntity<Page<Transaksi>>(transaksiPage, HttpStatus.OK);
        } else {
            Page<Transaksi> transaksiPage = transaksiRepository.findByStatus(status, PageRequest.of(page, size));
            return new ResponseEntity<Page<Transaksi>>(transaksiPage, HttpStatus.OK);
        }
    }

}
