package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqe extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private View zzaat;
    private final Context zzvr;

    private zzbqe(Context context) {
        super(context);
        this.zzvr = context;
    }

    public static zzbqe zza(Context context, View view, zzdnv zzdnvVar) {
        zzbqe zzbqeVar = new zzbqe(context);
        zzbqeVar.zzaat = view;
        zzbqeVar.addView(view);
        com.google.android.gms.ads.internal.zzp.zzlo();
        zzbco.zza((View) zzbqeVar, (ViewTreeObserver.OnScrollChangedListener) zzbqeVar);
        com.google.android.gms.ads.internal.zzp.zzlo();
        zzbco.zza((View) zzbqeVar, (ViewTreeObserver.OnGlobalLayoutListener) zzbqeVar);
        JSONObject jSONObject = zzdnvVar.zzhej;
        if (jSONObject != null) {
            RelativeLayout relativeLayout = new RelativeLayout(zzbqeVar.zzvr);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
            if (jSONObjectOptJSONObject != null) {
                zzbqeVar.zza(jSONObjectOptJSONObject, relativeLayout, 10);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("footer");
            if (jSONObjectOptJSONObject2 != null) {
                zzbqeVar.zza(jSONObjectOptJSONObject2, relativeLayout, 12);
            }
            zzbqeVar.addView(relativeLayout);
        }
        return zzbqeVar;
    }

    private final int zzb(double d2) {
        zzwm.zzpt();
        return zzbbg.zzc(this.zzvr, (int) d2);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        getLocationInWindow(new int[2]);
        this.zzaat.setY(-r0[1]);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        getLocationInWindow(new int[2]);
        this.zzaat.setY(-r0[1]);
    }

    private final void zza(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zzvr);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString(ViewHierarchyConstants.TEXT_KEY, ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int iZzb = zzb(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, iZzb, 0, iZzb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }
}
