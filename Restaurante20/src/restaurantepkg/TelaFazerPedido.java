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
    private JLabel nomeBebida1;
    private JLabel descricaoBebida1;
    private JLabel nomePrato3;
    private JLabel DescricaoPrato3;
    private JLabel valorPrato3;
    private JButton fazerPedido3;
    private JButton maisInfos3;
    private JLabel nomePrato4;
    private JLabel DescricaoPrato4;
    private JLabel valorPrato4;
    private JButton fazerPedido4;
    private JButton maisInfos4;
    private JLabel nomePrato5;
    private JLabel DescricaoPrato5;
    private JLabel valorPrato5;
    private JButton fazerPedido5;
    private JButton maisInfos5;

    public TelaFazerPedido() {

        //INSERÇÃO DE PRATOS

        //Prato 1
        if(cardapioDAO.getCardapio().size() >= 1) {
            this.inserirNoCardapio(nomePrato1, DescricaoPrato1, valorPrato1, fazerPedidoButton, maisInformacoes1Button, 0);
        } else {
            fazerPedidoButton.setVisible(false);
            maisInformacoes1Button.setVisible(false);
        }

        //Prato 2
        if(cardapioDAO.getCardapio().size() >= 2) {
            this.inserirNoCardapio(nomePrato2, DescricaoPrato2, valorPrato2, fazerPedido2, maisInfos2, 1);
        } else {
            fazerPedido2.setVisible(false);
            maisInfos2.setVisible(false);
        }

        //Prato 3
        if (cardapioDAO.getCardapio().size() >= 3) {
            this.inserirNoCardapio(nomePrato3, DescricaoPrato3, valorPrato3, fazerPedido3, maisInfos3, 2);
        } else {
            fazerPedido3.setVisible(false);
            maisInfos3.setVisible(false);
        }
        //Prato 4
        if (cardapioDAO.getCardapio().size() >= 4) {
            this.inserirNoCardapio(nomePrato4, DescricaoPrato4, valorPrato4, fazerPedido4, maisInfos4, 3);
        } else {
            fazerPedido4.setVisible(false);
            maisInfos4.setVisible(false);
        }

        if (cardapioDAO.getCardapio().size() >= 5) {
            this.inserirNoCardapio(nomePrato5, DescricaoPrato5, valorPrato5, fazerPedido5, maisInfos5, 4);
        } else {
            fazerPedido5.setVisible(false);
            maisInfos5.setVisible(false);
        }




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

    public void inserirNoCardapio(JLabel nomePrato, JLabel DescricaoPrato, JLabel valorPrato,
                                  JButton fazerPedido, JButton maisInfos, int indexArray) {

        fazerPedido.setVisible(true);
        maisInfos.setVisible(true);
        Cardapio prato = new Cardapio();
        prato = cardapioDAO.getCardapio().get(indexArray);

        String nome1 = prato.getNome_prato();
        String descricao1 = prato.getIngredientes();
        String preco1 = "R$ " + (prato.getPreco());

        nomePrato.setText(nome1);
        DescricaoPrato.setText(descricao1);
        valorPrato.setText(preco1);
    }


}
