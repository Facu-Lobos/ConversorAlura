
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class Conversor {
    private List<String> registros;
    ConversorRecord totalConvertido;


    public void setTotalConvertido(ConversorRecord totalConvertido) {
        this.totalConvertido = totalConvertido;
    }

    public List<String> getRegistros() {
        return registros;
    }

    public Conversor() {
        this.registros = new ArrayList<>();
    }

    public ConversorRecord conexionConversion(String monedaBase, String monedaAConvertir, double cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/4b1627dd7cb9d71fb9d335e1/pair/"+monedaBase+"/"+monedaAConvertir+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response  = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversorRecord.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda");
        }
    }
    public void registrarConversion(String monedaOrigen, String monedaDestino, double cantidad) {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String marcaTiempoFormateada = ahora.format(formatter);

        String registro = String.format("[%s] Convertido: %.2f %s A %.2f %s]", marcaTiempoFormateada, cantidad, monedaOrigen, totalConvertido.conversion_result(), monedaDestino);
        registros.add(registro);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String registro : registros) {
            builder.append(registro).append("\n");
        }
        return builder.toString();
    }
}
