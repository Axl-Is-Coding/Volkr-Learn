package com.ironsource.mediationsdk.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.mediationsdk.utils.i;
import com.ironsource.mediationsdk.utils.j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Vector;

/* JADX INFO: compiled from: ServerURL.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f14817a = "https://init.supersonicads.com/sdk/v";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f14818b = "?request=";

    public static String a(Context context, String str, String str2, String str3, String str4, Vector<Pair<String, String>> vector) throws UnsupportedEncodingException {
        Vector vector2 = new Vector();
        vector2.add(new Pair("platform", "android"));
        vector2.add(new Pair("applicationKey", str));
        vector2.add(new Pair("applicationUserId", str2));
        vector2.add(new Pair("sdkVersion", j.c()));
        if (j.d() == 0) {
            vector2.add(new Pair("serr", String.valueOf(j.d())));
        }
        if (!TextUtils.isEmpty(com.ironsource.mediationsdk.a.a.a().c())) {
            vector2.add(new Pair("pluginType", com.ironsource.mediationsdk.a.a.a().c()));
        }
        if (!TextUtils.isEmpty(com.ironsource.mediationsdk.a.a.a().d())) {
            vector2.add(new Pair("pluginVersion", com.ironsource.mediationsdk.a.a.a().d()));
        }
        if (!TextUtils.isEmpty(com.ironsource.mediationsdk.a.a.a().b())) {
            vector2.add(new Pair("plugin_fw_v", com.ironsource.mediationsdk.a.a.a().b()));
        }
        if (!TextUtils.isEmpty(str3)) {
            vector2.add(new Pair("advId", str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            vector2.add(new Pair("mt", str4));
        }
        String strA = com.ironsource.environment.a.a(context, context.getPackageName());
        if (!TextUtils.isEmpty(strA)) {
            vector2.add(new Pair("appVer", strA));
        }
        vector2.add(new Pair("osVer", Build.VERSION.SDK_INT + ""));
        vector2.add(new Pair("devMake", Build.MANUFACTURER));
        vector2.add(new Pair("devModel", Build.MODEL));
        String strB = j.b(context);
        if (!TextUtils.isEmpty(strB)) {
            vector2.add(new Pair("connType", strB));
        }
        if (vector != null) {
            vector2.addAll(vector);
        }
        return a(j.c()) + URLEncoder.encode(i.b("C38FB23A402222A0C17D34A92F971D1F", a((Vector<Pair<String, String>>) vector2)), "UTF-8");
    }

    public static String a(String str, boolean z, int i) throws UnsupportedEncodingException {
        Vector vector = new Vector();
        vector.add(new Pair("impression", Boolean.toString(z)));
        vector.add(new Pair("placementId", Integer.toString(i)));
        return str + "&" + a((Vector<Pair<String, String>>) vector);
    }

    private static String a(Vector<Pair<String, String>> vector) throws UnsupportedEncodingException {
        String str = "";
        for (Pair<String, String> pair : vector) {
            if (str.length() > 0) {
                str = str + "&";
            }
            str = str + ((String) pair.first) + "=" + URLEncoder.encode((String) pair.second, "UTF-8");
        }
        return str;
    }

    private static String a(String str) {
        return f14817a + str + f14818b;
    }
}
