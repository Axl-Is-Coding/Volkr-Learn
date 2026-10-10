package com.tendcloud.tenddata;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f19793a = new HashMap();

    public aq a(String str, String str2) {
        this.f19793a.put(str, str2);
        return this;
    }

    public String toString() {
        return this.f19793a.toString();
    }

    void a(HttpURLConnection httpURLConnection) {
        try {
            if (af.a(14) && af.b(19)) {
                this.f19793a.put("Connection", "close");
            }
            for (String str : this.f19793a.keySet()) {
                httpURLConnection.setRequestProperty(str, this.f19793a.get(str));
            }
        } catch (Throwable unused) {
        }
    }
}
