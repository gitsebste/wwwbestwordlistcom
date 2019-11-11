/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wwwbestwordlistcom.util;

import static java.time.Duration.ofMillis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Dell
 */
@SpringBootTest
public class MyMathTest {
    @Test
    void randomNumberBetweenInclusiveInclusion0And1Test()
    {
        Assertions.assertTimeoutPreemptively(ofMillis(1000), () ->{
        boolean[] zeroAndOne = new boolean[]{false,false};
        for(;;)
        {
            zeroAndOne[MyMath.getRandomNumberBetweenInclusive(0,1)]=true;
            if(zeroAndOne[0] && zeroAndOne[1])break;
        }
    });
    }
    
    @Test
    void randomNumberBetweenInclusiveProbability012345678Test()
    {
        int[] zeroToEight = new int[]{0,0,0,0,0,0,0,0,0};
        final int MILION = 1_000_000;
        for(int i=0;i<MILION;i++)
        {
            zeroToEight[MyMath.getRandomNumberBetweenInclusive(0,zeroToEight.length-1)]++;
        } 
        
        for(int i=0;i<zeroToEight.length;i++){
            final int curr=zeroToEight[i];
            double probabMeasured = curr*1.0/MILION;
            double probabExpectedLowerBound = 1.0/(zeroToEight.length+1);
            Assertions.assertTrue(probabMeasured>probabExpectedLowerBound);
        }

    }
    
}
