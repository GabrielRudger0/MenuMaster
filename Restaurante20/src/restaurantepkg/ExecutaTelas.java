package restaurantepkg;

import javax.swing.*;

public class ExecutaTelas {
    public static JFrame frameTelaMenuAdm = new JFrame("Menu Admin");
    public static JFrame frameTelaRegistro = new JFrame("Registro");
    public static JFrame frameTelaLogin = new JFrame("Login");
    public static JFrame frameTelaFazerPedido = new JFrame("Cardapio");
    public static JFrame frameTelaCardapio = new JFrame("Cardapio");
    public static JFrame frameTelaAvaliacoes = new JFrame("Avalie nosso serviço!");
    public static JFrame frameTelaContabil = new JFrame("Contabilidade");
    public static JFrame frameTelaInformacoesPrato = new JFrame("Informações");
    public void iniciarTelaAdmin() {

        frameTelaMenuAdm.setContentPane(new TelaMenuAdmin().telaMenuAdm);
        frameTelaMenuAdm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaMenuAdm.pack();
        frameTelaMenuAdm.setVisible(true);

    }
    public void iniciarTelaRegistro() {

        frameTelaRegistro.setContentPane(new TelaRegistro().panel1);
        frameTelaRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaRegistro.pack();
        frameTelaRegistro.setVisible(true);

    }
    public void iniciarTelaLogin() {

        frameTelaLogin.setContentPane(new Tela().telaLogin);
        frameTelaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaLogin.pack();
        frameTelaLogin.setVisible(true);

    }

    public void iniciarTelaFazerPedido() {


        frameTelaFazerPedido.setContentPane(new TelaFazerPedido().FazerPedido);
        frameTelaFazerPedido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaFazerPedido.pack();
        frameTelaFazerPedido.setVisible(true);


    }

    public void iniciarTelaCriarCardapio() {

        frameTelaCardapio.setContentPane(new TelaCardapio().telaCriacaoCardapio);
        frameTelaCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaCardapio.pack();
        frameTelaCardapio.setVisible(true);

    }
    public void iniciarTelaAvaliacoes() {

        frameTelaAvaliacoes.setContentPane(new TelaAvaliacao().telaAvaliacaoPrato);
        frameTelaAvaliacoes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaAvaliacoes.pack();
        frameTelaAvaliacoes.setVisible(true);


    }
    public void iniciarTelaContabil() {

        frameTelaAvaliacoes.setContentPane(new TelaAvaliacao().telaAvaliacaoPrato);
        frameTelaAvaliacoes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaAvaliacoes.pack();
        frameTelaAvaliacoes.setVisible(true);

    }
    public void iniciarTelaInformacoesPedido(int index) {

        frameTelaInformacoesPrato.setContentPane(new TelaInformacoesPrato(index).InformacoesPrato);
        frameTelaInformacoesPrato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaInformacoesPrato.pack();
        frameTelaInformacoesPrato.setVisible(true);


    }
}
