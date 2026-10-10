package com.sandboxol.file.e;

import android.content.Context;

/* JADX INFO: compiled from: UnzipHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends com.sandboxol.file.a.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f17608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.sandboxol.file.b.b f17609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f17610e;

    public i(com.sandboxol.file.b.b bVar) {
        this.f17609d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (b() != null) {
            b().d();
        }
    }

    @Override // com.sandboxol.file.a.b
    public void d() {
        a(this.f17609d);
    }

    @Override // com.sandboxol.file.a.b
    public void e() {
        if (this.f17610e != null) {
            a(3);
            this.f17610e.b();
        }
        if (b() != null) {
            b().e();
        }
    }

    private void a(com.sandboxol.file.b.b bVar) {
        if (bVar.e() != 1) {
            return;
        }
        this.f17610e = new g();
        this.f17610e.a(bVar, new h(this, bVar));
    }

    public i(Context context, com.sandboxol.file.b.b bVar) {
        this.f17608c = context;
        this.f17609d = bVar;
    }
}
