package freemarker.core;

/* JADX INFO: compiled from: NewBI.java */
/* JADX INFO: loaded from: classes5.dex */
class Pb extends AbstractC2781b {
    static final Class i;
    static Class j;
    static /* synthetic */ Class k;

    static {
        Class clsA = k;
        if (clsA == null) {
            clsA = a("freemarker.ext.beans.BeanModel");
            k = clsA;
        }
        i = clsA;
        try {
            j = Class.forName("d.a.a.d");
        } catch (Throwable unused) {
            j = null;
        }
    }

    Pb() {
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
