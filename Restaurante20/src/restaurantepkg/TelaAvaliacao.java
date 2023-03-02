package restaurantepkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAvaliacao {
    public JPanel telaAvaliacaoPrato;
    private JButton botaoEstrela1;
    private JButton botaoEstrela2;
    private JButton botaoEstrela3;
    private JButton botaoEstrela4;
    private JButton botaoEstrela5;

    public TelaAvaliacao() {
        botaoEstrela1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechaAvaliacaoAbreLogin();
            }
        });
        botaoEstrela2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechaAvaliacaoAbreLogin();
            }
        });
        botaoEstrela3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechaAvaliacaoAbreLogin();
            }
        });
        botaoEstrela4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechaAvaliacaoAbreLogin();
            }
        });
        botaoEstrela5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechaAvaliacaoAbreLogin();
            }
        });
    }
    private void fechaAvaliacaoAbreLogin() {
        ExecutaTelas executaTelas = new ExecutaTelas();
        ExecutaTelas.frameTelaAvaliacoes.dispose();
        executaTelas.iniciarTelaLogin();
    }


}

