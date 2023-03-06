package restaurantepkg;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ExecutaTelas {
    public static JFrame frameTelaMenuAdm = new JFrame("Menu Admin");
    public static JFrame frameTelaRegistro = new JFrame("Registro de Cliente");
    public static JFrame frameTelaLogin = new JFrame("MenuMaster");
    public static JFrame frameTelaFazerPedido = new JFrame("Cardápio");
    public static JFrame frameTelaCardapio = new JFrame("Registrar Item no Cardápio");
    public static JFrame frameTelaAvaliacoes = new JFrame("Avalie nosso serviço!");
    public static JFrame frameTelaContabil = new JFrame("Contabilidade");
    public static JFrame FrameTelaRelatorio = new JFrame("Registro");
    public static JFrame frameTelaReceita = new JFrame("Receita");
    public static JFrame frameTelaInformacoesPrato = new JFrame("Informações");
    private static URL url;
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();




    public void iniciarTelaAdmin() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaMenuAdm.setContentPane(new TelaMenuAdmin().telaMenuAdm);
        frameTelaMenuAdm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaMenuAdm.pack();
        frameTelaMenuAdm.setVisible(true);
        frameTelaMenuAdm.setLocation((dim.width-frameTelaMenuAdm.getSize().width)/2, dim.height/2-frameTelaMenuAdm.getSize().height/2);
        frameTelaMenuAdm.setIconImage(icon.getImage());

    }
    public void iniciarTelaRegistro() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaRegistro.setContentPane(new TelaRegistro().panel1);
        frameTelaRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaRegistro.pack();
        frameTelaRegistro.setVisible(true);
        frameTelaRegistro.setLocation((dim.width-frameTelaRegistro.getSize().width)/2, dim.height/2-frameTelaRegistro.getSize().height/2);
        frameTelaRegistro.setIconImage(icon.getImage());

    }
    public void iniciarTelaLogin() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaLogin.setContentPane(new Tela().telaLogin);
        frameTelaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaLogin.pack();
        frameTelaLogin.setVisible(true);
        frameTelaLogin.setLocation(dim.width/2-frameTelaLogin.getSize().width/2, dim.height/2-frameTelaLogin.getSize().height/2);
        frameTelaLogin.setIconImage(icon.getImage());
    }

    public void iniciarTelaFazerPedido() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaFazerPedido.setContentPane(new TelaFazerPedido().FazerPedido);
        frameTelaFazerPedido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaFazerPedido.pack();
        frameTelaFazerPedido.setVisible(true);
        frameTelaFazerPedido.setLocation(dim.width/2-frameTelaFazerPedido.getSize().width/2, dim.height/2-frameTelaFazerPedido.getSize().height/2);
        frameTelaFazerPedido.setIconImage(icon.getImage());
    }

    public void iniciarTelaCriarCardapio() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        frameTelaCardapio.setContentPane(new TelaCardapio().telaCriacaoCardapio);
        frameTelaCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaCardapio.pack();
        frameTelaCardapio.setVisible(true);
        frameTelaCardapio.setLocation(dim.width/2-frameTelaCardapio.getSize().width/2, dim.height/2-frameTelaCardapio.getSize().height/2);
        frameTelaCardapio.setIconImage(icon.getImage());
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

        frameTelaContabil.setContentPane(new TelaContabilMenu().TelaContabilidadeMenu);
        frameTelaContabil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaContabil.pack();
        frameTelaContabil.setVisible(true);
        frameTelaContabil.setLocation(dim.width/2-frameTelaContabil.getSize().width/2, dim.height/2-frameTelaContabil.getSize().height/2);
        frameTelaContabil.setIconImage(icon.getImage());

    }
    public void iniciarTelaRelatorio() {
        iconeAplicativo();
        ImageIcon icon = new ImageIcon(url);

        FrameTelaRelatorio.setContentPane(new TelaRelatorioClasse().FrameTelaRelatorio);
        FrameTelaRelatorio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameTelaRelatorio.pack();
        FrameTelaRelatorio.setVisible(true);
        FrameTelaRelatorio.setLocation(dim.width/2-FrameTelaRelatorio.getSize().width/2, dim.height/2-FrameTelaRelatorio.getSize().height/2);
        FrameTelaRelatorio.setIconImage(icon.getImage());
    }

    public void iniciarTelaReceita(){
        frameTelaReceita.setContentPane(new TelaReceita().frameTelaReceita);
        frameTelaReceita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaReceita.pack();
        frameTelaReceita.setVisible(true);
        frameTelaReceita.setLocation(dim.width/2-frameTelaReceita.getSize().width/2, dim.height/2-frameTelaReceita.getSize().height/2);
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
