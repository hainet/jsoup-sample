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
    public void getTest() {
        try {
            final Document document = Jsoup.connect("https://www.google.co.jp").get();

            assertThat(document.title(), is("Google"));
            assertThat(document.select("#lst-ib").toString(), is(containsString("name=\"q\"")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void parseTest() {
        final Document document = Jsoup.parse("<html><head><title>hainet</title></head><body><div id=hainet>jsoup</div></body></html>");

        assertThat(document.title(), is("hainet"));
        assertThat(document.select("#hainet").toString(), is(containsString("jsoup")));
    }
}
