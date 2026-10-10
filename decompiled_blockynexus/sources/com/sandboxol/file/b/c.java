package com.sandboxol.file.b;

import com.sandboxol.file.d.g;
import com.sandboxol.file.entity.VerifyInfo;

/* JADX INFO: compiled from: VerifyBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends com.sandboxol.file.a.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VerifyInfo[] f17555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g f17556e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17554c = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17557f = 1;

    public c a(VerifyInfo... verifyInfoArr) {
        this.f17555d = verifyInfoArr;
        return this;
    }

    public VerifyInfo[] b() {
        return this.f17555d;
    }

    public g c() {
        return this.f17556e;
    }

    public int d() {
        return this.f17554c;
    }

    public c a(g gVar) {
        this.f17556e = gVar;
        return this;
    }
}
