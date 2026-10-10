package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: TotalSizeLruDiskUsage.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f5740a = 83886080;

    @Override // com.bytedance.sdk.openadsdk.b.b
    public File a(String str, File file) throws IOException {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected boolean a(long j, int i) {
        return j < this.f5740a;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected boolean a(File file, long j, int i) {
        return j < this.f5740a / 2;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    public void a(List<File> list) {
        long jB = b(list);
        o.c("TotalSizeLruDiskUsage", "当前缓存文件的总size：" + ((jB / 1024) / 1024) + "MB");
        int size = list.size();
        boolean zA = a(jB, size);
        if (zA) {
            o.c("TotalSizeLruDiskUsage", "不满足删除条件，不执行删除操作(true)" + zA);
        } else {
            o.c("TotalSizeLruDiskUsage", "满足删除条件，开始执行删除操作(false)" + zA);
        }
        for (File file : list) {
            if (!zA) {
                o.c("TotalSizeLruDiskUsage", "满足删除条件开始删除文件......................");
                long length = file.length();
                if (file.delete()) {
                    size--;
                    jB -= length;
                    o.c("TotalSizeLruDiskUsage", "删除 一个 Cache file 当前总大小totalSize：" + ((jB / 1024) / 1024) + "MB");
                } else {
                    o.e("TotalSizeLruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
                boolean zA2 = a(file, jB, size);
                if (zA2) {
                    o.c("TotalSizeLruDiskUsage", "当前总大小totalSize：" + ((jB / 1024) / 1024) + "MB，最大值存储上限maxSize=" + ((this.f5740a / 1024) / 1024) + "MB，当前文件的总大小totalSize已小于等于maxSize一半，停止删除操作：minStopDeleteCondition=" + zA2);
                    return;
                }
            }
        }
    }
}
