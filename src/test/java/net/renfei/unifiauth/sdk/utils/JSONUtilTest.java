package net.renfei.unifiauth.sdk.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import net.renfei.unifiauth.sdk.entity.ApiResult;
import net.renfei.unifiauth.sdk.entity.UserProfile;
import org.junit.jupiter.api.Test;

/**
 * @author renfei
 */
public class JSONUtilTest {
    @Test
    public void test() throws Exception {
        String json = "{\"code\":200,\"message\":\"Success.\",\"timestamp\":1683874655,\"signature\":\"fde863ebf6abdbbf2c26c48e9e5b5997ecc34d29\",\"nonce\":\"2nLVi2pVQf6yWLCM\",\"data\":{\"username\":\"admin\",\"name\":\"管理员\",\"mobile\":\"13001000000\",\"officeAddress\":null,\"officePhone\":null,\"gender\":\"男\",\"secretLevel\":null}}";
        ApiResult<UserProfile> apiResult = JSONUtils.json2pojo(json, new TypeReference<ApiResult<UserProfile>>() {
        });
        System.out.println(apiResult.toString());
    }
}
