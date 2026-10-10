package com.tendcloud.tenddata;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class de extends cx {
    private static volatile de j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19997a = "oaid";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19998c = "vaid";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19999d = "aaid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f20000e = "udid";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f20001f = "";
    private volatile String g = "";
    private volatile String h = "";
    private volatile String i = "";

    private de() {
    }

    public static de b() {
        if (j == null) {
            synchronized (de.class) {
                if (j == null) {
                    j = new de();
                }
            }
        }
        return j;
    }

    public String c() {
        return this.f20001f;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.i;
    }

    public void setAAID(String str) {
        this.g = str;
        a("aaid", str);
    }

    public void setOAID(String str) {
        this.f20001f = str;
        a("oaid", str);
    }

    public void setUDID(String str) {
        this.i = str;
        a("udid", str);
    }

    public void setVAID(String str) {
        this.h = str;
        a("vaid", str);
    }
}
