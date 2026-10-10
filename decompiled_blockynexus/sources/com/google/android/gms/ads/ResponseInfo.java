package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzvr;
import com.google.android.gms.internal.ads.zzwm;
import com.google.android.gms.internal.ads.zzyn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class ResponseInfo {
    private final zzyn zzadt;
    private final List<AdapterResponseInfo> zzadu = new ArrayList();

    private ResponseInfo(zzyn zzynVar) {
        this.zzadt = zzynVar;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyp)).booleanValue()) {
            try {
                List<zzvr> adapterResponses = this.zzadt.getAdapterResponses();
                if (adapterResponses != null) {
                    Iterator<zzvr> it = adapterResponses.iterator();
                    while (it.hasNext()) {
                        this.zzadu.add(AdapterResponseInfo.zza(it.next()));
                    }
                }
            } catch (RemoteException e2) {
                zzbbq.zzc("Could not forward getAdapterResponseInfo to ResponseInfo.", e2);
            }
        }
    }

    public static ResponseInfo zza(zzyn zzynVar) {
        if (zzynVar != null) {
            return new ResponseInfo(zzynVar);
        }
        return null;
    }

    public final List<AdapterResponseInfo> getAdapterResponses() {
        return this.zzadu;
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzadt.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbbq.zzc("Could not forward getMediationAdapterClassName to ResponseInfo.", e2);
            return null;
        }
    }

    public final String getResponseId() {
        try {
            return this.zzadt.getResponseId();
        } catch (RemoteException e2) {
            zzbbq.zzc("Could not forward getResponseId to ResponseInfo.", e2);
            return null;
        }
    }

    public final String toString() {
        try {
            return zzdp().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzdp() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<AdapterResponseInfo> it = this.zzadu.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().zzdp());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        return jSONObject;
    }
}
