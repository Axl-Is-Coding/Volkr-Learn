package com.bumptech.glide.load.a;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: GlideUrl.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements com.bumptech.glide.load.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f4269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final URL f4270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private URL f4273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile byte[] f4274f;
    private int g;

    public l(URL url) {
        this(url, n.f4276b);
    }

    private byte[] d() {
        if (this.f4274f == null) {
            this.f4274f = a().getBytes(com.bumptech.glide.load.h.f4628a);
        }
        return this.f4274f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f4272d)) {
            String string = this.f4271c;
            if (TextUtils.isEmpty(string)) {
                URL url = this.f4270b;
                com.bumptech.glide.e.l.a(url);
                string = url.toString();
            }
            this.f4272d = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f4272d;
    }

    private URL f() throws MalformedURLException {
        if (this.f4273e == null) {
            this.f4273e = new URL(e());
        }
        return this.f4273e;
    }

    public String a() {
        String str = this.f4271c;
        if (str != null) {
            return str;
        }
        URL url = this.f4270b;
        com.bumptech.glide.e.l.a(url);
        return url.toString();
    }

    public Map<String, String> b() {
        return this.f4269a.a();
    }

    public URL c() throws MalformedURLException {
        return f();
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return a().equals(lVar.a()) && this.f4269a.equals(lVar.f4269a);
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        if (this.g == 0) {
            this.g = a().hashCode();
            this.g = (this.g * 31) + this.f4269a.hashCode();
        }
        return this.g;
    }

    public String toString() {
        return a();
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public l(String str) {
        this(str, n.f4276b);
    }

    public l(URL url, n nVar) {
        com.bumptech.glide.e.l.a(url);
        this.f4270b = url;
        this.f4271c = null;
        com.bumptech.glide.e.l.a(nVar);
        this.f4269a = nVar;
    }

    public l(String str, n nVar) {
        this.f4270b = null;
        com.bumptech.glide.e.l.a(str);
        this.f4271c = str;
        com.bumptech.glide.e.l.a(nVar);
        this.f4269a = nVar;
    }
}
