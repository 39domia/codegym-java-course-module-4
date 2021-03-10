package com.service;

import com.model.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryService {
    List<Dictionary> dictionaryList = new ArrayList<>();
    {
        dictionaryList.add(new Dictionary("book", "sach"));
        dictionaryList.add(new Dictionary("tree", "cay"));
        dictionaryList.add(new Dictionary("pen", "cay viet"));
    }


    public String search(String keyword){
        for (Dictionary dictionary : dictionaryList) {
            if (dictionary.getEnglish().equals(keyword)) {
                return dictionary.getVietnamese();
            }
        }
        return null;
    }
}
