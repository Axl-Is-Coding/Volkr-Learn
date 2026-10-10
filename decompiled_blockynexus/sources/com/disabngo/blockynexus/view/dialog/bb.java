package com.disabngo.blockynexus.view.dialog;

import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: UploadNewGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class bb implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UploadNewGameDialog f11530a;

    bb(UploadNewGameDialog uploadNewGameDialog) {
        this.f11530a = uploadNewGameDialog;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f11530a.a(th);
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        UploadNewGameDialog uploadNewGameDialog = this.f11530a;
        uploadNewGameDialog.o = true;
        if (uploadNewGameDialog.m) {
            uploadNewGameDialog.l();
        }
    }
}
