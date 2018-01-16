package com.hainet.jsoup.sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class JsoupTest {

    @Test
    public void jsoupTest() {
        try {
            final Document document = Jsoup.connect("https://www.google.co.jp").get();

            assertThat(document.title(), is("Google"));
            assertThat(document.select("#lst-ib").toString(), is(containsString("name=\"q\"")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
