package org.pucminas.models;

public class Equipamento {
    private int codigo;
    private String descricao;
    private double valorDiario;
    private Aluguel aluguel;

    public Equipamento() {
    }


    public Equipamento(int codigo, String descricao, double valorDiario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorDiario = valorDiario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public String toString() {
        return "Equipamento (Código: " + codigo + ", Descrição: " + descricao + ")";
    }
}
