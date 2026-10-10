package kotlin;

import kotlin.Result;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i {
    public static final Object a(Throwable th) {
        kotlin.jvm.internal.i.b(th, "exception");
        return new Result.Failure(th);
    }
}
