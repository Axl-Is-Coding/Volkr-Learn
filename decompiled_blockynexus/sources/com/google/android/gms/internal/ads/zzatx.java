package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatx extends ContextWrapper {
    private Context zzdvu;
    private WeakReference<Activity> zzdvv;

    private zzatx(Context context) {
        super(context);
        this.zzdvv = new WeakReference<>(null);
    }

    public static zzatx zzaa(Context context) {
        return new zzatx(zzl(context));
    }

    public static Context zzab(Context context) {
        return context instanceof zzatx ? ((zzatx) context).getBaseContext() : zzl(context);
    }

    private final synchronized Intent zze(Intent intent) {
        if (this.zzdvu != null && intent.getComponent() != null && intent.getComponent().getPackageName().equals(this.zzdvu.getPackageName())) {
            Intent intent2 = (Intent) intent.clone();
            intent2.setClassName(super.getPackageName(), intent.getComponent().getClassName());
            return intent2;
        }
        return intent;
    }

    private final synchronized void zzf(Intent intent) {
        Activity activity = this.zzdvv.get();
        if (activity == null) {
            intent.addFlags(268435456);
            super.startActivity(intent);
            return;
        }
        try {
            Intent intent2 = (Intent) intent.clone();
            intent2.setFlags(intent.getFlags() & (-268435457));
            activity.startActivity(intent2);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "");
            intent.addFlags(268435456);
            super.startActivity(intent);
        }
    }

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized ApplicationInfo getApplicationInfo() {
        if (this.zzdvu != null) {
            return this.zzdvu.getApplicationInfo();
        }
        return super.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageName() {
        if (this.zzdvu != null) {
            return this.zzdvu.getPackageName();
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageResourcePath() {
        if (this.zzdvu != null) {
            return this.zzdvu.getPackageResourcePath();
        }
        return super.getPackageResourcePath();
    }

    public final synchronized void setAppPackageName(String str) throws PackageManager.NameNotFoundException {
        this.zzdvu = super.createPackageContext(str, 0);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized void startActivity(Intent intent) {
        zzf(zze(intent));
    }
}
