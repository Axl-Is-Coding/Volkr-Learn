package com.disabngo.blockynexus.view.dialog;

import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: UploadNewGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class db implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UploadNewGameDialog f11542a;

    db(UploadNewGameDialog uploadNewGameDialog) {
        this.f11542a = uploadNewGameDialog;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f11542a.a(th);
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        this.f11542a.l();
    }
}
