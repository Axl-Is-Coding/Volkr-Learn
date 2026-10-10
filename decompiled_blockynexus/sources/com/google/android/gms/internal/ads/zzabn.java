package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzabn extends zzabm {
    zzabn() {
    }

    private static String zzcw(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final String zzg(String str, String str2) {
        String strZzcw = zzcw(str);
        String strZzcw2 = zzcw(str2);
        if (TextUtils.isEmpty(strZzcw)) {
            return strZzcw2;
        }
        if (TextUtils.isEmpty(strZzcw2)) {
            return strZzcw;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(strZzcw).length() + 1 + String.valueOf(strZzcw2).length());
        sb.append(strZzcw);
        sb.append(",");
        sb.append(strZzcw2);
        return sb.toString();
    }
}
