package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;

/* JADX INFO: compiled from: Image.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6102c;

    public String a() {
        return this.f6100a;
    }

    public int b() {
        return this.f6101b;
    }

    public int c() {
        return this.f6102c;
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f6100a) && this.f6101b > 0 && this.f6102c > 0;
    }

    public void a(String str) {
        this.f6100a = str;
    }

    public void b(int i) {
        this.f6102c = i;
    }

    public void a(int i) {
        this.f6101b = i;
    }

    public static TTImage a(g gVar) {
        if (gVar == null || !gVar.d()) {
            return null;
        }
        return new TTImage(gVar.c(), gVar.b(), gVar.a());
    }
}
