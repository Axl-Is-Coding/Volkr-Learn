package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: FragmentTransitionImpl.java */
/* JADX INFO: loaded from: classes.dex */
class S implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f1490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f1491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ U f1492c;

    S(U u, ArrayList arrayList, Map map) {
        this.f1492c = u;
        this.f1490a = arrayList;
        this.f1491b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.f1490a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f1490a.get(i);
            String strT = ViewCompat.t(view);
            if (strT != null) {
                ViewCompat.a(view, U.a((Map<String, String>) this.f1491b, strT));
            }
        }
    }
}
