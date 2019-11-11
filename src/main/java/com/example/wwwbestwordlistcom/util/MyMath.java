/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wwwbestwordlistcom.util;

/**
 *
 * @author Dell
 */
public class MyMath {
    
        public static int getRandomNumberBetweenInclusive(int a,int b) {
        int ret=0;
        if(a<b){
            ret=getRandomNumberBetweenInclusiveAssumingRightOrderOfParams(a,b); 
        }else if(b>a){
            ret=getRandomNumberBetweenInclusiveAssumingRightOrderOfParams(b,a); 
        }else{
            ret=a;
        }
        return ret;
    }

    private static int getRandomNumberBetweenInclusiveAssumingRightOrderOfParams(int min, int max) {
        int nrOfPossibilities = max-min+1;
        double lessThan1 = java.lang.Math.random(); //0>=rand<1
        int oneOfNrOfPossibilitiesFromZero = (int)(nrOfPossibilities*lessThan1);
        return oneOfNrOfPossibilitiesFromZero+min;
    }
    
}
