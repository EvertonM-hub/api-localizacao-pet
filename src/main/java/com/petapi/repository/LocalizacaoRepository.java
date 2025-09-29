package com.petapi.repository;

import com.petapi.model.LocalizacaoPet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<LocalizacaoPet, Long> {
}
