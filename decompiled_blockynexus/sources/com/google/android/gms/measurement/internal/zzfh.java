package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.umeng.analytics.pro.au;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfh {
    private final String zza;
    private final Bundle zzb;
    private boolean zzc;
    private Bundle zzd;
    private final /* synthetic */ zzfc zze;

    public zzfh(zzfc zzfcVar, String str, Bundle bundle) {
        this.zze = zzfcVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = new Bundle();
    }

    private final String zzb(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    jSONObject.put("v", String.valueOf(obj));
                    if (obj instanceof String) {
                        jSONObject.put(au.az, au.ax);
                    } else if (obj instanceof Long) {
                        jSONObject.put(au.az, "l");
                    } else if (obj instanceof Double) {
                        jSONObject.put(au.az, au.au);
                    } else {
                        this.zze.zzq().zze().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    this.zze.zzq().zze().zza("Cannot serialize bundle value to SharedPreferences", e2);
                }
            }
        }
        return jSONArray.toString();
    }

    public final Bundle zza() {
        if (!this.zzc) {
            this.zzc = true;
            String string = this.zze.zzf().getString(this.zza, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString(au.az);
                            byte b2 = -1;
                            int iHashCode = string3.hashCode();
                            if (iHashCode != 100) {
                                if (iHashCode != 108) {
                                    if (iHashCode == 115 && string3.equals(au.ax)) {
                                        b2 = 0;
                                    }
                                } else if (string3.equals("l")) {
                                    b2 = 2;
                                }
                            } else if (string3.equals(au.au)) {
                                b2 = 1;
                            }
                            if (b2 == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (b2 == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (b2 != 2) {
                                this.zze.zzq().zze().zza("Unrecognized persisted bundle type. Type", string3);
                            } else {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.zze.zzq().zze().zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.zzd = bundle;
                } catch (JSONException unused2) {
                    this.zze.zzq().zze().zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.zzd == null) {
                this.zzd = this.zzb;
            }
        }
        return this.zzd;
    }

    public final void zza(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor editorEdit = this.zze.zzf().edit();
        if (bundle.size() == 0) {
            editorEdit.remove(this.zza);
        } else {
            editorEdit.putString(this.zza, zzb(bundle));
        }
        editorEdit.apply();
        this.zzd = bundle;
    }
}
