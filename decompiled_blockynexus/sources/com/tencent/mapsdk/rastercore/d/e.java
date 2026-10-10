package com.tencent.mapsdk.rastercore.d;

import android.content.Context;
import com.tencent.mapsdk.raster.model.LatLng;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, com.tencent.mapsdk.rastercore.b.f[]> f19520a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile e f19521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f19522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ReentrantReadWriteLock f19523d = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19524e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f19525f = null;
    private boolean g = false;
    private AtomicInteger h = new AtomicInteger(0);

    private e() {
    }

    public static e a() {
        if (f19521b == null) {
            synchronized (e.class) {
                if (f19521b == null) {
                    f19521b = new e();
                }
            }
        }
        return f19521b;
    }

    public static boolean a(com.tencent.mapsdk.rastercore.b.f fVar, com.tencent.mapsdk.rastercore.b.f[] fVarArr) {
        if (fVarArr == null || fVarArr.length < 3) {
            return false;
        }
        int length = fVarArr.length - 1;
        boolean z = false;
        for (int i = 0; i < fVarArr.length; i++) {
            if (((fVarArr[i].a() < fVar.a() && fVarArr[length].a() >= fVar.a()) || (fVarArr[length].a() < fVar.a() && fVarArr[i].a() >= fVar.a())) && (fVarArr[i].b() <= fVar.b() || fVarArr[length].b() <= fVar.b())) {
                z ^= fVarArr[i].b() + (((fVar.a() - fVarArr[i].a()) / (fVarArr[length].a() - fVarArr[i].a())) * (fVarArr[length].b() - fVarArr[i].b())) < fVar.b();
            }
            length = i;
        }
        return z;
    }

    public static boolean a(com.tencent.mapsdk.rastercore.b.f[] fVarArr, com.tencent.mapsdk.rastercore.b.f[] fVarArr2) {
        boolean z;
        if (fVarArr != null && fVarArr2 != null) {
            int length = fVarArr.length;
            int i = 0;
            boolean zA = false;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                zA |= a(fVarArr[i], fVarArr2);
                if (zA) {
                    z = true;
                    break;
                }
                i++;
            }
            boolean zA2 = false;
            boolean z2 = false;
            for (com.tencent.mapsdk.rastercore.b.f fVar : fVarArr2) {
                zA2 |= a(fVar, fVarArr);
                if (zA2) {
                    z2 = true;
                }
            }
            if (!z && !z2) {
                return false;
            }
        }
        return true;
    }

    public static int b(String str) {
        int iK = h.k();
        if (str != null && str.length() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if ("version".equals(next)) {
                        iK = jSONObject.optInt(next);
                    } else {
                        com.tencent.mapsdk.rastercore.b.f[] fVarArrD = d(jSONObject.optString(next));
                        if (fVarArrD != null) {
                            f19520a.put(next, fVarArrD);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return iK;
    }

    private String c() throws Throwable {
        FileInputStream fileInputStream;
        this.f19523d.readLock().lock();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(this.f19524e));
        } catch (Throwable unused) {
            fileInputStream = null;
        }
        try {
            String str = new String(com.tencent.mapsdk.rastercore.c.a((InputStream) fileInputStream), "UTF-8");
            com.tencent.mapsdk.rastercore.c.a((Closeable) fileInputStream);
            this.f19523d.readLock().unlock();
            return str;
        } catch (Throwable th) {
            th = th;
            fileInputStream2 = fileInputStream;
            com.tencent.mapsdk.rastercore.c.a((Closeable) fileInputStream2);
            this.f19523d.readLock().unlock();
            throw th;
        }
    }

    public static com.tencent.mapsdk.rastercore.b.f[] c(String str) {
        return f19520a.get(str);
    }

    private static com.tencent.mapsdk.rastercore.b.f[] d(String str) {
        com.tencent.mapsdk.rastercore.b.f[] fVarArr = null;
        if (str != null && str.length() != 0) {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length == 0) {
                return null;
            }
            fVarArr = new com.tencent.mapsdk.rastercore.b.f[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].split(",");
                fVarArr[i] = com.tencent.mapsdk.rastercore.c.a(new LatLng(Double.parseDouble(strArrSplit2[1]), Double.parseDouble(strArrSplit2[0])));
            }
        }
        return fVarArr;
    }

    public final void a(Context context) {
        if (context != null && !this.g) {
            this.f19522c = context.getApplicationContext();
            this.f19524e = this.f19522c.getFilesDir() + "/frontiers.dat";
            this.f19525f = this.f19524e + ".bak";
            this.g = true;
        }
        if (this.h.getAndIncrement() <= 0) {
            String strC = c();
            if (strC != null) {
                b(strC);
                return;
            }
            com.tencent.mapsdk.rastercore.b.f[] fVarArrD = d("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.959229,21.677848:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
            f19520a.put("china", fVarArrD);
            f19520a.put("inland", fVarArrD);
        }
    }

    public final boolean a(String str) throws Throwable {
        this.f19523d.writeLock().lock();
        File file = new File(this.f19524e);
        File file2 = new File(this.f19525f);
        if (file2.exists() && !file2.delete()) {
            file2.deleteOnExit();
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists() || file.renameTo(file2)) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(str.getBytes("UTF-8"));
                    fileOutputStream2.flush();
                    com.tencent.mapsdk.rastercore.c.a(fileOutputStream2);
                    file2.delete();
                    this.f19523d.writeLock().unlock();
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    com.tencent.mapsdk.rastercore.c.a(fileOutputStream);
                    file2.renameTo(file);
                    this.f19523d.writeLock().unlock();
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        com.tencent.mapsdk.rastercore.c.a(fileOutputStream);
        file2.renameTo(file);
        this.f19523d.writeLock().unlock();
        return false;
    }

    public final void b() {
        if (this.h.decrementAndGet() == 0) {
            f19520a.clear();
            this.g = false;
        }
    }
}
