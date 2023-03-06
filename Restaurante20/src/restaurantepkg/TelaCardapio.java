package restaurantepkg;

import restauranteDAO.CardapioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TelaCardapio {
    public JPanel telaCriacaoCardapio;
    private JTextField insiraNomePrato;
    private JTextField insiraRestricoes;
    private JTextField insiraIngredientes;
    private JTextField insiraPreco;
    private JComboBox selecionaCategoria;
    private JButton confirmarButton;
    private JButton voltarButton;
    private JSpinner spinnerDisponibilidade;

    public TelaCardapio() {

        spinnerDisponibilidade.setModel(new SpinnerNumberModel(0, 0, 30, 1));
        CardapioDAO cardapioDAO = new CardapioDAO();
        Cardapio cardapioObject = new Cardapio();
        ExecutaTelas executaTelas = new ExecutaTelas();

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardapioDAO.save(cardapioObject);
                JOptionPane.showMessageDialog(null,"1 Item registrado no cardápio!","Registrar Item no Cardápio",JOptionPane.INFORMATION_MESSAGE);
                ExecutaTelas.frameTelaCardapio.dispose();
                executaTelas.iniciarTelaCriarCardapio();
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
                System.exit(0);
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
        spinnerDisponibilidade.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cardapioObject.setDisponibilidade(spinnerDisponibilidade.getValue() + "");
            }
        });
    }

}