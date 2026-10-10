package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbbc {
    private Context zzaai;
    private boolean zzedn;
    private boolean zzzh = false;
    private final Map<BroadcastReceiver, IntentFilter> zzedm = new WeakHashMap();
    private final BroadcastReceiver zzedl = new zzbbf(this);

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzc(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.zzedm.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                arrayList.add(entry.getKey());
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((BroadcastReceiver) obj).onReceive(context, intent);
        }
    }

    public final synchronized void initialize(Context context) {
        if (this.zzzh) {
            return;
        }
        this.zzaai = context.getApplicationContext();
        if (this.zzaai == null) {
            this.zzaai = context;
        }
        zzabb.initialize(this.zzaai);
        this.zzedn = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcsf)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.zzaai.registerReceiver(this.zzedl, intentFilter);
        this.zzzh = true;
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzedn) {
            this.zzedm.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzedn) {
            this.zzedm.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}
