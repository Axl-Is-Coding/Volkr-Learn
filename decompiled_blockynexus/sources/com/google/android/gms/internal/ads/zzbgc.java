package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgc implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzemm;

    zzbgc(JsResult jsResult) {
        this.zzemm = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzemm.confirm();
    }
}
