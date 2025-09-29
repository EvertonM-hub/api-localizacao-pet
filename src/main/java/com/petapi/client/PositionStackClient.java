package com.petapi.client;

import com.petapi.model.Endereco;

import com.petapi.model.PositionStackResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component // esta class é um componente gerenciada pelo SpringBoot
public class PositionStackClient {

    @Value("${positionstack.api.key}") // injeta a chave API
    private String accessKey;

    private final String URL = "http://api.positionstack.com/v1/reverse"; // Url dase da APi de geolocalização

    public Endereco buscarEndereco(double lat, double lon) {
        String uri = String.format("%s?access_key=%s&query=%s,%s", URL, accessKey, lat, lon);
        RestTemplate restTemplate = new RestTemplate(); // Instancia um cliente HTTP do Spring para fazer requisições REST

        try {  // Faz uma requisição GET para a API e espera receber um objeto do tipo PositionStackResponse
            ResponseEntity<PositionStackResponse> response =
                restTemplate.getForEntity(uri, PositionStackResponse.class);

            if (response.getBody() == null || response.getBody().getData().isEmpty()) {  // Verifica se a resposta tem dados válidos
                throw new RuntimeException("Nenhum dado encontrado na resposta da API.");
            }

            return response.getBody().getData().get(0);  // Retorna o primeiro endereço da lista
        } catch (HttpClientErrorException.TooManyRequests e) {  // Captura erro 429 - excedeu o limite de chamadas da API
            throw new RuntimeException("Limite de requisições excedido na API PositionStack.");
        } catch (Exception e) { // Captura qualquer outro erro
            throw new RuntimeException("Erro ao chamar API PositionStack: " + e.getMessage());
        }
    }
}


