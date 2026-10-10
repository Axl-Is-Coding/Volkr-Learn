package com.google.android.gms.internal.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzzi extends ContentProvider {
    private static Bundle zzh(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e2) {
            zzbbq.zzc("Failed to load metadata: Package name not found.", e2);
            return null;
        } catch (NullPointerException e3) {
            zzbbq.zzc("Failed to load metadata: Null pointer exception.", e3);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        Bundle bundleZzh = zzh(context);
        zzamt zzamtVarZztr = zzamt.zztr();
        if (bundleZzh == null) {
            zzbbq.zzfc("Metadata was null.");
        } else {
            try {
                String str = (String) bundleZzh.get("com.google.android.gms.ads.APPLICATION_ID");
                try {
                    Boolean bool = (Boolean) bundleZzh.get("com.google.android.gms.ads.AD_MANAGER_APP");
                    try {
                        Boolean bool2 = (Boolean) bundleZzh.get("com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT");
                        try {
                            String str2 = (String) bundleZzh.get("com.google.android.gms.ads.INTEGRATION_MANAGER");
                            if (str == null || str.matches("^/\\d+~.+$")) {
                                if (bool == null || !bool.booleanValue()) {
                                    if (TextUtils.isEmpty(str2)) {
                                        throw new IllegalStateException("\n\n******************************************************************************\n* The Google Mobile Ads SDK was initialized incorrectly. AdMob publishers    *\n* should follow the instructions here:                                       *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to add a valid App ID inside the AndroidManifest.                          *\n* Google Ad Manager publishers should follow instructions here:              *\n* https://googlemobileadssdk.page.link/ad-manager-android-update-manifest.   *\n******************************************************************************\n\n");
                                    }
                                    String strValueOf = String.valueOf(str2);
                                    zzbbq.zzef(strValueOf.length() != 0 ? "The Google Mobile Ads SDK is integrated by ".concat(strValueOf) : new String("The Google Mobile Ads SDK is integrated by "));
                                } else if (bool2 == null || !bool2.booleanValue()) {
                                    zzamtVarZztr.zzm(context);
                                }
                            } else {
                                if (!str.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) {
                                    throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here:                          *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to find your app ID.                                                       *\n******************************************************************************\n\n");
                                }
                                String strValueOf2 = String.valueOf(str);
                                zzbbq.zzef(strValueOf2.length() != 0 ? "Publisher provided Google AdMob App ID in manifest: ".concat(strValueOf2) : new String("Publisher provided Google AdMob App ID in manifest: "));
                                if (bool2 == null || !bool2.booleanValue()) {
                                    zzamtVarZztr.zzd(context, str);
                                }
                            }
                        } catch (ClassCastException e2) {
                            throw new IllegalStateException("The com.google.android.gms.ads.INTEGRATION_MANAGER metadata must have a String value.", e2);
                        }
                    } catch (ClassCastException e3) {
                        throw new IllegalStateException("The com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT metadata must have a boolean value.", e3);
                    }
                } catch (ClassCastException e4) {
                    throw new IllegalStateException("The com.google.android.gms.ads.AD_MANAGER_APP metadata must have a boolean value.", e4);
                }
            } catch (ClassCastException e5) {
                throw new IllegalStateException("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value.", e5);
            }
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
