package com.alibaba.sdk.android.feedback.xblink.c;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f3793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f3794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3795c = "GET";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f3796d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3797e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3798f = 1;
    private int g = 5000;
    private int h = 5000;
    private String i = "NONE";

    public h(String str) {
        if (str == null) {
            throw new NullPointerException("HttpRequest init error, url is null.");
        }
        this.f3793a = Uri.parse(str);
    }

    public Uri a() {
        return this.f3793a;
    }

    public void a(Uri uri) {
        if (uri != null) {
            this.f3793a = uri;
        }
    }

    public void a(Map map) {
        this.f3796d = map;
    }

    public void a(boolean z) {
        this.f3797e = z;
    }

    public byte[] b() {
        return this.f3794b;
    }

    public String c() {
        return this.f3795c;
    }

    public Map d() {
        return this.f3796d;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public boolean g() {
        return this.f3797e;
    }

    public int h() {
        return this.f3798f;
    }

    public String i() {
        return this.i;
    }
}
