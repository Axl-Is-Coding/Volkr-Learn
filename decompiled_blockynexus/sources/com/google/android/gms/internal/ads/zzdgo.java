package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgo implements zzdgx<zzdgu<Bundle>> {
    private final Context zzaai;
    private final zzdzb zzgcz;

    zzdgo(zzdzb zzdzbVar, Context context) {
        this.zzgcz = zzdzbVar;
        this.zzaai = context;
    }

    public static Bundle zza(Context context, JSONArray jSONArray) {
        Object obj;
        SharedPreferences sharedPreferences;
        String str;
        Bundle bundle = new Bundle();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            String strOptString = jSONObjectOptJSONObject.optString("bk");
            String strOptString2 = jSONObjectOptJSONObject.optString("sk");
            int iOptInt = jSONObjectOptJSONObject.optInt("type", -1);
            int i2 = iOptInt != 0 ? iOptInt != 1 ? iOptInt != 2 ? 0 : zzdgs.zzgyc : zzdgs.zzgyb : zzdgs.zzgya;
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && i2 != 0) {
                String[] strArrSplit = strOptString2.split("/");
                if (strArrSplit.length > 2 || strArrSplit.length == 0) {
                    obj = null;
                } else {
                    if (strArrSplit.length == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str = strArrSplit[0];
                    } else {
                        sharedPreferences = context.getSharedPreferences(strArrSplit[0], 0);
                        str = strArrSplit[1];
                    }
                    obj = sharedPreferences.getAll().get(str);
                }
                if (obj != null) {
                    int i3 = zzdgt.zzgye[i2 - 1];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3 && (obj instanceof Boolean)) {
                                bundle.putBoolean(strOptString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(strOptString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(strOptString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(strOptString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(strOptString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdgu<Bundle>> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdgr
            private final zzdgo zzgxz;

            {
                this.zzgxz = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgxz.zzarz();
            }
        });
    }

    final /* synthetic */ zzdgu zzarz() throws Exception {
        String str = (String) zzwm.zzpx().zzd(zzabb.zzcwg);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            final Bundle bundleZza = zza(this.zzaai, new JSONArray(str));
            return new zzdgu(bundleZza) { // from class: com.google.android.gms.internal.ads.zzdgq
                private final Bundle zzgxy;

                {
                    this.zzgxy = bundleZza;
                }

                @Override // com.google.android.gms.internal.ads.zzdgu
                public final void zzs(Object obj) {
                    ((Bundle) obj).putBundle("shared_pref", this.zzgxy);
                }
            };
        } catch (JSONException e2) {
            zzbbq.zzb("JSON parsing error", e2);
            return null;
        }
    }
}
