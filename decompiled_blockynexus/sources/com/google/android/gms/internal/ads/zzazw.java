package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzazw implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzazx zzeca;

    zzazw(zzazx zzazxVar) {
        this.zzeca = zzazxVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzayu.zza(this.zzeca.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
