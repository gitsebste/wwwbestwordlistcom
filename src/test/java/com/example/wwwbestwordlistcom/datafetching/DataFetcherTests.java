/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wwwbestwordlistcom.datafetching;

import com.example.wwwbestwordlistcom.dataprocessing.DataProcessor;
import com.example.wwwbestwordlistcom.util.MyMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Dell
 */
@SpringBootTest
public class DataFetcherTests {
    
//    @Test
//    void testFetchingPage(){
//        if(MyMath.getRandomNumberBetweenInclusive(0, 1)==0){
//            testFetchingMainPage();
//        }else{
//            testFetchingNonMainPage();
//        }
//    }
    
    void testFetchingMainPage(){
        String url="https://www.bestwordlist.com/allwords.htm";
        DataFetcher dataFetcher = new DataFetcher();
        dataFetcher.fetchData(url);
        Assertions.assertTrue(dataFetcher.fetchOK());
    }
    
    void testFetchingNonMainPage(){
        int numberOfNonMainPages=540;
        int pageNumber = MyMath.getRandomNumberBetweenInclusive(2,numberOfNonMainPages+1);
        String url="https://www.bestwordlist.com/allwordspage"+String.valueOf(pageNumber)+".htm";
        DataFetcher dataFetcher = new DataFetcher();
        dataFetcher.fetchData(url);
        Assertions.assertTrue(dataFetcher.fetchOK());
    }
    
    @Test
    void testGetNumberOfPages(){
        String url="https://www.bestwordlist.com/allwords.htm";
        DataFetcher dataFetcher = new DataFetcher();
        DataProcessor dataProcessor = new DataProcessor();
        int numberOfPages = 
                    dataProcessor.getNumberOfPages(
                            dataFetcher.fetchData(url).getDoc()
                    );
        Assertions.assertEquals(541, numberOfPages);
    }


    
}
