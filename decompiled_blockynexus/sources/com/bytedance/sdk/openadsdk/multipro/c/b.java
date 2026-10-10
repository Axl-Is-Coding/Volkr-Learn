package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.facebook.internal.ServerProtocol;

/* JADX INFO: compiled from: FrequentCallProviderImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.sdk.openadsdk.multipro.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7071a;

    public static boolean a(String str) {
        if (o.a() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverE = e();
            if (contentResolverE != null) {
                return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(contentResolverE.getType(Uri.parse(f() + "checkFrequency?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean c() {
        if (o.a() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverE = e();
            if (contentResolverE != null) {
                return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(contentResolverE.getType(Uri.parse(f() + "isSilent")));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String d() {
        if (o.a() == null) {
            return null;
        }
        try {
            ContentResolver contentResolverE = e();
            if (contentResolverE != null) {
                return contentResolverE.getType(Uri.parse(f() + "maxRit"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static ContentResolver e() {
        try {
            if (o.a() != null) {
                return o.a().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String f() {
        return e.f7076b + "/t_frequent/";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.f7071a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(Uri uri) {
        com.bytedance.sdk.openadsdk.utils.o.b("FrequentCallProviderImpl", "get type uri: " + String.valueOf(uri));
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.b.a.a().a(uri.getQueryParameter("rit")) ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.b.a.a().b() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.b.a.a().c();
        }
        return null;
    }
}
