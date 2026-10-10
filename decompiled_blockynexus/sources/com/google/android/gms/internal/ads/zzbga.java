package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbga implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzemm;

    zzbga(JsResult jsResult) {
        this.zzemm = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzemm.cancel();
    }
}
