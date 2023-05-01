package restauranteView;

import restauranteAplication.ExecutaTelas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaContabilMenu {
    public JPanel TelaContabilidadeMenu;
    private JButton relatorioGeralButton, detalhesDeReceitasButton, detalhesDeDespesasButton, botaoVoltar;

    public TelaContabilMenu() {
        ExecutaTelas executaTelas = new ExecutaTelas();

    relatorioGeralButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExecutaTelas.frameTelaContabilMenu.dispose();
            executaTelas.iniciarTelaRelatorio();
        }
    });
    detalhesDeReceitasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        executaTelas.frameTelaContabilMenu.dispose();
        executaTelas.iniciarTelaReceita();
        }
    });
    detalhesDeDespesasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            executaTelas.frameTelaContabilMenu.dispose();
            executaTelas.iniciarTelaDespesas();
        }
    });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ExecutaTelas.frameTelaContabilMenu.dispose();
                executaTelas.iniciarTelaAdmin();
            }
        });
    }
}


