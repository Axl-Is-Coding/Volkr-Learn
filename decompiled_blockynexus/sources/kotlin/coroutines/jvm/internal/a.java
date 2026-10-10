package kotlin.coroutines.jvm.internal;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements kotlin.b.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22817a = new a();

    private a() {
    }

    @Override // kotlin.b.a
    public kotlin.b.c getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // kotlin.b.a
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
