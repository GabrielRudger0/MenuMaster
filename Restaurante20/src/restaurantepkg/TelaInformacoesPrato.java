package restaurantepkg;

import restauranteDAO.CardapioDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TelaInformacoesPrato {
    public JPanel InformacoesPrato;
    private CardapioDAO cardapioDAO = new CardapioDAO();
    private DecimalFormat df = new DecimalFormat("R$ ##0.00");
    private JLabel nomePrato;
    private JLabel precoPrato;
    private JLabel categoriaPrato;
    private JLabel disponibilidadePrato;
    private JLabel restricoesPrato;
    private JLabel ingredientesPrato;
    private JButton voltarButton;

    public TelaInformacoesPrato(int index) {

        Cardapio prato = new Cardapio();
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
