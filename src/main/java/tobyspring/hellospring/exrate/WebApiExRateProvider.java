package tobyspring.hellospring.exrate;

import com.fasterxml.jackson.databind.ObjectMapper;

import tobyspring.hellospring.payment.ExRateProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class WebApiExRateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // InputStream() -> 가져온 데이터를 바이트형식으로 보내줌
        // InputStreamReader() -> 바이트 형식을 케릭터로 바꿔줌
        // BufferedReader() -> 한 줄씩 가져옴
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        ObjectMapper mapper = new ObjectMapper();
        ExRateData data = mapper.readValue(response, ExRateData.class);

        System.out.println("API Exrate: " + data.rates().get("KRW") );

        return data.rates().get("KRW");
    }
}

