package io.reactivex.subjects;

import io.reactivex.p;
import io.reactivex.w;

/* JADX INFO: compiled from: Subject.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T> extends p<T> implements w<T> {
    public final b<T> b() {
        return this instanceof a ? this : new a(this);
    }
}
