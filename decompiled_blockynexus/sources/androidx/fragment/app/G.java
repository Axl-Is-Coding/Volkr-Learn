package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransition.java */
/* JADX INFO: loaded from: classes.dex */
class G implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f1443a;

    G(ArrayList arrayList) {
        this.f1443a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        K.a((ArrayList<View>) this.f1443a, 4);
    }
}
