package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzadp;
import com.google.android.gms.internal.ads.zzadr;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public class MediaView extends FrameLayout {
    private MediaContent zzbng;
    private boolean zzbnh;
    private zzadp zzbni;
    private ImageView.ScaleType zzbnj;
    private boolean zzbnk;
    private zzadr zzbnl;

    public MediaView(Context context) {
        super(context);
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzbnk = true;
        this.zzbnj = scaleType;
        zzadr zzadrVar = this.zzbnl;
        if (zzadrVar != null) {
            zzadrVar.setImageScaleType(this.zzbnj);
        }
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zzbnh = true;
        this.zzbng = mediaContent;
        zzadp zzadpVar = this.zzbni;
        if (zzadpVar != null) {
            zzadpVar.setMediaContent(mediaContent);
        }
    }

    protected final synchronized void zza(zzadp zzadpVar) {
        this.zzbni = zzadpVar;
        if (this.zzbnh) {
            zzadpVar.setMediaContent(this.zzbng);
        }
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected final synchronized void zza(zzadr zzadrVar) {
        this.zzbnl = zzadrVar;
        if (this.zzbnk) {
            zzadrVar.setImageScaleType(this.zzbnj);
        }
    }
}
