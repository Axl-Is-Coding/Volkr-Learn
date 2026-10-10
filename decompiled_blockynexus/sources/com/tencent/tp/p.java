package com.tencent.tp;

import android.content.DialogInterface;
import android.widget.Button;

/* JADX INFO: loaded from: classes5.dex */
class p implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f19716a;

    p(n nVar) {
        this.f19716a = nVar;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        Button button = this.f19716a.f19709a.getButton(-3);
        if (button != null) {
            button.setTextSize(2, 18.0f);
        }
    }
}
