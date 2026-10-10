package com.bytedance.sdk.openadsdk.core.d;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AdInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<h> f6058d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6060f;

    public String a() {
        return this.f6055a;
    }

    public int b() {
        return this.f6056b;
    }

    public List<h> c() {
        return this.f6058d;
    }

    public String d() {
        return this.f6059e;
    }

    public void a(String str) {
        this.f6055a = str;
    }

    public void b(String str) {
        this.f6057c = str;
    }

    public void c(String str) {
        this.f6059e = str;
    }

    public void a(int i) {
        this.f6056b = i;
    }

    public void a(h hVar) {
        this.f6058d.add(hVar);
    }

    public void a(long j) {
        this.f6060f = j;
    }
}
