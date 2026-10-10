package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzqn {
    private final Context zzaai;
    private final zzbbx zzbpe;
    private final zzakr zzbra;
    private final Object lock = new Object();
    private final WeakHashMap<Object, Object> zzbqy = new WeakHashMap<>();
    private final ArrayList<Object> zzbqz = new ArrayList<>();

    public zzqn(Context context, zzbbx zzbbxVar) {
        this.zzaai = context.getApplicationContext();
        this.zzbpe = zzbbxVar;
        this.zzbra = new zzakr(context.getApplicationContext(), zzbbxVar, (String) zzwm.zzpx().zzd(zzabb.zzclt));
    }
}
