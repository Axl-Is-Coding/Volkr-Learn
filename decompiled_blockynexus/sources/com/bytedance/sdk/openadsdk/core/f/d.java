package com.bytedance.sdk.openadsdk.core.f;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PermissionsManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6168a = "d";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static d f6169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, Integer> f6170f = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f6171b = new HashSet(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<WeakReference<e>> f6172c = new ArrayList(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<e> f6173d = new ArrayList(1);

    private d() {
        b();
    }

    public static d a() {
        if (f6169e == null) {
            f6169e = new d();
        }
        return f6169e;
    }

    private synchronized void b() {
        String str;
        for (Field field : Manifest.permission.class.getFields()) {
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e2) {
                Log.e(f6168a, "Could not access field", e2);
                str = null;
            }
            this.f6171b.add(str);
        }
    }

    private List<String> c(Activity activity, String[] strArr, e eVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f6171b.contains(str)) {
                if (!a(activity, str)) {
                    arrayList.add(str);
                } else if (eVar != null) {
                    eVar.a(str, c.GRANTED);
                }
            } else if (eVar != null) {
                eVar.a(str, c.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private synchronized void a(String[] strArr, e eVar) {
        if (eVar == null) {
            return;
        }
        eVar.a(strArr);
        this.f6173d.add(eVar);
        this.f6172c.add(new WeakReference<>(eVar));
    }

    private void b(Activity activity, String[] strArr, e eVar) {
        boolean zA;
        for (String str : strArr) {
            if (eVar != null) {
                try {
                    if (!this.f6171b.contains(str)) {
                        zA = eVar.a(str, c.NOT_FOUND);
                    } else if (b.a(activity, str) != 0) {
                        zA = eVar.a(str, c.DENIED);
                    } else {
                        zA = eVar.a(str, c.GRANTED);
                    }
                    if (zA) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        a(eVar);
    }

    private synchronized void a(e eVar) {
        Iterator<WeakReference<e>> it = this.f6172c.iterator();
        while (it.hasNext()) {
            WeakReference<e> next = it.next();
            if (next.get() == eVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<e> it2 = this.f6173d.iterator();
        while (it2.hasNext()) {
            if (it2.next() == eVar) {
                it2.remove();
            }
        }
    }

    public synchronized boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (u.e()) {
            if (a.a(context, str) && (b.a(context, str) == 0 || !this.f6171b.contains(str))) {
                z = true;
            }
            return z;
        }
        return b.a(context, str) == 0 || !this.f6171b.contains(str);
    }

    public synchronized void a(Activity activity, String[] strArr, e eVar) {
        if (activity == null) {
            return;
        }
        try {
            a(strArr, eVar);
            if (Build.VERSION.SDK_INT < 23) {
                b(activity, strArr, eVar);
            } else {
                List<String> listC = c(activity, strArr, eVar);
                if (listC.isEmpty()) {
                    a(eVar);
                } else {
                    b.a(activity, (String[]) listC.toArray(new String[listC.size()]), 1);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void a(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (u.e() && !a.a(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            a(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(String[] strArr, int[] iArr, String[] strArr2) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<e>> it = this.f6172c.iterator();
            while (it.hasNext()) {
                e eVar = it.next().get();
                while (i < length) {
                    i = (eVar == null || eVar.a(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<e> it2 = this.f6173d.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
