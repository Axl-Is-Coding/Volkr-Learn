package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.h;
import com.google.android.datatransport.runtime.backends.m;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class CctBackendFactory implements com.google.android.datatransport.runtime.backends.e {
    @Override // com.google.android.datatransport.runtime.backends.e
    public m create(h hVar) {
        return new d(hVar.a(), hVar.d(), hVar.c());
    }
}
