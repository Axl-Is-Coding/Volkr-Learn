package com.twitter.sdk.android.core.internal.b;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: PreferenceStore.java */
/* JADX INFO: loaded from: classes5.dex */
public interface b {
    boolean a(SharedPreferences.Editor editor);

    SharedPreferences.Editor edit();

    SharedPreferences get();
}
