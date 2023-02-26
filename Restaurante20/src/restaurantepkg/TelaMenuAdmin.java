package restaurantepkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenuAdmin {
    private JPanel telaMenuAdm;
    private JButton registrarPratoNoCardápioButton;
    private JButton registrarClienteButton;

public TelaMenuAdmin() {
    TelaCardapio telaCardapio = new TelaCardapio();
    TelaRegistro telaRegistro = new TelaRegistro();

    registrarPratoNoCardápioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            telaCardapio.iniciarTelaCriarCardapio();
        }
    });
    registrarClienteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            telaRegistro.iniciarTelaRegistro();
        }
    });


}
    public void iniciarTelaAdmin() {
        JFrame frame = new JFrame("Menu Admin");
        frame.setContentPane(new TelaMenuAdmin().telaMenuAdm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
