
package entrega_teste_web;


import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import entrega_teste_web.App;
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
    @CsvSource(value ={"0,120,-1","2,120,108","4,120,108",
                      "6,120,114","7,120,114","9,120,114",
                      "10,120,114","11,120,120","12,120,120",
                      "14,120,120","15,120,120","17,120,122.64",
                      "29,120,124.08","31,120,-1"},
               delimiter= ',')
    public void adicionarCampos(int dia,Double valorNominal, Double retornaResultado) throws InterruptedException{
        
        app.visita();
        Double retorno = app.InserirNovosDados(valorNominal, (Integer) dia).retornaResultado();
        
        //assertEquals(app.InserirNovosDados(Double valorNominal, Integer dia),retornaResultado);
        assertEquals(retornaResultado, retorno);
        
        
//        // abre chrome
//        WebDriver driver = new ChromeDriver();
//        
//        
//        driver.get("https://aluguebug.herokuapp.com/form");
//
//        // acessa o formulario
//       
//        
//        WebElement dia = driver.findElement(By.id("dia"));
//        WebElement valor_nominal =driver.findElement(By.id("valor_nominal"));
//       
//        
//        
//        dia.sendKeys("1");
//        valor_nominal.sendKeys("120");
//        
//        WebElement botao =driver.findElement(By.id("botao"));
//        botao.click();
//        Thread.sleep(500);
//        WebElement resposta=driver.findElement(By.id("resposta"));
//        assertEquals("108",resposta.getAttribute("value"));
        
 
    }
    @AfterEach
    public void finaliza(){
        driver.close();
    }

}
