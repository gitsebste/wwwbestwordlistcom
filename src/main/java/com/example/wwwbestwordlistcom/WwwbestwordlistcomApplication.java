package com.example.wwwbestwordlistcom;

import com.example.wwwbestwordlistcom.datafetching.DataFetcher;
import com.example.wwwbestwordlistcom.dataprocessing.DataProcessor;
import com.example.wwwbestwordlistcom.word.Word;
import com.example.wwwbestwordlistcom.word.WordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class WwwbestwordlistcomApplication implements CommandLineRunner {

    @Autowired
    DataFetcher dataFetcher;
    @Autowired
    DataProcessor dataProcessor;

    @Autowired
    WordService wordService;

    public static void main(String[] args) {
        SpringApplication.run(WwwbestwordlistcomApplication.class, args);
    }

    @Override

    public void run(String... arg0) throws Exception {

        if (wordService.findAll() != null
                && wordService.findAll().size() > 0) {
            return;
        }

        String url = getMainPage();
        getAfterMainPages(url);

    }

    private String getMainPage() {
        String url = "https://www.bestwordlist.com/allwords.htm";
        getProcessAndSaveToDB(url);
        return url;
    }

    private void getAfterMainPages(String url) {
        int numberOfPages
                = dataProcessor.getNumberOfPages(
                        dataFetcher.fetchData(url).getDoc()
                );
        for (int i = 2; i <= numberOfPages; i++) {
            url = "https://www.bestwordlist.com/allwordspage" + i + ".htm";
            getProcessAndSaveToDB(url);
        }
    }

    private void getProcessAndSaveToDB(String url) {
        get(url);
        List<String> manyWordsWithAasFirstLetter = process();
        save(manyWordsWithAasFirstLetter);
    }

    private void get(String url) {
        dataFetcher.fetchData(url);
    }

    private List<String> process() {
        List<String> manyWordsWithAasFirstLetter = null;
        manyWordsWithAasFirstLetter = dataProcessor.getWords(dataFetcher.getDoc());
        return manyWordsWithAasFirstLetter;
    }

    private void save(List<String> manyWordsWithAasFirstLetter) {
        manyWordsWithAasFirstLetter.stream()
                .forEach(wordService::save);
    }

}
