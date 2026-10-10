package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: FragmentTransitionImpl.java */
/* JADX INFO: loaded from: classes.dex */
class T implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f1493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f1494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ U f1495c;

    T(U u, ArrayList arrayList, Map map) {
        this.f1495c = u;
        this.f1493a = arrayList;
        this.f1494b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.f1493a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f1493a.get(i);
            ViewCompat.a(view, (String) this.f1494b.get(ViewCompat.t(view)));
        }
    }
}
