package com.lipinskyi.common.api;

import com.lipinskyi.common.api.translate.GoogleAPI;
import com.lipinskyi.common.api.translate.GoogleAPIException;
import com.lipinskyi.common.api.translate.Language;
import com.lipinskyi.common.api.translate.Translate;
import com.lipinskyi.common.dao.Entity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Translator {

    public String translateWord(String word) {

        GoogleAPI.setHttpReferrer("link");
        GoogleAPI.setKey("AIzaSyBABREcOUzMuH2Tfp22bd_gwLhADUny1GQ");

        String translatedText = null;
        try {
            translatedText = Translate.DEFAULT.execute(word, Language.ENGLISH, Language.RUSSIAN);
        } catch (GoogleAPIException e) {
            System.err.println(e);
        }

        return translatedText;
    }

    public List<Entity> translateEntityList(List<Entity> entities) {

        List<Entity> translatedList = new ArrayList<>();

        for (Entity entity : entities) {
            Entity translatedEntity = new Entity();
            translatedEntity.setId(entity.getId());
            translatedEntity.setRegion(translateWord(entity.getRegion()));
            translatedEntity.setLocality(translateWord(entity.getLocality()));
            translatedList.add(translatedEntity);
        }

        return translatedList;
    }
}
