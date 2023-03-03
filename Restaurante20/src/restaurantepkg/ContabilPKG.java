package restaurantepkg;

import java.sql.Date;

public class ContabilPKG {

    private Date data;
    private String descricao;
    private double receitas;
    private double despesas;
    private double saldo;



    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getReceitas() {
        return receitas;
    }

    public void setReceitas(double receitas) {
        this.receitas = receitas;
    }

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
