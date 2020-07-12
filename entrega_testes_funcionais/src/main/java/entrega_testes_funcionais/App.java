
package entrega_testes_funcionais;


import org.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {

        System.out.println("Stephanie \n Estou usando API fornecida pelo professor!\n");
        System.out.println();

        // instanciando a classe Controle
        Controle inter = new Controle();
        System.out.println("Insira o dia: ");
        int dia = inter.dia();
        System.out.println("Insira o Valor do aluguel: Ex: 120,00 ");
        float valorNominal = inter.valor();

        // chamando a funcao calculo
        float aluguel = App.calculo(dia, valorNominal);

        // exibindo o resultado
        System.out.printf("valor calculado \n ");
        System.out.printf(" %.2f \n", aluguel);
    }
    public static float calculo(int dia, float valorNominal) {
        try {
            // instanciando a classe aluguel
            Aluguel aluguel = new Aluguel();
            aluguel.dia = dia;
            aluguel.valorNominal = valorNominal;
            
            // instanciando a classe JSON
            JSONObject my_json = new JSONObject(aluguel);

            // utilizando o metodo toString() para retornar o objeto em String
            String str_json = my_json.toString();
        
            // incluindo os parâmetros utilizando a classe builder 
            URIBuilder builder = new URIBuilder("https://aluguebug.herokuapp.com/calc");
            builder.setParameter("dados", str_json);

            // iniciando o método GET
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(builder.build());
 
            
            try {
                // executando a requisicao
                HttpResponse resp = client.execute(httpGet);
                // instanciando a classe entity
                HttpEntity httpEntity = resp.getEntity();
                String str_manipulada = EntityUtils.toString(httpEntity);

                // manipulando os caracteres, pois a requisicao vem com caracteres a mais
                str_manipulada = str_manipulada.split("\\{")[1];
                str_manipulada = str_manipulada.split("\\}")[0];
                str_manipulada = "{" + str_manipulada + "}";
                str_manipulada = str_manipulada.replace("\\\"", "");

                // instanciando novo objeto da classe JSONObject com a String manipulada
                JSONObject my_obj = new JSONObject(str_manipulada);

                // metodo que retorna double 
                float resultado = (float) my_obj.getDouble("valor_calculado");
                return resultado;
             } catch (Exception e) {
                 // cache para armazenar o exception
                 Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
             }
            
        }catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

}

