package com.bytedance.sdk.adnet.d;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: UrlBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, List<String>> f5561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5562b;

    public g(String str) {
        this.f5561a = new LinkedHashMap();
        this.f5562b = str;
    }

    private String b(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public void a(String str, int i) {
        List<String> linkedList = this.f5561a.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        linkedList.add(String.valueOf(i));
        this.f5561a.put(str, linkedList);
    }

    public String toString() {
        return a();
    }

    public g() {
        this.f5561a = new LinkedHashMap();
        this.f5562b = null;
    }

    public void a(String str, double d2) {
        List<String> linkedList = this.f5561a.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        linkedList.add(String.valueOf(d2));
        this.f5561a.put(str, linkedList);
    }

    public void a(String str, String str2) {
        List<String> linkedList = this.f5561a.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        linkedList.add(String.valueOf(str2));
        this.f5561a.put(str, linkedList);
    }

    public String a() {
        StringBuilder sb;
        String str;
        if (this.f5561a.isEmpty()) {
            return this.f5562b;
        }
        String strA = a(this.f5561a, "UTF-8");
        String str2 = this.f5562b;
        if (str2 == null || str2.length() == 0) {
            return strA;
        }
        if (this.f5562b.indexOf(63) >= 0) {
            sb = new StringBuilder();
            sb.append(this.f5562b);
            str = "&";
        } else {
            sb = new StringBuilder();
            sb.append(this.f5562b);
            str = "?";
        }
        sb.append(str);
        sb.append(strA);
        return sb.toString();
    }

    public String a(Map<String, List<String>> map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String strB = b(entry.getKey(), str);
            List<String> value = entry.getValue();
            if (value != null && value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String strB2 = next != null ? b(next, str) : "";
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(strB);
                    if (!strB2.isEmpty()) {
                        sb.append("=");
                        sb.append(strB2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
