package restaurantepkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenuAdmin {
    private JPanel telaMenuAdm;
    public JFrame frameTelaMenuAdm = new JFrame("Menu Admin");
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
            frameTelaMenuAdm.dispose();
            telaRegistro.iniciarTelaRegistro();
        }
    });


}
    public void iniciarTelaAdmin() {

        frameTelaMenuAdm.setContentPane(new TelaMenuAdmin().telaMenuAdm);
        frameTelaMenuAdm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTelaMenuAdm.pack();
        frameTelaMenuAdm.setVisible(true);

    }
}
