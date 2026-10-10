package com.bumptech.glide.load.a;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.a.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: FileLoader.java */
/* JADX INFO: loaded from: classes.dex */
class j implements i.d<ParcelFileDescriptor> {
    j() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.a.i.d
    public ParcelFileDescriptor a(File file) throws FileNotFoundException {
        return ParcelFileDescriptor.open(file, 268435456);
    }

    @Override // com.bumptech.glide.load.a.i.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.a.i.d
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }
}
