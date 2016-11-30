package com.cebidanes.agenda;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by jcebidanes on 28/11/2016.
 */
public class WebClient {
    public String post(String json) {
        try {
            // Usar 10.0.2.2 no lugar de localhost/127.0.0.1 para testar localmente
            URL url = new URL("http://10.0.2.2:8080/samuweb/rest/mobile/media");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            connection.setDoOutput(true);

            PrintStream output = new PrintStream(connection.getOutputStream());
            output.println(json);

            connection.connect();

            Scanner scanner = new Scanner(connection.getInputStream());
            String resposta = scanner.next();
            return resposta;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; //TODO adicionar aqui retorno para tratar depois
    }

}
