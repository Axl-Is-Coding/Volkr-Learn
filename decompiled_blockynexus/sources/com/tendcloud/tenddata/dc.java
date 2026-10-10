package com.tendcloud.tenddata;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class dc extends cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static db f19992a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f19993c = "type";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f19994d = "deviceId";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f19995e = "runtimeConfig";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f19996f = "hardwareConfig";
    private static final String g = "softwareConfig";
    private dd h = new dd();
    private da i = new da();

    public dc() {
        d();
    }

    private void d() {
        a("type", "mobile");
        f19992a = new db();
        a("deviceId", f19992a.a_());
        a(f19995e, new df().a_());
        a(f19996f, this.i.a_());
        a(g, this.h.a_());
    }

    public dd b() {
        return this.h;
    }

    public da c() {
        return this.i;
    }
}
