package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.utils.o;

/* JADX INFO: compiled from: DBMultiProviderImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.sdk.openadsdk.multipro.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f7018b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7019a;

    private boolean b(Uri uri) {
        boolean z = uri == null || TextUtils.isEmpty(uri.getPath());
        if (z) {
            o.b("DBMultiProviderImpl", "==check uri is null==");
        }
        return z;
    }

    private Context c() {
        Context context = this.f7019a;
        return context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.f7019a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        o.b("DBMultiProviderImpl", "query: " + String.valueOf(uri));
        synchronized (f7018b) {
            if (b(uri)) {
                return null;
            }
            String[] strArrSplit = uri.getPath().split("/");
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str3 = strArrSplit[2];
                String str4 = strArrSplit[3];
                if (!"ttopensdk.db".equals(str3)) {
                    return null;
                }
                return e.a(c()).a().a(str4, strArr, str, strArr2, null, null, str2);
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(Uri uri) {
        o.b("DBMultiProviderImpl", "getType: " + String.valueOf(uri));
        synchronized (f7018b) {
            if (b(uri)) {
                return null;
            }
            String[] strArrSplit = uri.getPath().split("/");
            if (strArrSplit != null && strArrSplit.length >= 5) {
                String str = strArrSplit[2];
                String str2 = strArrSplit[3];
                String str3 = strArrSplit[4];
                if ("ttopensdk.db".equals(str)) {
                    if ("execSQL".equals(str3)) {
                        String queryParameter = uri.getQueryParameter("sql");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            e.a(c()).a().a(Uri.decode(queryParameter));
                        }
                    } else if ("transactionBegin".equals(str3)) {
                        e.a(c()).a().a();
                    } else if ("transactionSetSuccess".equals(str3)) {
                        e.a(c()).a().b();
                    } else if ("transactionEnd".equals(str3)) {
                        e.a(c()).a().c();
                    }
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(Uri uri, ContentValues contentValues) {
        o.b("DBMultiProviderImpl", "insert: " + String.valueOf(uri));
        synchronized (f7018b) {
            if (b(uri)) {
                return null;
            }
            String[] strArrSplit = uri.getPath().split("/");
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str = strArrSplit[2];
                String str2 = strArrSplit[3];
                if ("ttopensdk.db".equals(str)) {
                    e.a(c()).a().a(str2, (String) null, contentValues);
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, String str, String[] strArr) {
        o.b("DBMultiProviderImpl", "delete: " + String.valueOf(uri));
        synchronized (f7018b) {
            if (b(uri)) {
                return 0;
            }
            String[] strArrSplit = uri.getPath().split("/");
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str2 = strArrSplit[2];
                String str3 = strArrSplit[3];
                if (!"ttopensdk.db".equals(str2)) {
                    return 0;
                }
                return e.a(c()).a().a(str3, str, strArr);
            }
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        o.b("DBMultiProviderImpl", "update: " + String.valueOf(uri));
        synchronized (f7018b) {
            if (b(uri)) {
                return 0;
            }
            String[] strArrSplit = uri.getPath().split("/");
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str2 = strArrSplit[2];
                String str3 = strArrSplit[3];
                if (!"ttopensdk.db".equals(str2)) {
                    return 0;
                }
                return e.a(c()).a().a(str3, contentValues, str, strArr);
            }
            return 0;
        }
    }
}
