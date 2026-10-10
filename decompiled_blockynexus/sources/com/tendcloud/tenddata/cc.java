package com.tendcloud.tenddata;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class cc {
    public static boolean a(Context context) {
        PackageManager packageManager;
        try {
            if (!af.b(29) && by.h() && (packageManager = context.getPackageManager()) != null) {
                if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void reflectMEiZU(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string != null) {
                    de.b().setOAID(string);
                }
                cursorQuery.close();
            }
        } catch (Throwable unused) {
        }
    }
}
