package com.google.zxing.a.a;

/* JADX INFO: compiled from: Token.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final h f14414a = new f(null, 0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f14415b;

    h(h hVar) {
        this.f14415b = hVar;
    }

    final h a() {
        return this.f14415b;
    }

    abstract void a(com.google.zxing.common.a aVar, byte[] bArr);

    final h b(int i, int i2) {
        return new b(this, i, i2);
    }

    final h a(int i, int i2) {
        return new f(this, i, i2);
    }
}
