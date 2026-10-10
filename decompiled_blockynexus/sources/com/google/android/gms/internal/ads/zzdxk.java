package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdxk implements FilenameFilter {
    private final Pattern zzhfo;

    public zzdxk(Pattern pattern) {
        zzdwd.checkNotNull(pattern);
        this.zzhfo = pattern;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return this.zzhfo.matcher(str).matches();
    }
}
