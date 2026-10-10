package com.disabngo.blockynexus.view.dialog;

import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: UploadNewGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class ab implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UploadNewGameDialog f11470a;

    ab(UploadNewGameDialog uploadNewGameDialog) {
        this.f11470a = uploadNewGameDialog;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f11470a.a(th);
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        UploadNewGameDialog uploadNewGameDialog = this.f11470a;
        uploadNewGameDialog.m = uploadNewGameDialog.j.getLatestResVersions().getCresVersion() == EngineEnv.loadCommonResVersion(BaseApplication.getContext(), this.f11470a.j.getIsNewEngine(), this.f11470a.j.getIsUgc());
        UploadNewGameDialog uploadNewGameDialog2 = this.f11470a;
        if (uploadNewGameDialog2.m && uploadNewGameDialog2.o) {
            uploadNewGameDialog2.l();
        }
    }
}
