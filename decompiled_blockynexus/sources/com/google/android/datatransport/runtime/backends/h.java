package com.google.android.datatransport.runtime.backends;

import android.content.Context;

/* JADX INFO: compiled from: CreationContext.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static h a(Context context, com.google.android.datatransport.runtime.e.a aVar, com.google.android.datatransport.runtime.e.a aVar2, String str) {
        return new d(context, aVar, aVar2, str);
    }

    public abstract Context a();

    public abstract String b();

    public abstract com.google.android.datatransport.runtime.e.a c();

    public abstract com.google.android.datatransport.runtime.e.a d();
}
