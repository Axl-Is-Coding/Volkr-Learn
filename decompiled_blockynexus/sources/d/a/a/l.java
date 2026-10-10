package d.a.a;

/* JADX INFO: compiled from: JythonVersionAdapterHolder.java */
/* JADX INFO: loaded from: classes5.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final k f21427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static /* synthetic */ Class f21428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21429c;

    static {
        Class clsA;
        try {
            if (f21428b == null) {
                clsA = a("org.python.core.PySystemState");
                f21428b = clsA;
            } else {
                clsA = f21428b;
            }
            int iG = freemarker.template.utility.h.g(clsA.getField("version").get(null).toString());
            Class clsA2 = f21429c;
            if (clsA2 == null) {
                clsA2 = a("freemarker.ext.jython.JythonVersionAdapter");
                f21429c = clsA2;
            }
            ClassLoader classLoader = clsA2.getClassLoader();
            try {
                if (iG >= 2005000) {
                    f21427a = (k) classLoader.loadClass("freemarker.ext.jython._Jython25VersionAdapter").newInstance();
                } else if (iG >= 2002000) {
                    f21427a = (k) classLoader.loadClass("freemarker.ext.jython._Jython22VersionAdapter").newInstance();
                } else {
                    f21427a = (k) classLoader.loadClass("freemarker.ext.jython._Jython20And21VersionAdapter").newInstance();
                }
            } catch (ClassNotFoundException e2) {
                throw a(e2);
            } catch (IllegalAccessException e3) {
                throw a(e3);
            } catch (InstantiationException e4) {
                throw a(e4);
            }
        } catch (Exception e5) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Failed to get Jython version: ");
            stringBuffer.append(e5);
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private static RuntimeException a(Exception exc) {
        return new RuntimeException("Unexpected exception when creating JythonVersionAdapter", exc);
    }
}
