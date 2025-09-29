package com.petapi.service;

import com.petapi.client.PositionStackClient;
import com.petapi.dto.LocalizacaoDTO;
import com.petapi.model.Endereco;
import com.petapi.model.LocalizacaoPet;
import com.petapi.repository.LocalizacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LocalizacaoServiceTest {

    @Mock
    private LocalizacaoRepository repository;

    @Mock
    private PositionStackClient positionClient;

    @InjectMocks
    private LocalizacaoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Ativa as anotações do Mockito
    }

    @Test
    void deveProcessarLocalizacaoERetornarPetSalvo() {
        // Arrange: cria DTO de entrada
        LocalizacaoDTO dto = new LocalizacaoDTO();
        dto.setSensorId("ABC123");
        dto.setLatitude(-22.97);
        dto.setLongitude(-43.18);
        dto.setDataHora(LocalDateTime.now());

        // Cria stub do endereço
        Endereco enderecoStub = new Endereco("Brasil", "RJ", "Rio de Janeiro", "Copacabana", "Av. Atlântica");

        // Cria mock do retorno esperado do pet salvo
        LocalizacaoPet petSalvo = new LocalizacaoPet();
        petSalvo.setSensorId(dto.getSensorId());

        // Stubando os métodos
        when(positionClient.buscarEndereco(-22.97, -43.18)).thenReturn(enderecoStub); // Stub da API externa
        when(repository.save(any(LocalizacaoPet.class))).thenReturn(petSalvo);         // Stub do save

        // Act: executa o método real
        LocalizacaoPet resultado = service.processarLocalizacao(dto);

        // Assert: verifica resultado
        assertNotNull(resultado);
        assertEquals("ABC123", resultado.getSensorId());

        // Verifica que os métodos foram chamados (mock)
        verify(positionClient).buscarEndereco(-22.97, -43.18);
        verify(repository).save(any(LocalizacaoPet.class));
    }
}
