package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: AuctionSettings.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15018f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private boolean l;
    private boolean m;
    private ArrayList<String> n;

    a() {
        this.f15014b = "";
        this.f15015c = "";
        this.f15013a = false;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = true;
        this.m = true;
        this.n = new ArrayList<>();
        this.f15018f = 0;
    }

    public String a() {
        return this.f15014b;
    }

    public long b() {
        return this.i;
    }

    public int c() {
        return this.f15017e;
    }

    public boolean d() {
        return this.l;
    }

    public boolean e() {
        return this.m;
    }

    public boolean f() {
        return this.f15013a;
    }

    public ArrayList<String> g() {
        return this.n;
    }

    public int h() {
        return this.f15016d;
    }

    public int i() {
        return this.f15018f;
    }

    public long j() {
        return this.j;
    }

    public long k() {
        return this.h;
    }

    public long l() {
        return this.k;
    }

    public long m() {
        return this.g;
    }

    public String n() {
        return this.f15015c;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n.add(str);
    }

    a(String str, String str2, int i, int i2, long j, boolean z, long j2, long j3, long j4, long j5, boolean z2, boolean z3, int i3) {
        this.f15014b = str;
        this.f15015c = str2;
        this.f15016d = i;
        this.f15017e = i2;
        this.g = j;
        this.f15013a = z;
        this.h = j2;
        this.i = j3;
        this.j = j4;
        this.k = j5;
        this.l = z2;
        this.m = z3;
        this.f15018f = i3;
        this.n = new ArrayList<>();
    }
}
