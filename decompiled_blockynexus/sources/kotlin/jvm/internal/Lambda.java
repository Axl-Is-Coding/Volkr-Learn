package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: compiled from: Lambda.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Lambda<R> implements g<R>, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strA = k.a(this);
        i.a((Object) strA, "Reflection.renderLambdaToString(this)");
        return strA;
    }
}
