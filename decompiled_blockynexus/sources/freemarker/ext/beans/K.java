package freemarker.ext.beans;

import java.lang.ref.WeakReference;
import org.zeroturnaround.javarebel.ClassEventListener;
import org.zeroturnaround.javarebel.ReloaderFactory;

/* JADX INFO: compiled from: JRebelClassChangeNotifier.java */
/* JADX INFO: loaded from: classes5.dex */
class K implements InterfaceC2873t {

    /* JADX INFO: compiled from: JRebelClassChangeNotifier.java */
    private static class a implements ClassEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f21548a;

        a(C2874u c2874u) {
            this.f21548a = new WeakReference(c2874u);
        }

        public void onClassEvent(int i, Class cls) {
            C2874u c2874u = (C2874u) this.f21548a.get();
            if (c2874u == null) {
                ReloaderFactory.getInstance().removeClassReloadListener(this);
            } else if (i == 1) {
                c2874u.d(cls);
            }
        }
    }

    K() {
    }

    @Override // freemarker.ext.beans.InterfaceC2873t
    public void a(C2874u c2874u) {
        ReloaderFactory.getInstance().addClassReloadListener(new a(c2874u));
    }
}
