package restaurantepkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenuAdmin {
    public JPanel telaMenuAdm;
    private JButton registrarPratoNoCardápioButton;
    private JButton registrarClienteButton;
    private JButton botaoVoltar;

    public TelaMenuAdmin() {
    TelaCardapio telaCardapio = new TelaCardapio();
    TelaRegistro telaRegistro = new TelaRegistro();
    ExecutaTelas executaTelas = new ExecutaTelas();
    registrarPratoNoCardápioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExecutaTelas.frameTelaMenuAdm.dispose();
            executaTelas.iniciarTelaCriarCardapio();
        }
    });
    registrarClienteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            ExecutaTelas.frameTelaMenuAdm.dispose();
            executaTelas.iniciarTelaRegistro();
        }
    });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opcaoConfirma = {"Voltar ao Cardapio", "Sair"};
                int opcaoSelecionada = JOptionPane.showOptionDialog(null,
                        "Deseja sair da conta e voltar a tela de login?", "Menu Admin",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, opcaoConfirma, opcaoConfirma[0]);

                if (opcaoSelecionada == 1) {
                    ExecutaTelas executaTelas = new ExecutaTelas();
                    ExecutaTelas.frameTelaMenuAdm.dispose();
                    executaTelas.iniciarTelaLogin();
                }
            }
        });
    }
}
