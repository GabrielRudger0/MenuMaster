package restaurante.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCEP {
    private final String urlBase = "https://viacep.com.br/ws/";
    private final String formato = "/json/";
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public ViaCEP(String cep) {
        this.cep = cep;
    }

    public void buscar() throws IOException {
        String urlStr = urlBase + cep + formato;
        URL url = new URL(urlStr);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String json = response.toString();
        json = json.replace("{", "").replace("}", "").replace("\"", "");
        String[] dados = json.split(",");

        for (String dado : dados) {
            String[] valor = dado.split(":");
            if (valor[0].equals("cep")) {
                this.cep = valor[1];
            } else if (valor[0].equals("logradouro")) {
                this.logradouro = valor[1];
            } else if (valor[0].equals("bairro")) {
                this.bairro = valor[1];
            } else if (valor[0].equals("localidade")) {
                this.localidade = valor[1];
            } else if (valor[0].equals("uf")) {
                this.uf = valor[1];
            }
        }
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }
}
