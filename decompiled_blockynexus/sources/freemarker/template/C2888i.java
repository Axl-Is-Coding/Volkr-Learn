package freemarker.template;

import freemarker.ext.beans.AbstractC2868n;
import freemarker.ext.beans.C2867m;
import freemarker.ext.beans.ua;
import java.lang.ref.ReferenceQueue;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: freemarker.template.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultObjectWrapperBuilder.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2888i extends AbstractC2889j {
    private static final WeakHashMap j = new WeakHashMap();
    private static final ReferenceQueue k = new ReferenceQueue();

    /* JADX INFO: renamed from: freemarker.template.i$a */
    /* JADX INFO: compiled from: DefaultObjectWrapperBuilder.java */
    private static class a implements ua.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f21725a = new a();

        private a() {
        }

        @Override // freemarker.ext.beans.ua.a
        public C2867m a(AbstractC2868n abstractC2868n) {
            return new C2887h(abstractC2868n, true);
        }
    }

    public C2888i(Version version) {
        super(version);
    }

    public C2887h build() {
        return (C2887h) ua.a(this, j, k, a.f21725a);
    }
}
