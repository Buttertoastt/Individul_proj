package com.google.api;
import junit.framework.TestCase;

import org.junit.Test;

import java.io.File;

/**
 * @author Richard Midwinter
 */
public class DetectTest extends TestCase {
    @Test
    public void testDetect() throws Exception {
        System.out.println("testDetect");

        GoogleAPI.setHttpReferrer(Files.read(new File(System.getProperty("user.home") + "/.google-translate-api-referrer.txt")).trim());
        GoogleAPI.setKey(Files.read(new File(System.getProperty("user.home") + "/.google-translate-api.key")).trim());

        DetectResult detectResult = Detect.execute("Hello world");

        assertEquals(Language.ENGLISH, detectResult.getLanguage());
        assertTrue(detectResult.getConfidence() > 0);
    }
}