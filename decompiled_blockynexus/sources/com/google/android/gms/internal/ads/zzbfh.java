package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbfh implements zzahq<zzbdu> {
    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbdu zzbduVar, Map map) {
        zzbdu zzbduVar2 = zzbduVar;
        zzbhd zzbhdVarZzzs = zzbduVar2.zzzs();
        if (zzbhdVarZzzs == null) {
            try {
                zzbhd zzbhdVar = new zzbhd(zzbduVar2, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzbduVar2.zza(zzbhdVar);
                zzbhdVarZzzs = zzbhdVar;
            } catch (NullPointerException | NumberFormatException e2) {
                zzbbq.zzc("Unable to parse videoMeta message.", e2);
                com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float f2 = Float.parseFloat((String) map.get("duration"));
        boolean zEquals = "1".equals(map.get("muted"));
        float f3 = Float.parseFloat((String) map.get("currentTime"));
        int i = Integer.parseInt((String) map.get("playbackState"));
        int i2 = (i < 0 || 3 < i) ? 0 : i;
        String str = (String) map.get("aspectRatio");
        float f4 = TextUtils.isEmpty(str) ? WheelView.DividerConfig.FILL : Float.parseFloat(str);
        if (zzbbq.isLoggable(3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 140);
            sb.append("Video Meta GMSG: currentTime : ");
            sb.append(f3);
            sb.append(" , duration : ");
            sb.append(f2);
            sb.append(" , isMuted : ");
            sb.append(zEquals);
            sb.append(" , playbackState : ");
            sb.append(i2);
            sb.append(" , aspectRatio : ");
            sb.append(str);
            zzbbq.zzef(sb.toString());
        }
        zzbhdVarZzzs.zza(f3, f2, i2, zEquals, f4);
    }
}
