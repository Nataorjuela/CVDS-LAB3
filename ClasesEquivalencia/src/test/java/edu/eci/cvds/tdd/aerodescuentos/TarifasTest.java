/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.tdd.aerodescuentos;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author natao
 */
public class TarifasTest {
   
    
    
    //verificar que no cumple con ninguna condicion para un descuento.
    // tarifa base 
    @Test
    public void validateTarifaBase() {
        long tarifaBase=60000;
        int diasAntelacion=2;
        int edad=20;
       
        long tarifa=(long)CalculadorDescuentos.calculoTarifa(tarifaBase,diasAntelacion,edad);
         Assert.assertEquals(tarifa, tarifaBase);   
    }
    
    //verificar que cumple edad superior a 65 años para un descuento del 8%
    @Test
    public void validarDescuento8(){
        long tarifaBase=60000;
        int diasAntelacion=2;   
        int edad=66;
        long tarifa=(long)CalculadorDescuentos.calculoTarifa(tarifaBase,diasAntelacion,edad);
        Assert.assertEquals(55200,tarifa);
    }
    
    //verificar que cumple edad inferior a 18 años para un descuento del 5%
    @Test
    public void validarDescuento5(){
        long tarifaBase=60000;
        int diasAntelacion=2;   
        int edad=14;
        long tarifa=(long)CalculadorDescuentos.calculoTarifa(tarifaBase,diasAntelacion,edad);
        Assert.assertEquals(57000,tarifa);
    }
    
     //verificar la compra de billete con antelacion superior a 20 dias para un descuento del 15%
    @Test
    public void validarDescuento15antelacion(){
        long tarifaBase=60000;
        int diasAntelacion=21;   
        int edad=19;
        long tarifa=(long)CalculadorDescuentos.calculoTarifa(tarifaBase,diasAntelacion,edad);
        Assert.assertEquals(51000,tarifa);
    }
    
    //NO CORRECTOS
    
    //verificar la edad no valida cuando es negativa 
    
    @Test
    public void validateEdadInvalida() {
        long tarifaBase=60000;
        int diasAntelacion=2;
        int edad=-20;
       
        long tarifa=(long)CalculadorDescuentos.calculoTarifa(tarifaBase,diasAntelacion,edad);
         Assert.assertEquals("ExcepcionParametrosInvalidos",tarifa);
    }
    
    //verificar la antelacion no valida cuando es negativa 
    @Test
    public void validarNoDescuento8(){
        long tarifaBase=60000;
        int diasAntelacion=-2;   
        int edad=66;
        long tarifa=(long)CalculadorDescuentos.calculoTarifa(tarifaBase,diasAntelacion,edad);
        Assert.assertEquals("ExcepcionParametrosInvalidos",tarifa);
    }
    
    //verificar tarifa negativa invalida
    @Test
    public void validarNoDescuento5(){
        long tarifaBase=-60000;
        int diasAntelacion=2;   
        int edad=14;
        long tarifa=(long)CalculadorDescuentos.calculoTarifa(tarifaBase,diasAntelacion,edad);
       Assert.assertEquals("ExcepcionParametrosInvalidos",tarifa);
    }
    
     
    }
    
    
    
    
}
