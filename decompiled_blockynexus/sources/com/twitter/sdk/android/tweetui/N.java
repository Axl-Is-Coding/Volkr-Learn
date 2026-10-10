package com.twitter.sdk.android.tweetui;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes5.dex */
final class N {
    static CharSequence a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence != null ? charSequence : charSequence2;
    }

    static Long a(String str, long j) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            return Long.valueOf(j);
        }
    }

    static String a(String str, String str2) {
        return str != null ? str : str2;
    }

    static String a(String str) {
        return a(str, "");
    }

    static CharSequence a(CharSequence charSequence) {
        return a(charSequence, "");
    }
}
