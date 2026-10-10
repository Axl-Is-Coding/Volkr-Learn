package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import cn.qqtheme.framework.widget.WheelView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.a.d;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.a.i;
import com.scwang.smartrefresh.layout.a.j;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* JADX INFO: loaded from: classes4.dex */
public class TwoLevelHeader extends InternalAbstract implements g {
    protected boolean mEnablePullToCloseTwoLevel;
    protected boolean mEnableTwoLevel;
    protected int mFloorDuration;
    protected float mFloorRage;
    protected int mHeaderHeight;
    protected float mMaxRage;
    protected float mPercent;
    protected h mRefreshHeader;
    protected i mRefreshKernel;
    protected float mRefreshRage;
    protected int mSpinner;
    protected d mTwoLevelListener;

    public TwoLevelHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract
    public boolean equals(Object obj) {
        h hVar = this.mRefreshHeader;
        return (hVar != null && hVar.equals(obj)) || super.equals(obj);
    }

    public TwoLevelHeader finishTwoLevel() {
        i iVar = this.mRefreshKernel;
        if (iVar != null) {
            iVar.a();
        }
        return this;
    }

    protected void moveSpinner(int i) {
        h hVar = this.mRefreshHeader;
        if (this.mSpinner == i || hVar == null) {
            return;
        }
        this.mSpinner = i;
        com.scwang.smartrefresh.layout.constant.b spinnerStyle = hVar.getSpinnerStyle();
        if (spinnerStyle == com.scwang.smartrefresh.layout.constant.b.f19149a) {
            hVar.getView().setTranslationY(i);
        } else if (spinnerStyle.i) {
            View view = hVar.getView();
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mSpinnerStyle = com.scwang.smartrefresh.layout.constant.b.f19153e;
        if (this.mRefreshHeader == null) {
            setRefreshHeader(new ClassicsHeader(getContext()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mSpinnerStyle = com.scwang.smartrefresh.layout.constant.b.f19151c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            if (childAt instanceof g) {
                this.mRefreshHeader = (g) childAt;
                this.mWrappedInternal = (h) childAt;
                bringChildToFront(childAt);
                break;
            }
            i++;
        }
        if (this.mRefreshHeader == null) {
            setRefreshHeader(new ClassicsHeader(getContext()));
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void onInitialized(i iVar, int i, int i2) {
        h hVar = this.mRefreshHeader;
        if (hVar == null) {
            return;
        }
        if (((i2 + i) * 1.0f) / i != this.mMaxRage && this.mHeaderHeight == 0) {
            this.mHeaderHeight = i;
            this.mRefreshHeader = null;
            iVar.b().setHeaderMaxDragRate(this.mMaxRage);
            this.mRefreshHeader = hVar;
        }
        if (this.mRefreshKernel == null && hVar.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19149a && !isInEditMode()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) hVar.getView().getLayoutParams();
            marginLayoutParams.topMargin -= i;
            hVar.getView().setLayoutParams(marginLayoutParams);
        }
        this.mHeaderHeight = i;
        this.mRefreshKernel = iVar;
        iVar.b(this.mFloorDuration);
        iVar.a(this, !this.mEnablePullToCloseTwoLevel);
        hVar.onInitialized(iVar, i, i2);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        h hVar = this.mRefreshHeader;
        if (hVar == null) {
            super.onMeasure(i, i2);
        } else {
            if (View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
                super.onMeasure(i, i2);
                return;
            }
            hVar.getView().measure(i, i2);
            super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), hVar.getView().getMeasuredHeight());
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void onMoving(boolean z, float f2, int i, int i2, int i3) {
        moveSpinner(i);
        h hVar = this.mRefreshHeader;
        i iVar = this.mRefreshKernel;
        if (hVar != null) {
            hVar.onMoving(z, f2, i, i2, i3);
        }
        if (z) {
            float f3 = this.mPercent;
            float f4 = this.mFloorRage;
            if (f3 < f4 && f2 >= f4 && this.mEnableTwoLevel) {
                iVar.a(RefreshState.ReleaseToTwoLevel);
            } else if (this.mPercent < this.mFloorRage || f2 >= this.mRefreshRage) {
                float f5 = this.mPercent;
                float f6 = this.mFloorRage;
                if (f5 >= f6 && f2 < f6) {
                    iVar.a(RefreshState.ReleaseToRefresh);
                }
            } else {
                iVar.a(RefreshState.PullDownToRefresh);
            }
            this.mPercent = f2;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.f
    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        h hVar = this.mRefreshHeader;
        if (hVar != null) {
            hVar.onStateChanged(jVar, refreshState, refreshState2);
            int i = c.f19169a[refreshState2.ordinal()];
            boolean z = true;
            if (i == 1) {
                if (hVar.getView() != this) {
                    hVar.getView().animate().alpha(WheelView.DividerConfig.FILL).setDuration(this.mFloorDuration / 2);
                }
                i iVar = this.mRefreshKernel;
                if (iVar != null) {
                    d dVar = this.mTwoLevelListener;
                    if (dVar != null && !dVar.a(jVar)) {
                        z = false;
                    }
                    iVar.a(z);
                    return;
                }
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    if (hVar.getView() != this) {
                        hVar.getView().animate().alpha(1.0f).setDuration(this.mFloorDuration / 2);
                    }
                } else if (i == 4 && hVar.getView().getAlpha() == WheelView.DividerConfig.FILL && hVar.getView() != this) {
                    hVar.getView().setAlpha(1.0f);
                }
            }
        }
    }

    public TwoLevelHeader openTwoLevel(boolean z) {
        i iVar = this.mRefreshKernel;
        if (iVar != null) {
            d dVar = this.mTwoLevelListener;
            iVar.a(!z || dVar == null || dVar.a(iVar.b()));
        }
        return this;
    }

    public TwoLevelHeader setEnablePullToCloseTwoLevel(boolean z) {
        i iVar = this.mRefreshKernel;
        this.mEnablePullToCloseTwoLevel = z;
        if (iVar != null) {
            iVar.a(this, !z);
        }
        return this;
    }

    public TwoLevelHeader setEnableTwoLevel(boolean z) {
        this.mEnableTwoLevel = z;
        return this;
    }

    public TwoLevelHeader setFloorDuration(int i) {
        this.mFloorDuration = i;
        return this;
    }

    public TwoLevelHeader setFloorRage(float f2) {
        this.mFloorRage = f2;
        return this;
    }

    public TwoLevelHeader setMaxRage(float f2) {
        if (this.mMaxRage != f2) {
            this.mMaxRage = f2;
            i iVar = this.mRefreshKernel;
            if (iVar != null) {
                this.mHeaderHeight = 0;
                iVar.b().setHeaderMaxDragRate(this.mMaxRage);
            }
        }
        return this;
    }

    public TwoLevelHeader setOnTwoLevelListener(d dVar) {
        this.mTwoLevelListener = dVar;
        return this;
    }

    public TwoLevelHeader setRefreshHeader(g gVar) {
        return setRefreshHeader(gVar, -1, -2);
    }

    public TwoLevelHeader setRefreshRage(float f2) {
        this.mRefreshRage = f2;
        return this;
    }

    public TwoLevelHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mPercent = WheelView.DividerConfig.FILL;
        this.mMaxRage = 2.5f;
        this.mFloorRage = 1.9f;
        this.mRefreshRage = 1.0f;
        this.mEnableTwoLevel = true;
        this.mEnablePullToCloseTwoLevel = true;
        this.mFloorDuration = 1000;
        this.mSpinnerStyle = com.scwang.smartrefresh.layout.constant.b.f19151c;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TwoLevelHeader);
        this.mMaxRage = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlMaxRage, this.mMaxRage);
        this.mFloorRage = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlFloorRage, this.mFloorRage);
        this.mRefreshRage = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlRefreshRage, this.mRefreshRage);
        this.mFloorDuration = typedArrayObtainStyledAttributes.getInt(R.styleable.TwoLevelHeader_srlFloorDuration, this.mFloorDuration);
        this.mEnableTwoLevel = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnableTwoLevel, this.mEnableTwoLevel);
        this.mEnablePullToCloseTwoLevel = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.mEnablePullToCloseTwoLevel);
        typedArrayObtainStyledAttributes.recycle();
    }

    public TwoLevelHeader setRefreshHeader(g gVar, int i, int i2) {
        if (gVar != null) {
            h hVar = this.mRefreshHeader;
            if (hVar != null) {
                removeView(hVar.getView());
            }
            if (gVar.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19151c) {
                addView(gVar.getView(), 0, new RelativeLayout.LayoutParams(i, i2));
            } else {
                addView(gVar.getView(), getChildCount(), new RelativeLayout.LayoutParams(i, i2));
            }
            this.mRefreshHeader = gVar;
            this.mWrappedInternal = gVar;
        }
        return this;
    }
}
