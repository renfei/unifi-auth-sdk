package net.renfei.unifiauth.sdk.entity;

import java.io.Serializable;

/**
 * 统一认证平台回调返回的数据对象
 *
 * @author renfei
 */
public class CallbackDataObject implements Serializable {
    private static final long serialVersionUID = -3316408227872898096L;
    private Boolean success;
    private String code;
    private String state;
    private String error;
    private String errorDescription;
    private String errorUri;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorUri() {
        return errorUri;
    }

    public void setErrorUri(String errorUri) {
        this.errorUri = errorUri;
    }
}
