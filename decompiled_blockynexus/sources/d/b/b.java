package d.b;

import java.io.PrintStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f21436a = {null, "JUL", "org.apache.log.Logger", "Avalon", "org.apache.log4j.Logger", "Log4j", "org.apache.commons.logging.Log", "CommonsLogging", "org.slf4j.Logger", "SLF4J"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f21437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f21438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f21439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f21440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map f21441f;
    static /* synthetic */ Class g;
    static /* synthetic */ Class h;

    static {
        if (f21436a.length / 2 != 5) {
            throw new AssertionError();
        }
        f21440e = "";
        f21441f = new HashMap();
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private static c b(int i) throws ClassNotFoundException {
        String strC = c(i);
        if (strC == null) {
            if (i == 1) {
                return new d();
            }
            if (i == 0) {
                return new g();
            }
            throw new RuntimeException("Bug");
        }
        Class.forName(strC);
        String strD = d(i);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("freemarker.log._");
            stringBuffer.append(strD);
            stringBuffer.append("LoggerFactory");
            return (c) Class.forName(stringBuffer.toString()).newInstance();
        } catch (Exception e2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unexpected error when creating logger factory for \"");
            stringBuffer2.append(strD);
            stringBuffer2.append("\".");
            throw new RuntimeException(stringBuffer2.toString(), e2);
        }
    }

    private static String c(int i) {
        if (i == -1 || i == 0) {
            return null;
        }
        return f21436a[(i - 1) * 2];
    }

    private static String d(int i) {
        return i == -1 ? "auto" : i == 0 ? "none" : f21436a[((i - 1) * 2) + 1];
    }

    private static boolean e(int i) {
        return (i == -1 || i == 0 || i == 5 || i == 4) ? false : true;
    }

    private static synchronized void f(int i) throws ClassNotFoundException {
        f21438c = a(i);
        f21437b = i;
    }

    private static String g(String str) throws Throwable {
        try {
            return (String) AccessController.doPrivileged(new a(str));
        } catch (AccessControlException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Insufficient permissions to read system property \"");
            stringBuffer.append(str);
            stringBuffer.append("\".");
            h(stringBuffer.toString());
            return null;
        } catch (Throwable th) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Failed to read system property \"");
            stringBuffer2.append(str);
            stringBuffer2.append("\".");
            d(stringBuffer2.toString(), th);
            return null;
        }
    }

    private static void h(String str) throws Throwable {
        a(false, str, null);
    }

    public abstract void a(String str, Throwable th);

    public abstract boolean a();

    public abstract void b(String str);

    public abstract void b(String str, Throwable th);

    public abstract boolean b();

    public abstract void c(String str);

    public abstract void c(String str, Throwable th);

    public abstract boolean c();

    public abstract void e(String str);

    public abstract void f(String str);

    private static void a(boolean z) throws Throwable {
        RuntimeException runtimeException;
        if (f21438c != null) {
            return;
        }
        Class clsA = g;
        if (clsA == null) {
            clsA = a("freemarker.log.Logger");
            g = clsA;
        }
        synchronized (clsA) {
            if (f21438c != null) {
                return;
            }
            String strG = g("org.freemarker.loggerLibrary");
            int i = -1;
            boolean z2 = true;
            if (strG != null) {
                strG = strG.trim();
                int i2 = -1;
                boolean z3 = false;
                do {
                    if (strG.equalsIgnoreCase(d(i2))) {
                        z3 = true;
                    } else {
                        i2++;
                    }
                    if (i2 > 5) {
                        break;
                    }
                } while (!z3);
                if (!z3) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Ignored invalid \"org.freemarker.loggerLibrary\" system property value: \"");
                    stringBuffer.append(strG);
                    stringBuffer.append("\"");
                    h(stringBuffer.toString());
                    if (z) {
                        return;
                    }
                }
                if (z3) {
                    i = i2;
                }
            } else if (z) {
                return;
            }
            try {
                f(i);
                if (strG != null) {
                    f21439d = true;
                }
            } finally {
                if (z2) {
                    try {
                    } catch (ClassNotFoundException e2) {
                    }
                }
            }
        }
    }

    public static b d(String str) {
        b bVarA;
        if (f21440e.length() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(f21440e);
            stringBuffer.append(str);
            str = stringBuffer.toString();
        }
        synchronized (f21441f) {
            bVarA = (b) f21441f.get(str);
            if (bVarA == null) {
                a(false);
                bVarA = f21438c.a(str);
                f21441f.put(str, bVarA);
            }
        }
        return bVarA;
    }

    private static boolean d() {
        try {
            Class.forName(c(3));
            Class.forName(c(5));
            try {
                Class.forName("org.apache.log4j.FileAppender");
                return false;
            } catch (ClassNotFoundException unused) {
                return ((Boolean) Class.forName("d.b.e").getMethod("test", new Class[0]).invoke(null, new Object[0])).booleanValue();
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    private static void d(String str, Throwable th) throws Throwable {
        a(true, str, th);
    }

    private static c a(int i) throws Throwable {
        if (i == -1) {
            int i2 = 5;
            while (i2 >= -1) {
                if (e(i2)) {
                    if (i2 == 3 && d()) {
                        i2 = 5;
                    }
                    try {
                        return b(i2);
                    } catch (ClassNotFoundException unused) {
                        continue;
                    } catch (Throwable th) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Unexpected error when initializing logging for \"");
                        stringBuffer.append(d(i2));
                        stringBuffer.append("\".");
                        d(stringBuffer.toString(), th);
                    }
                }
                i2--;
            }
            h("Auto detecton couldn't set up any logger libraries; FreeMarker logging suppressed.");
            return new g();
        }
        return b(i);
    }

    private static void a(boolean z, String str, Throwable th) throws Throwable {
        boolean z2;
        Class clsA = g;
        if (clsA == null) {
            clsA = a("freemarker.log.Logger");
            g = clsA;
        }
        synchronized (clsA) {
            z2 = (f21438c == null || (f21438c instanceof g)) ? false : true;
        }
        if (z2) {
            try {
                b bVarD = d("freemarker.logger");
                if (z) {
                    bVarD.c(str);
                } else {
                    bVarD.f(str);
                }
            } catch (Throwable unused) {
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(z ? "ERROR" : "WARN");
        stringBuffer.append(" ");
        Class clsA2 = h;
        if (clsA2 == null) {
            clsA2 = a("freemarker.log.LoggerFactory");
            h = clsA2;
        }
        stringBuffer.append(clsA2.getName());
        stringBuffer.append(": ");
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
        if (th != null) {
            PrintStream printStream2 = System.err;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("\tException: ");
            stringBuffer2.append(a(th));
            printStream2.println(stringBuffer2.toString());
            while (th.getCause() != null) {
                th = th.getCause();
                PrintStream printStream3 = System.err;
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("\tCaused by: ");
                stringBuffer3.append(a(th));
                printStream3.println(stringBuffer3.toString());
            }
        }
    }

    private static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj.toString();
        } catch (Throwable unused) {
            return obj.getClass().getName();
        }
    }
}
