package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import java.io.File;

/* JADX INFO: compiled from: Volley.java */
/* JADX INFO: loaded from: classes.dex */
public class s {
    public static com.android.volley.l a(Context context, b bVar) {
        c cVar;
        String str;
        if (bVar != null) {
            cVar = new c(bVar);
        } else if (Build.VERSION.SDK_INT >= 9) {
            cVar = new c((b) new k());
        } else {
            try {
                String packageName = context.getPackageName();
                str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                str = "volley/0";
            }
            cVar = new c(new g(AndroidHttpClient.newInstance(str)));
        }
        return a(context, cVar);
    }

    private static com.android.volley.l a(Context context, com.android.volley.h hVar) {
        com.android.volley.l lVar = new com.android.volley.l(new f(new File(context.getCacheDir(), "volley")), hVar);
        lVar.b();
        return lVar;
    }

    public static com.android.volley.l a(Context context) {
        return a(context, (b) null);
    }
}
