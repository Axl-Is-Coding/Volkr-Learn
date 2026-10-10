package com.squareup.picasso;

import java.io.PrintWriter;

/* JADX INFO: compiled from: StatsSnapshot.java */
/* JADX INFO: loaded from: classes5.dex */
public class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f19247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f19248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f19249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f19250f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final long n;

    public I(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f19245a = i;
        this.f19246b = i2;
        this.f19247c = j;
        this.f19248d = j2;
        this.f19249e = j3;
        this.f19250f = j4;
        this.g = j5;
        this.h = j6;
        this.i = j7;
        this.j = j8;
        this.k = i3;
        this.l = i4;
        this.m = i5;
        this.n = j9;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f19245a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f19246b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((this.f19246b / this.f19245a) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f19247c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f19248d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f19249e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f19250f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f19245a + ", size=" + this.f19246b + ", cacheHits=" + this.f19247c + ", cacheMisses=" + this.f19248d + ", downloadCount=" + this.k + ", totalDownloadSize=" + this.f19249e + ", averageDownloadSize=" + this.h + ", totalOriginalBitmapSize=" + this.f19250f + ", totalTransformedBitmapSize=" + this.g + ", averageOriginalBitmapSize=" + this.i + ", averageTransformedBitmapSize=" + this.j + ", originalBitmapCount=" + this.l + ", transformedBitmapCount=" + this.m + ", timeStamp=" + this.n + '}';
    }
}
