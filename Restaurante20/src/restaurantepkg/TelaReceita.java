package restaurantepkg;

import restauranteDAO.ContabilDAO;

import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TelaReceita {
    private ContabilDAO contabilDAO = new ContabilDAO();
    public JPanel FrameTelaReceita;
    private JLabel data;
    private JLabel dataConsulta;
    private JLabel receitaConsulta;
    private JButton voltarButton;
    private JTable tabela ;


    public void TelaRelatorioClasse(){

        String datas;

        ContabilPKG receita = new ContabilPKG();

        LocalDate currentDate = receita.getData().toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        datas = ("Date: " + formattedDate);

        data.setText(datas);

       //initComponents();

//        TableCellEditor cellEditor = new TableCellEditor() {
//            @Override
//            public Component getTableCellEditorComponent(JTable jTable, Object o, boolean b, int i, int i1) {
//                return null;
//
//            }
//
//            @Override
//            public Object getCellEditorValue() {
//                return null;
//            }
//
//            @Override
//            public boolean isCellEditable(EventObject eventObject) {
//                return false;
//            }
//
//            @Override
//            public boolean shouldSelectCell(EventObject eventObject) {
//                return false;
//            }
//
//            @Override
//            public boolean stopCellEditing() {
//                return false;
//            }
//
//            @Override
//            public void cancelCellEditing() {
//
//            }
//
//            @Override
//            public void addCellEditorListener(CellEditorListener cellEditorListener) {
//
//            }
//
//            @Override
//            public void removeCellEditorListener(CellEditorListener cellEditorListener) {
//
//            }
//        };

//        DefaultTableModel model = new DefaultTableModel();
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        int columnCount = metaData.getColumnCount();
//
//
//        for (int i = 1; i <= columnCount; i++) {
//            model.addColumn(metaData.getColumnName(i));
//        }
//        while (resultSet.next()) {
//            Object[] row = new Object[columnCount];
//            for (int i = 1; i <= columnCount; i++) {
//                row[i - 1] = resultSet.getObject(i);
//            }
//            model.addRow(row);
//        }
//
 }

    public TelaReceita() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ExecutaTelas.FrameTelaReceita.dispose();
                executaTelas.iniciarTelaContabil();
            }
        });
    }


//    private void initComponents() {
//        DefaultTableModel model = new DefaultTableModel(
//                new Object[][]{
//                        {1, "João", "Silva"},
//                        {2, "Maria", "Santos"},
//                        {3, "José", "Oliveira"}
//                },
//                new Object[]{"ID", "Nome", "Sobrenome"}
//        );
//        tabela = new JTable(model);
//
//
//    }
}
