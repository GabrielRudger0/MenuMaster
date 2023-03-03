package restaurantepkg;

import RestauranteAplication.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaContabilMenu {
    public JPanel TelaContabilidadeMenu;
    private JButton relatorioGeralButton;
    private JButton detalhesDeReceitasButton;
    private JButton detalhesDeDespesasButton;
    private JButton botaoVoltar;

    public TelaContabilMenu() {

        TelaRelatorioClasse telaRelatorioClasse = new TelaRelatorioClasse();
        ExecutaTelas executaTelas = new ExecutaTelas();

    relatorioGeralButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExecutaTelas.frameTelaContabil.dispose();
            executaTelas.iniciarTelaRelatorio();
        }
    });
    detalhesDeReceitasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    detalhesDeDespesasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ExecutaTelas.frameTelaContabil.dispose();
                executaTelas.iniciarTelaAdmin();
            }
        });
    }

}
