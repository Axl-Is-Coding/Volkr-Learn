package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
final class zzawm {
    private static final Map<String, String> zzdxk;
    private final List<String> zzdxl;
    private final zzavy zzdxm;
    private final Context zzvr;

    static {
        HashMap map = new HashMap();
        if (PlatformVersion.isAtLeastLollipop()) {
            map.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            map.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        zzdxk = map;
    }

    zzawm(Context context, List<String> list, zzavy zzavyVar) {
        this.zzvr = context;
        this.zzdxl = list;
        this.zzdxm = zzavyVar;
    }

    final List<String> zzb(String[] strArr) {
        boolean z;
        boolean z2;
        String strValueOf;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Iterator<String> it = this.zzdxl.iterator();
            do {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    break;
                }
                strValueOf = String.valueOf(next);
            } while (!(strValueOf.length() != 0 ? "android.webkit.resource.".concat(strValueOf) : new String("android.webkit.resource.")).equals(str));
            z2 = true;
            if (z2) {
                if (zzdxk.containsKey(str)) {
                    com.google.android.gms.ads.internal.zzp.zzkr();
                    if (!zzayu.zzr(this.zzvr, zzdxk.get(str))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(str);
                } else {
                    this.zzdxm.zzec(str);
                }
            } else {
                this.zzdxm.zzeb(str);
            }
        }
        return arrayList;
    }
}
