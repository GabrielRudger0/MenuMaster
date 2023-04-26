package restauranteView;

import restaurantePKG.ExecutaTelas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenuAdmin {
    public JPanel telaMenuAdm;

    private JButton registrarPratoNoCardápioButton;

    private JButton registrarClienteButton;

    private JButton contabilidadeMenuButton;

    private JButton botaoVoltar;

    public TelaMenuAdmin() {

    TelaCardapio telaCardapio = new TelaCardapio();
    TelaRegistro telaRegistro = new TelaRegistro();
    TelaContabilMenu telaContabilMenu = new TelaContabilMenu();
    ExecutaTelas executaTelas = new ExecutaTelas();


    contabilidadeMenuButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExecutaTelas.frameTelaMenuAdm.dispose();
            executaTelas.iniciarTelaContabil();
        }
    });

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
            TelaRegistro.entrandoComoAdmRegistro = true;
            executaTelas.iniciarTelaRegistro();
        }
    });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opcaoConfirma = {"Logoff", "Fechar Programa"};
                int opcaoSelecionada = JOptionPane.showOptionDialog(null,
                        "Deseja sair da conta e voltar a tela de login?", "Tem Certeza?",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, opcaoConfirma, opcaoConfirma[0]);

                if (opcaoSelecionada == 0) {
                    ExecutaTelas executaTelas = new ExecutaTelas();
                    ExecutaTelas.frameTelaMenuAdm.dispose();
                    executaTelas.iniciarTelaLogin();

                } else if (opcaoSelecionada == 1) {
                    System.exit(0);
                }

            }
        });

    }
}
