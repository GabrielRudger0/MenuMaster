package restaurantepkg;

import restauranteDAO.CardapioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;

public class TelaCardapio {
    public JPanel telaCriacaoCardapio;
    private JTextField insiraNomePrato;
    private JTextField insiraRestricoes;
    private JTextField insiraIngredientes;
    private JTextField insiraPreco;
    private JComboBox selecionaCategoria;
    private JButton disponivelButton;
    private JButton indisponivelButton;
    private JButton confirmarButton;
    private JButton voltarButton;

    public TelaCardapio() {

        CardapioDAO cardapioDAO = new CardapioDAO();
        Cardapio cardapioObject = new Cardapio();

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


        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardapioDAO.save(cardapioObject);
                int cont = 0;
                JOptionPane.showMessageDialog(null,(cont+1)+"Item registrado no cardápio!","Cardapio",JOptionPane.INFORMATION_MESSAGE);

            }
        });

        selecionaCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selecionado = (String) selecionaCategoria.getSelectedItem();
                cardapioObject.setCategoria(selecionado);
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ExecutaTelas.frameTelaCardapio.dispose();
                executaTelas.iniciarTelaAdmin();
            }
        });
        insiraNomePrato.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                cardapioObject.setNome_prato(insiraNomePrato.getText());
            }
        });
        insiraPreco.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                cardapioObject.setPreco(Float.parseFloat(insiraPreco.getText()));
            }
        });
        insiraRestricoes.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                cardapioObject.setRestricoes(insiraRestricoes.getText());
            }
        });
        insiraIngredientes.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                cardapioObject.setIngredientes(insiraIngredientes.getText());
            }
        });
    }

}