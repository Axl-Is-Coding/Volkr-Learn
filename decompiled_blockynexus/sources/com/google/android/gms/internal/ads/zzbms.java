package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbms implements zzaly<zzbmw> {
    private final PowerManager zzaaj;
    private final zzqo zzfnw;
    private final Context zzvr;

    public zzbms(Context context, zzqo zzqoVar) {
        this.zzvr = context;
        this.zzfnw = zzqoVar;
        this.zzaaj = (PowerManager) context.getSystemService("power");
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final JSONObject zzj(zzbmw zzbmwVar) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzqr zzqrVar = zzbmwVar.zzfoo;
        if (zzqrVar == null) {
            jSONObject = new JSONObject();
        } else {
            if (this.zzfnw.zzlv() == null) {
                throw new JSONException("Active view Info cannot be null.");
            }
            boolean z = zzqrVar.zzbrs;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObjectPut = jSONObject3.put("afmaVersion", this.zzfnw.zzlu()).put("activeViewJSON", this.zzfnw.zzlv()).put("timestamp", zzbmwVar.timestamp).put("adFormat", this.zzfnw.zzlt()).put("hashCode", this.zzfnw.getUniqueId());
            zzqo zzqoVar = this.zzfnw;
            jSONObjectPut.put("isMraid", false).put("isStopped", false).put("isPaused", zzbmwVar.zzfol).put("isNative", this.zzfnw.isNative()).put("isScreenOn", Build.VERSION.SDK_INT >= 20 ? this.zzaaj.isInteractive() : this.zzaaj.isScreenOn()).put("appMuted", com.google.android.gms.ads.internal.zzp.zzkw().zzqh()).put("appVolume", com.google.android.gms.ads.internal.zzp.zzkw().zzqg()).put("deviceVolume", zzazm.zzbi(this.zzvr.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zzvr.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzqrVar.zzaaq).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzqrVar.zzbrt.top).put("bottom", zzqrVar.zzbrt.bottom).put("left", zzqrVar.zzbrt.left).put("right", zzqrVar.zzbrt.right)).put("adBox", new JSONObject().put("top", zzqrVar.zzbru.top).put("bottom", zzqrVar.zzbru.bottom).put("left", zzqrVar.zzbru.left).put("right", zzqrVar.zzbru.right)).put("globalVisibleBox", new JSONObject().put("top", zzqrVar.zzbrv.top).put("bottom", zzqrVar.zzbrv.bottom).put("left", zzqrVar.zzbrv.left).put("right", zzqrVar.zzbrv.right)).put("globalVisibleBoxVisible", zzqrVar.zzbrw).put("localVisibleBox", new JSONObject().put("top", zzqrVar.zzbrx.top).put("bottom", zzqrVar.zzbrx.bottom).put("left", zzqrVar.zzbrx.left).put("right", zzqrVar.zzbrx.right)).put("localVisibleBoxVisible", zzqrVar.zzbry).put("hitBox", new JSONObject().put("top", zzqrVar.zzbrz.top).put("bottom", zzqrVar.zzbrz.bottom).put("left", zzqrVar.zzbrz.left).put("right", zzqrVar.zzbrz.right)).put("screenDensity", this.zzvr.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbmwVar.zzbro);
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcpx)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzqrVar.zzbsb;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbmwVar.zzfon)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
