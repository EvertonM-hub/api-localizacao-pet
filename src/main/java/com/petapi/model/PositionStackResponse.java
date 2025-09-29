package com.petapi.model;

import java.util.List;

public class PositionStackResponse {
    private List<Endereco> data;

    //  Construtor vazio
    public PositionStackResponse() {}

    //  Construtor com lista
    public PositionStackResponse(List<Endereco> data) {
        this.data = data;
    }

    //  Getter e Setter
    public List<Endereco> getData() {
        return data;
    }

    public void setData(List<Endereco> data) {
        this.data = data;
    }
}
