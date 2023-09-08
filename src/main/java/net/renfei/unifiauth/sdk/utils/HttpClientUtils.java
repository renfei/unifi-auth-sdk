package net.renfei.unifiauth.sdk.utils;

import net.renfei.unifiauth.sdk.entity.AccessTokenDataObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author renfei
 */
public class HttpClientUtils {

    public String get(URI uri, String token) {
        HttpGet request = new HttpGet(uri);
        if (token.startsWith("Bearer ")) {
            request.setHeader("Authorization", token);
        } else {
            request.setHeader("Authorization", "Bearer " + token);
        }

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .build();
             CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, StandardCharsets.UTF_8);
            } else {
                throw new RuntimeException("response entity is null.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String postForm(URI uri, String clientId, String password, Map<String, String> data) {
        HttpHost target = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());

        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(new BasicAuthCache() {{
            this.put(target, new BasicScheme());
        }});

        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials(clientId, password)
        );

        List<NameValuePair> formParams = new ArrayList<>();
        data.forEach((key, value) -> formParams.add(new BasicNameValuePair(key, value)));

        HttpPost request = new HttpPost(uri);
        request.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build();
             CloseableHttpResponse response = httpClient.execute(target, request, localContext)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            } else {
                throw new RuntimeException("response entity is null.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
