package freemarker.core;

/* JADX INFO: compiled from: _DelayedConversionToString.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21520a = new String();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f21521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f21522c = f21520a;

    public ec(Object obj) {
        this.f21521b = obj;
    }

    protected abstract String a(Object obj);

    public synchronized String toString() {
        if (this.f21522c == f21520a) {
            this.f21522c = a(this.f21521b);
            this.f21521b = null;
        }
        return this.f21522c;
    }
}
