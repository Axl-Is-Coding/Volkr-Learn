package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TTProviderManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f7077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference<Context> f7078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<a> f7079c = Collections.synchronizedList(new ArrayList());

    static {
        f7079c.add(new com.bytedance.sdk.openadsdk.multipro.d.c());
        f7079c.add(new com.bytedance.sdk.openadsdk.multipro.a.b());
        f7079c.add(new com.bytedance.sdk.openadsdk.multipro.c.b());
        f7079c.add(new com.bytedance.sdk.openadsdk.multipro.c.a());
        Iterator<a> it = f7079c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private f() {
    }

    public static f b(Context context) {
        if (context != null) {
            f7078b = new WeakReference<>(context.getApplicationContext());
        }
        if (f7077a == null) {
            synchronized (f.class) {
                if (f7077a == null) {
                    f7077a = new f();
                }
            }
        }
        return f7077a;
    }

    private boolean c(Uri uri) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        Iterator<a> it = f7079c.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            a aVarB = b(uri);
            if (aVarB != null) {
                return aVarB.a(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable th) {
            o.a("TTProviderManager", "==provider query error==", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(Uri uri) {
        try {
            a aVarB = b(uri);
            if (aVarB != null) {
                return aVarB.a(uri);
            }
            return null;
        } catch (Throwable th) {
            o.a("TTProviderManager", "==provider getType error==", th);
            return null;
        }
    }

    private a b(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (!c(uri)) {
            o.b("TTProviderManager", "uri is error1");
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            o.b("TTProviderManager", "uri is error2");
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            o.b("TTProviderManager", "uri is error3");
            return null;
        }
        for (a aVar : f7079c) {
            if (str.equals(aVar.a())) {
                return aVar;
            }
        }
        o.b("TTProviderManager", "uri is error4");
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(Uri uri, ContentValues contentValues) {
        try {
            a aVarB = b(uri);
            if (aVarB != null) {
                return aVarB.a(uri, contentValues);
            }
            return null;
        } catch (Throwable th) {
            o.a("TTProviderManager", "==provider insert error==", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, String str, String[] strArr) {
        try {
            a aVarB = b(uri);
            if (aVarB != null) {
                return aVarB.a(uri, str, strArr);
            }
            return 0;
        } catch (Throwable th) {
            o.a("TTProviderManager", "==provider delete error==", th);
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            a aVarB = b(uri);
            if (aVarB != null) {
                return aVarB.a(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable th) {
            o.a("TTProviderManager", "==provider update error==", th);
            return 0;
        }
    }
}
