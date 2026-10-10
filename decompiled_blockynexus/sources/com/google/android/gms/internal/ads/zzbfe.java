package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbfe implements zzahq<zzbdu> {
    private boolean zzeli;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzwm.zzpt();
            return zzbbg.zzc(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzbbq.zzfe(sb.toString());
            return i;
        }
    }

    private static void zza(zzbdh zzbdhVar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbdhVar.zzdl(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzbbq.zzfe(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzbdhVar.zzdm(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbdhVar.zzdn(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbdhVar.zzdo(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbdhVar.zzdp(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbdu zzbduVar, Map map) {
        int i;
        zzbdu zzbduVar2 = zzbduVar;
        String str = (String) map.get("action");
        if (str == null) {
            zzbbq.zzfe("Action missing from video GMSG.");
            return;
        }
        if (zzbbq.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String string = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(string).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(string);
            zzbbq.zzef(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzbbq.zzfe("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbduVar2.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                zzbbq.zzfe("Invalid color parameter in video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                zzbbq.zzfe("No MIME types specified for decoder properties inspection.");
                zzbdh.zza(zzbduVar2, "missingMimeTypes");
                return;
            }
            HashMap map2 = new HashMap();
            for (String str4 : str3.split(",")) {
                map2.put(str4, zzbbe.zzew(str4.trim()));
            }
            zzbdh.zza(zzbduVar2, map2);
            return;
        }
        zzbdn zzbdnVarZzzr = zzbduVar2.zzzr();
        if (zzbdnVarZzzr == null) {
            zzbbq.zzfe("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean zEquals = "new".equals(str);
        boolean zEquals2 = "position".equals(str);
        if (!zEquals && !zEquals2) {
            zzbhd zzbhdVarZzzs = zzbduVar2.zzzs();
            if (zzbhdVarZzzs != null) {
                if ("timeupdate".equals(str)) {
                    String str5 = (String) map.get("currentTime");
                    if (str5 == null) {
                        zzbbq.zzfe("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        zzbhdVarZzzs.zze(Float.parseFloat(str5));
                        return;
                    } catch (NumberFormatException unused2) {
                        String strValueOf = String.valueOf(str5);
                        zzbbq.zzfe(strValueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(strValueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                        return;
                    }
                }
                if ("skip".equals(str)) {
                    zzbhdVarZzzs.zzacw();
                    return;
                }
            }
            zzbdh zzbdhVarZzzn = zzbdnVarZzzr.zzzn();
            if (zzbdhVarZzzn == null) {
                zzbdh.zzb(zzbduVar2);
                return;
            }
            if ("click".equals(str)) {
                Context context = zzbduVar2.getContext();
                int iZza = zza(context, map, "x", 0);
                int iZza2 = zza(context, map, "y", 0);
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iZza, iZza2, 0);
                zzbdhVarZzzn.zze(motionEventObtain);
                motionEventObtain.recycle();
                return;
            }
            if ("currentTime".equals(str)) {
                String str6 = (String) map.get("time");
                if (str6 == null) {
                    zzbbq.zzfe("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzbdhVarZzzn.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
                    return;
                } catch (NumberFormatException unused3) {
                    String strValueOf2 = String.valueOf(str6);
                    zzbbq.zzfe(strValueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(strValueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                    return;
                }
            }
            if (MessengerShareContentUtility.SHARE_BUTTON_HIDE.equals(str)) {
                zzbdhVarZzzn.setVisibility(4);
                return;
            }
            if ("load".equals(str)) {
                zzbdhVarZzzn.zzhy();
                return;
            }
            if ("loadControl".equals(str)) {
                zza(zzbdhVarZzzn, (Map<String, String>) map);
                return;
            }
            if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzbdhVarZzzn.zzzh();
                    return;
                } else {
                    zzbdhVarZzzn.zzzi();
                    return;
                }
            }
            if ("pause".equals(str)) {
                zzbdhVarZzzn.pause();
                return;
            }
            if ("play".equals(str)) {
                zzbdhVarZzzn.play();
                return;
            }
            if ("show".equals(str)) {
                zzbdhVarZzzn.setVisibility(0);
                return;
            }
            if ("src".equals(str)) {
                String str7 = (String) map.get("src");
                String[] strArr = {str7};
                String str8 = (String) map.get("demuxed");
                if (str8 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str8);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            strArr2[i2] = jSONArray.getString(i2);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused4) {
                        String strValueOf3 = String.valueOf(str8);
                        zzbbq.zzfe(strValueOf3.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(strValueOf3) : new String("Malformed demuxed URL list for playback: "));
                        strArr = new String[]{str7};
                    }
                }
                zzbdhVarZzzn.zzc(str7, strArr);
                return;
            }
            if ("touchMove".equals(str)) {
                Context context2 = zzbduVar2.getContext();
                zzbdhVarZzzn.zza(zza(context2, map, "dx", 0), zza(context2, map, "dy", 0));
                if (this.zzeli) {
                    return;
                }
                zzbduVar2.zzuz();
                this.zzeli = true;
                return;
            }
            if ("volume".equals(str)) {
                String str9 = (String) map.get("volume");
                if (str9 == null) {
                    zzbbq.zzfe("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzbdhVarZzzn.setVolume(Float.parseFloat(str9));
                    return;
                } catch (NumberFormatException unused5) {
                    String strValueOf4 = String.valueOf(str9);
                    zzbbq.zzfe(strValueOf4.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(strValueOf4) : new String("Could not parse volume parameter from volume video GMSG: "));
                    return;
                }
            }
            if ("watermark".equals(str)) {
                zzbdhVarZzzn.zzzj();
                return;
            } else {
                String strValueOf5 = String.valueOf(str);
                zzbbq.zzfe(strValueOf5.length() != 0 ? "Unknown video action: ".concat(strValueOf5) : new String("Unknown video action: "));
                return;
            }
        }
        Context context3 = zzbduVar2.getContext();
        int iZza3 = zza(context3, map, "x", 0);
        int iZza4 = zza(context3, map, "y", 0);
        int iZza5 = zza(context3, map, "w", -1);
        int iZza6 = zza(context3, map, "h", -1);
        int iMin = Math.min(iZza5, zzbduVar2.zzzz() - iZza3);
        int iMin2 = Math.min(iZza6, zzbduVar2.zzzy() - iZza4);
        try {
            i = Integer.parseInt((String) map.get("player"));
        } catch (NumberFormatException unused6) {
            i = 0;
        }
        boolean z = Boolean.parseBoolean((String) map.get("spherical"));
        if (zEquals && zzbdnVarZzzr.zzzn() == null) {
            zzbdnVarZzzr.zza(iZza3, iZza4, iMin, iMin2, i, z, new zzbdv((String) map.get("flags")));
            zzbdh zzbdhVarZzzn2 = zzbdnVarZzzr.zzzn();
            if (zzbdhVarZzzn2 != null) {
                zza(zzbdhVarZzzn2, (Map<String, String>) map);
                return;
            }
            return;
        }
        zzbdnVarZzzr.zze(iZza3, iZza4, iMin, iMin2);
    }
}
