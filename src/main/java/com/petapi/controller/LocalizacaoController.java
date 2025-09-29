package com.petapi.controller;

import com.petapi.dto.LocalizacaoDTO;


import com.petapi.model.LocalizacaoPet;
import com.petapi.service.LocalizacaoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/localizacao") 
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService service;

    @PostMapping
    public ResponseEntity<LocalizacaoPet> registrar(@RequestBody LocalizacaoDTO dto) {
        LocalizacaoPet pet = service.processarLocalizacao(dto);
        return ResponseEntity.ok(pet);
    }
    
    @GetMapping
    public ResponseEntity<List<LocalizacaoPet>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalizacaoPet> buscarPorId(@PathVariable Long id) {
        LocalizacaoPet pet = service.buscarPorId(id);
        if (pet != null) {
            return ResponseEntity.ok(pet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = service.removerPorId(id);
        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
