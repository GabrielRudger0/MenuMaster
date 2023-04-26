package restauranteView;

import restauranteDAO.ContabilDAO;
import restaurantePKG.ContabilPKG;
import restaurantePKG.ExecutaTelas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaRelatorioClasse {

    private ContabilDAO contabilDAO = new ContabilDAO();
    public JPanel FrameTelaRelatorio;

    private DecimalFormat df = new DecimalFormat("R$ ##0.00");

    private JLabel head;

    private JButton voltarButton;

    private JLabel dataConsulta;

    private JLabel descricaoConsulta;

    private JLabel receitaConsulta;

    private JLabel despesasConsuta;

    private JLabel saldoConsulta;

    private static double saldo = 0;

    private static double receitas;

    private static double despesas;


    public TelaRelatorioClasse(){

       String data;

       ContabilPKG relatorio = new ContabilPKG();

        relatorio = contabilDAO.getRelatorio().get(0);

        for (int i = 0; i <contabilDAO.getRelatorio().size() ; i++) {
            receitas += contabilDAO.getRelatorio().get(i).getReceitas();
        }

        for (int i = 0; i < contabilDAO.getRelatorio().size(); i++) {
            despesas += contabilDAO.getRelatorio().get(i).getDespesas();
        }

        for (int i = 0; i < contabilDAO.getRelatorio().size(); i++) {
            saldo += contabilDAO.getRelatorio().get(i).getSaldo();
        }

        LocalDate currentDate = relatorio.getData().toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        data = (formattedDate);

        receitaConsulta.setText(df.format(receitas));
        dataConsulta.setText(data);
        despesasConsuta.setText(df.format(despesas));
        saldoConsulta.setText(df.format(saldo));

        receitas = 0;
        despesas = 0;
        saldo = 0;

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ExecutaTelas.FrameTelaRelatorio.dispose();
                executaTelas.iniciarTelaContabil();
            }
        });
    }
}
