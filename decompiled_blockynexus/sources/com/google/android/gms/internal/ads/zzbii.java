package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbii implements zzahq<zzbgj> {
    private final /* synthetic */ zzbig zzeqt;

    zzbii(zzbig zzbigVar) {
        this.zzeqt = zzbigVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbgj zzbgjVar, Map map) {
        if (map != null) {
            String str = (String) map.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i = Integer.parseInt(str);
                synchronized (this.zzeqt) {
                    if (this.zzeqt.zzepo != i) {
                        this.zzeqt.zzepo = i;
                        this.zzeqt.requestLayout();
                    }
                }
            } catch (Exception e2) {
                zzbbq.zzd("Exception occurred while getting webview content height", e2);
            }
        }
    }
}
