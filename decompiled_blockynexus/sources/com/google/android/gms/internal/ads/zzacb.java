package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzacb {
    private MotionEvent zzczr = MotionEvent.obtain(0, 0, 1, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
    private MotionEvent zzczs = MotionEvent.obtain(0, 0, 0, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);

    public final void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zzczr.getEventTime()) {
            this.zzczr = MotionEvent.obtain(motionEvent);
        } else {
            if (motionEvent.getAction() != 0 || motionEvent.getEventTime() <= this.zzczs.getEventTime()) {
                return;
            }
            this.zzczs = MotionEvent.obtain(motionEvent);
        }
    }

    public final MotionEvent zzrv() {
        return this.zzczr;
    }

    public final MotionEvent zzrw() {
        return this.zzczs;
    }
}
