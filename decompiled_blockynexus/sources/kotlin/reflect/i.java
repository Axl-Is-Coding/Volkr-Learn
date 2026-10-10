package kotlin.reflect;

import kotlin.reflect.g;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface i<T, R> extends g<R>, kotlin.jvm.a.b<T, R> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface a<T, R> extends g.b<R>, kotlin.jvm.a.b<T, R> {
    }

    R get(T t);

    Object getDelegate(T t);

    /* JADX INFO: renamed from: getGetter */
    a<T, R> mo123getGetter();
}
