package freemarker.template.utility;

import java.security.AccessControlException;
import java.security.AccessController;

/* JADX INFO: compiled from: SecurityUtilities.java */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.b.b f21752a = d.b.b.d("freemarker.security");

    public static String a(String str, String str2) {
        try {
            return (String) AccessController.doPrivileged(new f(str, str2));
        } catch (AccessControlException unused) {
            d.b.b bVar = f21752a;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Insufficient permissions to read system property ");
            stringBuffer.append(h.f(str));
            stringBuffer.append(", using default value ");
            stringBuffer.append(h.f(str2));
            bVar.f(stringBuffer.toString());
            return str2;
        }
    }
}
