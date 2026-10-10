package com.google.android.gms.ads.mediation.rtb;

import com.google.android.gms.ads.mediation.Adapter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RtbAdapter extends Adapter {
    public abstract void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks);
}
