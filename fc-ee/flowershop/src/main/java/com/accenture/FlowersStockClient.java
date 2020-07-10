package com.accenture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FlowersStockClient {
    private static String Url = "http://localhost:8080/ws/FlowersStock";

    public static void main(String[] args) {
        int i = 0;
        while (i < 50) {
            i++;
            try {
                sendRequestIncreaseFlowersStock((int) (Math.random() * 21 + 10));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10 * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

        private static void sendRequestIncreaseFlowersStock(int count) throws IOException{
            String soapXML = generateIncreaseFlowersStockSoapXML(count);
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(Url).openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);

                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(soapXML.getBytes());
                outputStream.flush();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String str;
                while((str = bufferedReader.readLine()) != null){
                    System.out.println((str));
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private static String generateIncreaseFlowersStockSoapXML(int count){
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webService.flowershop/\">\n" +
                " <soapenv:Header/>\n" +
                " <soapenv:Body>\n" +
                " <web:increaseFlowersStockSize>\n" +
                " <count>"+count+"</count>\n" +
                " </web:increaseFlowersStockSize>\n" +
                " </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }
}
