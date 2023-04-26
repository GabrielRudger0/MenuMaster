package restaurantePKG;

import restauranteDAO.ContabilDAO;
import java.time.LocalDate;
import java.util.Random;

public class CriaDespesas {

    public void criaDespesas() {
        //As despesas criadas por esse método serão aleatórias e implementadas
        // após o inicio da execução do programa;

        ContabilPKG contaIngredientesBebidas = new ContabilPKG();
        ContabilPKG contaManutencaoEquipamentos = new ContabilPKG();
        ContabilPKG contaEnergiaAgua = new ContabilPKG();
        Random randomize = new Random();

        double minGastoIngredientesBebidas = 200.0, maxGastoIngredientesBebidas = 500.0;
        double minGastoEquipamentoManutencao = 100.0, maxGastoEquipamentoManutencao = 200.0;
        double minGastoEnergiaAgua = 500.0, maxGastoGastoEnergiaAgua = 800.0;

        double gastoIngredientesBebidas = minGastoIngredientesBebidas + (maxGastoIngredientesBebidas - minGastoIngredientesBebidas) * randomize.nextDouble();
        double gastoManutencaoEquipamentos = minGastoEquipamentoManutencao + (maxGastoEquipamentoManutencao - minGastoEquipamentoManutencao) * randomize.nextDouble();
        double gastoEnergiaAgua = minGastoEnergiaAgua + (maxGastoGastoEnergiaAgua - minGastoEnergiaAgua) * randomize.nextDouble();

        adicionaDespesaAoBanco(contaIngredientesBebidas, "Conta de Ingredientes e Bebidas", gastoIngredientesBebidas);
        adicionaDespesaAoBanco(contaManutencaoEquipamentos, "Conta de Equipamentos e Manutenção", gastoManutencaoEquipamentos);
        adicionaDespesaAoBanco(contaEnergiaAgua, "Conta de Energia e Água", gastoEnergiaAgua);

    }
    private void adicionaDespesaAoBanco(ContabilPKG contaParaBD, String contaDescricao, double contaValor) {
        ContabilDAO tabelaContabilBD = new ContabilDAO();
        LocalDate hoje = LocalDate.now();
        java.sql.Date dataAtual = java.sql.Date.valueOf(hoje);

        contaParaBD.setData(dataAtual);
        contaParaBD.setDescricao(contaDescricao);
        contaParaBD.setSaldo(0.0);
        contaParaBD.setDespesas(contaValor);
        contaParaBD.setSaldo(-contaValor);
        tabelaContabilBD.save(contaParaBD);
    }
}
