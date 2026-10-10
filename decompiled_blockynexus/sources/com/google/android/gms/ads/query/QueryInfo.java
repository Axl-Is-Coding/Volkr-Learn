package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzaru;
import com.google.android.gms.internal.ads.zzzj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class QueryInfo {
    private final zzzj zzhls;

    public QueryInfo(zzzj zzzjVar) {
        this.zzhls = zzzjVar;
    }

    @KeepForSdk
    public static void generate(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        new zzaru(context, adFormat, adRequest == null ? null : adRequest.zzdr()).zza(queryInfoGenerationCallback);
    }

    @KeepForSdk
    public String getQuery() {
        return this.zzhls.getQuery();
    }

    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.zzhls.getQueryBundle();
    }

    @KeepForSdk
    public String getRequestId() {
        return zzzj.zza(this);
    }
}
