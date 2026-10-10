package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
public abstract class zzbdf extends TextureView implements zzbdy {
    protected final zzbdp zzege;
    protected final zzbdz zzegf;

    public zzbdf(Context context) {
        super(context);
        this.zzege = new zzbdp();
        this.zzegf = new zzbdz(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f2, float f3);

    public abstract void zza(zzbdc zzbdcVar);

    public void zzb(String str, String[] strArr) {
        setVideoPath(str);
    }

    public void zzdl(int i) {
    }

    public void zzdm(int i) {
    }

    public void zzdn(int i) {
    }

    public void zzdo(int i) {
    }

    public void zzdp(int i) {
    }

    public abstract String zzyx();

    public abstract void zzzb();
}
