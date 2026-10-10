package com.sandboxol.common.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.R;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.i;
import com.scwang.smartrefresh.layout.a.j;
import com.scwang.smartrefresh.layout.c.c;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.b;

/* JADX INFO: loaded from: classes.dex */
public class SmartRefreshHeader extends LinearLayout implements g {
    private ImageView mProgressView;

    /* JADX INFO: renamed from: com.sandboxol.common.widget.SmartRefreshHeader$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState = new int[RefreshState.values().length];

        static {
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SmartRefreshHeader(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        setGravity(17);
        this.mProgressView = new ImageView(context);
        this.mProgressView.setImageDrawable(getResources().getDrawable(R.drawable.ic_progress_puzzle));
        addView(this.mProgressView, c.a(20.0f), c.a(20.0f));
        setMinimumHeight(c.a(60.0f));
        this.mProgressView.animate().setInterpolator(null);
        if (isInEditMode()) {
            return;
        }
        this.mProgressView.setVisibility(8);
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public b getSpinnerStyle() {
        return b.f19149a;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public View getView() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mProgressView.animate().cancel();
        Object drawable = this.mProgressView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public int onFinish(j jVar, boolean z) {
        Object drawable = this.mProgressView.getDrawable();
        if (!(drawable instanceof Animatable)) {
            return 500;
        }
        Animatable animatable = (Animatable) drawable;
        if (!animatable.isRunning()) {
            return 500;
        }
        animatable.stop();
        return 500;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public void onHorizontalDrag(float f2, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public void onInitialized(i iVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public void onMoving(boolean z, float f2, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public void onReleased(j jVar, int i, int i2) {
        onStartAnimator(jVar, i, i2);
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public void onStartAnimator(j jVar, int i, int i2) {
        ImageView imageView = this.mProgressView;
        imageView.setVisibility(0);
        Object drawable = this.mProgressView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        } else {
            imageView.animate().rotation(36000.0f).setDuration(100000L);
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.f
    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.mProgressView.setVisibility(0);
            this.mProgressView.animate().rotation(WheelView.DividerConfig.FILL).setDuration(0L);
        } else if (i != 3) {
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public void setPrimaryColors(int... iArr) {
    }

    public SmartRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public SmartRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
