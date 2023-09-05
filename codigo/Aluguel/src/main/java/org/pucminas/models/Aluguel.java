package org.pucminas.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Aluguel {
    private Cliente cliente;
    private Equipamento equipamento;
    private String dataInicio;
    private String dataFim;
    private double valorTotalAluguel;

    public Aluguel(Cliente cliente, Equipamento equipamento, String dataInicio, String dataFim) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        calcularValorTotalAluguel();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public void calcularValorTotalAluguel() {
        long numDias = calcularDiferencaDias(dataInicio, dataFim);
        valorTotalAluguel = numDias * this.getValorAluguelPorDia();
    }

    public double getValorTotalAluguel() {
        return valorTotalAluguel;
    }

    public void setValorTotalAluguel(double valorTotalAluguel) {
        this.valorTotalAluguel = valorTotalAluguel;
    }

    private long getDiasDeAluguel() {
        return calcularDiferencaDias(dataInicio, dataFim);
    }

    private long calcularDiferencaDias(String dataInicioStr, String dataFimStr) {
        LocalDate dataInicio = LocalDate.parse(dataInicioStr);
        LocalDate dataFim = LocalDate.parse(dataFimStr);
        return ChronoUnit.DAYS.between(dataInicio, dataFim);
    }

    private double getValorAluguelPorDia() {
        return this.getEquipamento().getValorDiario();
    }

    @Override
    public String toString() {
        return "cliente :" + cliente.getNome() +
                ", \nequipamento:" + equipamento.getDescricao() +
                ", \ndataInicio:'" + dataInicio + '\'' +
                ", \ndataFim:'" + dataFim + '\'' +
                ", \nduração:" + getDiasDeAluguel() + " dias " +
                ", \nvalor aluguel por dia: " + getValorAluguelPorDia()+
                ", \nvalor total do aluguel: " + getValorTotalAluguel();
    }
}
