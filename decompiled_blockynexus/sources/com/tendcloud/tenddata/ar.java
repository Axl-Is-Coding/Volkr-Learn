package com.tendcloud.tenddata;

import java.net.HttpURLConnection;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public enum ar {
    GET(false),
    POST(true);


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19797c;

    ar(boolean z) {
        this.f19797c = z;
    }

    final void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.setRequestMethod(name());
            httpURLConnection.setDoOutput(this.f19797c);
            httpURLConnection.setDoInput(true);
        } catch (Throwable unused) {
        }
    }
}
