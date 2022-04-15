package com.google.api;

import com.google.api.Files;
import junit.framework.TestCase;

import org.junit.Test;

import com.google.api.GoogleAPI;

import java.io.File;

/**
 * @author Richard Midwinter
 *
 */
public class LoopTest extends TestCase {

    private Translate translate;

    @Override
    protected void setUp() throws Exception {
        translate = Translate.DEFAULT;
    }

    @Test
    public void testTranslate() throws Exception {
        System.out.println("testTranslate");

        GoogleAPI.setHttpReferrer(Files.read(new File(System.getProperty("user.home") + "/.google-translate-api-referrer.txt")).trim());
        GoogleAPI.setKey(Files.read(new File(System.getProperty("user.home") + "/.google-translate-api.key")).trim());

        for (int i = 0; i<30; i++) {
            System.out.println("Loop: " +i);
            assertEquals("????? ???????", translate.execute("Hello world", Language.ENGLISH, Language.ARABIC));
        }
    }
}