package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.common.LibStorageUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
public final class zzbdz implements AudioManager.OnAudioFocusChangeListener {
    private float zzdj = 1.0f;
    private boolean zzegn;
    private final AudioManager zzejm;
    private final zzbdy zzejn;
    private boolean zzejo;
    private boolean zzejp;

    public zzbdz(Context context, zzbdy zzbdyVar) {
        this.zzejm = (AudioManager) context.getSystemService(LibStorageUtils.AUDIO);
        this.zzejn = zzbdyVar;
    }

    private final void zzaae() {
        boolean z;
        boolean z2;
        boolean z3 = this.zzegn && !this.zzejp && this.zzdj > WheelView.DividerConfig.FILL;
        if (z3 && !(z2 = this.zzejo)) {
            AudioManager audioManager = this.zzejm;
            if (audioManager != null && !z2) {
                this.zzejo = audioManager.requestAudioFocus(this, 3, 2) == 1;
            }
            this.zzejn.zzzb();
            return;
        }
        if (z3 || !(z = this.zzejo)) {
            return;
        }
        AudioManager audioManager2 = this.zzejm;
        if (audioManager2 != null && z) {
            this.zzejo = audioManager2.abandonAudioFocus(this) == 0;
        }
        this.zzejn.zzzb();
    }

    public final float getVolume() {
        return this.zzejo ? this.zzejp ? WheelView.DividerConfig.FILL : this.zzdj : WheelView.DividerConfig.FILL;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.zzejo = i > 0;
        this.zzejn.zzzb();
    }

    public final void setMuted(boolean z) {
        this.zzejp = z;
        zzaae();
    }

    public final void setVolume(float f2) {
        this.zzdj = f2;
        zzaae();
    }

    public final void zzaac() {
        this.zzegn = true;
        zzaae();
    }

    public final void zzaad() {
        this.zzegn = false;
        zzaae();
    }
}
