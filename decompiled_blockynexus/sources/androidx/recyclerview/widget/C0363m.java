package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DividerItemDecoration.java */
/* JADX INFO: loaded from: classes.dex */
public class C0363m extends RecyclerView.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f2007a = {R.attr.listDivider};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f2008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f2010d = new Rect();

    public C0363m(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f2007a);
        this.f2008b = typedArrayObtainStyledAttributes.getDrawable(0);
        if (this.f2008b == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
        a(i);
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.f2010d);
            int iRound = this.f2010d.bottom + Math.round(childAt.getTranslationY());
            this.f2008b.setBounds(paddingLeft, iRound - this.f2008b.getIntrinsicHeight(), width, iRound);
            this.f2008b.draw(canvas);
        }
        canvas.restore();
    }

    public void a(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.f2009c = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
        Drawable drawable = this.f2008b;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f2009c == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
        if (recyclerView.getLayoutManager() == null || this.f2008b == null) {
            return;
        }
        if (this.f2009c == 1) {
            b(canvas, recyclerView);
        } else {
            a(canvas, recyclerView);
        }
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.f2010d);
            int iRound = this.f2010d.right + Math.round(childAt.getTranslationX());
            this.f2008b.setBounds(iRound - this.f2008b.getIntrinsicWidth(), paddingTop, iRound, height);
            this.f2008b.draw(canvas);
        }
        canvas.restore();
    }
}
