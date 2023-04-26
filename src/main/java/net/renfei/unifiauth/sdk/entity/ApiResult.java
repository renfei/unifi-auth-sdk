package net.renfei.unifiauth.sdk.entity;

import net.renfei.unifiauth.sdk.constant.HttpStatus;
import net.renfei.unifiauth.sdk.utils.StringUtils;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * 统一接口响应对象
 *
 * @author renfei
 */
@Schema(title = "统一接口响应对象")
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = -3316408227872898096L;
    @Schema(description = "状态码，成功为200")
    private Integer code;
    @Schema(description = "消息")
    private String message;
    @Schema(description = "服务器时间戳")
    private Integer timestamp;
    @Schema(description = "签名")
    private String signature;
    @Schema(description = "随机数")
    private String nonce;
    @Schema(description = "数据负载")
    private T data;

    private ApiResult() {
        this.signature();
    }

    private ApiResult(Builder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
        this.signature();
    }

    public ApiResult(T data) {
        this.code = HttpStatus.SUCCESS;
        this.message = "Success.";
        this.data = data;
        this.signature();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static ApiResult<?> success() {
        ApiResult<?> apiResult = new ApiResult<>();
        apiResult.code = HttpStatus.SUCCESS;
        apiResult.message = "Success.";
        return apiResult;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message == null ? "" : this.message;
    }

    public Integer getTimestamp() {
        return this.timestamp;
    }

    public T getData() {
        return this.data;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getNonce() {
        return this.nonce;
    }

    private void setNonce(String nonce) {
        this.nonce = nonce;
    }

    private void signature() {
        this.timestamp = (int) (System.currentTimeMillis() / 1000L);
        this.nonce = StringUtils.getRandomString(16);
        this.signature = StringUtils.signature(this.timestamp.toString(), this.nonce);
    }

    public static class Builder<T> {
        private Integer code;
        private String message;
        private T data;

        public Builder() {
        }

        public Builder<T> code(int code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResult<T> build() {
            return new ApiResult<>(this);
        }
    }
}
