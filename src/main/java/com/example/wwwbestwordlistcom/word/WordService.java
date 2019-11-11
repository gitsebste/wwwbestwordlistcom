/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wwwbestwordlistcom.word;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class WordService {
    
    @Autowired
    WordRepository wordRepository;
    
    public void save(String word){
        wordRepository.save(new Word(word));
    }
    
        public List<Word> findAll(){
        return wordRepository.findAll();
    }
}
