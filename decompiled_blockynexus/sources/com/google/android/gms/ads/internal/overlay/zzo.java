package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzwm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzo extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzdpu;
    private final zzw zzdpv;

    public zzo(Context context, zzr zzrVar, zzw zzwVar) {
        super(context);
        this.zzdpv = zzwVar;
        setOnClickListener(this);
        this.zzdpu = new ImageButton(context);
        this.zzdpu.setImageResource(R.drawable.btn_dialog);
        this.zzdpu.setBackgroundColor(0);
        this.zzdpu.setOnClickListener(this);
        ImageButton imageButton = this.zzdpu;
        zzwm.zzpt();
        int iZzc = zzbbg.zzc(context, zzrVar.paddingLeft);
        zzwm.zzpt();
        int iZzc2 = zzbbg.zzc(context, 0);
        zzwm.zzpt();
        int iZzc3 = zzbbg.zzc(context, zzrVar.paddingRight);
        zzwm.zzpt();
        imageButton.setPadding(iZzc, iZzc2, iZzc3, zzbbg.zzc(context, zzrVar.paddingBottom));
        this.zzdpu.setContentDescription("Interstitial close button");
        ImageButton imageButton2 = this.zzdpu;
        zzwm.zzpt();
        int iZzc4 = zzbbg.zzc(context, zzrVar.size + zzrVar.paddingLeft + zzrVar.paddingRight);
        zzwm.zzpt();
        addView(imageButton2, new FrameLayout.LayoutParams(iZzc4, zzbbg.zzc(context, zzrVar.size + zzrVar.paddingBottom), 17));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzw zzwVar = this.zzdpv;
        if (zzwVar != null) {
            zzwVar.zzus();
        }
    }

    public final void zzal(boolean z) {
        if (z) {
            this.zzdpu.setVisibility(8);
        } else {
            this.zzdpu.setVisibility(0);
        }
    }
}
