
package entrega_testes_funcionais;

import org.json.JSONObject;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
    public static void main(String[] args) {
    	System.out.println("Stephanie");
    	System.out.println("Estou usando API fornecida pelo professor!");
    	//alterar o system.out

    	//receber do usuario o dia o valor nominal
    	//scaneer - copiar a classe controller

    	int dia = 1;
    	float valor = 120;
    	Aluguel teste = new Aluguel();
    	teste.valor_nominal=valor;
    	teste.dia=dia;

    	JSONObject objeto = new JSONObject(teste);
    	System.out.println(objeto.toString());

        // fazer uma requisão http com o objeto que é da variável da linha 21

        public class JavaHttpRequestExample {
            public static void main(String args[]){
                System.out.println("HTTP Request Example");
                sendGetRequest();
            }

            public static void sendGetRequest(){
                try{
                    URL url = new URL(S:"https://aluguebug.herokuapp.com/calc");
                    HttpURLConnection HttpURLConnection=(HttpURLConnection)url.openConnection();
                    HttpURLConnection.setRequestMethod("GET");
                    String line="";
                    InputStreamReader InputStreamReader=new InputStreamReader(HttpURLConnection.getInputStream());
                    BufferedReader BufferedReader=new BufferedReader(inputStreamReader);
                    StringBuilder response=new StringBuilder();
                    while ((line=bufferedReader.readLine())!=null){
                        response.append(line);
                    }
                    bufferedReader.close();
                    System.out.println("Response: "+response.toString());
            }
            catch (Exception e){
                System.out.println("Error in Making Get Request")
            }
        }


    	
    }
    
}
