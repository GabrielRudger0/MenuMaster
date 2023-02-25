package restaurantepkg;

import restauranteDAO.CardapioDAO;

import javax.swing.*;

public class TelaInformacoesPrato {
    public CardapioDAO cardapioDAO = new CardapioDAO();
    private JPanel InformacoesPrato;
    private JLabel nomePrato;
    private JLabel precoPrato;
    private JLabel categoriaPrato;
    private JLabel disponibilidadePrato;
    private JLabel restricoesPrato;
    private JLabel ingredientesPrato;

    public TelaInformacoesPrato(int index) {
        Cardapio prato = new Cardapio();
        System.out.println(index);
        prato = cardapioDAO.getCardapio().get(index);

        nomePrato.setText(prato.getNome_prato());
        precoPrato.setText("R$ " + prato.getPreco());
        categoriaPrato.setText(prato.getCategoria());
        disponibilidadePrato.setText(prato.getDisponibilidade());
        restricoesPrato.setText(prato.getRestricoes());
        ingredientesPrato.setText(prato.getIngredientes());
    }
    public void iniciarTelaInformacoesPedido(int index) {
        JFrame frame = new JFrame("Informações");
        frame.setContentPane(new TelaInformacoesPrato(index).InformacoesPrato);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
