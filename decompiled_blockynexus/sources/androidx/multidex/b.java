package androidx.multidex;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: MultiDexExtractor.java */
/* JADX INFO: loaded from: classes.dex */
class b implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MultiDexExtractor f1775a;

    b(MultiDexExtractor multiDexExtractor) {
        this.f1775a = multiDexExtractor;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return !file.getName().equals("MultiDex.lock");
    }
}
