package com.testehan.openliberty;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationIT {

    private final String port = System.getProperty("default.http.port");
    private final String war = "converter";
    private final String urlBase = "http://localhost:" + port + "/" + war + "/";


    @Test
    public void testIndexPage() throws Exception {
        final String url = this.urlBase;
        final HttpURLConnection con = testRequestHelper(url, "GET");

        assertEquals(200, con.getResponseCode(), "Incorrect response code from " + url);
        assertTrue(testBufferHelper(con).contains("Enter the height in centimeters"), "Incorrect response from " + url);
    }

    @Test
    public void testHeightsPage() throws Exception {
        final String url = this.urlBase + "heights.jsp?heightCm=10";
        final HttpURLConnection con = testRequestHelper(url, "POST");

        final String response = testBufferHelper(con);
        assertTrue(response.contains("3        inches"), "Response was" +response);
    }

    private HttpURLConnection testRequestHelper(final String url, final String method) throws Exception {
        final URL obj = new URL(url);
        final HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod(method);
        return con;
    }

    private String testBufferHelper(final HttpURLConnection con) throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        final StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
