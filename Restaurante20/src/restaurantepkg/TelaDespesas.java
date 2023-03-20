package restaurantepkg;

import restauranteDAO.ContabilDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TelaDespesas {
    ContabilDAO contabilDAO = new ContabilDAO();

    public JPanel FrameTelaDespesas;

    private JButton buttonVoltar;

    private JTable JTableDespesas;

    private JPanel JPanelTabela;

    private DecimalFormat df =new DecimalFormat("R$ ##0.00");

    private String descricao;

    private Double despesas;

    public TelaDespesas (){


        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data");
        model.addColumn("Despesas");
        model.addColumn("Descrição");

        model.addRow(new Object[]{"Data", "Descrição","Receita"});
        for (int i = 0; i < contabilDAO.getRelatorio().size(); i++) {
            despesas = contabilDAO.getRelatorio().get(i).getDespesas();
            descricao = contabilDAO.getRelatorio().get(i).getDescricao();

                if (contabilDAO.getRelatorio().get(i).getDespesas() != 0) {
                    model.addRow(new Object[]{contabilDAO.getRelatorio().get(i).getData(), descricao, df.format(despesas)});
                }
        }

        JTableDespesas.setModel(model);

        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ExecutaTelas.FrameTelaDespesas.dispose();
                executaTelas.iniciarTelaContabil();
            }
        });

        }
}
