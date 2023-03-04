package restaurantepkg;

import restauranteDAO.ContabilDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaRelatorioClasse {

    private ContabilDAO contabilDAO = new ContabilDAO();
    public JPanel FrameTelaRelatorio;
    private JLabel head;
    private JButton voltarButton;
    private JLabel dataConsulta;
    private JLabel descricaoConsulta;
    private JLabel receitaConsulta;
    private JLabel despesasConsuta;
    private JLabel saldoConsulta;
    private static double saldo = 0;
    private static double receitas;


    public TelaRelatorioClasse(){

       String data;


       ContabilPKG relatorio = new ContabilPKG();

        for (int i = 0; i <contabilDAO.getRelatorio().size() ; i++) {
            receitas += contabilDAO.getRelatorio().get(i).getReceitas();
        }
       relatorio = contabilDAO.getRelatorio().get(0);

       saldo = relatorio.getSaldo();

        LocalDate currentDate = relatorio.getData().toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        data = ("Today's date is: " + formattedDate);

        receitaConsulta.setText(Double.toString(receitas));
        dataConsulta.setText(data);
        saldoConsulta.setText(Double.toString(saldo));
        receitas = 0;
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
