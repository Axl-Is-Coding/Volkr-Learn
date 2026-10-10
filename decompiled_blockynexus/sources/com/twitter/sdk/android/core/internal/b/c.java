package com.twitter.sdk.android.core.internal.b;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: PreferenceStoreImpl.java */
/* JADX INFO: loaded from: classes5.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f20157a;

    public c(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.f20157a = context.getSharedPreferences(str, 0);
    }

    @Override // com.twitter.sdk.android.core.internal.b.b
    public boolean a(SharedPreferences.Editor editor) {
        editor.apply();
        return true;
    }

    @Override // com.twitter.sdk.android.core.internal.b.b
    public SharedPreferences.Editor edit() {
        return this.f20157a.edit();
    }

    @Override // com.twitter.sdk.android.core.internal.b.b
    public SharedPreferences get() {
        return this.f20157a;
    }
}
