package com.disabngo.blockynexus.view.dialog;

import androidx.databinding.Observable;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: compiled from: UploadNewGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Xa extends Observable.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UploadNewGameDialog f11440a;

    Xa(UploadNewGameDialog uploadNewGameDialog) {
        this.f11440a = uploadNewGameDialog;
    }

    @Override // androidx.databinding.Observable.a
    public void onPropertyChanged(Observable observable, int i) {
        if (this.f11440a.h.f().f11422f.get().booleanValue()) {
            Messenger.getDefault().send(Integer.valueOf(this.f11440a.f11416f), MessageToken.TOKEN_DOWNLOAD_SUCCESS_ENTER_PARTY);
            this.f11440a.finish();
        }
    }
}
