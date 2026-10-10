package com.google.android.gms.internal.ads;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzaqn {
    private final zzbgj zzdgy;
    private final String zzdoa;

    public zzaqn(zzbgj zzbgjVar) {
        this(zzbgjVar, "");
    }

    public final void zza(int i, int i2, int i3, int i4) {
        try {
            this.zzdgy.zza("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4));
        } catch (JSONException e2) {
            zzbbq.zzc("Error occurred while dispatching size change.", e2);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzdgy.zza("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4));
        } catch (JSONException e2) {
            zzbbq.zzc("Error occurred while dispatching default position.", e2);
        }
    }

    public final void zzdx(String str) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("message", str).put("action", this.zzdoa);
            if (this.zzdgy != null) {
                this.zzdgy.zza("onError", jSONObjectPut);
            }
        } catch (JSONException e2) {
            zzbbq.zzc("Error occurred while dispatching error event.", e2);
        }
    }

    public final void zzdy(String str) {
        try {
            this.zzdgy.zza("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e2) {
            zzbbq.zzc("Error occurred while dispatching ready Event.", e2);
        }
    }

    public final void zzdz(String str) {
        try {
            this.zzdgy.zza("onStateChanged", new JSONObject().put(ServerProtocol.DIALOG_PARAM_STATE, str));
        } catch (JSONException e2) {
            zzbbq.zzc("Error occurred while dispatching state change.", e2);
        }
    }

    public zzaqn(zzbgj zzbgjVar, String str) {
        this.zzdgy = zzbgjVar;
        this.zzdoa = str;
    }

    public final void zza(int i, int i2, int i3, int i4, float f2, int i5) {
        try {
            this.zzdgy.zza("onScreenInfoChanged", new JSONObject().put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f2).put("rotation", i5));
        } catch (JSONException e2) {
            zzbbq.zzc("Error occurred while obtaining screen information.", e2);
        }
    }
}
