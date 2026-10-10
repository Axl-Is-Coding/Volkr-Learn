package androidx.loader.app;

import a.a.j;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.C0344r;
import androidx.lifecycle.g;
import androidx.lifecycle.m;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.loader.app.a;
import androidx.loader.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
class LoaderManagerImpl extends androidx.loader.app.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f1613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f1614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f1615c;

    static class a<D> implements n<D> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c<D> f1616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a.InterfaceC0024a<D> f1617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1618c = false;

        a(c<D> cVar, a.InterfaceC0024a<D> interfaceC0024a) {
            this.f1616a = cVar;
            this.f1617b = interfaceC0024a;
        }

        boolean a() {
            return this.f1618c;
        }

        void b() {
            if (this.f1618c) {
                if (LoaderManagerImpl.f1613a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f1616a);
                }
                this.f1617b.onLoaderReset(this.f1616a);
            }
        }

        @Override // androidx.lifecycle.n
        public void c(D d2) {
            if (LoaderManagerImpl.f1613a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f1616a + ": " + this.f1616a.dataToString(d2));
            }
            this.f1617b.onLoadFinished(this.f1616a, d2);
            this.f1618c = true;
        }

        public String toString() {
            return this.f1617b.toString();
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f1618c);
        }
    }

    static class b extends p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final q.a f1619c = new androidx.loader.app.b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private j<LoaderInfo> f1620d = new j<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1621e = false;

        b() {
        }

        static b a(C0344r c0344r) {
            return (b) new q(c0344r, f1619c).a(b.class);
        }

        @Override // androidx.lifecycle.p
        protected void b() {
            super.b();
            int iC = this.f1620d.c();
            for (int i = 0; i < iC; i++) {
                this.f1620d.e(i).a(true);
            }
            this.f1620d.b();
        }

        void c() {
            this.f1621e = false;
        }

        boolean d() {
            return this.f1621e;
        }

        void e() {
            int iC = this.f1620d.c();
            for (int i = 0; i < iC; i++) {
                this.f1620d.e(i).f();
            }
        }

        void f() {
            this.f1621e = true;
        }

        void a(int i, LoaderInfo loaderInfo) {
            this.f1620d.c(i, loaderInfo);
        }

        <D> LoaderInfo<D> a(int i) {
            return this.f1620d.a(i);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f1620d.c() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f1620d.c(); i++) {
                    LoaderInfo loaderInfoE = this.f1620d.e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f1620d.c(i));
                    printWriter.print(": ");
                    printWriter.println(loaderInfoE.toString());
                    loaderInfoE.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    LoaderManagerImpl(g gVar, C0344r c0344r) {
        this.f1614b = gVar;
        this.f1615c = b.a(c0344r);
    }

    private <D> c<D> a(int i, Bundle bundle, a.InterfaceC0024a<D> interfaceC0024a, c<D> cVar) {
        try {
            this.f1615c.f();
            c<D> cVarOnCreateLoader = interfaceC0024a.onCreateLoader(i, bundle);
            if (cVarOnCreateLoader == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (cVarOnCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(cVarOnCreateLoader.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + cVarOnCreateLoader);
            }
            LoaderInfo loaderInfo = new LoaderInfo(i, bundle, cVarOnCreateLoader, cVar);
            if (f1613a) {
                Log.v("LoaderManager", "  Created new loader " + loaderInfo);
            }
            this.f1615c.a(i, loaderInfo);
            this.f1615c.c();
            return loaderInfo.setCallback(this.f1614b, interfaceC0024a);
        } catch (Throwable th) {
            this.f1615c.c();
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.f.a.a(this.f1614b, sb);
        sb.append("}}");
        return sb.toString();
    }

    public static class LoaderInfo<D> extends m<D> implements c.InterfaceC0026c<D> {
        private final int k;
        private final Bundle l;
        private final c<D> m;
        private g n;
        private a<D> o;
        private c<D> p;

        LoaderInfo(int i, Bundle bundle, c<D> cVar, c<D> cVar2) {
            this.k = i;
            this.l = bundle;
            this.m = cVar;
            this.p = cVar2;
            this.m.registerListener(i, this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void a(n<? super D> nVar) {
            super.a((n) nVar);
            this.n = null;
            this.o = null;
        }

        @Override // androidx.lifecycle.m, androidx.lifecycle.LiveData
        public void b(D d2) {
            super.b(d2);
            c<D> cVar = this.p;
            if (cVar != null) {
                cVar.reset();
                this.p = null;
            }
        }

        @Override // androidx.lifecycle.LiveData
        protected void c() {
            if (LoaderManagerImpl.f1613a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.m.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        protected void d() {
            if (LoaderManagerImpl.f1613a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.m.stopLoading();
        }

        c<D> e() {
            return this.m;
        }

        void f() {
            g gVar = this.n;
            a<D> aVar = this.o;
            if (gVar == null || aVar == null) {
                return;
            }
            super.a((n) aVar);
            a(gVar, aVar);
        }

        c<D> setCallback(g gVar, a.InterfaceC0024a<D> interfaceC0024a) {
            a<D> aVar = new a<>(this.m, interfaceC0024a);
            a(gVar, aVar);
            a<D> aVar2 = this.o;
            if (aVar2 != null) {
                a((n) aVar2);
            }
            this.n = gVar;
            this.o = aVar;
            return this.m;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.k);
            sb.append(" : ");
            androidx.core.f.a.a(this.m, sb);
            sb.append("}}");
            return sb.toString();
        }

        c<D> a(boolean z) {
            if (LoaderManagerImpl.f1613a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.m.cancelLoad();
            this.m.abandon();
            a<D> aVar = this.o;
            if (aVar != null) {
                a((n) aVar);
                if (z) {
                    aVar.b();
                }
            }
            this.m.unregisterListener(this);
            if ((aVar != null && !aVar.a()) || z) {
                this.m.reset();
                return this.p;
            }
            return this.m;
        }

        @Override // androidx.loader.content.c.InterfaceC0026c
        public void a(c<D> cVar, D d2) {
            if (LoaderManagerImpl.f1613a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b(d2);
                return;
            }
            if (LoaderManagerImpl.f1613a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            a(d2);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.k);
            printWriter.print(" mArgs=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.m);
            this.m.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.o != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.o);
                this.o.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().dataToString(a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(b());
        }
    }

    @Override // androidx.loader.app.a
    public <D> c<D> a(int i, Bundle bundle, a.InterfaceC0024a<D> interfaceC0024a) {
        if (!this.f1615c.d()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                LoaderInfo<D> loaderInfoA = this.f1615c.a(i);
                if (f1613a) {
                    Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
                }
                if (loaderInfoA == null) {
                    return a(i, bundle, interfaceC0024a, (c) null);
                }
                if (f1613a) {
                    Log.v("LoaderManager", "  Re-using existing loader " + loaderInfoA);
                }
                return loaderInfoA.setCallback(this.f1614b, interfaceC0024a);
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.a
    public void a() {
        this.f1615c.e();
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f1615c.a(str, fileDescriptor, printWriter, strArr);
    }
}
