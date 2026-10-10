package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bj;
import java.io.Serializable;

/* JADX INFO: compiled from: TBase.java */
/* JADX INFO: loaded from: classes5.dex */
public interface bc<T extends bc<?, ?>, F extends bj> extends Serializable {
    void clear();

    bc<T, F> deepCopy();

    F fieldForId(int i);

    void read(cb cbVar) throws bi;

    void write(cb cbVar) throws bi;
}
