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

    public static PedidoDAO pedidoDAO = new PedidoDAO();

    public static ArrayList<PedidoPKG> listaDePedidos = new ArrayList<>();

    private CardapioDAO cardapioDAO = new CardapioDAO();

    private int[] sequencialIndexes = {-1,-1,-1,-1,-1};

    private DecimalFormat df = new DecimalFormat("R$ ##0.00");

    private static int indexPedidoAtual;

    private static double valorDaCompra;

    private static double valorPrato;

    private static int quantidadePedido1;

    private static int quantidadePedido2;

    private static int quantidadePedido3;

    private static int quantidadePedido4;

    private static int quantidadePedido5;

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

    private JLabel valorBebida1;

    private JButton fazerPedidoBebida1;

    private JLabel nomeBebida2;

    private JLabel descricaoBebida2;

    private JLabel valorBebida2;

    private JLabel descricaoBebida3;

    private JLabel nomeBebida3;

    private JLabel valorBebida3;

    private JButton fazerPedidoBebida2;

    private JButton fazerPedidoBebida3;

    private JButton fazerPedidoBebida4;

    private JButton fazerPedidoBebida5;

    private JLabel descricaoBebida4;

    private JLabel descricaoBebida5;

    private JLabel valorBebida4;

    private JLabel valorBebida5;

    private JLabel nomeBebida4;

    private JLabel nomeBebida5;

    private JButton cofirmarCompraButton;

    private JButton botaoCancelar;

    private JButton botaoSair;

    private JSpinner spinnerPedido1;

    private JSpinner spinnerPedido2;

    private JSpinner spinnerPedido3;

    private JSpinner spinnerPedido4;

    private JSpinner spinnerPedido5;

    private JSpinner spinnerBebida1;

    private JSpinner spinnerBebida2;

    private JSpinner spinnerBebida3;

    private JSpinner spinnerBebida4;

    private JSpinner spinnerBebida5;

    private JLabel nomeUsuario;

    private JLabel idUsuario;

    public static String nomeUsuarioAtual;

    public TelaCardapio() {

        nomeUsuario.setText(nomeUsuarioAtual);
        idUsuario.setText("Identificação: " + PedidoDAO.idClienteAtual);

        ExecutaTelas executaTelas = new ExecutaTelas();

        //INSERÇÃO DE PRATOS
        //
        // E BEBIDAS

        //Prato/Bebida 1
        if (cardapioDAO.getCardapio().size() >= 1) {

            //Blocos verificam se é uma bebida que foi registrada ou um prato
            //Caso seja uma bebida, desativa a posição de pratos, e vice versa
            if (this.eBebida(0)) {
                fazerPedidoButton.setVisible(false);
                maisInformacoes1Button.setVisible(false);
                spinnerPedido1.setVisible(false);
                this.inserirBebida(0, nomeBebida1, descricaoBebida1, valorBebida1, fazerPedidoBebida1);
            } else {
                fazerPedidoBebida1.setVisible(false);
                spinnerBebida1.setVisible(false);
                this.inserirNoCardapio(nomePrato1, DescricaoPrato1, valorPrato1, fazerPedidoButton, maisInformacoes1Button, 0);
            }
        } else {
            fazerPedidoBebida1.setVisible(false);
            fazerPedidoButton.setVisible(false);
            maisInformacoes1Button.setVisible(false);
            spinnerPedido1.setVisible(false);
            spinnerBebida1.setVisible(false);
        }

        //Prato/Bebida 2
        if (cardapioDAO.getCardapio().size() >= 2) {
            if (this.eBebida(1)) {
                fazerPedido2.setVisible(false);
                maisInfos2.setVisible(false);
                spinnerPedido2.setVisible(false);
                this.inserirBebida(1, nomeBebida2, descricaoBebida2, valorBebida2, fazerPedidoBebida2);
            } else {
                fazerPedidoBebida2.setVisible(false);
                spinnerBebida2.setVisible(false);
                this.inserirNoCardapio(nomePrato2, DescricaoPrato2, valorPrato2, fazerPedido2, maisInfos2, 1);
            }

        } else {
            fazerPedidoBebida2.setVisible(false);
            fazerPedido2.setVisible(false);
            maisInfos2.setVisible(false);
            spinnerPedido2.setVisible(false);
            spinnerBebida2.setVisible(false);
        }

        //Prato/Bebida 3
        if (cardapioDAO.getCardapio().size() >= 3) {
            if (this.eBebida(2)) {
                fazerPedido3.setVisible(false);
                maisInfos3.setVisible(false);
                spinnerPedido3.setVisible(false);
                this.inserirBebida(2, nomeBebida3, descricaoBebida3, valorBebida3, fazerPedidoBebida3);
            } else {
                fazerPedidoBebida3.setVisible(false);
                spinnerBebida3.setVisible(false);
                this.inserirNoCardapio(nomePrato3, DescricaoPrato3, valorPrato3, fazerPedido3, maisInfos3, 2);
            }

        } else {
            fazerPedidoBebida3.setVisible(false);
            fazerPedido3.setVisible(false);
            maisInfos3.setVisible(false);
            spinnerPedido3.setVisible(false);
            spinnerBebida3.setVisible(false);
        }
        //Prato/Bebida 4
        if (cardapioDAO.getCardapio().size() >= 4) {
            if (this.eBebida(3)) {
                fazerPedido4.setVisible(false);
                maisInfos4.setVisible(false);
                spinnerPedido4.setVisible(false);
                this.inserirBebida(3, nomeBebida4, descricaoBebida4, valorBebida4, fazerPedidoBebida4);
            } else {
                fazerPedidoBebida4.setVisible(false);
                spinnerBebida4.setVisible(false);
                this.inserirNoCardapio(nomePrato4, DescricaoPrato4, valorPrato4, fazerPedido4, maisInfos4, 3);
            }

        } else {
            fazerPedidoBebida4.setVisible(false);
            fazerPedido4.setVisible(false);
            maisInfos4.setVisible(false);
            spinnerPedido4.setVisible(false);
            spinnerBebida4.setVisible(false);
        }

        //Prato/Bebida 5
        if (cardapioDAO.getCardapio().size() >= 5) {
            if (this.eBebida(4)) {
                fazerPedido5.setVisible(false);
                maisInfos5.setVisible(false);
                spinnerPedido5.setVisible(false);
                this.inserirBebida(4, nomeBebida5, descricaoBebida5, valorBebida5, fazerPedidoBebida5);
            } else {
                fazerPedidoBebida5.setVisible(false);
                spinnerBebida5.setVisible(false);
                this.inserirNoCardapio(nomePrato5, DescricaoPrato5, valorPrato5, fazerPedido5, maisInfos5, 4);
            }

        } else {
            fazerPedidoBebida5.setVisible(false);
            fazerPedido5.setVisible(false);
            maisInfos5.setVisible(false);
            spinnerPedido5.setVisible(false);
            spinnerBebida5.setVisible(false);
        }


        maisInformacoes1Button.addActionListener(new ActionListener() {
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

        fazerPedidoButton.addActionListener(new ActionListener() {
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
        cofirmarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opcaoConfirma = {"Confirmar", "Sair"};
                String pratosPedidos = "Comanda Cliente(ID: " + PedidoDAO.idClienteAtual + "): ";
                String texto = "Itens Pedidos: \n\n";
                int quantidadePedido = 0;
                boolean erroPedidos = false;
                quantidadePedido = retornaIndexPedidoAtual(indexPedidoAtual);

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

                        //INSERE COMANDA NO CONTABIL
                        //--------------------------------------------------
                        ContabilDAO tabelaContabilBanco = new ContabilDAO();
                        ContabilPKG contabilidade = new ContabilPKG();

                        LocalDate hoje = LocalDate.now();
                        java.sql.Date dataAtual = java.sql.Date.valueOf(hoje);
                        contabilidade.setData(dataAtual);
                        contabilidade.setDescricao(pratosPedidos);
                        contabilidade.setReceitas(valorDaCompra);
                        contabilidade.setDespesas(0);
                        contabilidade.setSaldo(valorDaCompra);

                        tabelaContabilBanco.save(contabilidade);
                        //--------------------------------------------------
                        TelaAvaliacao.indexPedidoAtualParaAvaliacao = 0;
                        executaTelas.iniciarTelaAvaliacoes();
                        ExecutaTelas.frameTelaFazerPedido.dispose();

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
                    ExecutaTelas.frameTelaFazerPedido.dispose();
                    executaTelas.iniciarTelaLogin();
                }

            }
        });

        spinnerPedido1.setModel(new SpinnerNumberModel(0, 0, 12, 1));
        spinnerPedido2.setModel(new SpinnerNumberModel(0, 0, 12, 1));
        spinnerPedido3.setModel(new SpinnerNumberModel(0, 0, 12, 1));
        spinnerPedido4.setModel(new SpinnerNumberModel(0, 0, 12, 1));
        spinnerPedido5.setModel(new SpinnerNumberModel(0, 0, 12, 1));
        spinnerBebida1.setModel(new SpinnerNumberModel(0, 0, 30, 1));
        spinnerBebida2.setModel(new SpinnerNumberModel(0, 0, 30, 1));
        spinnerBebida3.setModel(new SpinnerNumberModel(0, 0, 30, 1));
        spinnerBebida4.setModel(new SpinnerNumberModel(0, 0, 30, 1));
        spinnerBebida5.setModel(new SpinnerNumberModel(0, 0, 30, 1));

        spinnerPedido1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido1 = (int) spinnerPedido1.getValue();

            }
        });
        spinnerPedido2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido2 = (int) spinnerPedido2.getValue();
            }
        });
        spinnerPedido3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido3 = (int) spinnerPedido3.getValue();
            }
        });
        spinnerPedido4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido4 = (int) spinnerPedido4.getValue();
            }
        });
        spinnerPedido5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido5 = (int) spinnerPedido5.getValue();
            }
        });
        spinnerBebida1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido1 = (int) spinnerBebida1.getValue();
            }
        });
        spinnerBebida2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido2 = (int) spinnerBebida2.getValue();
            }
        });
        spinnerBebida3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido3 = (int) spinnerBebida3.getValue();
            }
        });
        spinnerBebida4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido4 = (int) spinnerBebida4.getValue();
            }
        });
        spinnerBebida5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                quantidadePedido5 = (int) spinnerBebida5.getValue();
            }
        });
    }

    public void inserirNoCardapio(JLabel nomePrato, JLabel DescricaoPrato, JLabel valorPrato,
                                  JButton fazerPedido, JButton maisInfos, int indexArray) {

        this.organizaSequenciaDeIndex(indexArray);

        CardapioPKG prato = new CardapioPKG();
        prato = cardapioDAO.getCardapio().get(indexArray);
        String nome1 = prato.getNome_prato();
        String descricao1 = prato.getIngredientes();
        String preco1 = df.format(prato.getPreco());

        fazerPedido.setVisible(true);
        maisInfos.setVisible(true);

        nomePrato.setText("Nome do Prato: " + nome1);
        DescricaoPrato.setText("Descrição: " + descricao1);
        valorPrato.setText(preco1);

    }

    public void inserirBebida(int indexArray, JLabel nomeBebida, JLabel descricaoBebida, JLabel valorBebida,
                              JButton fazerPedidoBebida) {

        this.organizaSequenciaDeIndex(indexArray);

        CardapioPKG bebida = new CardapioPKG();
        bebida = cardapioDAO.getCardapio().get(indexArray);
        String nome1 = bebida.getNome_prato();
        String descricao1 = bebida.getIngredientes();
        String preco1 = df.format(bebida.getPreco());

        fazerPedidoBebida.setVisible(true);
        nomeBebida.setText("Nome da Bebida: " + nome1);
        descricaoBebida.setText("Descrição: " + descricao1);
        valorBebida.setText(preco1);

    }

    public void registrarPedido(int indexArray) {
        PedidoPKG pedido = new PedidoPKG();
        CardapioPKG prato = new CardapioPKG();
        indexPedidoAtual = indexArray;
        prato = cardapioDAO.getCardapio().get(indexArray);

        if (prato.getDisponibilidade().equals("0")) {
            JOptionPane.showMessageDialog(null,"Sentimos muito, o item selecionado não está disponível.","Cardapio",JOptionPane.ERROR_MESSAGE);
        } else {
            int qtd = 1;
            qtd = retornaIndexPedidoAtual(indexArray);
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

    public boolean eBebida ( int indexArray){
        //Função verifica se é uma bebida que esta sendo registrada ou não
            boolean eBebidaSN = false;
            CardapioPKG bebida = new CardapioPKG();
            bebida = cardapioDAO.getCardapio().get(indexArray);

            if (bebida.getCategoria().equals("Bebidas Alcoólicas") || bebida.getCategoria().equals("Refrescos e Sucos")) {
                eBebidaSN = true;
            }
            return eBebidaSN;

    }
    public void organizaSequenciaDeIndex(int indexArray) {

        //Função criada para organizar os botões respectivamente com seus itens
        // o index de cada item vai entrando na variavel sequencialIndexes[]
        if (sequencialIndexes[0] == -1) {
            sequencialIndexes[0] = indexArray;

        } else if(sequencialIndexes[1] == -1){
            sequencialIndexes[1] = indexArray;

        } else if(sequencialIndexes[2] == -1) {
            sequencialIndexes[2] = indexArray;
        } else if(sequencialIndexes[3] == -1) {
            sequencialIndexes[3] = indexArray;
        } else if(sequencialIndexes[4] == -1) {
            sequencialIndexes[4] = indexArray;
        }
    }
    public int retornaIndexPedidoAtual(int index) {
        int quantidadePedido = 0;
        switch (index) {
            case 0:
                quantidadePedido = quantidadePedido1;
                break;
            case 1:
                quantidadePedido = quantidadePedido2;
                break;
            case 2:
                quantidadePedido = quantidadePedido3;
                break;
            case 3:
                quantidadePedido = quantidadePedido4;
                break;
            case 4:
                quantidadePedido = quantidadePedido5;
                break;

        }
        return quantidadePedido;
    }
}
