package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.e.n;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.request.target.Target;
import io.rong.message.ContactNotificationMessage;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class SingleRequest<R> implements d, com.bumptech.glide.request.target.h, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f4781a = Log.isLoggable(ContactNotificationMessage.CONTACT_OPERATION_REQUEST, 2);
    private int A;
    private int B;
    private boolean C;
    private RuntimeException D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.e.a.g f4783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f4784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e<R> f4785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RequestCoordinator f4786f;
    private final Context g;
    private final com.bumptech.glide.f h;
    private final Object i;
    private final Class<R> j;
    private final a<?> k;
    private final int l;
    private final int m;
    private final Priority n;
    private final Target<R> o;
    private final List<e<R>> p;
    private final com.bumptech.glide.request.a.c<? super R> q;
    private final Executor r;
    private C<R> s;
    private r.d t;
    private long u;
    private volatile r v;
    private Status w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, com.bumptech.glide.f fVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i, int i2, Priority priority, Target<R> target, e<R> eVar, List<e<R>> list, RequestCoordinator requestCoordinator, r rVar, com.bumptech.glide.request.a.c<? super R> cVar, Executor executor) {
        this.f4782b = f4781a ? String.valueOf(super.hashCode()) : null;
        this.f4783c = com.bumptech.glide.e.a.g.a();
        this.f4784d = obj;
        this.g = context;
        this.h = fVar;
        this.i = obj2;
        this.j = cls;
        this.k = aVar;
        this.l = i;
        this.m = i2;
        this.n = priority;
        this.o = target;
        this.f4785e = eVar;
        this.p = list;
        this.f4786f = requestCoordinator;
        this.v = rVar;
        this.q = cVar;
        this.r = executor;
        this.w = Status.PENDING;
        if (this.D == null && fVar.g()) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    public static <R> SingleRequest<R> a(Context context, com.bumptech.glide.f fVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i, int i2, Priority priority, Target<R> target, e<R> eVar, List<e<R>> list, RequestCoordinator requestCoordinator, r rVar, com.bumptech.glide.request.a.c<? super R> cVar, Executor executor) {
        return new SingleRequest<>(context, fVar, obj, obj2, cls, aVar, i, i2, priority, target, eVar, list, requestCoordinator, rVar, cVar, executor);
    }

    private void d() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean e() {
        RequestCoordinator requestCoordinator = this.f4786f;
        return requestCoordinator == null || requestCoordinator.f(this);
    }

    private boolean f() {
        RequestCoordinator requestCoordinator = this.f4786f;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean g() {
        RequestCoordinator requestCoordinator = this.f4786f;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    private void h() {
        d();
        this.f4783c.b();
        this.o.removeCallback(this);
        r.d dVar = this.t;
        if (dVar != null) {
            dVar.a();
            this.t = null;
        }
    }

    private Drawable i() {
        if (this.x == null) {
            this.x = this.k.getErrorPlaceholder();
            if (this.x == null && this.k.getErrorId() > 0) {
                this.x = a(this.k.getErrorId());
            }
        }
        return this.x;
    }

    private Drawable j() {
        if (this.z == null) {
            this.z = this.k.getFallbackDrawable();
            if (this.z == null && this.k.getFallbackId() > 0) {
                this.z = a(this.k.getFallbackId());
            }
        }
        return this.z;
    }

    private Drawable k() {
        if (this.y == null) {
            this.y = this.k.getPlaceholderDrawable();
            if (this.y == null && this.k.getPlaceholderId() > 0) {
                this.y = a(this.k.getPlaceholderId());
            }
        }
        return this.y;
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f4786f;
        return requestCoordinator == null || !requestCoordinator.getRoot().a();
    }

    private void m() {
        RequestCoordinator requestCoordinator = this.f4786f;
        if (requestCoordinator != null) {
            requestCoordinator.d(this);
        }
    }

    private void n() {
        RequestCoordinator requestCoordinator = this.f4786f;
        if (requestCoordinator != null) {
            requestCoordinator.e(this);
        }
    }

    private void o() {
        if (f()) {
            Drawable drawableJ = this.i == null ? j() : null;
            if (drawableJ == null) {
                drawableJ = i();
            }
            if (drawableJ == null) {
                drawableJ = k();
            }
            this.o.onLoadFailed(drawableJ);
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean b() {
        boolean z;
        synchronized (this.f4784d) {
            z = this.w == Status.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public void begin() {
        synchronized (this.f4784d) {
            d();
            this.f4783c.b();
            this.u = com.bumptech.glide.e.h.a();
            if (this.i == null) {
                if (n.b(this.l, this.m)) {
                    this.A = this.l;
                    this.B = this.m;
                }
                a(new GlideException("Received null model"), j() == null ? 5 : 3);
                return;
            }
            if (this.w == Status.RUNNING) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (this.w == Status.COMPLETE) {
                a((C<?>) this.s, DataSource.MEMORY_CACHE);
                return;
            }
            this.w = Status.WAITING_FOR_SIZE;
            if (n.b(this.l, this.m)) {
                a(this.l, this.m);
            } else {
                this.o.getSize(this);
            }
            if ((this.w == Status.RUNNING || this.w == Status.WAITING_FOR_SIZE) && f()) {
                this.o.onLoadStarted(k());
            }
            if (f4781a) {
                a("finished run method in " + com.bumptech.glide.e.h.a(this.u));
            }
        }
    }

    @Override // com.bumptech.glide.request.g
    public Object c() {
        this.f4783c.b();
        return this.f4784d;
    }

    @Override // com.bumptech.glide.request.d
    public void clear() {
        C<R> c2;
        synchronized (this.f4784d) {
            d();
            this.f4783c.b();
            if (this.w == Status.CLEARED) {
                return;
            }
            h();
            if (this.s != null) {
                c2 = this.s;
                this.s = null;
            } else {
                c2 = null;
            }
            if (e()) {
                this.o.onLoadCleared(k());
            }
            this.w = Status.CLEARED;
            if (c2 != null) {
                this.v.b((C<?>) c2);
            }
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean isComplete() {
        boolean z;
        synchronized (this.f4784d) {
            z = this.w == Status.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f4784d) {
            z = this.w == Status.RUNNING || this.w == Status.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public void pause() {
        synchronized (this.f4784d) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean a() {
        boolean z;
        synchronized (this.f4784d) {
            z = this.w == Status.COMPLETE;
        }
        return z;
    }

    private Drawable a(int i) {
        return com.bumptech.glide.load.b.b.a.a(this.h, i, this.k.getTheme() != null ? this.k.getTheme() : this.g.getTheme());
    }

    @Override // com.bumptech.glide.request.target.h
    public void a(int i, int i2) throws Throwable {
        Object obj;
        this.f4783c.b();
        Object obj2 = this.f4784d;
        synchronized (obj2) {
            try {
                try {
                    if (f4781a) {
                        a("Got onSizeReady in " + com.bumptech.glide.e.h.a(this.u));
                    }
                    if (this.w == Status.WAITING_FOR_SIZE) {
                        this.w = Status.RUNNING;
                        float sizeMultiplier = this.k.getSizeMultiplier();
                        this.A = a(i, sizeMultiplier);
                        this.B = a(i2, sizeMultiplier);
                        if (f4781a) {
                            a("finished setup for calling load in " + com.bumptech.glide.e.h.a(this.u));
                        }
                        obj = obj2;
                        try {
                            this.t = this.v.a(this.h, this.i, this.k.getSignature(), this.A, this.B, this.k.getResourceClass(), this.j, this.n, this.k.getDiskCacheStrategy(), this.k.getTransformations(), this.k.isTransformationRequired(), this.k.isScaleOnlyOrNoTransform(), this.k.getOptions(), this.k.isMemoryCacheable(), this.k.getUseUnlimitedSourceGeneratorsPool(), this.k.getUseAnimationPool(), this.k.getOnlyRetrieveFromCache(), this, this.r);
                            if (this.w != Status.RUNNING) {
                                this.t = null;
                            }
                            if (f4781a) {
                                a("finished onSizeReady in " + com.bumptech.glide.e.h.a(this.u));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    private static int a(int i, float f2) {
        return i == Integer.MIN_VALUE ? i : Math.round(f2 * i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r6 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        r5.v.b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00aa, code lost:
    
        if (r6 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
    
        r5.v.b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.bumptech.glide.load.engine.C<?> r6, com.bumptech.glide.load.DataSource r7) throws java.lang.Throwable {
        /*
            r5 = this;
            com.bumptech.glide.e.a.g r0 = r5.f4783c
            r0.b()
            r0 = 0
            java.lang.Object r1 = r5.f4784d     // Catch: java.lang.Throwable -> Lbc
            monitor-enter(r1)     // Catch: java.lang.Throwable -> Lbc
            r5.t = r0     // Catch: java.lang.Throwable -> Lb2
            if (r6 != 0) goto L2f
            com.bumptech.glide.load.engine.GlideException r6 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r7.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = "Expected to receive a Resource<R> with an object of "
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class<R> r2 = r5.j     // Catch: java.lang.Throwable -> Lb2
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = " inside, but instead got null."
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lb2
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lb2
            r5.a(r6)     // Catch: java.lang.Throwable -> Lb2
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb2
            return
        L2f:
            java.lang.Object r2 = r6.get()     // Catch: java.lang.Throwable -> Lb2
            if (r2 == 0) goto L5c
            java.lang.Class<R> r3 = r5.j     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class r4 = r2.getClass()     // Catch: java.lang.Throwable -> Lb2
            boolean r3 = r3.isAssignableFrom(r4)     // Catch: java.lang.Throwable -> Lb2
            if (r3 != 0) goto L42
            goto L5c
        L42:
            boolean r3 = r5.g()     // Catch: java.lang.Throwable -> Lb2
            if (r3 != 0) goto L57
            r5.s = r0     // Catch: java.lang.Throwable -> Lba
            com.bumptech.glide.request.SingleRequest$Status r7 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch: java.lang.Throwable -> Lba
            r5.w = r7     // Catch: java.lang.Throwable -> Lba
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lba
            if (r6 == 0) goto L56
            com.bumptech.glide.load.engine.r r7 = r5.v
            r7.b(r6)
        L56:
            return
        L57:
            r5.a(r6, r2, r7)     // Catch: java.lang.Throwable -> Lb2
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb2
            return
        L5c:
            r5.s = r0     // Catch: java.lang.Throwable -> Lba
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lba
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lba
            r0.<init>()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r3 = "Expected to receive an object of "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lba
            java.lang.Class<R> r3 = r5.j     // Catch: java.lang.Throwable -> Lba
            r0.append(r3)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r3 = " but instead got "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lba
            if (r2 == 0) goto L7b
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Throwable -> Lba
            goto L7d
        L7b:
            java.lang.String r3 = ""
        L7d:
            r0.append(r3)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r3 = "{"
            r0.append(r3)     // Catch: java.lang.Throwable -> Lba
            r0.append(r2)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r3 = "} inside Resource{"
            r0.append(r3)     // Catch: java.lang.Throwable -> Lba
            r0.append(r6)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r3 = "}."
            r0.append(r3)     // Catch: java.lang.Throwable -> Lba
            if (r2 == 0) goto L9a
            java.lang.String r2 = ""
            goto L9c
        L9a:
            java.lang.String r2 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L9c:
            r0.append(r2)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lba
            r7.<init>(r0)     // Catch: java.lang.Throwable -> Lba
            r5.a(r7)     // Catch: java.lang.Throwable -> Lba
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lba
            if (r6 == 0) goto Lb1
            com.bumptech.glide.load.engine.r r7 = r5.v
            r7.b(r6)
        Lb1:
            return
        Lb2:
            r6 = move-exception
            r7 = r6
            r6 = r0
        Lb5:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lba
            throw r7     // Catch: java.lang.Throwable -> Lb7
        Lb7:
            r7 = move-exception
            r0 = r6
            goto Lbd
        Lba:
            r7 = move-exception
            goto Lb5
        Lbc:
            r7 = move-exception
        Lbd:
            if (r0 == 0) goto Lc4
            com.bumptech.glide.load.engine.r r6 = r5.v
            r6.b(r0)
        Lc4:
            goto Lc6
        Lc5:
            throw r7
        Lc6:
            goto Lc5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.a(com.bumptech.glide.load.engine.C, com.bumptech.glide.load.DataSource):void");
    }

    private void a(C<R> c2, R r, DataSource dataSource) {
        boolean zOnResourceReady;
        boolean zL = l();
        this.w = Status.COMPLETE;
        this.s = c2;
        if (this.h.e() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.i + " with size [" + this.A + "x" + this.B + "] in " + com.bumptech.glide.e.h.a(this.u) + " ms");
        }
        boolean z = true;
        this.C = true;
        try {
            if (this.p != null) {
                Iterator<e<R>> it = this.p.iterator();
                zOnResourceReady = false;
                while (it.hasNext()) {
                    zOnResourceReady |= it.next().onResourceReady(r, this.i, this.o, dataSource, zL);
                }
            } else {
                zOnResourceReady = false;
            }
            if (this.f4785e == null || !this.f4785e.onResourceReady(r, this.i, this.o, dataSource, zL)) {
                z = false;
            }
            if (!(z | zOnResourceReady)) {
                this.o.onResourceReady(r, this.q.a(dataSource, zL));
            }
            this.C = false;
            n();
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.g
    public void a(GlideException glideException) {
        a(glideException, 5);
    }

    private void a(GlideException glideException, int i) {
        boolean zOnLoadFailed;
        this.f4783c.b();
        synchronized (this.f4784d) {
            glideException.setOrigin(this.D);
            int iE = this.h.e();
            if (iE <= i) {
                Log.w("Glide", "Load failed for " + this.i + " with size [" + this.A + "x" + this.B + "]", glideException);
                if (iE <= 4) {
                    glideException.logRootCauses("Glide");
                }
            }
            this.t = null;
            this.w = Status.FAILED;
            boolean z = true;
            this.C = true;
            try {
                if (this.p != null) {
                    Iterator<e<R>> it = this.p.iterator();
                    zOnLoadFailed = false;
                    while (it.hasNext()) {
                        zOnLoadFailed |= it.next().onLoadFailed(glideException, this.i, this.o, l());
                    }
                } else {
                    zOnLoadFailed = false;
                }
                if (this.f4785e == null || !this.f4785e.onLoadFailed(glideException, this.i, this.o, l())) {
                    z = false;
                }
                if (!(zOnLoadFailed | z)) {
                    o();
                }
                this.C = false;
                m();
            } catch (Throwable th) {
                this.C = false;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean a(d dVar) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        Priority priority;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        Priority priority2;
        int size2;
        if (!(dVar instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f4784d) {
            i = this.l;
            i2 = this.m;
            obj = this.i;
            cls = this.j;
            aVar = this.k;
            priority = this.n;
            size = this.p != null ? this.p.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) dVar;
        synchronized (singleRequest.f4784d) {
            i3 = singleRequest.l;
            i4 = singleRequest.m;
            obj2 = singleRequest.i;
            cls2 = singleRequest.j;
            aVar2 = singleRequest.k;
            priority2 = singleRequest.n;
            size2 = singleRequest.p != null ? singleRequest.p.size() : 0;
        }
        return i == i3 && i2 == i4 && n.a(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && priority == priority2 && size == size2;
    }

    private void a(String str) {
        Log.v(ContactNotificationMessage.CONTACT_OPERATION_REQUEST, str + " this: " + this.f4782b);
    }
}
