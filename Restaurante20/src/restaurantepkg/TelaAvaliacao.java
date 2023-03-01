package restaurantepkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAvaliacao {
    private JPanel telaAvaliacaoPrato;
    private JButton botaoEstrela1;
    private JButton botaoEstrela2;
    private JButton botaoEstrela3;
    private JButton botaoEstrela4;
    private JButton botaoEstrela5;

    public TelaAvaliacao() {
        botaoEstrela1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoEstrela2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoEstrela3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoEstrela4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoEstrela5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void iniciarTelaAvaliacoes() {
        JFrame frame = new JFrame("Avalie nosso serviço!");
        frame.setContentPane(new TelaAvaliacao().telaAvaliacaoPrato);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}

