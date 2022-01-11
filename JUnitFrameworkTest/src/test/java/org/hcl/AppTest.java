package org.hcl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest{

    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll Executed");
    }

    @BeforeEach
    void setupThis(){
        System.out.println("@BeforeEach Executed");
    }

    @Test
    void calculate(){
        //Assertions.fail("No code has been implemented", new Exception());
        System.out.println("Before Implementation Executed");
        int returnVal = Addition.add(12,5);
        System.out.println("After Implementation Executed");
        Assertions.assertEquals(17, returnVal);

    }
    @Test
    void product(){
        //Assertions.fail("No code has been implemented", new Exception());
        System.out.println("Before Implementation Executed");
        int returnVal = Multiply.multi(12,5);
        System.out.println("After Implementation Executed");
        Assertions.assertEquals(60, returnVal);
    }
}