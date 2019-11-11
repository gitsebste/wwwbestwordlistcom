/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wwwbestwordlistcom.dataprocessing;

import com.example.wwwbestwordlistcom.datafetching.DataFetcher;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Dell
 */
@SpringBootTest
public class DataProcessorTest {
    
    @Test
    void testGetWords(){
        DataFetcher dataFetcher = new DataFetcher();
        dataFetcher.fetchData("https://www.bestwordlist.com/allwords.htm");
        DataProcessor dataProcessor = new DataProcessor();
        List<String> manyWordsWithAasFirstLetter=null;
        if (dataFetcher.fetchOK()) {
            manyWordsWithAasFirstLetter= dataProcessor.getWords(dataFetcher.getDoc());
        }
        Assertions.assertTrue(manyWordsWithAasFirstLetter!=null);
        Assertions.assertTrue(manyWordsWithAasFirstLetter.size()>100);
        
        for(int i=0;i<manyWordsWithAasFirstLetter.size();i++){
            final String curr = manyWordsWithAasFirstLetter.get(i);
            Assertions.assertEquals('a',curr.toLowerCase().charAt(0));
        }
    }        
    
}
