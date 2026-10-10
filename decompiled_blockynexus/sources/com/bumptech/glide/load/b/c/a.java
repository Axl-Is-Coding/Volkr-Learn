package com.bumptech.glide.load.b.c;

import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.m;
import java.io.File;

/* JADX INFO: compiled from: FileDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements m<File, File> {
    @Override // com.bumptech.glide.load.m
    public boolean a(File file, l lVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.m
    public C<File> a(File file, int i, int i2, l lVar) {
        return new b(file);
    }
}
