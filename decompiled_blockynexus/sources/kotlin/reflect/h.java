package kotlin.reflect;

import kotlin.reflect.g;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface h<R> extends g<R>, kotlin.jvm.a.a<R> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface a<R> extends g.b<R>, kotlin.jvm.a.a<R> {
    }

    R get();

    Object getDelegate();

    /* JADX INFO: renamed from: getGetter */
    a<R> mo122getGetter();
}
