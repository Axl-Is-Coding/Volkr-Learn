package org.apache.commons.compress.compressors.a;

/* JADX INFO: compiled from: GzipParameters.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f23544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f23545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23546d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f23543a = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23547e = 255;

    public void a(int i) {
        if (i >= -1 && i <= 9) {
            this.f23543a = i;
            return;
        }
        throw new IllegalArgumentException("Invalid gzip compression level: " + i);
    }

    public void b(String str) {
        this.f23545c = str;
    }

    public void b(int i) {
        this.f23547e = i;
    }

    public void a(long j) {
        this.f23544b = j;
    }

    public void a(String str) {
        this.f23546d = str;
    }
}
