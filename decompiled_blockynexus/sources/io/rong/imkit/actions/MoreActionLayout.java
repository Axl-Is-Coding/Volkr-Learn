package io.rong.imkit.actions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class MoreActionLayout extends ViewGroup {
    private Context context;
    private Fragment fragment;

    public MoreActionLayout(Context context) {
        super(context);
        this.context = context;
    }

    public void addActions(List<IClickActions> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            final IClickActions iClickActions = list.get(i);
            ClickImageView clickImageView = new ClickImageView(this.context);
            clickImageView.setImageDrawable(list.get(i).obtainDrawable(this.context));
            clickImageView.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.actions.MoreActionLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    iClickActions.onClick(MoreActionLayout.this.fragment);
                }
            });
            addView(clickImageView, i);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount() > 0 ? measuredWidth / getChildCount() : 0;
        int i5 = 0;
        while (i5 < getChildCount()) {
            View childAt = getChildAt(i5);
            int i6 = i5 * childCount;
            i5++;
            childAt.layout(i6, 0, i5 * childCount, measuredHeight);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = getChildCount() > 0 ? View.MeasureSpec.getSize(i) / getChildCount() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).measure(View.MeasureSpec.makeMeasureSpec(size, FileTypeUtils.GIGABYTE), i2);
        }
    }

    public void refreshView(boolean z) {
        for (int i = 0; i < getChildCount(); i++) {
            ((ClickImageView) getChildAt(i)).setEnable(z);
        }
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public MoreActionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }
}
