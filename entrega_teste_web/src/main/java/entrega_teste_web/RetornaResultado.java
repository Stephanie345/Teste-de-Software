
package entrega_teste_web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class RetornaResultado {
    private WebDriver driver;

    public RetornaResultado(WebDriver driver) {
        this.driver = driver;
    }
    
    public Double retornaResultado(){
        WebElement resposta = driver.findElement(By.id("resposta"));
        String respostaDouble = resposta.getAttribute("value");
        return Double.parseDouble(respostaDouble);
    }
    
    
}
