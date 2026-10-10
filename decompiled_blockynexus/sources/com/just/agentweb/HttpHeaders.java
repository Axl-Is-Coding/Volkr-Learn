package com.just.agentweb;

import a.a.b;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpHeaders {
    private final Map<String, Map<String, String>> mHeaders = new b();

    HttpHeaders() {
    }

    public static HttpHeaders create() {
        return new HttpHeaders();
    }

    private String subBaseUrl(String str) {
        int iIndexOf;
        return (!TextUtils.isEmpty(str) && (iIndexOf = str.indexOf("?")) > 0) ? str.substring(0, iIndexOf) : str;
    }

    public void additionalHttpHeader(String str, String str2, String str3) {
        if (str == null) {
            return;
        }
        String strSubBaseUrl = subBaseUrl(str);
        Map<String, Map<String, String>> headers = getHeaders();
        Map<String, String> bVar = headers.get(subBaseUrl(strSubBaseUrl));
        if (bVar == null) {
            bVar = new b<>();
        }
        bVar.put(str2, str3);
        headers.put(strSubBaseUrl, bVar);
    }

    public void additionalHttpHeaders(String str, Map<String, String> map) {
        if (str == null) {
            return;
        }
        String strSubBaseUrl = subBaseUrl(str);
        Map<String, Map<String, String>> headers = getHeaders();
        if (map == null) {
            map = new b<>();
        }
        headers.put(strSubBaseUrl, map);
    }

    public Map<String, String> getHeaders(String str) {
        String strSubBaseUrl = subBaseUrl(str);
        if (this.mHeaders.get(strSubBaseUrl) != null) {
            return this.mHeaders.get(strSubBaseUrl);
        }
        b bVar = new b();
        this.mHeaders.put(strSubBaseUrl, bVar);
        return bVar;
    }

    public boolean isEmptyHeaders(String str) {
        Map<String, String> headers = getHeaders(subBaseUrl(str));
        return headers == null || headers.isEmpty();
    }

    public void removeHttpHeader(String str, String str2) {
        if (str == null) {
            return;
        }
        Map<String, String> map = getHeaders().get(subBaseUrl(str));
        if (map != null) {
            map.remove(str2);
        }
    }

    public String toString() {
        return "HttpHeaders{mHeaders=" + this.mHeaders + '}';
    }

    public Map<String, Map<String, String>> getHeaders() {
        return this.mHeaders;
    }
}
