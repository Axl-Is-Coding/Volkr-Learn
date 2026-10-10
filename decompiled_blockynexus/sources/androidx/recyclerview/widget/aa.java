package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
class aa extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ba f1945a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    aa(ba baVar, Context context) {
        super(context);
        this.f1945a = baVar;
    }

    @Override // androidx.recyclerview.widget.E
    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.E, androidx.recyclerview.widget.RecyclerView.s
    protected void onTargetFound(View view, RecyclerView.t tVar, RecyclerView.s.a aVar) {
        ba baVar = this.f1945a;
        RecyclerView recyclerView = baVar.f1951a;
        if (recyclerView == null) {
            return;
        }
        int[] iArrA = baVar.a(recyclerView.getLayoutManager(), view);
        int i = iArrA[0];
        int i2 = iArrA[1];
        int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
        if (iCalculateTimeForDeceleration > 0) {
            aVar.a(i, i2, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }
}
