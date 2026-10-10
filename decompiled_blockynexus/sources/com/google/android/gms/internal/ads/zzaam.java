package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.just.agentweb.DefaultWebClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaam {
    private final Context zzvr;

    public zzaam(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null");
        this.zzvr = context;
    }

    private final boolean zza(Intent intent) {
        Preconditions.checkNotNull(intent, "Intent can not be null");
        return !this.zzvr.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public final boolean zzrb() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return zza(intent);
    }

    public final boolean zzrc() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(DefaultWebClient.SCHEME_SMS));
        return zza(intent);
    }

    public final boolean zzrd() {
        return ((Boolean) zzbay.zza(this.zzvr, new zzaal())).booleanValue() && Wrappers.packageManager(this.zzvr).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public final boolean zzre() {
        return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
