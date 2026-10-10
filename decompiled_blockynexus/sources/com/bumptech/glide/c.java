package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.A;
import com.bumptech.glide.load.a.B;
import com.bumptech.glide.load.a.C;
import com.bumptech.glide.load.a.C0486a;
import com.bumptech.glide.load.a.C0488c;
import com.bumptech.glide.load.a.C0490e;
import com.bumptech.glide.load.a.D;
import com.bumptech.glide.load.a.E;
import com.bumptech.glide.load.a.a.a;
import com.bumptech.glide.load.a.a.b;
import com.bumptech.glide.load.a.a.c;
import com.bumptech.glide.load.a.a.d;
import com.bumptech.glide.load.a.a.e;
import com.bumptech.glide.load.a.a.f;
import com.bumptech.glide.load.a.f;
import com.bumptech.glide.load.a.g;
import com.bumptech.glide.load.a.i;
import com.bumptech.glide.load.a.q;
import com.bumptech.glide.load.a.z;
import com.bumptech.glide.load.b.a.a;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.l;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.n;
import com.bumptech.glide.load.resource.bitmap.C0499a;
import com.bumptech.glide.load.resource.bitmap.C0500b;
import com.bumptech.glide.load.resource.bitmap.C0501c;
import com.bumptech.glide.load.resource.bitmap.D;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.load.resource.bitmap.u;
import com.bumptech.glide.load.resource.bitmap.w;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.bitmap.y;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.request.target.Target;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Glide.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f4113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f4114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r f4115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f4116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b.i f4117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f f4118f;
    private final Registry g;
    private final com.bumptech.glide.load.engine.a.b h;
    private final m i;
    private final com.bumptech.glide.manager.d j;
    private final a l;
    private final List<k> k = new ArrayList();
    private MemoryCategory m = MemoryCategory.NORMAL;

    /* JADX INFO: compiled from: Glide.java */
    public interface a {
        com.bumptech.glide.request.f build();
    }

    c(Context context, r rVar, com.bumptech.glide.load.engine.b.i iVar, com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar, m mVar, com.bumptech.glide.manager.d dVar, int i, a aVar, Map<Class<?>, l<?, ?>> map, List<com.bumptech.glide.request.e<Object>> list, boolean z, boolean z2) {
        com.bumptech.glide.load.m gVar;
        com.bumptech.glide.load.m yVar;
        com.bumptech.glide.load.b.b.d dVar2;
        this.f4115c = rVar;
        this.f4116d = eVar;
        this.h = bVar;
        this.f4117e = iVar;
        this.i = mVar;
        this.j = dVar;
        this.l = aVar;
        Resources resources = context.getResources();
        this.g = new Registry();
        this.g.a((ImageHeaderParser) new DefaultImageHeaderParser());
        if (Build.VERSION.SDK_INT >= 27) {
            this.g.a((ImageHeaderParser) new q());
        }
        List<ImageHeaderParser> listA = this.g.a();
        com.bumptech.glide.load.resource.gif.a aVar2 = new com.bumptech.glide.load.resource.gif.a(context, listA, eVar, bVar);
        com.bumptech.glide.load.m<ParcelFileDescriptor, Bitmap> mVarC = D.c(eVar);
        com.bumptech.glide.load.resource.bitmap.m mVar2 = new com.bumptech.glide.load.resource.bitmap.m(this.g.a(), resources.getDisplayMetrics(), eVar, bVar);
        if (!z2 || Build.VERSION.SDK_INT < 28) {
            gVar = new com.bumptech.glide.load.resource.bitmap.g(mVar2);
            yVar = new y(mVar2, bVar);
        } else {
            yVar = new u();
            gVar = new com.bumptech.glide.load.resource.bitmap.h();
        }
        com.bumptech.glide.load.b.b.d dVar3 = new com.bumptech.glide.load.b.b.d(context);
        z.c cVar = new z.c(resources);
        z.d dVar4 = new z.d(resources);
        z.b bVar2 = new z.b(resources);
        z.a aVar3 = new z.a(resources);
        C0501c c0501c = new C0501c(bVar);
        com.bumptech.glide.load.b.d.a aVar4 = new com.bumptech.glide.load.b.d.a();
        com.bumptech.glide.load.b.d.d dVar5 = new com.bumptech.glide.load.b.d.d();
        ContentResolver contentResolver = context.getContentResolver();
        Registry registry = this.g;
        registry.a(ByteBuffer.class, new C0490e());
        registry.a(InputStream.class, new A(bVar));
        registry.a("Bitmap", ByteBuffer.class, Bitmap.class, gVar);
        registry.a("Bitmap", InputStream.class, Bitmap.class, yVar);
        if (ParcelFileDescriptorRewinder.c()) {
            dVar2 = dVar3;
            this.g.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new w(mVar2));
        } else {
            dVar2 = dVar3;
        }
        Registry registry2 = this.g;
        registry2.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, mVarC);
        registry2.a("Bitmap", AssetFileDescriptor.class, Bitmap.class, D.a(eVar));
        registry2.a(Bitmap.class, Bitmap.class, C.a.a());
        registry2.a("Bitmap", Bitmap.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.A());
        registry2.a(Bitmap.class, (n) c0501c);
        registry2.a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new C0499a(resources, gVar));
        registry2.a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new C0499a(resources, yVar));
        registry2.a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new C0499a(resources, mVarC));
        registry2.a(BitmapDrawable.class, (n) new C0500b(eVar, c0501c));
        registry2.a("Gif", InputStream.class, GifDrawable.class, new com.bumptech.glide.load.resource.gif.h(listA, aVar2, bVar));
        registry2.a("Gif", ByteBuffer.class, GifDrawable.class, aVar2);
        registry2.a(GifDrawable.class, (n) new com.bumptech.glide.load.resource.gif.c());
        registry2.a(com.bumptech.glide.gifdecoder.a.class, com.bumptech.glide.gifdecoder.a.class, C.a.a());
        registry2.a("Bitmap", com.bumptech.glide.gifdecoder.a.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.f(eVar));
        com.bumptech.glide.load.b.b.d dVar6 = dVar2;
        registry2.a(Uri.class, Drawable.class, dVar6);
        registry2.a(Uri.class, Bitmap.class, new x(dVar6, eVar));
        registry2.a((e.a<?>) new a.C0060a());
        registry2.a(File.class, ByteBuffer.class, new f.b());
        registry2.a(File.class, InputStream.class, new i.e());
        registry2.a(File.class, File.class, new com.bumptech.glide.load.b.c.a());
        registry2.a(File.class, ParcelFileDescriptor.class, new i.b());
        registry2.a(File.class, File.class, C.a.a());
        registry2.a((e.a<?>) new l.a(bVar));
        if (ParcelFileDescriptorRewinder.c()) {
            this.g.a((e.a<?>) new ParcelFileDescriptorRewinder.a());
        }
        Registry registry3 = this.g;
        registry3.a(Integer.TYPE, InputStream.class, cVar);
        registry3.a(Integer.TYPE, ParcelFileDescriptor.class, bVar2);
        registry3.a(Integer.class, InputStream.class, cVar);
        registry3.a(Integer.class, ParcelFileDescriptor.class, bVar2);
        registry3.a(Integer.class, Uri.class, dVar4);
        registry3.a(Integer.TYPE, AssetFileDescriptor.class, aVar3);
        registry3.a(Integer.class, AssetFileDescriptor.class, aVar3);
        registry3.a(Integer.TYPE, Uri.class, dVar4);
        registry3.a(String.class, InputStream.class, new g.c());
        registry3.a(Uri.class, InputStream.class, new g.c());
        registry3.a(String.class, InputStream.class, new B.c());
        registry3.a(String.class, ParcelFileDescriptor.class, new B.b());
        registry3.a(String.class, AssetFileDescriptor.class, new B.a());
        registry3.a(Uri.class, InputStream.class, new b.a());
        registry3.a(Uri.class, InputStream.class, new C0486a.c(context.getAssets()));
        registry3.a(Uri.class, ParcelFileDescriptor.class, new C0486a.b(context.getAssets()));
        registry3.a(Uri.class, InputStream.class, new c.a(context));
        registry3.a(Uri.class, InputStream.class, new d.a(context));
        if (Build.VERSION.SDK_INT >= 29) {
            this.g.a(Uri.class, InputStream.class, new e.c(context));
            this.g.a(Uri.class, ParcelFileDescriptor.class, new e.b(context));
        }
        Registry registry4 = this.g;
        registry4.a(Uri.class, InputStream.class, new D.d(contentResolver));
        registry4.a(Uri.class, ParcelFileDescriptor.class, new D.b(contentResolver));
        registry4.a(Uri.class, AssetFileDescriptor.class, new D.a(contentResolver));
        registry4.a(Uri.class, InputStream.class, new E.a());
        registry4.a(URL.class, InputStream.class, new f.a());
        registry4.a(Uri.class, File.class, new q.a(context));
        registry4.a(com.bumptech.glide.load.a.l.class, InputStream.class, new a.C0057a());
        registry4.a(byte[].class, ByteBuffer.class, new C0488c.a());
        registry4.a(byte[].class, InputStream.class, new C0488c.d());
        registry4.a(Uri.class, Uri.class, C.a.a());
        registry4.a(Drawable.class, Drawable.class, C.a.a());
        registry4.a(Drawable.class, Drawable.class, new com.bumptech.glide.load.b.b.e());
        registry4.a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.b.d.b(resources));
        registry4.a(Bitmap.class, byte[].class, aVar4);
        registry4.a(Drawable.class, byte[].class, new com.bumptech.glide.load.b.d.c(eVar, aVar4, dVar5));
        registry4.a(GifDrawable.class, byte[].class, dVar5);
        if (Build.VERSION.SDK_INT >= 23) {
            com.bumptech.glide.load.m<ByteBuffer, Bitmap> mVarB = com.bumptech.glide.load.resource.bitmap.D.b(eVar);
            this.g.a(ByteBuffer.class, Bitmap.class, mVarB);
            this.g.a(ByteBuffer.class, BitmapDrawable.class, new C0499a(resources, mVarB));
        }
        this.f4118f = new f(context, bVar, this.g, new com.bumptech.glide.request.target.e(), aVar, map, list, rVar, z, i);
    }

    public static File a(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            if (Log.isLoggable("Glide", 6)) {
                Log.e("Glide", "default disk cache dir is null");
            }
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    public static File b(Context context) {
        return a(context, "image_manager_disk_cache");
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e2) {
            a(e2);
            throw null;
        } catch (InstantiationException e3) {
            a(e3);
            throw null;
        } catch (NoSuchMethodException e4) {
            a(e4);
            throw null;
        } catch (InvocationTargetException e5) {
            a(e5);
            throw null;
        }
    }

    public static synchronized void i() {
        if (f4113a != null) {
            f4113a.e().getApplicationContext().unregisterComponentCallbacks(f4113a);
            f4113a.f4115c.a();
        }
        f4113a = null;
    }

    public com.bumptech.glide.load.engine.a.e c() {
        return this.f4116d;
    }

    public Context e() {
        return this.f4118f.getBaseContext();
    }

    f f() {
        return this.f4118f;
    }

    public Registry g() {
        return this.g;
    }

    public m h() {
        return this.i;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        a();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        a(i);
    }

    private static void b(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        a(context, new e(), generatedAppGlideModule);
    }

    public static k c(Context context) {
        return e(context).a(context);
    }

    private static m e(Context context) {
        com.bumptech.glide.e.l.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).h();
    }

    public com.bumptech.glide.load.engine.a.b b() {
        return this.h;
    }

    void b(k kVar) {
        synchronized (this.k) {
            if (this.k.contains(kVar)) {
                this.k.remove(kVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public static c a(Context context) {
        if (f4113a == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(context.getApplicationContext());
            synchronized (c.class) {
                if (f4113a == null) {
                    a(context, generatedAppGlideModuleD);
                }
            }
        }
        return f4113a;
    }

    com.bumptech.glide.manager.d d() {
        return this.j;
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f4114b) {
            f4114b = true;
            b(context, generatedAppGlideModule);
            f4114b = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @Deprecated
    public static synchronized void a(c cVar) {
        if (f4113a != null) {
            i();
        }
        f4113a = cVar;
    }

    public static void a(Context context, e eVar) {
        GeneratedAppGlideModule generatedAppGlideModuleD = d(context);
        synchronized (c.class) {
            if (f4113a != null) {
                i();
            }
            a(context, eVar, generatedAppGlideModuleD);
        }
    }

    private static void a(Context context, e eVar, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<com.bumptech.glide.b.c> listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            listEmptyList = new com.bumptech.glide.b.e(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.a().isEmpty()) {
            Set<Class<?>> setA = generatedAppGlideModule.a();
            Iterator<com.bumptech.glide.b.c> it = listEmptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.b.c next = it.next();
                if (setA.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<com.bumptech.glide.b.c> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        eVar.a(generatedAppGlideModule != null ? generatedAppGlideModule.b() : null);
        Iterator<com.bumptech.glide.b.c> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().applyOptions(applicationContext, eVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, eVar);
        }
        c cVarA = eVar.a(applicationContext);
        for (com.bumptech.glide.b.c cVar : listEmptyList) {
            try {
                cVar.registerComponents(applicationContext, cVarA, cVarA.g);
            } catch (AbstractMethodError e2) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + cVar.getClass().getName(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.registerComponents(applicationContext, cVarA, cVarA.g);
        }
        applicationContext.registerComponentCallbacks(cVarA);
        f4113a = cVarA;
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public void a() {
        com.bumptech.glide.e.n.b();
        this.f4117e.a();
        this.f4116d.a();
        this.h.a();
    }

    public void a(int i) {
        com.bumptech.glide.e.n.b();
        Iterator<k> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().onTrimMemory(i);
        }
        this.f4117e.a(i);
        this.f4116d.a(i);
        this.h.a(i);
    }

    public static k a(Activity activity) {
        return e(activity).a(activity);
    }

    public static k a(FragmentActivity fragmentActivity) {
        return e(fragmentActivity).a(fragmentActivity);
    }

    public static k a(Fragment fragment) {
        return e(fragment.getContext()).a(fragment);
    }

    @Deprecated
    public static k a(android.app.Fragment fragment) {
        return e(fragment.getActivity()).a(fragment);
    }

    public static k a(View view) {
        return e(view.getContext()).a(view);
    }

    boolean a(Target<?> target) {
        synchronized (this.k) {
            Iterator<k> it = this.k.iterator();
            while (it.hasNext()) {
                if (it.next().untrack(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    void a(k kVar) {
        synchronized (this.k) {
            if (!this.k.contains(kVar)) {
                this.k.add(kVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }
}
