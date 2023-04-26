package restauranteView;

import restauranteDAO.ContabilDAO;
import restaurantePKG.ContabilPKG;
import restaurantePKG.ExecutaTelas;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TelaReceita {

    private ContabilDAO contabilDAO = new ContabilDAO();
    public JPanel FrameTelaReceita;

    private JButton voltarButton;

    private JTable JTableReceita;

    private JPanel JPanelTabela;

    private DecimalFormat df =new DecimalFormat("R$ ##0.00");

    private String data;

    private double receita;

    private String descricao;



    public void TelaRelatorioClasse(){

        String datas;

        ContabilPKG receita = new ContabilPKG();

        LocalDate currentDate = receita.getData().toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        datas = ("Date: " + formattedDate);

 }

    public TelaReceita() {

        ContabilPKG relatorio = new ContabilPKG();

        relatorio = contabilDAO.getRelatorio().get(0);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data");
        model.addColumn("Receita");
        model.addColumn("Descrição");
        model.addRow(new Object[]{"Data", "Descrição","Receita"});

        for (int i = 0; i < contabilDAO.getRelatorio().size(); i++) {
            receita = contabilDAO.getRelatorio().get(i).getReceitas();
            descricao = contabilDAO.getRelatorio().get(i).getDescricao();

            if (contabilDAO.getRelatorio().get(i).getReceitas() != 0) {
                model.addRow(new Object[]{contabilDAO.getRelatorio().get(i).getData(), descricao, df.format(receita)});
            }
            }

        JTableReceita.setModel(model);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                System.out.println(contabilDAO.getRelatorio().size());
                ExecutaTelas.FrameTelaReceita.dispose();
                executaTelas.iniciarTelaContabil();
            }
        });

    }
}


