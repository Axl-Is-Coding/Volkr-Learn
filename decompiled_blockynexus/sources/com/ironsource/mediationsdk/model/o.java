package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: ProviderOrder.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14935c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14938f;
    private String g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f14933a = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<String> f14936d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<String> f14937e = new ArrayList<>();

    public ArrayList<String> a() {
        return this.f14937e;
    }

    public ArrayList<String> b() {
        return this.f14936d;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f14933a.add(str);
    }

    public String d() {
        return this.f14935c;
    }

    public ArrayList<String> e() {
        return this.f14933a;
    }

    public void f(String str) {
        this.f14934b = str;
    }

    public void g(String str) {
        this.f14935c = str;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f14937e.add(str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f14936d.add(str);
    }

    public void d(String str) {
        this.f14938f = str;
    }

    public void e(String str) {
        this.g = str;
    }

    public String c() {
        return this.f14934b;
    }
}
