package d.b;

/* JADX INFO: compiled from: _Log4jOverSLF4JTester.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static /* synthetic */ Class f21443b;

    static {
        Class clsA = f21443b;
        if (clsA == null) {
            clsA = a("freemarker.log._Log4jOverSLF4JTester");
            f21443b = clsA;
        }
        f21442a = clsA.getName();
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
