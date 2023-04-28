package restauranteView;

import restauranteAplication.ExecutaTelas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAvaliacao {
    public JPanel telaAvaliacaoPrato;
    public static String avaliacaoSelecionada, comentarioAvaliativo;
    public static int  indexPedidoAtualParaAvaliacao;
    private static int pedidosNaoAvaliados = TelaCardapio.listaDePedidos.size();
    private JButton botaoEstrela1, botaoEstrela2, botaoEstrela3, botaoEstrela4, botaoEstrela5;
    private JLabel nomePrato;

    public TelaAvaliacao() {

        if (pedidosNaoAvaliados == 0) {
            ExecutaTelas.frameTelaAvaliacoes.dispose();
        }

        nomePrato.setText(TelaCardapio.listaDePedidos.get(indexPedidoAtualParaAvaliacao).getItenspedidos());
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
        TelaCardapio.listaDePedidos.get(indexPedidoAtualParaAvaliacao).setAvaliacao5Star(TelaAvaliacao.avaliacaoSelecionada);
        TelaCardapio.listaDePedidos.get(indexPedidoAtualParaAvaliacao).setAvaliacaoFinal(TelaAvaliacao.comentarioAvaliativo);
        TelaCardapio.pedidoDAO.save(TelaCardapio.listaDePedidos.get(indexPedidoAtualParaAvaliacao));

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

