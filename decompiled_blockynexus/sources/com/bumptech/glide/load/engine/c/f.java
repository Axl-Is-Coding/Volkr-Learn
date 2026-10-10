package com.bumptech.glide.load.engine.c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: RuntimeCompat.java */
/* JADX INFO: loaded from: classes.dex */
class f implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Pattern f4555a;

    f(Pattern pattern) {
        this.f4555a = pattern;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.f4555a.matcher(str).matches();
    }
}
