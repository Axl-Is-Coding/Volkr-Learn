package freemarker.template.utility;

import java.security.PrivilegedAction;

/* JADX INFO: compiled from: SecurityUtilities.java */
/* JADX INFO: loaded from: classes5.dex */
final class f implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f21750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f21751b;

    f(String str, String str2) {
        this.f21750a = str;
        this.f21751b = str2;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        return System.getProperty(this.f21750a, this.f21751b);
    }
}
