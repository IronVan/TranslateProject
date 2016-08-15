package com.lipinskyi.common.api;

import com.lipinskyi.common.api.translate.GoogleAPI;
import com.lipinskyi.common.api.translate.GoogleAPIException;
import com.lipinskyi.common.api.translate.Language;
import com.lipinskyi.common.api.translate.Translate;

public class Main {
    public static void main(String[] args) {
        // Set the HTTP referrer to your website address.
        GoogleAPI.setHttpReferrer("link");

        // Set the Google Translate API key
        GoogleAPI.setKey("AIzaSyBABREcOUzMuH2Tfp22bd_gwLhADUny1GQ");

        String translatedText = null;
        try {
            translatedText = Translate.DEFAULT.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH);
        } catch (GoogleAPIException e) {
           System.err.println(e);
        }

        System.out.println(translatedText);
    }
}
