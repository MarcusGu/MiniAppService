package com.marcus.common.http;


import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HttpRequest {

    private static final Log log = LogFactory.getLog(HttpRequest.class);

    private static final int CONNECT_TIMEOUT = 5000;
    private static final int SOCKET_TIMEOUT = 5000;

    private CloseableHttpClient mHttpClient;

    public HttpRequest() {
        initHttpClient();
    }

    private void initHttpClient() {
        mHttpClient = HttpClientBuilder.create().build();
    }

    public String get(String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = mHttpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            log.info("Http get : " + entity.getContent());
            return parseStream(entity.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }

    public String post(String url, HashMap<String, String> param) {
        HttpPost post = new HttpPost(url);

        if (null != param && !param.isEmpty()) {
            Set<Map.Entry<String, String>> entrySet = param.entrySet();
            Iterator iterator = entrySet.iterator();
            do {
                Map.Entry<String, String> entry = (Map.Entry) iterator.next();
                post.addHeader(entry.getKey(), entry.getValue());
            } while (iterator.hasNext());
        }

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        post.setConfig(config);

        try {
            CloseableHttpResponse response = mHttpClient.execute(post);
            log.info("Http host : " + response.getEntity());
            HttpEntity entity = response.getEntity();
            return parseStream(entity.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String parseStream(InputStream stream) {
        InputStreamReader streamReader = null;
        BufferedReader reader = null;
        try {
            streamReader = new InputStreamReader(stream);
            reader = new BufferedReader(streamReader);
            String line = null;
            String result = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            System.out.println("Http Result : " + result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != streamReader) {
                    streamReader.close();
                }
                if (null != reader) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static HttpRequest getInstance() {
        return ClientHolder.INSTANCE;
    }

    private final static class ClientHolder {
        private static final HttpRequest INSTANCE = new HttpRequest();
    }

}
