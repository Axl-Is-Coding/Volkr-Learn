package com.tendcloud.tenddata;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f19791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f19792b;

    /* JADX INFO: compiled from: td */
    public enum a {
        UNIVERSAL_STREAM("application/octet-stream"),
        JSON(AbstractSpiCall.ACCEPT_JSON_VALUE),
        FORM("application/x-www-form-urlencoded"),
        EMPTY("");

        private String name;

        a(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    public ap(a aVar, byte[] bArr) {
        this.f19791a = aVar;
        this.f19792b = bArr;
    }

    public byte[] a() {
        return this.f19792b;
    }

    public a b() {
        return this.f19791a;
    }

    void a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setFixedLengthStreamingMode(this.f19792b.length);
        httpURLConnection.setRequestProperty("Content-Type", this.f19791a.getName());
        OutputStream outputStream = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(this.f19792b);
            if (outputStream == null) {
                return;
            }
        } catch (Throwable unused) {
            if (outputStream == null) {
                return;
            }
        }
        try {
            outputStream.close();
        } catch (Throwable unused2) {
        }
    }
}
