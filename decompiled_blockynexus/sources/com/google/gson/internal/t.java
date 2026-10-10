package com.google.gson.internal;

import java.util.Comparator;

/* JADX INFO: compiled from: LinkedTreeMap.java */
/* JADX INFO: loaded from: classes2.dex */
class t implements Comparator<Comparable> {
    t() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }
}
