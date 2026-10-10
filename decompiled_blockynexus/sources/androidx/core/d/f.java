package androidx.core.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.a.l;
import androidx.core.content.a.h;
import androidx.core.d.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FontsContractCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a.a.g<String, Typeface> f1074a = new a.a.g<>(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final k f1075b = new k("fonts", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f1076c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final a.a.i<String, ArrayList<k.a<c>>> f1077d = new a.a.i<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Comparator<byte[]> f1078e = new e();

    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b[] f1080b;

        public a(int i, b[] bVarArr) {
            this.f1079a = i;
            this.f1080b = bVarArr;
        }

        public b[] a() {
            return this.f1080b;
        }

        public int b() {
            return this.f1079a;
        }
    }

    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f1081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f1084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f1085e;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            androidx.core.f.h.a(uri);
            this.f1081a = uri;
            this.f1082b = i;
            this.f1083c = i2;
            this.f1084d = z;
            this.f1085e = i3;
        }

        public int a() {
            return this.f1085e;
        }

        public int b() {
            return this.f1082b;
        }

        public Uri c() {
            return this.f1081a;
        }

        public int d() {
            return this.f1083c;
        }

        public boolean e() {
            return this.f1084d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: FontsContractCompat.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Typeface f1086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f1087b;

        c(Typeface typeface, int i) {
            this.f1086a = typeface;
            this.f1087b = i;
        }
    }

    static c a(Context context, androidx.core.d.a aVar, int i) {
        try {
            a aVarA = a(context, (CancellationSignal) null, aVar);
            if (aVarA.b() != 0) {
                return new c(null, aVarA.b() == 1 ? -2 : -3);
            }
            Typeface typefaceA = androidx.core.a.c.a(context, null, aVarA.a(), i);
            return new c(typefaceA, typefaceA != null ? 0 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c(null, -1);
        }
    }

    public static Typeface a(Context context, androidx.core.d.a aVar, h.a aVar2, Handler handler, boolean z, int i, int i2) {
        String str = aVar.c() + "-" + i2;
        Typeface typeface = f1074a.get(str);
        if (typeface != null) {
            if (aVar2 != null) {
                aVar2.a(typeface);
            }
            return typeface;
        }
        if (z && i == -1) {
            c cVarA = a(context, aVar, i2);
            if (aVar2 != null) {
                int i3 = cVarA.f1087b;
                if (i3 == 0) {
                    aVar2.a(cVarA.f1086a, handler);
                } else {
                    aVar2.a(i3, handler);
                }
            }
            return cVarA.f1086a;
        }
        androidx.core.d.b bVar = new androidx.core.d.b(context, aVar, i2, str);
        if (z) {
            try {
                return ((c) f1075b.a(bVar, i)).f1086a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        androidx.core.d.c cVar = aVar2 == null ? null : new androidx.core.d.c(aVar2, handler);
        synchronized (f1076c) {
            ArrayList<k.a<c>> arrayList = f1077d.get(str);
            if (arrayList != null) {
                if (cVar != null) {
                    arrayList.add(cVar);
                }
                return null;
            }
            if (cVar != null) {
                ArrayList<k.a<c>> arrayList2 = new ArrayList<>();
                arrayList2.add(cVar);
                f1077d.put(str, arrayList2);
            }
            f1075b.a(bVar, new d(str));
            return null;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (b bVar : bVarArr) {
            if (bVar.a() == 0) {
                Uri uriC = bVar.c();
                if (!map.containsKey(uriC)) {
                    map.put(uriC, l.a(context, cancellationSignal, uriC));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static a a(Context context, CancellationSignal cancellationSignal, androidx.core.d.a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoA = a(context.getPackageManager(), aVar, context.getResources());
        if (providerInfoA == null) {
            return new a(1, null);
        }
        return new a(0, a(context, aVar, providerInfoA.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, androidx.core.d.a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String strD = aVar.d();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strD, 0);
        if (providerInfoResolveContentProvider != null) {
            if (providerInfoResolveContentProvider.packageName.equals(aVar.e())) {
                List<byte[]> listA = a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
                Collections.sort(listA, f1078e);
                List<List<byte[]>> listA2 = a(aVar, resources);
                for (int i = 0; i < listA2.size(); i++) {
                    ArrayList arrayList = new ArrayList(listA2.get(i));
                    Collections.sort(arrayList, f1078e);
                    if (a(listA, arrayList)) {
                        return providerInfoResolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + strD + ", but package was not " + aVar.e());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + strD);
    }

    private static List<List<byte[]>> a(androidx.core.d.a aVar, Resources resources) {
        if (aVar.a() != null) {
            return aVar.a();
        }
        return androidx.core.content.a.c.a(resources, aVar.b());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static androidx.core.d.f.b[] a(android.content.Context r19, androidx.core.d.a r20, java.lang.String r21, android.os.CancellationSignal r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.d.f.a(android.content.Context, androidx.core.d.a, java.lang.String, android.os.CancellationSignal):androidx.core.d.f$b[]");
    }
}
