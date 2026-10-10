package com.google.protobuf;

/* JADX INFO: compiled from: LazyFieldLite.java */
/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C2306l f14383a = C2306l.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteString f14384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C2306l f14385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile x f14386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile ByteString f14387e;

    protected void a(x xVar) {
        if (this.f14386d != null) {
            return;
        }
        synchronized (this) {
            if (this.f14386d != null) {
                return;
            }
            try {
                if (this.f14384b != null) {
                    this.f14386d = xVar.getParserForType().a(this.f14384b, this.f14385c);
                    this.f14387e = this.f14384b;
                } else {
                    this.f14386d = xVar;
                    this.f14387e = ByteString.EMPTY;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f14386d = xVar;
                this.f14387e = ByteString.EMPTY;
            }
        }
    }

    public x b(x xVar) {
        a(xVar);
        return this.f14386d;
    }

    public x c(x xVar) {
        x xVar2 = this.f14386d;
        this.f14384b = null;
        this.f14387e = null;
        this.f14386d = xVar;
        return xVar2;
    }
}
