package restauranteView;

import restauranteAplication.ExecutaTelas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAdminMenu {
    public JPanel telaMenuAdm;
    private JButton registrarPratoButton, registrarClienteButton, contabilidadeMenuButton,
        botaoVoltar;


    public TelaAdminMenu() {

    ExecutaTelas executaTelas = new ExecutaTelas();

    contabilidadeMenuButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExecutaTelas.frameTelaAdminMenu.dispose();
            executaTelas.iniciarTelaContabil();
        }
    });

    registrarPratoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExecutaTelas.frameTelaAdminMenu.dispose();
            executaTelas.iniciarTelaCriarCardapio();
        }
    });
    registrarClienteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            ExecutaTelas.frameTelaAdminMenu.dispose();
            TelaRegistroCliente.entrandoComoAdmRegistro = true;
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
                    ExecutaTelas.frameTelaAdminMenu.dispose();
                    executaTelas.iniciarTelaLogin();

                } else if (opcaoSelecionada == 1) {
                    System.exit(0);
                }

            }
        });

    }
}
