package com.tencent.tp;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes5.dex */
class o implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f19715a;

    o(n nVar) {
        this.f19715a = nVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f19715a.f19714f != null) {
            this.f19715a.f19714f.a(0);
        }
    }
}
