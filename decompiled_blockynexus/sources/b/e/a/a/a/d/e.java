package b.e.a.a.a.d;

import android.text.TextUtils;
import com.iab.omid.library.ironsrc.adsession.Owner;
import com.iab.omid.library.ironsrc.adsession.g;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static void a() {
        if (!b.e.a.a.a.a.b()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    public static void a(Owner owner) {
        if (owner.equals(Owner.NONE)) {
            throw new IllegalArgumentException("Impression owner is none");
        }
    }

    public static void a(g gVar) {
        if (gVar.g()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void b(g gVar) {
        if (gVar.j().c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    public static void c(g gVar) {
        if (!gVar.h()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }
}
