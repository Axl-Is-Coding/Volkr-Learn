package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ISBannerSize.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2374v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2374v f15055a = new C2374v("BANNER", 320, 50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2374v f15056b = new C2374v("LARGE", 320, 90);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2374v f15057c = new C2374v("RECTANGLE", 300, 250);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final C2374v f15058d = new C2374v("LEADERBOARD", 728, 90);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2374v f15059e = new C2374v("SMART", 0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15060f;
    private int g;
    private String h;

    public C2374v(String str, int i, int i2) {
        this.h = str;
        this.f15060f = i;
        this.g = i2;
    }

    public String a() {
        return this.h;
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.f15060f;
    }

    public boolean d() {
        return this.h.equals("SMART");
    }
}
