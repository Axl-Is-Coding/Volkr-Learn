package com.twitter.sdk.android.core.internal;

import android.net.Uri;
import android.os.Build;
import java.text.Normalizer;

/* JADX INFO: compiled from: TwitterApi.java */
/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20182a;

    public m() {
        this("https://api.twitter.com");
    }

    static String b(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 31 && cCharAt < 127) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public String a() {
        return this.f20182a;
    }

    public m(String str) {
        this.f20182a = str;
    }

    public Uri.Builder a(String... strArr) {
        Uri.Builder builderBuildUpon = Uri.parse(a()).buildUpon();
        if (strArr != null) {
            for (String str : strArr) {
                builderBuildUpon.appendPath(str);
            }
        }
        return builderBuildUpon;
    }

    public static String a(String str, String str2) {
        return a(str + '/' + str2 + ' ' + Build.MODEL + '/' + Build.VERSION.RELEASE + " (" + Build.MANUFACTURER + ';' + Build.MODEL + ';' + Build.BRAND + ';' + Build.PRODUCT + ')');
    }

    static String a(String str) {
        return b(Normalizer.normalize(str, Normalizer.Form.NFD));
    }
}
