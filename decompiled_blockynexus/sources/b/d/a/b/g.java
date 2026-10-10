package b.d.a.b;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    public static g a(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new a(cls.getSimpleName()) : new d(cls.getSimpleName());
    }

    public abstract void a(String str);
}
