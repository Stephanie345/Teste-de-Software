package entrega_testes_funcionais;

import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


public class TestParametrizado {
    
    App apl = new App();

    //@Disabled
    @ParameterizedTest
    @CsvSource(value ={"0,120,-1","2,120,108","4,120,108",
                      "6,120,114","7,120,114","9,120,114",
                      "10,120,114","11,120,120","12,120,120",
                      "14,120,120","15,120,120","17,120,122.64",
                      "29,120,124.08","31,120,-1"},
               delimiter= ',')
    public void testCsvSource(int dia,float valorNominal,float resultadoEsperado){
        assertEquals ( resultadoEsperado, apl.calculo(dia, valorNominal), 0.01);
        
    }
    @Disabled
    @ParameterizedTest(name = "Teste {index} => valor={0} dia={1}," + " resultado={2}")
    @CsvFileSource(resources = "/planilha.csv")
    public void testCsvFile(int dia,float valorNominal,float resultadoEsperado){
        assertEquals ( resultadoEsperado, apl.calculo(dia, valorNominal), 0.01);
        
    }

}
   

    

