package com.alibaba.mtl.log.c;

import java.util.List;

/* JADX INFO: compiled from: ILogStore.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    int a(List<com.alibaba.mtl.log.model.a> list);

    List<com.alibaba.mtl.log.model.a> a(String str, int i);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    boolean mo21a(List<com.alibaba.mtl.log.model.a> list);

    void c(String str, String str2);

    void clear();

    void e(int i);

    int g();
}
