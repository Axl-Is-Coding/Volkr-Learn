package io.reactivex.processors;

import io.reactivex.e;
import io.reactivex.h;

/* JADX INFO: compiled from: FlowableProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> extends e<T> implements f.b.a<T, T>, h<T> {
    public final a<T> h() {
        return this instanceof b ? this : new b(this);
    }
}
