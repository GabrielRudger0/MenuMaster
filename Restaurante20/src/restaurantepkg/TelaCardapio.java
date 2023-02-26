package restaurantepkg;

import restauranteDAO.CardapioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaCardapio {
    private JTextField insiraNomePrato;
    private JTextField insiraRestricoes;
    private JComboBox selecionaCategoria;
    private JButton disponivelButton;
    private JButton indisponivelButton;
    private JTextField insiraIngredientes;
    private JTextField insiraPreco;
    private JButton confirmarButton;
    private JButton voltarButton;
    private JPanel telaCriacaoCardapio;
    private JComboBox comboBox1;
    private JTextField textField1;

    public TelaCardapio() {

        CardapioDAO cardapioDAO = new CardapioDAO();
        Cardapio cardapioObject = new Cardapio();

        insiraNomePrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardapioObject.setNome_prato(insiraNomePrato.getText());

            }
        });
        insiraPreco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardapioObject.setPreco(Float.parseFloat(insiraPreco.getText()));

            }
        });
        disponivelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardapioObject.setDisponibilidade("Sim");

            }
        });
        indisponivelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardapioObject.setDisponibilidade("Não");

            }
        });
        insiraRestricoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardapioObject.setRestricoes(insiraRestricoes.getText());

            }
        });
        insiraIngredientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardapioObject.setIngredientes(insiraIngredientes.getText());
                System.out.println(cardapioObject.getIngredientes());
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardapioDAO.save(cardapioObject);
                JOptionPane.showMessageDialog(null,"Item registrado no cardápio","Cardapio",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);

            }
        });

        selecionaCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selecionado = (String) selecionaCategoria.getSelectedItem();
                cardapioObject.setCategoria(selecionado);
            }
        });
    }
    public void iniciarTelaCriarCardapio() {
        JFrame frame = new JFrame("Cardapio");
        frame.setContentPane(new TelaCardapio().telaCriacaoCardapio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}