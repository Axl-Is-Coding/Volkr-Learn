package d.b;

import java.security.PrivilegedAction;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes5.dex */
final class a implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f21435a;

    a(String str) {
        this.f21435a = str;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        return System.getProperty(this.f21435a, null);
    }
}
