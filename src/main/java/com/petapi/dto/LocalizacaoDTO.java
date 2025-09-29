package com.petapi.dto;

import java.time.LocalDateTime;

public class LocalizacaoDTO {
    private String sensorId;
    private double latitude;
    private double longitude;
    private LocalDateTime dataHora;
    
    public LocalizacaoDTO () {};
    
    public LocalizacaoDTO ( String sensorId, double latitude, double longitude, LocalDateTime dataHora ) {
    	this.sensorId = sensorId;
    	this.latitude = latitude;
    	this.longitude = longitude;
    	this.dataHora = dataHora;
    }
    // Getters e setters
    
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
    
    public double getLongitude() {
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
}
