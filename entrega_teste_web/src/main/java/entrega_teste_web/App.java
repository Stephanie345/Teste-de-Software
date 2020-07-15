package entrega_teste_web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class App {
    WebDriver driver;

    public App(WebDriver driver) {
        this.driver = driver;
    }
    
    public void visita(){
        driver.get("https://aluguebug.herokuapp.com/form");
    }
    
    public RetornaResultado InserirNovosDados(Double valorNominal, Integer dia) throws InterruptedException{
        WebElement diaSend = driver.findElement(By.id("dia"));
        WebElement valor_nominalSend = driver.findElement(By.id("valor_nominal"));
        
        valor_nominalSend.sendKeys(valorNominal.toString());
        diaSend.sendKeys(dia.toString());
        
        
        WebElement botao = driver.findElement(By.id("botao"));
        botao.click();
        
        Thread.sleep(1000);
        
        return new RetornaResultado(driver); 
    }
    
}