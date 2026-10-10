package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: TotalCountLruDiskFile.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5739b;

    public c(int i, int i2) {
        this.f5738a = 15;
        this.f5739b = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f5738a = i;
        this.f5739b = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected boolean a(long j, int i) {
        return i <= this.f5738a;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected boolean a(File file, long j, int i) {
        return i <= this.f5739b;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected void a(List<File> list) {
        long jB = b(list);
        int size = list.size();
        if (a(jB, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jB -= length;
                o.c("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
            } else {
                o.c("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
            }
            if (a(file, jB, size)) {
                return;
            }
        }
    }
}
