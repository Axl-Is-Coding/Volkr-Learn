package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.umeng.analytics.pro.au;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdi implements zzceq {
    private final zzbbx zzbpe;
    private final Clock zzbqa;
    private final zzeg zzeom;
    private final zzdnv zzeot;
    private final zzdst zzfnf;
    private final zzcep zzfqc;
    private final zzdok zzfsk;
    private final JSONObject zzfxs;
    private final zzcil zzfxt;
    private final zzcei zzfxu;
    private final zzbuu zzfxv;
    private final zzbuc zzfxw;
    private final zzbmu zzfxx;
    private final zzcfh zzfxy;
    private final zzcae zzfxz;
    private boolean zzfyb;
    private zzxz zzfyi;
    private final Context zzvr;
    private boolean zzfya = false;
    private boolean zzfyc = false;
    private boolean zzfyd = false;
    private Point zzfye = new Point();
    private Point zzfyf = new Point();
    private long zzfyg = 0;
    private long zzfyh = 0;

    public zzcdi(Context context, zzcep zzcepVar, JSONObject jSONObject, zzcil zzcilVar, zzcei zzceiVar, zzeg zzegVar, zzbuu zzbuuVar, zzbuc zzbucVar, zzdnv zzdnvVar, zzbbx zzbbxVar, zzdok zzdokVar, zzbmu zzbmuVar, zzcfh zzcfhVar, Clock clock, zzcae zzcaeVar, zzdst zzdstVar) {
        this.zzvr = context;
        this.zzfqc = zzcepVar;
        this.zzfxs = jSONObject;
        this.zzfxt = zzcilVar;
        this.zzfxu = zzceiVar;
        this.zzeom = zzegVar;
        this.zzfxv = zzbuuVar;
        this.zzfxw = zzbucVar;
        this.zzeot = zzdnvVar;
        this.zzbpe = zzbbxVar;
        this.zzfsk = zzdokVar;
        this.zzfxx = zzbmuVar;
        this.zzfxy = zzcfhVar;
        this.zzbqa = clock;
        this.zzfxz = zzcaeVar;
        this.zzfnf = zzdstVar;
    }

    private final boolean zzalo() {
        return this.zzfxs.optBoolean("allow_custom_click_gesture", false);
    }

    private final String zzb(View view, Map<String, WeakReference<View>> map) {
        if (map != null && view != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                if (view.equals(entry.getValue().get())) {
                    return entry.getKey();
                }
            }
        }
        int iZzama = this.zzfxu.zzama();
        if (iZzama == 1) {
            return "1099";
        }
        if (iZzama == 2) {
            return "2099";
        }
        if (iZzama == 3 || iZzama != 6) {
            return null;
        }
        return "3099";
    }

    private final boolean zzfy(String str) {
        JSONObject jSONObjectOptJSONObject = this.zzfxs.optJSONObject("allow_pub_event_reporting");
        return jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean(str, false);
    }

    private final String zzx(View view) {
        try {
            JSONObject jSONObjectOptJSONObject = this.zzfxs.optJSONObject("tracking_urls_and_actions");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            return this.zzeom.zzca().zza(this.zzvr, jSONObjectOptJSONObject.optString("click_string"), view);
        } catch (Exception e2) {
            zzbbq.zzc("Exception obtaining click signals", e2);
            return null;
        }
    }

    private final String zzy(View view) {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcro)).booleanValue()) {
            return null;
        }
        try {
            return this.zzeom.zzca().zza(this.zzvr, view, (Activity) null);
        } catch (Exception unused) {
            zzbbq.zzfc("Exception getting data.");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void cancelUnconfirmedClick() {
        if (this.zzfxs.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzfxy.cancelUnconfirmedClick();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void destroy() {
        this.zzfxt.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final boolean isCustomClickGestureEnabled() {
        return zzalo();
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void setClickConfirmingView(View view) {
        if (!this.zzfxs.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzbbq.zzfe("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzcfh zzcfhVar = this.zzfxy;
        if (view != null) {
            view.setOnClickListener(zzcfhVar);
            view.setClickable(true);
            zzcfhVar.zzgbt = new WeakReference<>(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzfye = new Point();
        this.zzfyf = new Point();
        if (!this.zzfyb) {
            this.zzfxz.zzv(view);
            this.zzfyb = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzfxx.zzo(this);
        boolean zZzdi = zzbau.zzdi(this.zzbpe.zzeem);
        if (map != null) {
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                View view2 = it.next().getValue().get();
                if (view2 != null) {
                    if (zZzdi) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            Iterator<Map.Entry<String, WeakReference<View>>> it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                View view3 = it2.next().getValue().get();
                if (view3 != null) {
                    if (zZzdi) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzalp() {
        zza(null, null, null, null, null, null, false);
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzalq() {
        try {
            if (this.zzfyi != null) {
                this.zzfyi.onAdMuted();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzalr() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(au.av, this.zzfxs);
            zzbcc.zza(this.zzfxt.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzfz(String str) {
        zza(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzg(Bundle bundle) {
        if (bundle == null) {
            zzbbq.zzef("Click data is null. No click is reported.");
        } else if (!zzfy("click_reporting")) {
            zzbbq.zzfc("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zza(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, com.google.android.gms.ads.internal.zzp.zzkr().zza(bundle, (JSONObject) null), false, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzh(Bundle bundle) {
        if (bundle == null) {
            zzbbq.zzef("Touch event data is null. No touch event is reported.");
            return;
        }
        if (!zzfy("touch_reporting")) {
            zzbbq.zzfc("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
            return;
        }
        this.zzeom.zzca().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final boolean zzi(Bundle bundle) {
        if (zzfy("impression_reporting")) {
            return zza(null, null, null, null, null, com.google.android.gms.ads.internal.zzp.zzkr().zza(bundle, (JSONObject) null), false);
        }
        zzbbq.zzfc("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzsv() {
        this.zzfyd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        zza(zzbau.zza(this.zzvr, view), zzbau.zza(this.zzvr, map, map2, view), zzbau.zzt(view), zzbau.zzb(this.zzvr, view), zzy(view), null, zzbau.zza(this.zzeot));
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        this.zzfye = new Point();
        this.zzfyf = new Point();
        this.zzfxz.zzw(view);
        this.zzfyb = false;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        JSONObject jSONObjectZza = zzbau.zza(this.zzvr, map, map2, view2);
        JSONObject jSONObjectZza2 = zzbau.zza(this.zzvr, view2);
        JSONObject jSONObjectZzt = zzbau.zzt(view2);
        JSONObject jSONObjectZzb = zzbau.zzb(this.zzvr, view2);
        String strZzb = zzb(view, map);
        zza(((Boolean) zzwm.zzpx().zzd(zzabb.zzcrp)).booleanValue() ? view2 : view, jSONObjectZza2, jSONObjectZza, jSONObjectZzt, jSONObjectZzb, strZzb, zzbau.zza(strZzb, this.zzvr, this.zzfyf, this.zzfye), null, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfyd) {
            zzbbq.zzef("Custom click reporting failed. enableCustomClickGesture is not set.");
            return;
        }
        if (!zzalo()) {
            zzbbq.zzef("Custom click reporting failed. Ad unit id not whitelisted.");
            return;
        }
        JSONObject jSONObjectZza = zzbau.zza(this.zzvr, map, map2, view);
        JSONObject jSONObjectZza2 = zzbau.zza(this.zzvr, view);
        JSONObject jSONObjectZzt = zzbau.zzt(view);
        JSONObject jSONObjectZzb = zzbau.zzb(this.zzvr, view);
        String strZzb = zzb(null, map);
        zza(view, jSONObjectZza2, jSONObjectZza, jSONObjectZzt, jSONObjectZzb, strZzb, zzbau.zza(strZzb, this.zzvr, this.zzfyf, this.zzfye), null, z, true);
    }

    private final void zza(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put(au.av, this.zzfxs);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            jSONObject7.put("has_custom_click_handler", this.zzfqc.zzge(this.zzfxu.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put(MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE, this.zzfxu.zzama());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.zzfsk.zzdly != null && this.zzfsk.zzdly.zzbns);
            jSONObject8.put("custom_mute_enabled", (this.zzfxu.getMuteThisAdReasons().isEmpty() || this.zzfxu.zzamd() == null) ? false : true);
            if (this.zzfxy.zzanj() != null && this.zzfxs.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzbqa.currentTimeMillis());
            if (this.zzfyd && zzalo()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            jSONObject8.put("has_custom_click_handler", this.zzfqc.zzge(this.zzfxu.getCustomTemplateId()) != null);
            jSONObject8.put("click_signals", zzx(view));
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long jCurrentTimeMillis = this.zzbqa.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", jCurrentTimeMillis - this.zzfyg);
            jSONObject9.put("time_from_last_touch", jCurrentTimeMillis - this.zzfyh);
            jSONObject7.put("touch_signal", jSONObject9);
            zzbcc.zza(this.zzfxt.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e2) {
            zzbbq.zzc("Unable to create click JSON.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzfye = zzbau.zza(motionEvent, view2);
        long jCurrentTimeMillis = this.zzbqa.currentTimeMillis();
        this.zzfyh = jCurrentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzfyg = jCurrentTimeMillis;
            this.zzfyf = this.zzfye;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        Point point = this.zzfye;
        motionEventObtain.setLocation(point.x, point.y);
        this.zzeom.zza(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        JSONObject jSONObjectZza = zzbau.zza(this.zzvr, map, map2, view);
        JSONObject jSONObjectZza2 = zzbau.zza(this.zzvr, view);
        JSONObject jSONObjectZzt = zzbau.zzt(view);
        JSONObject jSONObjectZzb = zzbau.zzb(this.zzvr, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", jSONObjectZza);
            jSONObject.put("ad_view_signal", jSONObjectZza2);
            jSONObject.put("scroll_view_signal", jSONObjectZzt);
            jSONObject.put("lock_screen_signal", jSONObjectZzb);
            return jSONObject;
        } catch (JSONException e2) {
            zzbbq.zzc("Unable to create native ad view signals JSON.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(zzafz zzafzVar) {
        if (!this.zzfxs.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzbbq.zzfe("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzfxy.zza(zzafzVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(zzyd zzydVar) {
        try {
            if (this.zzfyc) {
                return;
            }
            if (zzydVar == null && this.zzfxu.zzamd() != null) {
                this.zzfyc = true;
                this.zzfnf.zzes(this.zzfxu.zzamd().zzqk());
                zzalq();
            } else {
                this.zzfyc = true;
                this.zzfnf.zzes(zzydVar.zzqk());
                zzalq();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(zzxz zzxzVar) {
        this.zzfyi = zzxzVar;
    }

    private final boolean zza(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(au.av, this.zzfxs);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcro)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            jSONObject6.put("screen", zzbau.zzbm(this.zzvr));
            zzcdh zzcdhVar = null;
            this.zzfxt.zza("/logScionEvent", new zzcdk(this));
            this.zzfxt.zza("/nativeImpression", new zzcdj(this));
            zzbcc.zza(this.zzfxt.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            boolean z2 = this.zzfya;
            if (z2 || this.zzeot.zzhdw == null) {
                return true;
            }
            this.zzfya = z2 | com.google.android.gms.ads.internal.zzp.zzlb().zzb(this.zzvr, this.zzbpe.zzbre, this.zzeot.zzhdw.toString(), this.zzfsk.zzhfb);
            return true;
        } catch (JSONException e2) {
            zzbbq.zzc("Unable to create impression JSON.", e2);
            return false;
        }
    }
}
