package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbge implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzemn;

    zzbge(JsPromptResult jsPromptResult) {
        this.zzemn = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzemn.cancel();
    }
}
