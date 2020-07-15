
package entrega_teste_web;


import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class TesteAutomatizado {
    private App app;
    private WebDriver driver;
    
    @BeforeEach
    public void inicializa(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.app = new App(driver);
    }
    
    @ParameterizedTest
    @CsvSource(value ={"1,120,120","2,120,108","4,120,108","5,120,120","6,120,114",
                       "7,120,114","10,120,114","11,120,120",
                       "12,120,120","14,120,120","17,120,122.64",
                      "29,120,124.08","31,120,-1"},
               delimiter= ',')
    public void camposValidos(int dia,Double valorNominal, Double retornaResultado) throws InterruptedException{
        
        app.visita();
        Double retorno = app.InserirNovosDados(valorNominal, (Integer) dia).retornaResultado();
        assertEquals(retornaResultado, retorno, 0.01);    
    }
    
    @ParameterizedTest
    @CsvSource(value ={"0,120,-1","9,120,114","15,120,120"},
               delimiter= ',')
    public void camposInvalidos(int dia,Double valorNominal, Double retornaResultado) throws InterruptedException{
        
        app.visita();
        Double retorno = app.InserirNovosDados(valorNominal, (Integer) dia).retornaResultado();
        assertEquals(retornaResultado, retorno,0.01);    
    }
    
    @AfterEach
    public void finaliza(){
        driver.close();
    }

}
