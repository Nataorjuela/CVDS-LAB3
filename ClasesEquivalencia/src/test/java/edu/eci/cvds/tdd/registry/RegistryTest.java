/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.tdd.registry;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author natao
 */
public class RegistryTest {
    //edad invalida.
     private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person("Diego",1025789,160,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
        
    }
   //VALID:la persona esta viva,edad valida y que no sea una persona duplicada
    
    @Test
    public void validateRegistryResultDuplicate() {
        Person person1 = new Person("Natalia",101024893,20,Gender.FEMALE,true);
        Person person2 = new Person("Natalia",101024893,20,Gender.FEMALE,true);

        RegisterResult result1 = registry.registerVoter(person1);
        RegisterResult result2 = registry.registerVoter(person2);

        Assert.assertEquals(RegisterResult.VALID, result1);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }
    //ALIVE:verificar si el estado de la persona es muerta
    @Test
    public void validateRegistryResultAlive() {
        Person person3 = new Person("Genesis",101024894,20,Gender.FEMALE,false);

        RegisterResult result3 = registry.registerVoter(person3);

        Assert.assertEquals(RegisterResult.DEAD, result3);
    
    }

    //UNDERAGE: Verficamos que la persona esta por debajo de la edad requerida

    @Test
    public void validateRegistryResultUnderAge() {
        Person person = new Person("Camila",2146136,17,Gender.FEMALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    //verificar que la persona cumple con la edad requerida,que este viva y no este duplicada. 
    @Test
    public void validateRegistryResultValid() {
        Person person = new Person("Alan",2146136,20,Gender.FEMALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
 

}
