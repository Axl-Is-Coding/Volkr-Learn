package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: GameDetailEnterGameLogic.java */
/* JADX INFO: loaded from: classes3.dex */
class G implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ M f17911a;

    G(M m) {
        this.f17911a = m;
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void error(Throwable th) {
        com.sandboxol.file.d.d.a(this, th);
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        this.f17911a.c();
    }
}
