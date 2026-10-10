package com.scwang.smartrefresh.layout.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.f;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.a.i;
import com.scwang.smartrefresh.layout.a.j;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class InternalAbstract extends RelativeLayout implements h {
    protected com.scwang.smartrefresh.layout.constant.b mSpinnerStyle;
    protected h mWrappedInternal;
    protected View mWrappedView;

    /* JADX WARN: Multi-variable type inference failed */
    protected InternalAbstract(View view) {
        this(view, view instanceof h ? (h) view : null);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof h) && getView() == ((h) obj).getView();
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public com.scwang.smartrefresh.layout.constant.b getSpinnerStyle() {
        int i;
        com.scwang.smartrefresh.layout.constant.b bVar = this.mSpinnerStyle;
        if (bVar != null) {
            return bVar;
        }
        h hVar = this.mWrappedInternal;
        if (hVar != null && hVar != this) {
            return hVar.getSpinnerStyle();
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                this.mSpinnerStyle = ((SmartRefreshLayout.LayoutParams) layoutParams).f19117b;
                com.scwang.smartrefresh.layout.constant.b bVar2 = this.mSpinnerStyle;
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            if (layoutParams != null && ((i = layoutParams.height) == 0 || i == -1)) {
                for (com.scwang.smartrefresh.layout.constant.b bVar3 : com.scwang.smartrefresh.layout.constant.b.f19154f) {
                    if (bVar3.i) {
                        this.mSpinnerStyle = bVar3;
                        return bVar3;
                    }
                }
            }
        }
        com.scwang.smartrefresh.layout.constant.b bVar4 = com.scwang.smartrefresh.layout.constant.b.f19149a;
        this.mSpinnerStyle = bVar4;
        return bVar4;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public View getView() {
        View view = this.mWrappedView;
        return view == null ? this : view;
    }

    public boolean isSupportHorizontalDrag() {
        h hVar = this.mWrappedInternal;
        return (hVar == null || hVar == this || !hVar.isSupportHorizontalDrag()) ? false : true;
    }

    public int onFinish(j jVar, boolean z) {
        h hVar = this.mWrappedInternal;
        if (hVar == null || hVar == this) {
            return 0;
        }
        return hVar.onFinish(jVar, z);
    }

    public void onHorizontalDrag(float f2, int i, int i2) {
        h hVar = this.mWrappedInternal;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.onHorizontalDrag(f2, i, i2);
    }

    public void onInitialized(i iVar, int i, int i2) {
        h hVar = this.mWrappedInternal;
        if (hVar != null && hVar != this) {
            hVar.onInitialized(iVar, i, i2);
            return;
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                iVar.a(this, ((SmartRefreshLayout.LayoutParams) layoutParams).f19116a);
            }
        }
    }

    public void onMoving(boolean z, float f2, int i, int i2, int i3) {
        h hVar = this.mWrappedInternal;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.onMoving(z, f2, i, i2, i3);
    }

    public void onReleased(j jVar, int i, int i2) {
        h hVar = this.mWrappedInternal;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.onReleased(jVar, i, i2);
    }

    public void onStartAnimator(j jVar, int i, int i2) {
        h hVar = this.mWrappedInternal;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.onStartAnimator(jVar, i, i2);
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        h hVar = this.mWrappedInternal;
        if (hVar == null || hVar == this) {
            return;
        }
        if ((this instanceof RefreshFooterWrapper) && (hVar instanceof g)) {
            if (refreshState.isFooter) {
                refreshState = refreshState.toHeader();
            }
            if (refreshState2.isFooter) {
                refreshState2 = refreshState2.toHeader();
            }
        } else if ((this instanceof RefreshHeaderWrapper) && (this.mWrappedInternal instanceof f)) {
            if (refreshState.isHeader) {
                refreshState = refreshState.toFooter();
            }
            if (refreshState2.isHeader) {
                refreshState2 = refreshState2.toFooter();
            }
        }
        h hVar2 = this.mWrappedInternal;
        if (hVar2 != null) {
            hVar2.onStateChanged(jVar, refreshState, refreshState2);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public boolean setNoMoreData(boolean z) {
        h hVar = this.mWrappedInternal;
        return (hVar instanceof f) && ((f) hVar).setNoMoreData(z);
    }

    public void setPrimaryColors(int... iArr) {
        h hVar = this.mWrappedInternal;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.setPrimaryColors(iArr);
    }

    protected InternalAbstract(View view, h hVar) {
        super(view.getContext(), null, 0);
        this.mWrappedView = view;
        this.mWrappedInternal = hVar;
        if (this instanceof RefreshFooterWrapper) {
            h hVar2 = this.mWrappedInternal;
            if ((hVar2 instanceof g) && hVar2.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19153e) {
                hVar.getView().setScaleY(-1.0f);
                return;
            }
        }
        if (this instanceof RefreshHeaderWrapper) {
            h hVar3 = this.mWrappedInternal;
            if ((hVar3 instanceof f) && hVar3.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19153e) {
                hVar.getView().setScaleY(-1.0f);
            }
        }
    }

    protected InternalAbstract(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
