package zlc.season.rxdownload4.manager;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: zlc.season.rxdownload4.manager.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BasicTaskLimitation.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class C2952a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile C2952a f23952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0280a f23953b = new C0280a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<H> f23954c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23956e;

    /* JADX INFO: renamed from: zlc.season.rxdownload4.manager.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BasicTaskLimitation.kt */
    public static final class C0280a {
        private C0280a() {
        }

        public static /* synthetic */ r a(C0280a c0280a, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 3;
            }
            return c0280a.a(i);
        }

        public /* synthetic */ C0280a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final r a(int i) {
            C2952a c2952a = C2952a.f23952a;
            if (c2952a == null) {
                synchronized (this) {
                    c2952a = C2952a.f23952a;
                    if (c2952a == null) {
                        c2952a = new C2952a(i);
                        C2952a.f23952a = c2952a;
                    }
                }
            }
            return c2952a;
        }
    }

    public C2952a(int i) {
        this.f23956e = i;
    }

    @Override // zlc.season.rxdownload4.manager.r
    public void b(final H h) {
        kotlin.jvm.internal.i.b(h, "taskManager");
        int i = this.f23955d;
        if (i >= this.f23956e) {
            this.f23954c.add(h);
            h.c();
        } else {
            this.f23955d = i + 1;
            h.d();
            final Object obj = new Object();
            h.a(obj, false, new kotlin.jvm.a.b<p, kotlin.l>() { // from class: zlc.season.rxdownload4.manager.BasicTaskLimitation$start$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.a.b
                public /* bridge */ /* synthetic */ kotlin.l invoke(p pVar) {
                    invoke2(pVar);
                    return kotlin.l.f22855a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(p pVar) {
                    kotlin.jvm.internal.i.b(pVar, "it");
                    if (q.a(pVar)) {
                        h.a(obj);
                        C2952a c2952a = this.this$0;
                        c2952a.f23955d--;
                        if (this.this$0.f23954c.size() > 0) {
                            this.this$0.b((H) this.this$0.f23954c.remove(0));
                        }
                    }
                }
            });
        }
    }

    @Override // zlc.season.rxdownload4.manager.r
    public void c(H h) {
        kotlin.jvm.internal.i.b(h, "taskManager");
        this.f23954c.remove(h);
        h.b();
    }

    @Override // zlc.season.rxdownload4.manager.r
    public void a(H h) {
        kotlin.jvm.internal.i.b(h, "taskManager");
        this.f23954c.remove(h);
        h.e();
    }
}
