package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: ScrollbarHelper.java */
/* JADX INFO: loaded from: classes.dex */
class X {
    static int a(RecyclerView.t tVar, J j, View view, View view2, RecyclerView.i iVar, boolean z, boolean z2) {
        if (iVar.getChildCount() == 0 || tVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (tVar.a() - Math.max(iVar.getPosition(view), iVar.getPosition(view2))) - 1) : Math.max(0, Math.min(iVar.getPosition(view), iVar.getPosition(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(j.a(view2) - j.d(view)) / (Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1))) + (j.f() - j.d(view)));
        }
        return iMax;
    }

    static int b(RecyclerView.t tVar, J j, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || tVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return tVar.a();
        }
        return (int) (((j.a(view2) - j.d(view)) / (Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1)) * tVar.a());
    }

    static int a(RecyclerView.t tVar, J j, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || tVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1;
        }
        return Math.min(j.g(), j.a(view2) - j.d(view));
    }
}
