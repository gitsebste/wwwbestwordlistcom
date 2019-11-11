/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wwwbestwordlistcom.datafetching;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dell
 */
@Component
public class DataFetcher {
    
    Document doc;

    public Document getDoc() {
        return doc;
    }

    public DataFetcher fetchData(String url) {
        fetchDataSafe(url);
        return this;
    }
    
    private void fetchDataSafe(String url) {
        try {
            doc = Jsoup.connect(url).get();            
        } catch (IOException ex) {
            Logger.getLogger(DataFetcher.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public boolean fetchOK() {
        if(doc==null)return false;                
        return doc.hasText();
    }
  
}
