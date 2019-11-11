/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wwwbestwordlistcom.dataprocessing;

import com.example.wwwbestwordlistcom.word.WordService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dell
 */
@Component
public class DataProcessor {

    private Document doc;

    public List<String> getWords(Document doc) {
        this.doc=doc;        
        ArrayList<String> ret = new ArrayList<String>();
        Element biggestParagraph = getBiggestPragraph();
        Arrays.stream(biggestParagraph.text().split(" "))
                .forEach(ret::add);                
        return ret;
    }

    private Element getBiggestPragraph() {
        if (getAllParagraphs()==null) {            
            return null;
        }
        int biggestSize = 0;
        Element biggest = null;
        for(Element element : getAllParagraphs() ){
            if(element.text().length()>biggestSize){
                biggestSize=element.text().length();
                biggest=element;
            }
        }
        return biggest;
    }
    private Elements getAllParagraphs(){
        return doc.getElementsByTag("p");
    }

    public int getNumberOfPages(Document doc) {
        this.doc=doc;
        Element theElement=null;
        for(Element element : getAllParagraphs() ){
            if(element.toString().contains("Pages")){
                theElement = element;
                break;
            }
        }
        String[] arr = theElement.text().split(" ");
        return Integer.valueOf(arr[arr.length-1]);
    }
    
}
