package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends RecyclerView.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f13320a = C.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Calendar f13321b = C.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MaterialCalendar f13322c;

    l(MaterialCalendar materialCalendar) {
        this.f13322c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
        if ((recyclerView.getAdapter() instanceof D) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            D d2 = (D) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (androidx.core.f.d<Long, Long> dVar : this.f13322c.g.A()) {
                Long l = dVar.f1153a;
                if (l != null && dVar.f1154b != null) {
                    this.f13320a.setTimeInMillis(l.longValue());
                    this.f13321b.setTimeInMillis(dVar.f1154b.longValue());
                    int iA = d2.a(this.f13320a.get(1));
                    int iA2 = d2.a(this.f13321b.get(1));
                    View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iA);
                    View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iA2);
                    int iA3 = iA / gridLayoutManager.a();
                    int iA4 = iA2 / gridLayoutManager.a();
                    int i = iA3;
                    while (i <= iA4) {
                        if (gridLayoutManager.findViewByPosition(gridLayoutManager.a() * i) != null) {
                            canvas.drawRect(i == iA3 ? viewFindViewByPosition.getLeft() + (viewFindViewByPosition.getWidth() / 2) : 0, r9.getTop() + this.f13322c.k.f13307d.b(), i == iA4 ? viewFindViewByPosition2.getLeft() + (viewFindViewByPosition2.getWidth() / 2) : recyclerView.getWidth(), r9.getBottom() - this.f13322c.k.f13307d.a(), this.f13322c.k.h);
                        }
                        i++;
                    }
                }
            }
        }
    }
}
