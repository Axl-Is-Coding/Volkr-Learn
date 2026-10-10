package com.disabngo.blockynexus.view.dialog;

import com.disabngo.blockynexus.R;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: UploadNewGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class cb implements com.sandboxol.file.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UploadNewGameDialog f11536a;

    cb(UploadNewGameDialog uploadNewGameDialog) {
        this.f11536a = uploadNewGameDialog;
    }

    @Override // com.sandboxol.file.d.c
    public void onComplete(Progress progress) {
        this.f11536a.h.f().f11420d.set(this.f11536a.getString(R.string.unzipping));
    }

    @Override // com.sandboxol.file.d.c
    public void onError(Throwable th) {
        this.f11536a.h.f().f11419c.set(this.f11536a.getString(R.string.update_so_failed_text));
    }

    @Override // com.sandboxol.file.d.c
    public /* synthetic */ void onNext(Progress progress) {
        com.sandboxol.file.d.b.b(this, progress);
    }

    @Override // com.sandboxol.file.d.c
    public /* synthetic */ void onSubscribe(Throwable th) {
        com.sandboxol.file.d.b.a(this, th);
    }
}
