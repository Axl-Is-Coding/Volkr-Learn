package com.disabngo.blockynexus.view.dialog;

import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: UploadNewGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Za implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UploadNewGameDialog f11444a;

    Za(UploadNewGameDialog uploadNewGameDialog) {
        this.f11444a = uploadNewGameDialog;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f11444a.a(th);
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        UploadNewGameDialog uploadNewGameDialog = this.f11444a;
        uploadNewGameDialog.m = uploadNewGameDialog.j.getLatestResVersions().getCresVersion() == EngineEnv.loadCommonResVersion(BaseApplication.getContext(), this.f11444a.j.getIsNewEngine(), this.f11444a.j.getIsUgc());
        UploadNewGameDialog uploadNewGameDialog2 = this.f11444a;
        if (uploadNewGameDialog2.m && uploadNewGameDialog2.n) {
            uploadNewGameDialog2.l();
        }
    }
}
