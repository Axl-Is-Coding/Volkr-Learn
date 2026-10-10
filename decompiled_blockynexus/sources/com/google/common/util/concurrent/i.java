package com.google.common.util.concurrent;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import java.util.ArrayList;

/* JADX INFO: compiled from: CycleDetectingLockFactory.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends ThreadLocal<ArrayList<CycleDetectingLockFactory.a>> {
    i() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    public ArrayList<CycleDetectingLockFactory.a> initialValue() {
        return Lists.a(3);
    }
}
