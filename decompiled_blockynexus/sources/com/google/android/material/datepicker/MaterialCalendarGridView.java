package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f13286a;

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    private void a(int i, Rect rect) {
        if (i == 33) {
            setSelection(getAdapter().b());
        } else if (i == 130) {
            setSelection(getAdapter().a());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        v adapter = getAdapter();
        e<?> eVar = adapter.f13345c;
        C2232d c2232d = adapter.f13346d;
        Long item = adapter.getItem(adapter.a());
        Long item2 = adapter.getItem(adapter.b());
        for (androidx.core.f.d<Long, Long> dVar : eVar.A()) {
            Long l = dVar.f1153a;
            if (l != null) {
                if (dVar.f1154b == null) {
                    continue;
                } else {
                    long jLongValue = l.longValue();
                    long jLongValue2 = dVar.f1154b.longValue();
                    if (a(item, item2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2))) {
                        return;
                    }
                    if (jLongValue < item.longValue()) {
                        iA = adapter.a();
                        iA2 = adapter.b(iA) ? 0 : materialCalendarGridView.getChildAt(iA - 1).getRight();
                    } else {
                        materialCalendarGridView.f13286a.setTimeInMillis(jLongValue);
                        iA = adapter.a(materialCalendarGridView.f13286a.get(5));
                        iA2 = a(materialCalendarGridView.getChildAt(iA));
                    }
                    if (jLongValue2 > item2.longValue()) {
                        iA3 = adapter.b();
                        iA4 = adapter.c(iA3) ? getWidth() : materialCalendarGridView.getChildAt(iA3).getRight();
                    } else {
                        materialCalendarGridView.f13286a.setTimeInMillis(jLongValue2);
                        iA3 = adapter.a(materialCalendarGridView.f13286a.get(5));
                        iA4 = a(materialCalendarGridView.getChildAt(iA3));
                    }
                    int itemId = (int) adapter.getItemId(iA);
                    int itemId2 = (int) adapter.getItemId(iA3);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > iA ? 0 : iA2, childAt.getTop() + c2232d.f13304a.b(), iA3 > numColumns2 ? getWidth() : iA4, childAt.getBottom() - c2232d.f13304a.a(), c2232d.h);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            a(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().a()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter().a()) {
            super.setSelection(getAdapter().a());
        } else {
            super.setSelection(i);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof v)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), v.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13286a = C.b();
        if (p.a(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        ViewCompat.a(this, new o(this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public v getAdapter() {
        return (v) super.getAdapter();
    }

    private static boolean a(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    private static int a(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }
}
