package restaurantepkg;

import javax.swing.*;
import java.awt.*;

public class ExecutaTelas {
    public static JFrame frameTelaMenuAdm = new JFrame("Menu Admin");
    public static JFrame frameTelaRegistro = new JFrame("Registro");
    public static JFrame frameTelaLogin = new JFrame("Login");
    public static JFrame frameTelaFazerPedido = new JFrame("Cardapio");
    public static JFrame frameTelaCardapio = new JFrame("Cardapio");
    public static JFrame frameTelaAvaliacoes = new JFrame("Avalie nosso serviço!");
    public static JFrame frameTelaContabil = new JFrame("Contabilidade");
    public static JFrame frameTelaInformacoesPrato = new JFrame("Informações");
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public void iniciarTelaAdmin() {

        frameTelaMenuAdm.setContentPane(new TelaMenuAdmin().telaMenuAdm);
        frameTelaMenuAdm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaMenuAdm.pack();
        frameTelaMenuAdm.setVisible(true);
        frameTelaMenuAdm.setLocation((dim.width-frameTelaMenuAdm.getSize().width)/2, dim.height/2-frameTelaMenuAdm.getSize().height/2);


    }
    public void iniciarTelaRegistro() {

        frameTelaRegistro.setContentPane(new TelaRegistro().panel1);
        frameTelaRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaRegistro.pack();
        frameTelaRegistro.setVisible(true);
        frameTelaRegistro.setLocation((dim.width-frameTelaRegistro.getSize().width)/2, dim.height/2-frameTelaRegistro.getSize().height/2);


    }
    public void iniciarTelaLogin() {

        frameTelaLogin.setContentPane(new Tela().telaLogin);
        frameTelaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaLogin.pack();
        frameTelaLogin.setVisible(true);
        frameTelaLogin.setLocation(dim.width/2-frameTelaLogin.getSize().width/2, dim.height/2-frameTelaLogin.getSize().height/2);

    }

    public void iniciarTelaFazerPedido() {

        frameTelaFazerPedido.setContentPane(new TelaFazerPedido().FazerPedido);
        frameTelaFazerPedido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaFazerPedido.pack();
        frameTelaFazerPedido.setVisible(true);
        frameTelaFazerPedido.setLocation(dim.width/2-frameTelaFazerPedido.getSize().width/2, dim.height/2-frameTelaFazerPedido.getSize().height/2);
    }

    public void iniciarTelaCriarCardapio() {

        frameTelaCardapio.setContentPane(new TelaCardapio().telaCriacaoCardapio);
        frameTelaCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaCardapio.pack();
        frameTelaCardapio.setVisible(true);
        frameTelaCardapio.setLocation(dim.width/2-frameTelaCardapio.getSize().width/2, dim.height/2-frameTelaCardapio.getSize().height/2);

    }
    public void iniciarTelaAvaliacoes() {

        frameTelaAvaliacoes.setContentPane(new TelaAvaliacao().telaAvaliacaoPrato);
        frameTelaAvaliacoes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaAvaliacoes.pack();
        frameTelaAvaliacoes.setVisible(true);
        frameTelaAvaliacoes.setLocation(dim.width/2-frameTelaAvaliacoes.getSize().width/2, dim.height/2-frameTelaAvaliacoes.getSize().height/2);



    }
    public void iniciarTelaContabil() {

        frameTelaAvaliacoes.setContentPane(new TelaAvaliacao().telaAvaliacaoPrato);
        frameTelaAvaliacoes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaAvaliacoes.pack();
        frameTelaAvaliacoes.setVisible(true);
        frameTelaAvaliacoes.setLocation(dim.width/2-frameTelaLogin.getSize().width/2, dim.height/2-frameTelaLogin.getSize().height/2);


    }
    public void iniciarTelaInformacoesPedido(int index) {

        frameTelaInformacoesPrato.setContentPane(new TelaInformacoesPrato(index).InformacoesPrato);
        frameTelaInformacoesPrato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaInformacoesPrato.pack();
        frameTelaInformacoesPrato.setVisible(true);
        frameTelaInformacoesPrato.setLocation(dim.width/2-frameTelaInformacoesPrato.getSize().width/2, dim.height/2-frameTelaInformacoesPrato.getSize().height/2);

    }
}
