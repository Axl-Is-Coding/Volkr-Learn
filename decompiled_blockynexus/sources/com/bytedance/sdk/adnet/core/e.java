package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.err.VAdError;

/* JADX INFO: compiled from: DefaultRetryPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.sdk.adnet.face.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f5498d;

    public e() {
        this(2500, 1, 1.0f);
    }

    public e a(int i) {
        this.f5495a = i;
        return this;
    }

    public e b(int i) {
        this.f5497c = i;
        return this;
    }

    protected boolean c() {
        return this.f5496b <= this.f5497c;
    }

    public e(int i, int i2, float f2) {
        this.f5495a = i;
        this.f5497c = i2;
        this.f5498d = f2;
    }

    @Override // com.bytedance.sdk.adnet.face.d
    public int a() {
        return this.f5495a;
    }

    @Override // com.bytedance.sdk.adnet.face.d
    public int b() {
        return this.f5496b;
    }

    @Override // com.bytedance.sdk.adnet.face.d
    public void a(VAdError vAdError) throws VAdError {
        this.f5496b++;
        int i = this.f5495a;
        this.f5495a = i + ((int) (i * this.f5498d));
        if (!c()) {
            throw vAdError;
        }
    }
}
