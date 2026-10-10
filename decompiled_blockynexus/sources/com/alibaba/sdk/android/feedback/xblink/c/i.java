package com.alibaba.sdk.android.feedback.xblink.c;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3799a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f3800b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f3801c = null;

    public int a() {
        return this.f3799a;
    }

    public void a(int i) {
        this.f3799a = i;
    }

    public void a(String str, String str2) {
        this.f3800b.put(str, str2);
    }

    public void a(byte[] bArr) {
        this.f3801c = bArr;
    }

    public Map b() {
        return this.f3800b;
    }

    public byte[] c() {
        return this.f3801c;
    }
}
