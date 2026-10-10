package com.bytedance.sdk.openadsdk.core.g;

import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: AdSlotSetter.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6184a;
    public List<String> z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6185b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6186c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6187d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6188e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6189f = 1;
    public int g = 100;
    public int h = 0;
    public int i = 2;
    public int j = 1;
    public int k = 3;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = 2;
    public int p = 1;
    public int q = 0;
    public int r = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    public int s = 2;
    public int t = -1;
    public int u = 20;
    public int v = -1;
    public int w = 0;
    public int x = 5;
    public int y = 0;
    public int A = 2;

    private a() {
    }

    public static a a() {
        return new a();
    }

    public a b(int i) {
        this.w = i;
        return this;
    }

    public a c(int i) {
        this.y = i;
        return this;
    }

    public a d(int i) {
        this.u = i;
        return this;
    }

    public a e(int i) {
        this.t = i;
        return this;
    }

    public a f(int i) {
        this.q = i;
        return this;
    }

    public a g(int i) {
        this.r = i;
        return this;
    }

    public a h(int i) {
        this.s = i;
        return this;
    }

    public a i(int i) {
        this.o = i;
        return this;
    }

    public a j(int i) {
        this.m = i;
        return this;
    }

    public a k(int i) {
        this.n = i;
        return this;
    }

    public a l(int i) {
        this.l = i;
        return this;
    }

    public a m(int i) {
        this.k = i;
        return this;
    }

    public a n(int i) {
        this.f6185b = i;
        return this;
    }

    public a o(int i) {
        this.f6186c = i;
        return this;
    }

    public a p(int i) {
        this.f6187d = i;
        return this;
    }

    public a q(int i) {
        this.f6188e = i;
        return this;
    }

    public a r(int i) {
        this.f6189f = i;
        return this;
    }

    public a s(int i) {
        this.g = i;
        return this;
    }

    public a t(int i) {
        this.h = i;
        return this;
    }

    public a u(int i) {
        this.i = i;
        return this;
    }

    public a v(int i) {
        this.j = i;
        return this;
    }

    public a w(int i) {
        this.p = i;
        return this;
    }

    public a x(int i) {
        this.A = i;
        return this;
    }

    public a y(int i) {
        this.x = i;
        return this;
    }

    public a a(int i) {
        this.v = i;
        return this;
    }

    public a a(String str) {
        this.f6184a = str;
        return this;
    }

    public a a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.z = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    this.z.add(jSONArray.get(i).toString());
                } catch (Exception unused) {
                }
            }
        }
        return this;
    }
}
