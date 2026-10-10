package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagx {
    public static final zzahq<zzbgj> zzder = zzaha.zzdfl;
    public static final zzahq<zzbgj> zzdes = zzagz.zzdfl;
    public static final zzahq<zzbgj> zzdet = zzahc.zzdfl;
    public static final zzahq<zzbgj> zzdeu = zzahb.zzdfl;
    public static final zzahq<zzbgj> zzdev = new zzahg();
    public static final zzahq<zzbgj> zzdew = new zzahi();
    public static final zzahq<zzbgj> zzdex = zzahe.zzdfl;
    public static final zzahq<Object> zzdey = new zzahh();
    public static final zzahq<zzbgj> zzdez = new zzahk();
    public static final zzahq<zzbgj> zzdfa = zzahd.zzdfl;
    public static final zzahq<zzbgj> zzdfb = new zzahj();
    public static final zzahq<zzbgj> zzdfc = new zzahm();
    public static final zzahq<zzbdu> zzdfd = new zzbfe();
    public static final zzahq<zzbdu> zzdfe = new zzbfh();
    public static final zzahq<zzbgj> zzdff = new zzagy();
    public static final zzahw zzdfg = new zzahw();
    public static final zzahq<zzbgj> zzdfh = new zzahl();
    public static final zzahq<zzbgj> zzdfi = new zzaho();
    public static final zzahq<zzbgj> zzdfj = new zzahn();
    public static final zzahq<zzbgj> zzdfk = new zzahf();

    static final /* synthetic */ void zza(zzbhq zzbhqVar, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int i = Integer.parseInt(str);
            int i2 = Integer.parseInt(str2);
            int i3 = Integer.parseInt(str3);
            zzeg zzegVarZzabz = zzbhqVar.zzabz();
            if (zzegVarZzabz != null) {
                zzegVarZzabz.zzca().zza(i, i2, i3);
            }
        } catch (NumberFormatException unused) {
            zzbbq.zzfe("Could not parse touch parameters from gmsg.");
        }
    }

    static final /* synthetic */ void zzb(zzbhi zzbhiVar, Map map) {
        PackageManager packageManager = zzbhiVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String strOptString = jSONObject2.optString("id");
                        String strOptString2 = jSONObject2.optString("u");
                        String strOptString3 = jSONObject2.optString(au.ay);
                        String strOptString4 = jSONObject2.optString("m");
                        String strOptString5 = jSONObject2.optString(au.aw);
                        String strOptString6 = jSONObject2.optString("c");
                        String strOptString7 = jSONObject2.optString("intent_url");
                        Intent uri = null;
                        if (!TextUtils.isEmpty(strOptString7)) {
                            try {
                                uri = Intent.parseUri(strOptString7, 0);
                            } catch (URISyntaxException e2) {
                                String strValueOf = String.valueOf(strOptString7);
                                zzbbq.zzc(strValueOf.length() != 0 ? "Error parsing the url: ".concat(strValueOf) : new String("Error parsing the url: "), e2);
                            }
                        }
                        if (uri == null) {
                            uri = new Intent();
                            if (!TextUtils.isEmpty(strOptString2)) {
                                uri.setData(Uri.parse(strOptString2));
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                uri.setAction(strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                uri.setType(strOptString4);
                            }
                            if (!TextUtils.isEmpty(strOptString5)) {
                                uri.setPackage(strOptString5);
                            }
                            if (!TextUtils.isEmpty(strOptString6)) {
                                String[] strArrSplit = strOptString6.split("/", 2);
                                if (strArrSplit.length == 2) {
                                    uri.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                }
                            }
                        }
                        try {
                            jSONObject.put(strOptString, packageManager.resolveActivity(uri, 65536) != null);
                        } catch (JSONException e3) {
                            zzbbq.zzc("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        zzbbq.zzc("Error parsing the intent data.", e4);
                    }
                }
                ((zzajr) zzbhiVar).zza("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzajr) zzbhiVar).zza("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzajr) zzbhiVar).zza("openableIntents", new JSONObject());
        }
    }

    static final /* synthetic */ void zzc(zzbhi zzbhiVar, Map map) {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcyl)).booleanValue()) {
            zzbbq.zzfe("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get(au.n);
        if (TextUtils.isEmpty(str)) {
            zzbbq.zzfe("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap map2 = new HashMap();
        map2.put(str, Boolean.valueOf(zzbhiVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null));
        ((zzajr) zzbhiVar).zza("openableApp", map2);
    }

    static final /* synthetic */ void zzd(zzbhi zzbhiVar, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzbbq.zzfe("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] strArrSplit = str.split(",");
        HashMap map2 = new HashMap();
        PackageManager packageManager = zzbhiVar.getContext().getPackageManager();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) == null) {
                z = false;
            }
            map2.put(str2, Boolean.valueOf(z));
        }
        ((zzajr) zzbhiVar).zza("openableURLs", map2);
    }

    static final /* synthetic */ void zza(zzbhi zzbhiVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzbbq.zzfe("URL missing from httpTrack GMSG.");
        } else {
            new zzbax(zzbhiVar.getContext(), ((zzbht) zzbhiVar).zzzx().zzbre, str).zzwz();
        }
    }

    static final /* synthetic */ void zza(zzbfy zzbfyVar, Map map) throws zzef {
        String str = (String) map.get("u");
        if (str == null) {
            zzbbq.zzfe("URL missing from click GMSG.");
            return;
        }
        Uri uriZza = Uri.parse(str);
        try {
            zzeg zzegVarZzabz = ((zzbhq) zzbfyVar).zzabz();
            if (zzegVarZzabz != null && zzegVarZzabz.zzb(uriZza)) {
                uriZza = zzegVarZzabz.zza(uriZza, ((zzbhi) zzbfyVar).getContext(), ((zzbhs) zzbfyVar).getView(), ((zzbhi) zzbfyVar).zzzu());
            }
        } catch (zzef unused) {
            String strValueOf = String.valueOf(str);
            zzbbq.zzfe(strValueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(strValueOf) : new String("Unable to append parameter to URL: "));
        }
        zzbhi zzbhiVar = (zzbhi) zzbfyVar;
        new zzbax(zzbhiVar.getContext(), ((zzbht) zzbfyVar).zzzx().zzbre, zzaxh.zzb(uriZza, zzbhiVar.getContext())).zzwz();
    }
}
