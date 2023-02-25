package restaurantepkg;

import restauranteDAO.CardapioDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFazerPedido {

    public CardapioDAO cardapioDAO = new CardapioDAO();
    private JPanel FazerPedido;
    private JLabel MenuMaster;
    private JLabel nomePrato1;
    private JLabel DescricaoPrato1;
    private JLabel valorPrato1;
    private JButton fazerPedidoButton;
    private JButton maisInformacoes1Button;
    private JButton fazerPedido2;
    private JButton maisInfos2;
    private JLabel nomePrato2;
    private JLabel DescricaoPrato2;
    private JLabel valorPrato2;

    public TelaFazerPedido() {

        //Prato1
        Cardapio prato1 = new Cardapio();
        prato1 = cardapioDAO.getCardapio().get(0);

        String nome1 = prato1.getNome_prato();
        String descricao1 = prato1.getIngredientes();
        String preco1 = "R$ " + (prato1.getPreco());

        nomePrato1.setText(nome1);
        DescricaoPrato1.setText(descricao1);
        valorPrato1.setText(preco1);

        //Prato2
        Cardapio prato2 = new Cardapio();
        prato2 = cardapioDAO.getCardapio().get(1);

        String nome2 = prato2.getNome_prato();
        String descricao2 = prato2.getIngredientes();
        String preco2 = "R$ " + (prato2.getPreco());

        nomePrato2.setText(nome2);
        DescricaoPrato2.setText(descricao2);
        valorPrato2.setText(preco2);

        maisInformacoes1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaInformacoesPrato telaInformacoes = new TelaInformacoesPrato(0);
                telaInformacoes.iniciarTelaInformacoesPedido(0);

            }
        });
        maisInfos2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaInformacoesPrato telaInformacoes = new TelaInformacoesPrato(1);
                telaInformacoes.iniciarTelaInformacoesPedido(1);
            }
        });
    }

    public void iniciarTelaFazerPedido() {
        JFrame frame = new JFrame("Cardapio");
        frame.setContentPane(new TelaFazerPedido().FazerPedido);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
    public int indexArray(int indexSelecionado) {
        return indexSelecionado;
    }


}
