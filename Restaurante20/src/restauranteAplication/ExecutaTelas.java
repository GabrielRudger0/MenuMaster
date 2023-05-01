package restauranteAplication;


import restauranteView.*;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ExecutaTelas {

    public static JFrame frameTelaAdminMenu = new JFrame("Menu Admin");

    public static JFrame frameTelaRegistroCliente = new JFrame("Registro de Cliente");

    public static JFrame frameTelaLogin = new JFrame("MenuMaster");

    public static JFrame frameTelaCardapio = new JFrame("Cardápio");

    public static JFrame frameTelaRegistroCardapio = new JFrame("Registrar Item no Cardápio");

    public static JFrame frameTelaAvaliacoes = new JFrame("Avalie nosso serviço!");

    public static JFrame frameTelaContabilMenu = new JFrame("Contabilidade");

    public static JFrame FrameTelaContabilRelatorio = new JFrame("Relatório Geral");

    public static JFrame FrameTelaContabilDespesas = new JFrame("Despesas");

    public static JFrame frameTelaInformacoesPrato = new JFrame("Informações");

    public static JFrame FrameTelaContabilReceita = new JFrame("Receita");

    private static URL url;

    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public void iniciarTelaAdmin() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaAdminMenu.setContentPane(new TelaAdminMenu().telaMenuAdm);
        frameTelaAdminMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaAdminMenu.pack();
        frameTelaAdminMenu.setVisible(true);
        frameTelaAdminMenu.setLocation((dim.width- frameTelaAdminMenu.getSize().width)/2, dim.height/2- frameTelaAdminMenu.getSize().height/2);
        frameTelaAdminMenu.setIconImage(icon.getImage());

    }
    public void iniciarTelaRegistro() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaRegistroCliente.setContentPane(new TelaRegistroCliente().telaRegistroCliente);
        frameTelaRegistroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaRegistroCliente.pack();
        frameTelaRegistroCliente.setVisible(true);
        frameTelaRegistroCliente.setLocation((dim.width- frameTelaRegistroCliente.getSize().width)/2, dim.height/2- frameTelaRegistroCliente.getSize().height/2);
        frameTelaRegistroCliente.setIconImage(icon.getImage());

    }
    public void iniciarTelaLogin() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaLogin.setContentPane(new TelaLogin().telaLogin);
        frameTelaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaLogin.pack();
        frameTelaLogin.setVisible(true);
        frameTelaLogin.setLocation(dim.width/2-frameTelaLogin.getSize().width/2, dim.height/2-frameTelaLogin.getSize().height/2);
        frameTelaLogin.setIconImage(icon.getImage());
    }

    public void iniciarTelaFazerPedido() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaCardapio.setContentPane(new TelaCardapio().FazerPedido);
        frameTelaCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaCardapio.pack();
        frameTelaCardapio.setVisible(true);
        frameTelaCardapio.setLocation(dim.width/2- frameTelaCardapio.getSize().width/2, dim.height/2- frameTelaCardapio.getSize().height/2);
        frameTelaCardapio.setIconImage(icon.getImage());
    }

    public void iniciarTelaCriarCardapio() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaRegistroCardapio.setContentPane(new TelaRegistroCardapio().telaCriacaoCardapio);
        frameTelaRegistroCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaRegistroCardapio.pack();
        frameTelaRegistroCardapio.setVisible(true);
        frameTelaRegistroCardapio.setLocation(dim.width/2- frameTelaRegistroCardapio.getSize().width/2, dim.height/2- frameTelaRegistroCardapio.getSize().height/2);
        frameTelaRegistroCardapio.setIconImage(icon.getImage());
    }
    public void iniciarTelaAvaliacoes() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaAvaliacoes.setContentPane(new TelaAvaliacao().telaAvaliacaoPrato);
        frameTelaAvaliacoes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaAvaliacoes.pack();
        frameTelaAvaliacoes.setVisible(true);
        frameTelaAvaliacoes.setLocation(dim.width/2-frameTelaAvaliacoes.getSize().width/2, dim.height/2-frameTelaAvaliacoes.getSize().height/2);
        frameTelaAvaliacoes.setIconImage(icon.getImage());


    }
    public void iniciarTelaContabil() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaContabilMenu.setContentPane(new TelaContabilMenu().TelaContabilidadeMenu);
        frameTelaContabilMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaContabilMenu.pack();
        frameTelaContabilMenu.setVisible(true);
        frameTelaContabilMenu.setLocation(dim.width/2- frameTelaContabilMenu.getSize().width/2, dim.height/2- frameTelaContabilMenu.getSize().height/2);
        frameTelaContabilMenu.setIconImage(icon.getImage());

    }
    public void iniciarTelaRelatorio() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        FrameTelaContabilRelatorio.setContentPane(new TelaContabilRelatorio().FrameTelaRelatorio);
        FrameTelaContabilRelatorio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameTelaContabilRelatorio.pack();
        FrameTelaContabilRelatorio.setVisible(true);
        FrameTelaContabilRelatorio.setLocation(dim.width/2- FrameTelaContabilRelatorio.getSize().width/2, dim.height/2- FrameTelaContabilRelatorio.getSize().height/2);
        FrameTelaContabilRelatorio.setIconImage(icon.getImage());
    }

    public void iniciarTelaReceita(){
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        FrameTelaContabilReceita.setContentPane(new TelaContabilReceita().FrameTelaReceita);
        FrameTelaContabilReceita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameTelaContabilReceita.pack();
        FrameTelaContabilReceita.setVisible(true);
        FrameTelaContabilReceita.setLocation(dim.width/2- FrameTelaContabilReceita.getSize().width/2, dim.height/2- FrameTelaContabilReceita.getSize().height/2);
        FrameTelaContabilReceita.setIconImage(icon.getImage());
    }

    public void iniciarTelaDespesas(){
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        FrameTelaContabilDespesas.setContentPane(new TelaContabilDespesas().FrameTelaDespesas);
        FrameTelaContabilDespesas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameTelaContabilDespesas.pack();
        FrameTelaContabilDespesas.setVisible(true);
        FrameTelaContabilDespesas.setLocation(dim.width/2- FrameTelaContabilReceita.getSize().width/2, dim.height/2- FrameTelaContabilDespesas.getSize().height/2);
        FrameTelaContabilDespesas.setIconImage(icon.getImage());
    }
    public void iniciarTelaInformacoesPedido(int index) {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaInformacoesPrato.setContentPane(new TelaInformacoesPrato(index).InformacoesPrato);
        frameTelaInformacoesPrato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaInformacoesPrato.pack();
        frameTelaInformacoesPrato.setVisible(true);
        frameTelaInformacoesPrato.setLocation(dim.width/2-frameTelaInformacoesPrato.getSize().width/2, dim.height/2-frameTelaInformacoesPrato.getSize().height/2);
        frameTelaInformacoesPrato.setIconImage(icon.getImage());
    }
    private void iconeAplicativo() {
        try {
            url = new URL("https://media.discordapp.net/attachments/1003823464400040058/1082104297250107472/Menyu_1.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(url);
    }
}
