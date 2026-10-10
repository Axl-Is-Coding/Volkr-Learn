package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaqe implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqc zzdmw;

    zzaqe(zzaqc zzaqcVar) {
        this.zzdmw = zzaqcVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdmw.zzdx("Operation denied by user.");
    }
}
