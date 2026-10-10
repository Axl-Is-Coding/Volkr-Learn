package com.ironsource.sdk.data;

/* JADX INFO: compiled from: AdUnitsReady.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f15376b = "type";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f15377c = "numOfAdUnits";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f15378d = "firstCampaignCredits";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f15379e = "totalNumberCredits";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f15380f = "productType";
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private boolean l;

    public a(String str) {
        super(str);
        if (a(f15376b)) {
            j(d(f15376b));
        }
        if (a(f15377c)) {
            g(d(f15377c));
            a(true);
        } else {
            a(false);
        }
        if (a(f15378d)) {
            f(d(f15378d));
        }
        if (a(f15379e)) {
            i(d(f15379e));
        }
        if (a(f15380f)) {
            h(d(f15380f));
        }
    }

    private void a(boolean z) {
        this.l = z;
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.h;
    }

    public boolean d() {
        return this.l;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.i = str;
    }

    public void h(String str) {
        this.h = str;
    }

    public void i(String str) {
        this.k = str;
    }

    public void j(String str) {
        this.g = str;
    }
}
