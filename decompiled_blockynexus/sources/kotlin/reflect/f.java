package kotlin.reflect;

/* JADX INFO: compiled from: KFunction.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface f<R> extends b<R>, kotlin.c<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // kotlin.reflect.b
    boolean isSuspend();
}
