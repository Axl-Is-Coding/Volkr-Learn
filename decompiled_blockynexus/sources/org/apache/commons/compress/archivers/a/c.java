package org.apache.commons.compress.archivers.a;

import java.io.IOException;

/* JADX INFO: compiled from: TarArchiveSparseEntry.java */
/* JADX INFO: loaded from: classes5.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f23524a;

    public c(byte[] bArr) throws IOException {
        this.f23524a = f.a(bArr, 504);
    }

    public boolean a() {
        return this.f23524a;
    }
}
