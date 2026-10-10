package com.bumptech.glide.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.h;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: ApplicationVersionSignature.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap<String, h> f4139a = new ConcurrentHashMap();

    public static h a(Context context) {
        String packageName = context.getPackageName();
        h hVar = f4139a.get(packageName);
        if (hVar != null) {
            return hVar;
        }
        h hVarC = c(context);
        h hVarPutIfAbsent = f4139a.putIfAbsent(packageName, hVarC);
        return hVarPutIfAbsent == null ? hVarC : hVarPutIfAbsent;
    }

    private static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e2);
            return null;
        }
    }

    private static h c(Context context) {
        return new d(a(b(context)));
    }

    private static String a(PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }
}
