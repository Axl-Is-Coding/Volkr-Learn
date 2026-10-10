package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(18)
public class zzazh extends zzaze {
    @Override // com.google.android.gms.internal.ads.zzazd
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final int zzxw() {
        return 14;
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final long zzya() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcrq)).booleanValue()) {
            return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
        }
        return -1L;
    }
}
