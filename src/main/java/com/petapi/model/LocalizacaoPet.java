package com.petapi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class LocalizacaoPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorId;
    private double latitude;
    private double longitude;
    private LocalDateTime dataHora;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String endereco;

    //Construtor /  Getters e setters
    
    public LocalizacaoPet (String sensorId, double latitude, double longitude, LocalDateTime dataHora, String pais, String estado, String cidade, String bairro, String endereco ) {
    	this.sensorId = sensorId;
    	this.latitude = latitude;
    	this.longitude = longitude;
    	this.dataHora = dataHora;
    	this.pais = pais;
    	this.estado = estado;
    	this.cidade = cidade;
    	this.bairro = bairro;
    	this.endereco = endereco;
    }
    
    public LocalizacaoPet() {
    	
    }
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
    public String getSensorId() {
    	return sensorId;
    }
    
    public void setSensorId(String sensorId) {
    	this.sensorId = sensorId;
    }
    
    public double getLatitude() {
    	return latitude;
    }
    
    public void setLatitude(double latitude) {
    	this.latitude = latitude;
    }
    
    public double getLongitude () {
    	return longitude;
    }
    
    public void setLongitude(double longitude) {
    	this.longitude = longitude;
    }
    
    public LocalDateTime getDataHora() {
    	return dataHora;
    }
    
    public void setDataHora(LocalDateTime dataHora) {
    	this.dataHora = dataHora;
    }
    
    public String getPais() {
    	return pais;
    }
    
    public void setPais(String pais) {
    	this.pais = pais;
    }
    
    public String getEstado() {
    	return estado;
    }
    
    public void setEstado(String estado) {
    	this.estado = estado;
    }
    
    public String getCidade() {
    	return cidade;
    }
    
    public void  setCidade(String cidade) {
    	this.cidade = cidade;
    }
    
    public String getBairro() {
    	return bairro;
    }
    
    public void setBairro(String bairro) {
    	this.bairro = bairro;
    }
    
    public String getEndereco() {
    	return endereco;
    }
    
    public void setEndereco (String endereco) {
    	this.endereco = endereco;
    }
    	
}
