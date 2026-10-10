package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcfh implements View.OnClickListener {
    private final Clock zzbqa;
    private final zzcil zzgbo;
    private zzafz zzgbp;
    private zzahq<Object> zzgbq;
    String zzgbr;
    Long zzgbs;
    WeakReference<View> zzgbt;

    public zzcfh(zzcil zzcilVar, Clock clock) {
        this.zzgbo = zzcilVar;
        this.zzbqa = clock;
    }

    private final void zzank() {
        View view;
        this.zzgbr = null;
        this.zzgbs = null;
        WeakReference<View> weakReference = this.zzgbt;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.zzgbt = null;
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzgbp == null || this.zzgbs == null) {
            return;
        }
        zzank();
        try {
            this.zzgbp.onUnconfirmedClickCancelled();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzgbt;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.zzgbr != null && this.zzgbs != null) {
            HashMap map = new HashMap();
            map.put("id", this.zzgbr);
            map.put("time_interval", String.valueOf(this.zzbqa.currentTimeMillis() - this.zzgbs.longValue()));
            map.put("messageType", "onePointFiveClick");
            this.zzgbo.zza("sendMessageToNativeJs", map);
        }
        zzank();
    }

    public final void zza(final zzafz zzafzVar) {
        this.zzgbp = zzafzVar;
        zzahq<Object> zzahqVar = this.zzgbq;
        if (zzahqVar != null) {
            this.zzgbo.zzb("/unconfirmedClick", zzahqVar);
        }
        this.zzgbq = new zzahq(this, zzafzVar) { // from class: com.google.android.gms.internal.ads.zzcfk
            private final zzcfh zzgbu;
            private final zzafz zzgbv;

            {
                this.zzgbu = this;
                this.zzgbv = zzafzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                zzcfh zzcfhVar = this.zzgbu;
                zzafz zzafzVar2 = this.zzgbv;
                try {
                    zzcfhVar.zzgbs = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    zzbbq.zzfc("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzcfhVar.zzgbr = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzafzVar2 == null) {
                    zzbbq.zzef("Received unconfirmed click but UnconfirmedClickListener is null.");
                    return;
                }
                try {
                    zzafzVar2.onUnconfirmedClickReceived(str);
                } catch (RemoteException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        };
        this.zzgbo.zza("/unconfirmedClick", this.zzgbq);
    }

    public final zzafz zzanj() {
        return this.zzgbp;
    }
}
