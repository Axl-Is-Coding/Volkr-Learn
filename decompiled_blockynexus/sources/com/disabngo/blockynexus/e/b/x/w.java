package com.disabngo.blockynexus.e.b.x;

import android.text.TextUtils;
import android.widget.EditText;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;

/* JADX INFO: compiled from: FriendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class w implements EditTextDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0934B f10318a;

    w(C0934B c0934b) {
        this.f10318a = c0934b;
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(EditText editText) {
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f10318a.k();
        } else {
            this.f10318a.a(str);
        }
    }
}
