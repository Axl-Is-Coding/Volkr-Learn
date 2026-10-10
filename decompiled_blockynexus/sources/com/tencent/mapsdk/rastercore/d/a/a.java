package com.tencent.mapsdk.rastercore.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mapsdk.rastercore.b.b;
import com.tencent.mapsdk.rastercore.c;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.d.h;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<b> f19494a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, Bitmap> f19495b = new ConcurrentHashMap<>();
    private static ReentrantReadWriteLock g = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f19497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<f> f19498e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19496c = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicInteger f19499f = new AtomicInteger(0);

    public a(f fVar) {
        if (this.f19499f.getAndIncrement() == 0) {
            a(h.j());
        }
        this.f19497d = f.a();
        this.f19498e = new WeakReference<>(fVar);
    }

    public static void a(String str) {
        if (str == null) {
            return;
        }
        f19494a.clear();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray jSONArray2 = jSONObject.getJSONArray(FirebaseAnalytics.Param.LEVEL);
                int i2 = jSONArray2.getInt(0);
                int i3 = jSONArray2.getInt(1);
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray3 = jSONObject.getJSONArray("districts");
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    JSONObject jSONObject2 = jSONArray3.getJSONObject(i4);
                    arrayList.add(new com.tencent.mapsdk.rastercore.b.a(jSONObject2.getInt("rule"), jSONObject2.getInt("priority"), jSONObject2.getString("logo_name"), jSONObject2.getString("logo"), jSONObject2.getString("frontier")));
                }
                f19494a.add(new b(i2, i3, arrayList));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, Bitmap bitmap) throws Throwable {
        FileOutputStream fileOutputStream;
        File file;
        g.writeLock().lock();
        if (bitmap == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            file = new File(b(str));
        } catch (Throwable unused) {
            fileOutputStream = null;
        }
        if (file.exists()) {
            c.a((Closeable) null);
            g.writeLock().unlock();
            return false;
        }
        fileOutputStream = new FileOutputStream(file);
        try {
            boolean zCompress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            c.a(fileOutputStream);
            g.writeLock().unlock();
            return zCompress;
        } catch (Throwable unused2) {
            c.a(fileOutputStream);
            g.writeLock().unlock();
            return false;
        }
        c.a(fileOutputStream2);
        g.writeLock().unlock();
        throw th;
    }

    private String b(String str) {
        String strD = d();
        c.b(strD);
        return strD + "/" + str;
    }

    private Bitmap c(String str) throws Throwable {
        FileInputStream fileInputStream;
        g.readLock().lock();
        FileInputStream fileInputStream2 = null;
        Bitmap bitmapDecodeStream = null;
        try {
            File file = new File(b(str));
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
                    c.a((Closeable) fileInputStream);
                } catch (Throwable unused) {
                    c.a((Closeable) fileInputStream);
                    g.readLock().unlock();
                    return null;
                }
            } else {
                c.a((Closeable) null);
            }
            g.readLock().unlock();
            return bitmapDecodeStream;
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    private String d() {
        return this.f19497d.getFilesDir() + "/logos";
    }

    public final void a() {
        g.writeLock().lock();
        f19495b.clear();
        try {
            File file = new File(d());
            if (file.exists()) {
                final File file2 = new File(this.f19497d.getFilesDir() + "/oldLogos");
                if (file.renameTo(file2)) {
                    new Thread(this) { // from class: com.tencent.mapsdk.rastercore.d.a.a.2
                        @Override // java.lang.Thread, java.lang.Runnable
                        public final void run() {
                            super.run();
                            c.a(file2.getAbsolutePath());
                        }
                    }.start();
                } else {
                    c.a(file.getAbsolutePath());
                }
            }
        } catch (Throwable th) {
            g.writeLock().unlock();
            throw th;
        }
        g.writeLock().unlock();
    }

    public final void a(com.tencent.mapsdk.rastercore.b.c cVar) {
        b next;
        String[] strArrA;
        float fC = cVar.c();
        Iterator<b> it = f19494a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (fC >= next.a() && fC <= next.b()) {
                break;
            }
        }
        if (next == null || (strArrA = next.a(cVar)) == null) {
            return;
        }
        final String str = strArrA[0];
        final String str2 = strArrA[1];
        if (str != this.f19496c) {
            Bitmap bitmap = f19495b.get(str);
            if (bitmap != null) {
                if (bitmap.isRecycled()) {
                    f19495b.remove(str);
                } else if (this.f19498e.get() != null) {
                    this.f19498e.get().a(bitmap);
                    this.f19496c = str;
                    return;
                }
            }
            Bitmap bitmapC = c(str);
            if (bitmapC == null || this.f19498e.get() == null) {
                this.f19496c = null;
                new Thread() { // from class: com.tencent.mapsdk.rastercore.d.a.a.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() throws Throwable {
                        HttpURLConnection httpURLConnection;
                        Throwable th;
                        super.run();
                        try {
                            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                            try {
                                httpURLConnection.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                                if (httpURLConnection.getResponseCode() == 200) {
                                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                                    if (bitmapDecodeStream != null) {
                                        a.f19495b.put(str, bitmapDecodeStream);
                                    }
                                    if (a.this.f19498e.get() != null) {
                                        ((f) a.this.f19498e.get()).b(bitmapDecodeStream);
                                    }
                                    a.this.a(str, bitmapDecodeStream);
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            httpURLConnection = null;
                            th = th3;
                        }
                    }
                }.start();
            } else {
                this.f19496c = str;
                f19495b.put(this.f19496c, bitmapC);
                this.f19498e.get().a(bitmapC);
            }
        }
    }

    public final void b() {
        if (this.f19499f.decrementAndGet() == 0) {
            if (Build.VERSION.SDK_INT < 11) {
                Iterator<Map.Entry<String, Bitmap>> it = f19495b.entrySet().iterator();
                while (it.hasNext()) {
                    Bitmap value = it.next().getValue();
                    if (value != null && !value.isRecycled()) {
                        value.recycle();
                    }
                }
            }
            f19495b.clear();
        }
    }
}
