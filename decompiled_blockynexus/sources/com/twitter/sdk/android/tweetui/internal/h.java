package com.twitter.sdk.android.tweetui.internal;

import java.util.Locale;

/* JADX INFO: compiled from: MediaTimeUtils.java */
/* JADX INFO: loaded from: classes5.dex */
final class h {
    static String a(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        return i4 > 0 ? String.format(Locale.getDefault(), "%1$d:%2$02d:%3$02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)) : String.format(Locale.getDefault(), "%1$d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i2));
    }
}
