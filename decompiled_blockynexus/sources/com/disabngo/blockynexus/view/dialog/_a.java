package com.disabngo.blockynexus.view.dialog;

import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: UploadNewGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class _a implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UploadNewGameDialog f11445a;

    _a(UploadNewGameDialog uploadNewGameDialog) {
        this.f11445a = uploadNewGameDialog;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f11445a.a(th);
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        boolean z = this.f11445a.j.getLatestResVersions().getGresVersion() == SharedUtils.getLong(this.f11445a, SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION);
        UploadNewGameDialog uploadNewGameDialog = this.f11445a;
        if (uploadNewGameDialog.m && z) {
            uploadNewGameDialog.l();
        }
    }
}
