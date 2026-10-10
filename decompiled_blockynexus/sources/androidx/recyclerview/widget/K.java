package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: PagerSnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
class K extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ L f1818a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    K(L l, Context context) {
        super(context);
        this.f1818a = l;
    }

    @Override // androidx.recyclerview.widget.E
    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.E
    protected int calculateTimeForScrolling(int i) {
        return Math.min(100, super.calculateTimeForScrolling(i));
    }

    @Override // androidx.recyclerview.widget.E, androidx.recyclerview.widget.RecyclerView.s
    protected void onTargetFound(View view, RecyclerView.t tVar, RecyclerView.s.a aVar) {
        L l = this.f1818a;
        int[] iArrA = l.a(l.f1951a.getLayoutManager(), view);
        int i = iArrA[0];
        int i2 = iArrA[1];
        int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
        if (iCalculateTimeForDeceleration > 0) {
            aVar.a(i, i2, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }
}
