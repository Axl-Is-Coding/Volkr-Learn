package b.d.a;

import org.aspectj.lang.NoAspectBoundException;

/* JADX INFO: compiled from: RequiresParseDetailAspect.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static /* synthetic */ Throwable f2541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ g f2542b = null;

    static {
        try {
            b();
        } catch (Throwable th) {
            f2541a = th;
        }
    }

    public static g a() {
        g gVar = f2542b;
        if (gVar != null) {
            return gVar;
        }
        throw new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", f2541a);
    }

    private static /* synthetic */ void b() {
        f2542b = new g();
    }

    public void a(org.aspectj.lang.a aVar) {
        if (aVar.getTarget() instanceof a) {
            if (((a) aVar.getTarget()).d()) {
                return;
            }
            ((a) aVar.getTarget()).e();
        } else {
            throw new RuntimeException("Only methods in subclasses of " + a.class.getName() + " can  be annotated with ParseDetail");
        }
    }
}
