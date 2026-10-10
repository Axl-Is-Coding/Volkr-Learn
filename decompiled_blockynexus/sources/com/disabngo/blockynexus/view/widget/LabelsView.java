package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class LabelsView extends ViewGroup {
    private BaseAdapter adapter;
    private int addDrawable;
    private ImageView addImageView;
    private DataSetObserver dataSetObserver;
    private boolean isShowAddView;
    private int marginLineHeight;
    private int marginStringWidth;
    private a onAddLabelsListener;

    public interface a {
        void a();
    }

    public LabelsView(Context context) {
        super(context);
        this.dataSetObserver = new p(this);
        this.isShowAddView = true;
    }

    private void initImageView(Context context) {
        this.addImageView = new ImageView(context);
        this.addImageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.addImageView.setImageDrawable(context.getResources().getDrawable(this.addDrawable));
        this.addImageView.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12078a.a(view);
            }
        });
    }

    private int measureHeight(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingTop = i2 + getPaddingTop() + getPaddingBottom() + ((int) dp2px(getContext(), this.marginLineHeight));
            size = mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
        }
        return Math.max(size, getSuggestedMinimumHeight());
    }

    private int measureWidth(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingLeft = i2 + getPaddingLeft() + getPaddingRight();
            size = mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
        }
        return Math.max(size, getSuggestedMinimumWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdapter() {
        ImageView imageView;
        removeAllViews();
        int count = this.adapter.getCount();
        for (int i = 0; i < count; i++) {
            addView(this.adapter.getView(i, null, this));
        }
        if (!this.isShowAddView || (imageView = this.addImageView) == null) {
            return;
        }
        addView(imageView);
    }

    public /* synthetic */ void a(View view) {
        a aVar = this.onAddLabelsListener;
        if (aVar != null) {
            aVar.a();
        }
    }

    public float dp2px(Context context, float f2) {
        return TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = i3 - i;
        int childCount = getChildCount();
        int i6 = paddingTop;
        int iMax = 0;
        int measuredWidth = paddingLeft;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (i5 <= childAt.getMeasuredWidth() + measuredWidth + getPaddingRight()) {
                measuredWidth = getPaddingLeft();
                i6 = i6 + this.marginLineHeight + iMax;
                iMax = 0;
            }
            if (i7 != childCount - 1) {
                childAt.layout(measuredWidth, i6, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + i6);
            } else if (iMax > childAt.getMeasuredHeight()) {
                int i8 = i6 + iMax;
                childAt.layout(measuredWidth, i8 - childAt.getMeasuredHeight(), childAt.getMeasuredWidth() + measuredWidth, i8);
            } else {
                childAt.layout(measuredWidth, i6, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + i6);
            }
            measuredWidth = measuredWidth + childAt.getMeasuredWidth() + this.marginStringWidth;
            iMax = Math.max(iMax, childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View childAt;
        super.onMeasure(i, i2);
        int count = this.adapter.getCount();
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int iMax = 0;
        int measuredWidth = 0;
        int iMax2 = 0;
        for (int i3 = 0; i3 < count + 1; i3++) {
            if (i3 == count) {
                childAt = this.addImageView;
                if (childAt == null) {
                    break;
                } else {
                    measureChild(childAt, i, i2);
                }
            } else {
                childAt = getChildAt(i3);
                measureChild(childAt, i, i2);
            }
            measuredWidth += childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (size < measuredWidth) {
                iMax += measuredHeight;
                measuredWidth = 0;
            } else {
                iMax = Math.max(measuredHeight, iMax);
                iMax2 = Math.max(iMax2, measuredWidth);
            }
        }
        setMeasuredDimension(measureWidth(getSuggestedMinimumWidth(), getMeasuredWidth()), measureHeight(getSuggestedMinimumHeight(), iMax));
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.adapter = baseAdapter;
        baseAdapter.registerDataSetObserver(this.dataSetObserver);
        notifyAdapter();
    }

    public void setAddViewShow(boolean z) {
        this.isShowAddView = z;
    }

    public void setData(BaseAdapter baseAdapter, a aVar, int i, int i2, int i3) {
        this.addDrawable = i;
        this.marginLineHeight = (int) dp2px(getContext(), i2);
        this.marginStringWidth = (int) dp2px(getContext(), i3);
        this.onAddLabelsListener = aVar;
        if (this.isShowAddView) {
            initImageView(getContext());
        }
        setAdapter(baseAdapter);
    }

    public LabelsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dataSetObserver = new p(this);
        this.isShowAddView = true;
    }

    public LabelsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dataSetObserver = new p(this);
        this.isShowAddView = true;
    }
}
