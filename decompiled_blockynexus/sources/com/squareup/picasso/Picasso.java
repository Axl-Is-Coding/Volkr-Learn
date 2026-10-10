package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.squareup.picasso.AbstractC2746a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public class Picasso {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Handler f19259a = new w(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile Picasso f19260b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f19261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f19262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f19263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<E> f19264f;
    final Context g;
    final q h;
    final InterfaceC2756k i;
    final H j;
    final Map<Object, AbstractC2746a> k;
    final Map<ImageView, ViewTreeObserverOnPreDrawListenerC2760o> l;
    final ReferenceQueue<Object> m;
    final Bitmap.Config n;
    boolean o;
    volatile boolean p;
    boolean q;

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);

        final int debugColor;

        LoadedFrom(int i) {
            this.debugColor = i;
        }
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f19265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Downloader f19266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ExecutorService f19267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private InterfaceC2756k f19268d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private c f19269e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d f19270f;
        private List<E> g;
        private Bitmap.Config h;
        private boolean i;
        private boolean j;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f19265a = context.getApplicationContext();
        }

        public Picasso a() {
            Context context = this.f19265a;
            if (this.f19266b == null) {
                this.f19266b = P.c(context);
            }
            if (this.f19268d == null) {
                this.f19268d = new t(context);
            }
            if (this.f19267c == null) {
                this.f19267c = new A();
            }
            if (this.f19270f == null) {
                this.f19270f = d.f19273a;
            }
            H h = new H(this.f19268d);
            return new Picasso(context, new q(context, this.f19267c, Picasso.f19259a, this.f19266b, this.f19268d, h), this.f19268d, this.f19269e, this.f19270f, this.g, h, this.h, this.i, this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ReferenceQueue<Object> f19271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f19272b;

        b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f19271a = referenceQueue;
            this.f19272b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    AbstractC2746a.C0167a c0167a = (AbstractC2746a.C0167a) this.f19271a.remove(1000L);
                    Message messageObtainMessage = this.f19272b.obtainMessage();
                    if (c0167a != null) {
                        messageObtainMessage.what = 3;
                        messageObtainMessage.obj = c0167a.f19280a;
                        this.f19272b.sendMessage(messageObtainMessage);
                    } else {
                        messageObtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    this.f19272b.post(new x(this, e2));
                    return;
                }
            }
        }
    }

    public interface c {
        void a(Picasso picasso, Uri uri, Exception exc);
    }

    public interface d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f19273a = new y();

        C a(C c2);
    }

    Picasso(Context context, q qVar, InterfaceC2756k interfaceC2756k, c cVar, d dVar, List<E> list, H h, Bitmap.Config config, boolean z, boolean z2) {
        this.g = context;
        this.h = qVar;
        this.i = interfaceC2756k;
        this.f19261c = cVar;
        this.f19262d = dVar;
        this.n = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new F(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new C2758m(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new C2759n(context));
        arrayList.add(new C2747b(context));
        arrayList.add(new r(context));
        arrayList.add(new NetworkRequestHandler(qVar.f19306d, h));
        this.f19264f = Collections.unmodifiableList(arrayList);
        this.j = h;
        this.k = new WeakHashMap();
        this.l = new WeakHashMap();
        this.o = z;
        this.p = z2;
        this.m = new ReferenceQueue<>();
        this.f19263e = new b(this.m, f19259a);
        this.f19263e.start();
    }

    Bitmap b(String str) {
        Bitmap bitmap = this.i.get(str);
        if (bitmap != null) {
            this.j.b();
        } else {
            this.j.c();
        }
        return bitmap;
    }

    void c(AbstractC2746a abstractC2746a) {
        this.h.b(abstractC2746a);
    }

    public void a(ImageView imageView) {
        a((Object) imageView);
    }

    public void a(J j) {
        a((Object) j);
    }

    public D a(Uri uri) {
        return new D(this, uri, 0);
    }

    void b(AbstractC2746a abstractC2746a) {
        Bitmap bitmapB = MemoryPolicy.shouldReadFromMemoryCache(abstractC2746a.f19278e) ? b(abstractC2746a.c()) : null;
        if (bitmapB != null) {
            a(bitmapB, LoadedFrom.MEMORY, abstractC2746a);
            if (this.p) {
                P.a("Main", "completed", abstractC2746a.f19275b.d(), "from " + LoadedFrom.MEMORY);
                return;
            }
            return;
        }
        a(abstractC2746a);
        if (this.p) {
            P.a("Main", "resumed", abstractC2746a.f19275b.d());
        }
    }

    public D a(String str) {
        if (str == null) {
            return new D(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    List<E> a() {
        return this.f19264f;
    }

    C a(C c2) {
        this.f19262d.a(c2);
        if (c2 != null) {
            return c2;
        }
        throw new IllegalStateException("Request transformer " + this.f19262d.getClass().getCanonicalName() + " returned null for " + c2);
    }

    void a(ImageView imageView, ViewTreeObserverOnPreDrawListenerC2760o viewTreeObserverOnPreDrawListenerC2760o) {
        this.l.put(imageView, viewTreeObserverOnPreDrawListenerC2760o);
    }

    void a(AbstractC2746a abstractC2746a) {
        Object objJ = abstractC2746a.j();
        if (objJ != null && this.k.get(objJ) != abstractC2746a) {
            a(objJ);
            this.k.put(objJ, abstractC2746a);
        }
        c(abstractC2746a);
    }

    void a(RunnableC2754i runnableC2754i) {
        AbstractC2746a abstractC2746aB = runnableC2754i.b();
        List<AbstractC2746a> listC = runnableC2754i.c();
        boolean z = true;
        boolean z2 = (listC == null || listC.isEmpty()) ? false : true;
        if (abstractC2746aB == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = runnableC2754i.d().f19213e;
            Exception excE = runnableC2754i.e();
            Bitmap bitmapK = runnableC2754i.k();
            LoadedFrom loadedFromG = runnableC2754i.g();
            if (abstractC2746aB != null) {
                a(bitmapK, loadedFromG, abstractC2746aB);
            }
            if (z2) {
                int size = listC.size();
                for (int i = 0; i < size; i++) {
                    a(bitmapK, loadedFromG, listC.get(i));
                }
            }
            c cVar = this.f19261c;
            if (cVar == null || excE == null) {
                return;
            }
            cVar.a(this, uri, excE);
        }
    }

    private void a(Bitmap bitmap, LoadedFrom loadedFrom, AbstractC2746a abstractC2746a) {
        if (abstractC2746a.k()) {
            return;
        }
        if (!abstractC2746a.l()) {
            this.k.remove(abstractC2746a.j());
        }
        if (bitmap == null) {
            abstractC2746a.b();
            if (this.p) {
                P.a("Main", "errored", abstractC2746a.f19275b.d());
                return;
            }
            return;
        }
        if (loadedFrom != null) {
            abstractC2746a.a(bitmap, loadedFrom);
            if (this.p) {
                P.a("Main", "completed", abstractC2746a.f19275b.d(), "from " + loadedFrom);
                return;
            }
            return;
        }
        throw new AssertionError("LoadedFrom cannot be null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        P.a();
        AbstractC2746a abstractC2746aRemove = this.k.remove(obj);
        if (abstractC2746aRemove != null) {
            abstractC2746aRemove.a();
            this.h.a(abstractC2746aRemove);
        }
        if (obj instanceof ImageView) {
            ViewTreeObserverOnPreDrawListenerC2760o viewTreeObserverOnPreDrawListenerC2760oRemove = this.l.remove((ImageView) obj);
            if (viewTreeObserverOnPreDrawListenerC2760oRemove != null) {
                viewTreeObserverOnPreDrawListenerC2760oRemove.a();
            }
        }
    }

    public static Picasso a(Context context) {
        if (f19260b == null) {
            synchronized (Picasso.class) {
                if (f19260b == null) {
                    f19260b = new a(context).a();
                }
            }
        }
        return f19260b;
    }
}
