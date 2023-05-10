package net.renfei.unifiauth.sdk.utils;


import net.renfei.unifiauth.sdk.entity.AccessTokenDataObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author renfei
 */
public class HttpClientUtilsTest {

    //@Test
    public void postTest() throws Exception {
        URI uri = new URI("http://localhost:8888/oauth2/token");

        Map<String, String> data = new HashMap<String, String>() {{
            this.put("grant_type", "authorization_code");
            this.put("client_id", "fec01ad39c9e495082ac74a861588d25");
            this.put("redirect_uri", "https://www.baidu.com");
            this.put("code", "Vh-2C3LWiCDwBIXQDvApOFTrG9xAfSdCBKtbeAgoRL7-8q6gT32h1mTM4zhDtXB412ztQmBna4CszC2eFPSZkBY-f9DNgrgminedVnCeiDNI3fVRd-aRGCdoi0qUWj43");
        }};

        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.postForm(uri, "fec01ad39c9e495082ac74a861588d25", "password", data);
        System.out.println(result);

        Map<String, Object> stringObjectMap = JSONUtils.json2map(result);
        if (stringObjectMap.get("access_token") != null) {
            AccessTokenDataObject accessTokenDataObject = JSONUtils.json2pojo(result, AccessTokenDataObject.class);
            System.out.println(accessTokenDataObject);
        } else if (stringObjectMap.get("error") != null) {
            System.err.println(stringObjectMap.get("error"));
        } else {
            System.err.println(stringObjectMap.get("message"));
        }
    }
}
