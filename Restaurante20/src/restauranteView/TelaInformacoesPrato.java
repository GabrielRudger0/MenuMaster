package restauranteView;

import restauranteDAO.CardapioDAO;
import restaurantePKG.CardapioPKG;
import restauranteAplication.ExecutaTelas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TelaInformacoesPrato {
    public JPanel InformacoesPrato;
    private CardapioDAO cardapioDAO = new CardapioDAO();
    private DecimalFormat df = new DecimalFormat("R$ ##0.00");
    private JLabel nomePrato, precoPrato, categoriaPrato, disponibilidadePrato,
            restricoesPrato, ingredientesPrato;
    private JButton voltarButton;

    public TelaInformacoesPrato(int index) {

        CardapioPKG prato = new CardapioPKG();
        prato = cardapioDAO.getCardapio().get(index);

        nomePrato.setText(prato.getNome_prato());
        precoPrato.setText(df.format(prato.getPreco()));
        categoriaPrato.setText(prato.getCategoria());
        disponibilidadePrato.setText(prato.getDisponibilidade());
        restricoesPrato.setText(prato.getRestricoes());
        ingredientesPrato.setText(prato.getIngredientes());

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas.frameTelaInformacoesPrato.dispose();
            }
        });


    }

}
