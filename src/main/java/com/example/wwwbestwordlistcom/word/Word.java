/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wwwbestwordlistcom.word;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Dell
 */
@Entity
public class Word {
    
    @Id
    String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }
    
    
    
    
}
