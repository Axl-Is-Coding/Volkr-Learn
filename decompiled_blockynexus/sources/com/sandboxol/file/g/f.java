package com.sandboxol.file.g;

import android.app.Activity;

/* JADX INFO: compiled from: VerifyHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends com.sandboxol.file.a.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.sandboxol.file.b.c f17623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Activity f17624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f17625e;

    public f(com.sandboxol.file.b.c cVar) {
        this.f17623c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (b() != null) {
            b().d();
        }
    }

    @Override // com.sandboxol.file.a.b
    public void d() {
        a(this.f17623c);
    }

    @Override // com.sandboxol.file.a.b
    public void e() {
        if (this.f17625e != null) {
            a(3);
            this.f17625e.b();
        }
        if (b() != null) {
            b().e();
        }
    }

    private void a(com.sandboxol.file.b.c cVar) {
        if (cVar.d() != 1) {
            return;
        }
        this.f17625e = new d();
        this.f17625e.a(cVar, new e(this, cVar));
    }

    public f(Activity activity, com.sandboxol.file.b.c cVar) {
        this.f17624d = activity;
        this.f17623c = cVar;
    }
}
