package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.umeng.analytics.pro.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddw implements zzdgu<Bundle> {
    private final Location zznb;

    public zzddw(Location location) {
        this.zznb = location;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (this.zznb != null) {
            Bundle bundle3 = new Bundle();
            float accuracy = this.zznb.getAccuracy() * 1000.0f;
            long time = this.zznb.getTime() * 1000;
            long latitude = (long) (this.zznb.getLatitude() * 1.0E7d);
            long longitude = (long) (this.zznb.getLongitude() * 1.0E7d);
            bundle3.putFloat("radius", accuracy);
            bundle3.putLong(b.B, latitude);
            bundle3.putLong("long", longitude);
            bundle3.putLong("time", time);
            bundle2.putBundle("uule", bundle3);
        }
    }
}
