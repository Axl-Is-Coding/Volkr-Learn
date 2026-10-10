package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzazp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
final class zzh extends RelativeLayout {

    @VisibleForTesting
    private zzazp zzdpf;

    @VisibleForTesting
    boolean zzdpg;

    public zzh(Context context, String str, String str2) {
        super(context);
        this.zzdpf = new zzazp(context, str);
        this.zzdpf.zzae(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzdpg) {
            return false;
        }
        this.zzdpf.zzd(motionEvent);
        return false;
    }
}
