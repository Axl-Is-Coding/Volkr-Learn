package com.tendcloud.tenddata;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class ce {
    public static boolean a(Context context) {
        PackageManager packageManager;
        try {
            if (!af.b(29) && by.k() && (packageManager = context.getPackageManager()) != null) {
                if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void reflectNUBIA(Context context) {
        Bundle bundleCall;
        String string;
        try {
            Uri uri = Uri.parse("content://cn.nubia.identity/identity");
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                if (contentProviderClientAcquireContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireContentProviderClient.close();
                    } else {
                        contentProviderClientAcquireContentProviderClient.release();
                    }
                }
            } else {
                bundleCall = context.getContentResolver().call(uri, "getOAID", (String) null, (Bundle) null);
            }
            if (bundleCall.getInt("code", -1) != 0 || (string = bundleCall.getString("id")) == null) {
                return;
            }
            de.b().setOAID(string);
        } catch (Throwable unused) {
        }
    }
}
