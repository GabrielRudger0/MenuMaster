package restauranteView;

import restauranteDAO.CardapioDAO;
import restauranteDAO.ContabilDAO;
import restauranteDAO.PedidoDAO;
import restaurantePKG.CardapioPKG;
import restaurantePKG.ContabilPKG;
import restauranteAplication.ExecutaTelas;
import restaurantePKG.PedidoPKG;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class TelaCardapio {
    public JPanel FazerPedido;
    private CardapioDAO cardapioDAO = new CardapioDAO();
    private int[] sequencialIndexes = {-1,-1,-1,-1,-1};
    private DecimalFormat df = new DecimalFormat("R$ ##0.00");
    public static String nomeUsuarioAtual;
    public static PedidoDAO pedidoDAO = new PedidoDAO();
    public static ArrayList<PedidoPKG> listaDePedidos = new ArrayList<>();
    private static double valorDaCompra, valorPrato;
    private static int[] quantidadePedido = new int[5];
    private JLabel nomeUsuario, idUsuario;
    private JLabel MenuMaster,
            nomePrato1, descricaoPrato1, valorPrato1,
            nomePrato2, descricaoPrato2, valorPrato2,
            nomePrato3, descricaoPrato3, valorPrato3,
            nomePrato4, descricaoPrato4, valorPrato4,
            nomePrato5, descricaoPrato5, valorPrato5;
    private JLabel
            nomeBebida1, descricaoBebida1, valorBebida1,
            nomeBebida2, descricaoBebida2, valorBebida2,
            nomeBebida3, descricaoBebida3, valorBebida3,
            nomeBebida4, descricaoBebida4, valorBebida4,
            nomeBebida5, descricaoBebida5, valorBebida5;
    private JButton
            fazerPedido1, maisInfos1,
            fazerPedido2, maisInfos2,
            fazerPedido3, maisInfos3,
            fazerPedido4, maisInfos4,
            fazerPedido5, maisInfos5;

    private JButton fazerPedidoBebida1, fazerPedidoBebida2, fazerPedidoBebida3,
            fazerPedidoBebida4, fazerPedidoBebida5;

    private JButton botaoConfirmarCompra, botaoCancelar, botaoSair;
    private JSpinner spinnerPedido1, spinnerPedido2, spinnerPedido3, spinnerPedido4, spinnerPedido5,
            spinnerBebida1, spinnerBebida2, spinnerBebida3, spinnerBebida4, spinnerBebida5;
    private JSpinner[] spinners = {spinnerPedido1, spinnerPedido2, spinnerPedido3, spinnerPedido4, spinnerPedido5,  spinnerBebida1, spinnerBebida2, spinnerBebida3, spinnerBebida4, spinnerBebida5};

    public TelaCardapio() {

        nomeUsuario.setText(nomeUsuarioAtual);
        idUsuario.setText("Identificação: " + PedidoDAO.idClienteAtual);

        ExecutaTelas executaTelas = new ExecutaTelas();

        //INSERÇÃO DE PRATOS
        // E BEBIDAS

        //Prato/Bebida 1
        registrarBebibaOuPrato( nomePrato1,descricaoPrato1,valorPrato1,
                                nomeBebida1, descricaoBebida1, valorBebida1,
                                fazerPedido1, maisInfos1, spinnerPedido1,
                                fazerPedidoBebida1, spinnerBebida1, 0, 1);

        //Prato/Bebida 2
        registrarBebibaOuPrato( nomePrato2,descricaoPrato2,valorPrato2,
                nomeBebida2, descricaoBebida2, valorBebida2,
                fazerPedido2, maisInfos2, spinnerPedido2,
                fazerPedidoBebida2, spinnerBebida2, 1, 2);

        //Prato/Bebida 3
        registrarBebibaOuPrato( nomePrato3,descricaoPrato3,valorPrato3,
                nomeBebida3, descricaoBebida3, valorBebida3,
                fazerPedido3, maisInfos3, spinnerPedido3,
                fazerPedidoBebida3, spinnerBebida3, 2, 3);

        //Prato/Bebida 4
        registrarBebibaOuPrato( nomePrato4,descricaoPrato4,valorPrato4,
                nomeBebida4, descricaoBebida4, valorBebida4,
                fazerPedido4, maisInfos4, spinnerPedido4,
                fazerPedidoBebida4, spinnerBebida4, 3, 4);

        //Prato/Bebida 5
        registrarBebibaOuPrato( nomePrato5,descricaoPrato5,valorPrato5,
                nomeBebida5, descricaoBebida5, valorBebida5,
                fazerPedido5, maisInfos5, spinnerPedido5,
                fazerPedidoBebida5, spinnerBebida5, 4, 5);

        // --------------------------------
        // BOTÕES DE "INFO" E "FAZER PEDIDO"

        maisInfos1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executaTelas.iniciarTelaInformacoesPedido(0);

            }
        });
        maisInfos2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executaTelas.iniciarTelaInformacoesPedido(1);
            }
        });
        maisInfos3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executaTelas.iniciarTelaInformacoesPedido(2);
            }
        });
        maisInfos4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executaTelas.iniciarTelaInformacoesPedido(3);
            }
        });
        maisInfos5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executaTelas.iniciarTelaInformacoesPedido(4);
            }
        });

        fazerPedido1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPedido(0);

            }
        });
        fazerPedido2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPedido(1);
            }
        });
        fazerPedido3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPedido(2);
            }
        });
        fazerPedido4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPedido(3);
            }
        });
        fazerPedido5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPedido(4);
            }
        });
        fazerPedidoBebida1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = sequencialIndexes[0];
                registrarPedido(sequencialIndexes[index]);
            }
        });
        fazerPedidoBebida2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = sequencialIndexes[1];
                registrarPedido(index);
            }
        });
        fazerPedidoBebida3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sequencialIndexes[2] != -1) {
                    registrarPedido(sequencialIndexes[2]);
                }
            }
        });
        fazerPedidoBebida4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sequencialIndexes[3] != -1){
                    registrarPedido(sequencialIndexes[3]);
                }

            }
        });
        fazerPedidoBebida5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sequencialIndexes[4] != -1) {
                    registrarPedido(sequencialIndexes[4]);
                }
            }
        });

        // FIM BOTÕES DE "INFO" E "FAZER PEDIDO"
        // --------------------------------

        // --------------------------------
        // BOTÕES DE FINALIZAÇÃO
        botaoConfirmarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opcaoConfirma = {"Confirmar", "Sair"};
                String pratosPedidos = "Comanda Cliente(ID: " + PedidoDAO.idClienteAtual + "): ";
                String texto = "Itens Pedidos: \n\n";
                boolean erroPedidos = false;

                if (listaDePedidos.size() == 0) {
                    erroPedidos = true;
                }

                for (int i = 0; i <= listaDePedidos.size() - 1; i++) {
                    if (Integer.parseInt(listaDePedidos.get(i).getQuantidade()) == 0) {
                        JOptionPane.showMessageDialog(null, "Erro!\nQuantidade inválida, itens removidos do carrinho.", "Finalizar Pedido", JOptionPane.ERROR_MESSAGE);
                        listaDePedidos.removeAll(listaDePedidos);
                        erroPedidos = true;
                        texto = "Itens Pedidos: \n\n";
                        valorDaCompra = 0;
                        break;
                    }

                }
                if (erroPedidos == false) {
                    for (int i = 0; i <= listaDePedidos.size() - 1; i++) {
                        String obs = listaDePedidos.get(i).getObservacao();
                        pratosPedidos += listaDePedidos.get(i).getQuantidade() + " " + listaDePedidos.get(i).getItenspedidos() + "; ";

                        texto +=
                                "Prato/Bebida: " + listaDePedidos.get(i).getItenspedidos() +
                                        "\nQuantidade: " + listaDePedidos.get(i).getQuantidade() +
                                        "\nObservação: " + obs + "\n\n";
                    }
                    texto += "Valor Total: " + df.format(valorDaCompra) + "\n";

                    int opcaoSelecionada = JOptionPane.showOptionDialog(null, texto, "Finalizar Pedido", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, opcaoConfirma, opcaoConfirma[0]);
                    if (opcaoSelecionada == 0) {
                        JOptionPane.showMessageDialog(null, "Seu pedido chegará em instantes, Obrigado!","Cardápio",JOptionPane.INFORMATION_MESSAGE);

                        enviaComandaParaContabil(pratosPedidos);

                        TelaAvaliacao.indexPedidoAtualParaAvaliacao = 0;
                        executaTelas.iniciarTelaAvaliacoes();
                        ExecutaTelas.frameTelaCardapio.dispose();

                    }
                }

            }
        });

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fazer um delete para deletar todos os pedidos do usuario
                //ou apenas um
                listaDePedidos.removeAll(listaDePedidos);
                JOptionPane.showMessageDialog(null,"Itens removidos do carrinho.","Carrinho",JOptionPane.INFORMATION_MESSAGE);
                valorDaCompra = 0;
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opcaoConfirma = {"Voltar ao Cardápio", "Sair"};
                int opcaoSelecionada = JOptionPane.showOptionDialog(null,
                        "Deseja sair da conta e voltar a tela de login?", "Cardápio",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, opcaoConfirma, opcaoConfirma[0]);

                if (opcaoSelecionada == 1) {
                    ExecutaTelas executaTelas = new ExecutaTelas();
                    ExecutaTelas.frameTelaCardapio.dispose();
                    executaTelas.iniciarTelaLogin();
                }

            }
        });
        // FIM BOTÕES DE FINALIZAÇÃO
        // --------------------------------

        for (int i = 0; i < 10; i++) {
            spinners[i].setModel(new SpinnerNumberModel(0, 0, 15, 1));
        }

        spinnerPedido1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido[0] = (int) spinnerPedido1.getValue();

            }
        });
        spinnerPedido2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido[1] = (int) spinnerPedido2.getValue();
            }
        });
        spinnerPedido3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido[2] = (int) spinnerPedido3.getValue();
            }
        });
        spinnerPedido4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido[3] = (int) spinnerPedido4.getValue();
            }
        });
        spinnerPedido5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido[4] = (int) spinnerPedido5.getValue();
            }
        });
        spinnerBebida1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido[0] = (int) spinnerBebida1.getValue();
            }
        });
        spinnerBebida2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido[1] = (int) spinnerBebida2.getValue();
            }
        });
        spinnerBebida3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido[2] = (int) spinnerBebida3.getValue();
            }
        });
        spinnerBebida4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido[3] = (int) spinnerBebida4.getValue();
            }
        });
        spinnerBebida5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido[4] = (int) spinnerBebida5.getValue();
            }
        });

    }
    private void registrarBebibaOuPrato(JLabel nomePrato, JLabel descricaoPrato, JLabel valorPrato,
                                        JLabel nomeBebida, JLabel descricaoBebida, JLabel valorBebida,
                                        JButton fazerPedido, JButton maisInfos, JSpinner spinnerPedido,
                                        JButton fazerPedidoBebida, JSpinner spinnerBebida,
                                        int indexArray, int posicaoNoCardapio) {

        if (cardapioDAO.getCardapio().size() >= posicaoNoCardapio) {

            //Bloco divide e organiza o cardápio entre bebida e prato

            if (this.eBebida(indexArray)) {
                removerVisibilidadePrato(fazerPedido, maisInfos, spinnerPedido);
                this.inserirItem(nomeBebida, descricaoBebida, valorBebida, fazerPedidoBebida, maisInfos, indexArray);
            } else {
                removerVisibilidadeBebida(fazerPedidoBebida, spinnerBebida);
                this.inserirItem(nomePrato, descricaoPrato, valorPrato, fazerPedido, maisInfos, indexArray);
            }
        } else {
            removerVisibilidadePrato(fazerPedido, maisInfos, spinnerPedido);
            removerVisibilidadeBebida(fazerPedidoBebida, spinnerBebida);
        }
    }
    private void removerVisibilidadePrato(JButton fazerPedido, JButton maisInfos, JSpinner spinnerPedido) {
        fazerPedido.setVisible(false);
        spinnerPedido.setVisible(false);
        maisInfos.setVisible(false);
    }
    private void removerVisibilidadeBebida(JButton fazerPedidoBebida, JSpinner spinnerBebida) {
        fazerPedidoBebida.setVisible(false);
        spinnerBebida.setVisible(false);
    }

    public void inserirItem(JLabel nomeItem, JLabel descricaoItem, JLabel valorItem,
                            JButton fazerPedido, JButton maisInfos, int indexArray) {

        for (int i = 0; i < 5; i++) {
            if (sequencialIndexes[i] == -1) {
                sequencialIndexes[i] = indexArray;
                break;
            }
        }

        CardapioPKG item = cardapioDAO.getCardapio().get(indexArray);
        String nome = item.getNome_prato();
        String descricao = item.getIngredientes();
        String preco = df.format(item.getPreco());

        fazerPedido.setVisible(true);
        if (!this.eBebida(indexArray)) {
            maisInfos.setVisible(true);
        }

        nomeItem.setText("Nome do Prato: " + nome);
        descricaoItem.setText("Descrição: " + descricao);
        valorItem.setText(preco);

    }

    public void registrarPedido(int indexArray) {
        PedidoPKG pedido = new PedidoPKG();
        CardapioPKG prato = cardapioDAO.getCardapio().get(indexArray);

        if (prato.getDisponibilidade().equals("0")) {
            JOptionPane.showMessageDialog(null,"Sentimos muito, o item selecionado não está disponível.","Cardapio",JOptionPane.ERROR_MESSAGE);
        } else {
            int qtd = 1;
            qtd = quantidadePedido[indexArray];

            Object[] opcaoSimNao = {"Sim", "Não"};
            String obs = "Nenhuma Observação";
            pedido.setObservacao(obs);

            int opcaoSelecionada = 0;
            valorPrato = prato.getPreco() * qtd;
            valorDaCompra += valorPrato;
            opcaoSelecionada = JOptionPane.showOptionDialog(null, "Deseja fazer uma observação?", "Observação",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcaoSimNao, opcaoSimNao[1]);

            if (opcaoSelecionada == 0) {
                obs = JOptionPane.showInputDialog(null, "Observação:", "Observação", JOptionPane.INFORMATION_MESSAGE);
                pedido.setObservacao(obs);

            }

            String pratoPedido = prato.getNome_prato();
            pedido.setItenspedidos(pratoPedido);
            pedido.setQuantidade("" + qtd);
            listaDePedidos.add(pedido);
        }

    }
    private void enviaComandaParaContabil(String comanda) {

        ContabilDAO tabelaContabilBanco = new ContabilDAO();
        ContabilPKG contabilidade = new ContabilPKG();

        LocalDate hoje = LocalDate.now();
        java.sql.Date dataAtual = java.sql.Date.valueOf(hoje);
        contabilidade.setData(dataAtual);
        contabilidade.setDescricao(comanda);
        contabilidade.setReceitas(valorDaCompra);
        contabilidade.setDespesas(0);
        contabilidade.setSaldo(valorDaCompra);

        tabelaContabilBanco.save(contabilidade);
    }

    private boolean eBebida ( int indexArray){
        //Função verifica se é uma bebida que esta sendo registrada ou não
            boolean eBebidaSN = false;
            CardapioPKG bebida = cardapioDAO.getCardapio().get(indexArray);

            if (bebida.getCategoria().equals("Bebidas Alcoólicas") || bebida.getCategoria().equals("Refrescos e Sucos")) {
                eBebidaSN = true;
            }
            return eBebidaSN;

    }

}
