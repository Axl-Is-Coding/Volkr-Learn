package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.e;

/* JADX INFO: compiled from: DBMultiAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static ContentResolver a(Context context) {
        if (context == null) {
            try {
                context = o.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    private static String a() {
        return e.f7076b + "/t_db/ttopensdk.db/";
    }

    public static synchronized void a(Context context, String str, ContentValues contentValues) {
        if (contentValues != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    ContentResolver contentResolverA = a(context);
                    if (contentResolverA != null) {
                        contentResolverA.insert(Uri.parse(a() + str), contentValues);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized int a(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver contentResolverA = a(context);
            if (contentResolverA != null) {
                return contentResolverA.delete(Uri.parse(a() + str), str2, strArr);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static synchronized int a(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    ContentResolver contentResolverA = a(context);
                    if (contentResolverA != null) {
                        return contentResolverA.update(Uri.parse(a() + str), contentValues, str2, strArr);
                    }
                } catch (Throwable unused) {
                }
                return 0;
            }
        }
        return 0;
    }

    public static synchronized Cursor a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContentResolver contentResolverA = a(context);
            if (contentResolverA != null) {
                return contentResolverA.query(Uri.parse(a() + str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static synchronized void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverA = a(context);
            if (contentResolverA != null) {
                contentResolverA.getType(Uri.parse(a() + "unknown/execSQL?sql=" + Uri.encode(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
