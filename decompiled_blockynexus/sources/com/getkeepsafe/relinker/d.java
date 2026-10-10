package com.getkeepsafe.relinker;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: ReLinkerInstance.java */
/* JADX INFO: loaded from: classes.dex */
class d implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f12516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f12517b;

    d(e eVar, String str) {
        this.f12517b = eVar;
        this.f12516a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f12516a);
    }
}
