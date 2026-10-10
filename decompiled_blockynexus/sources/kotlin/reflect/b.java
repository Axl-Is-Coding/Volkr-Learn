package kotlin.reflect;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: KCallable.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface b<R> extends a {
    R call(Object... objArr);

    R callBy(Map<Object, ? extends Object> map);

    List<Object> getParameters();

    j getReturnType();

    List<Object> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
