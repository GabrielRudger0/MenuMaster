package restaurantepkg;

import restauranteDAO.ContabilDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaReceita {
    private ContabilDAO contabilDAO = new ContabilDAO();
    public JPanel frameTelaReceita;
    private JPanel JPanel;
    private JLabel head;
    private JLabel data;
    private JLabel receita;
    private JTable table1;
    private JButton voltarButton;




    public void TelaRelatorioClasse(){

        String datas;

        ContabilPKG receita = new ContabilPKG();
        ExecutaTelas executaTelas = new ExecutaTelas();

        LocalDate currentDate = receita.getData().toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        datas = ("Date: " + formattedDate);

        data.setText(datas);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                executaTelas.FrameTelaRelatorio.dispose();
                executaTelas.iniciarTelaContabil();
            }
        });

    }

    }
