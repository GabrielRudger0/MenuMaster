package restaurantepkg;

import restauranteDAO.CardapioDAO;

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
    private static String avaliacaoSelecionada;

    public TelaAvaliacao() {
        Cardapio pratoDoCardapio = new Cardapio();
        botaoEstrela1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliacaoSelecionada = "★☆☆☆☆";
                fechaAvaliacaoAbreLogin();
            }
        });
        botaoEstrela2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliacaoSelecionada = "★★☆☆☆";
                fechaAvaliacaoAbreLogin();
            }
        });
        botaoEstrela3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliacaoSelecionada = "★★★☆☆";
                fechaAvaliacaoAbreLogin();
            }
        });
        botaoEstrela4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliacaoSelecionada = "★★★★☆";
                fechaAvaliacaoAbreLogin();
            }
        });
        botaoEstrela5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliacaoSelecionada = "★★★★★";
                fechaAvaliacaoAbreLogin();
            }
        });
    }
    private void fechaAvaliacaoAbreLogin() {
        ExecutaTelas executaTelas = new ExecutaTelas();
        ExecutaTelas.frameTelaAvaliacoes.dispose();
        executaTelas.iniciarTelaLogin();
    }
    private String comentarioAvaliacao() {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja deixar um comentário sobre o prato?", "Avaliação", JOptionPane.YES_NO_OPTION);
        String comentario = "Sem Comentário";
        if (opcao == JOptionPane.YES_OPTION) {

            comentario = JOptionPane.showInputDialog(null, "Escreva o seu comentário:", "Avaliação", JOptionPane.PLAIN_MESSAGE);

            JOptionPane.showMessageDialog(null, "O seu comentário foi: " + comentario, "Avaliação", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Obrigado pela sua escolha!", "Avaliação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Obrigado pela sua avaliação!", "Avaliação", JOptionPane.INFORMATION_MESSAGE);
        }
        return comentario;
    }


}

