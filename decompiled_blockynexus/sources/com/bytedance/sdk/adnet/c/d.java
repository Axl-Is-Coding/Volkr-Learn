package com.bytedance.sdk.adnet.c;

import java.util.Map;

/* JADX INFO: compiled from: TNCConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5439a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5440b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Integer> f5441c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f5442d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5443e = 10;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5444f = 1;
    public int g = 1;
    public int h = 10;
    public int i = 1;
    public int j = 1;
    public int k = 900;
    public int l = 120;
    public String m = null;
    public int n = 0;
    public long o = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f5439a);
        sb.append(" probeEnable: ");
        sb.append(this.f5440b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f5441c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f5442d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f5443e);
        sb.append("#");
        sb.append(this.f5444f);
        sb.append("#");
        sb.append(this.g);
        sb.append(" reqErr: ");
        sb.append(this.h);
        sb.append("#");
        sb.append(this.i);
        sb.append("#");
        sb.append(this.j);
        sb.append(" updateInterval: ");
        sb.append(this.k);
        sb.append(" updateRandom: ");
        sb.append(this.l);
        sb.append(" httpBlack: ");
        sb.append(this.m);
        return sb.toString();
    }
}
