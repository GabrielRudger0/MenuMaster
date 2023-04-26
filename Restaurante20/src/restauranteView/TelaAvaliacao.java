package restauranteView;

import restaurantePKG.CardapioPKG;
import restauranteAplication.ExecutaTelas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAvaliacao {
    public JPanel telaAvaliacaoPrato;

    private JButton botaoEstrela1;

    private JButton botaoEstrela2;

    private JButton botaoEstrela3;

    private JButton botaoEstrela4;

    private JButton botaoEstrela5;

    private JLabel nomePrato;

    private static int pedidosNaoAvaliados = TelaFazerPedido.listaDePedidos.size();

    public static String avaliacaoSelecionada;

    public static String comentarioAvaliativo;

    public static int indexPedidoAtualParaAvaliacao;


    public TelaAvaliacao() {

        if (pedidosNaoAvaliados == 0) {
            ExecutaTelas.frameTelaAvaliacoes.dispose();
        }

        CardapioPKG pratoDoCardapio = new CardapioPKG();

        nomePrato.setText(TelaFazerPedido.listaDePedidos.get(indexPedidoAtualParaAvaliacao).getItenspedidos());
        botaoEstrela1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliacaoSelecionada = "★☆☆☆☆";
                comentarioAvaliativo = comentarioAvaliacao();
                adicionaAvaliacoesNoBanco();
            }
        });
        botaoEstrela2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliacaoSelecionada = "★★☆☆☆";
                comentarioAvaliativo = comentarioAvaliacao();
                adicionaAvaliacoesNoBanco();
            }
        });
        botaoEstrela3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliacaoSelecionada = "★★★☆☆";
                comentarioAvaliativo = comentarioAvaliacao();
                adicionaAvaliacoesNoBanco();
            }
        });
        botaoEstrela4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliacaoSelecionada = "★★★★☆";
                comentarioAvaliativo = comentarioAvaliacao();
                adicionaAvaliacoesNoBanco();
            }
        });
        botaoEstrela5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliacaoSelecionada = "★★★★★";
                comentarioAvaliativo = comentarioAvaliacao();
                adicionaAvaliacoesNoBanco();
            }
        });
    }
    private String comentarioAvaliacao() {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja deixar um comentário sobre o prato?", "Avaliação", JOptionPane.YES_NO_OPTION);
        String comentario = "Sem Comentário";
        if (opcao == JOptionPane.YES_OPTION) {

            comentario = JOptionPane.showInputDialog(null, "Escreva o seu comentário:", "Avaliação", JOptionPane.PLAIN_MESSAGE);
            if (comentario.equals("")) {
                comentario = "Sem Comentário";
            }
            JOptionPane.showMessageDialog(null, "O seu comentário foi: " + comentario, "Avaliação", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Obrigado pela sua escolha!", "Avaliação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Obrigado pela sua avaliação!", "Avaliação", JOptionPane.INFORMATION_MESSAGE);
        }
        return comentario;
    }
    public void adicionaAvaliacoesNoBanco() {
        TelaFazerPedido.listaDePedidos.get(indexPedidoAtualParaAvaliacao).setAvaliacao5Star(TelaAvaliacao.avaliacaoSelecionada);
        TelaFazerPedido.listaDePedidos.get(indexPedidoAtualParaAvaliacao).setAvaliacaoFinal(TelaAvaliacao.comentarioAvaliativo);
        TelaFazerPedido.pedidoDAO.save(TelaFazerPedido.listaDePedidos.get(indexPedidoAtualParaAvaliacao));
        ExecutaTelas.frameTelaAvaliacoes.dispose();
        --pedidosNaoAvaliados;

        if (pedidosNaoAvaliados > 0) {
            ++TelaAvaliacao.indexPedidoAtualParaAvaliacao;
            ExecutaTelas.frameTelaAvaliacoes.dispose();
            ExecutaTelas executaTelas = new ExecutaTelas();
            executaTelas.iniciarTelaAvaliacoes();
        }
    }

}

