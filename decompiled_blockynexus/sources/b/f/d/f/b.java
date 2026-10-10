package b.f.d.f;

import android.app.Activity;
import b.f.d.c.p;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.utils.d;

/* JADX INFO: compiled from: BackButtonHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f2739a;

    public static b a() {
        b bVar = f2739a;
        return bVar == null ? new b() : bVar;
    }

    public boolean a(Activity activity) {
        int i = a.f2738a[d.d().a().ordinal()];
        if (i == 1 || i == 2 || i != 3) {
            return false;
        }
        try {
            WebController webController = (WebController) p.c(activity).a().f();
            if (webController != null) {
                webController.nativeNavigationPressed("back");
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
