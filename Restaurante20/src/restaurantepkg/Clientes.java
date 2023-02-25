package restaurantepkg;

import java.util.Date;

public class Clientes {



    private String nomeCliente;
    private String cepCliente;
    private String emailCliente;
    private String telefoneCliente;
    private int idCliente;
    private String senha_cliente;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    public String getSenha_cliente() {
        return senha_cliente;
    }

    public void setSenha_cliente(String senha_cliente) {
        this.senha_cliente = senha_cliente;
    }
}
