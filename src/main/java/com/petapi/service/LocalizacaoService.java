package com.petapi.service;

import com.petapi.dto.LocalizacaoDTO;

import com.petapi.model.LocalizacaoPet;
import com.petapi.model.Endereco;
import com.petapi.repository.LocalizacaoRepository;
import com.petapi.client.PositionStackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository repository;

    @Autowired
    private PositionStackClient positionClient;

    public LocalizacaoPet processarLocalizacao(LocalizacaoDTO dto) {
        Endereco endereco = positionClient.buscarEndereco(dto.getLatitude(), dto.getLongitude());

        LocalizacaoPet pet = new LocalizacaoPet();
        pet.setSensorId(dto.getSensorId());
        pet.setLatitude(dto.getLatitude());
        pet.setLongitude(dto.getLongitude());
        pet.setDataHora(dto.getDataHora());
        pet.setPais(endereco.getCountry());
        pet.setEstado(endereco.getRegion());
        pet.setCidade(endereco.getCity());
        pet.setBairro(endereco.getBairro());
        pet.setEndereco(endereco.getLabel());

        return repository.save(pet);
    }
    
    public List<LocalizacaoPet> listarTodas() {
        return repository.findAll();
    }

    public LocalizacaoPet buscarPorId(Long id) {
        Optional<LocalizacaoPet> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public boolean removerPorId(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}