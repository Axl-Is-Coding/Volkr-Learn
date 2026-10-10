package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.common.LibStorageUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzazm {
    private boolean zzdrn = false;
    private float zzdrh = 1.0f;

    public static float zzbi(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(LibStorageUtils.AUDIO);
        if (audioManager == null) {
            return WheelView.DividerConfig.FILL;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        return streamMaxVolume == 0 ? WheelView.DividerConfig.FILL : audioManager.getStreamVolume(3) / streamMaxVolume;
    }

    private final synchronized boolean zzyb() {
        return this.zzdrh >= WheelView.DividerConfig.FILL;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.zzdrn = z;
    }

    public final synchronized void setAppVolume(float f2) {
        this.zzdrh = f2;
    }

    public final synchronized float zzqg() {
        if (!zzyb()) {
            return 1.0f;
        }
        return this.zzdrh;
    }

    public final synchronized boolean zzqh() {
        return this.zzdrn;
    }
}
