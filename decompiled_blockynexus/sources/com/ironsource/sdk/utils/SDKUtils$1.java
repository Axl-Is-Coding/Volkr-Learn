package com.ironsource.sdk.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
final class SDKUtils$1 implements DialogInterface.OnClickListener {
    SDKUtils$1() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
