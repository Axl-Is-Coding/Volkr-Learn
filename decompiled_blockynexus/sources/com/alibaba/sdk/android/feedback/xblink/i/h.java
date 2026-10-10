package com.alibaba.sdk.android.feedback.xblink.i;

import android.net.Uri;
import android.text.TextUtils;
import com.just.agentweb.DefaultWebClient;
import com.tendcloud.tenddata.aa;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map f3897a = new HashMap();

    static {
        for (e eVar : e.values()) {
            f3897a.put(eVar.b(), eVar.c());
        }
    }

    public static String a(String str, String str2, String str3) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        if (uri.getQueryParameter(str2) != null) {
            return str;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter(str2, str3);
        return builderBuildUpon.toString();
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.toLowerCase().startsWith(DefaultWebClient.HTTP_SCHEME) || str.toLowerCase().startsWith(DefaultWebClient.HTTPS_SCHEME));
    }

    public static String b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Uri uri = Uri.parse(str);
            stringBuffer.append(uri.getScheme());
            stringBuffer.append(aa.f19741a);
            stringBuffer.append(uri.getHost());
            stringBuffer.append(uri.getPath());
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
