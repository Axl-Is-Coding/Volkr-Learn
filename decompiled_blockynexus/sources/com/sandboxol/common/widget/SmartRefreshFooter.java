package com.sandboxol.common.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.R;
import com.scwang.smartrefresh.layout.a.f;
import com.scwang.smartrefresh.layout.a.i;
import com.scwang.smartrefresh.layout.a.j;
import com.scwang.smartrefresh.layout.c.c;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.b;

/* JADX INFO: loaded from: classes.dex */
public class SmartRefreshFooter extends LinearLayout implements f {
    protected boolean mNoMoreData;
    private ImageView mProgressView;
    private TextView mTitleText;

    /* JADX INFO: renamed from: com.sandboxol.common.widget.SmartRefreshFooter$1, reason: invalid class name */
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

    public SmartRefreshFooter(Context context) {
        super(context);
        this.mNoMoreData = false;
        initView(context);
    }

    private void initView(Context context) {
        setGravity(17);
        this.mTitleText = new TextView(context);
        this.mProgressView = new ImageView(context);
        this.mProgressView.setImageDrawable(getResources().getDrawable(R.drawable.ic_progress_puzzle));
        addView(this.mProgressView, c.a(20.0f), c.a(20.0f));
        addView(this.mTitleText, -1, -2);
        this.mTitleText.setGravity(17);
        setMinimumHeight(c.a(40.0f));
        this.mProgressView.animate().setInterpolator(null);
        this.mTitleText.setVisibility(8);
        this.mTitleText.setTextColor(getResources().getColor(R.color.itemEndTip));
        this.mTitleText.setTextSize(10.0f);
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
        if (this.mNoMoreData) {
            return 0;
        }
        this.mTitleText.setVisibility(8);
        ImageView imageView = this.mProgressView;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(WheelView.DividerConfig.FILL).setDuration(0L);
        }
        imageView.setVisibility(8);
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
        if (this.mNoMoreData) {
            return;
        }
        this.mTitleText.setVisibility(8);
        ImageView imageView = this.mProgressView;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.mProgressView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.f
    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()];
        if (i == 1 || i == 2 || i != 3) {
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public boolean setNoMoreData(boolean z) {
        if (this.mNoMoreData == z) {
            return true;
        }
        this.mNoMoreData = z;
        if (!z) {
            return true;
        }
        this.mTitleText.setVisibility(0);
        this.mTitleText.setText(R.string.item_end_tip);
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public void setPrimaryColors(int... iArr) {
    }

    public SmartRefreshFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNoMoreData = false;
        initView(context);
    }

    public SmartRefreshFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNoMoreData = false;
        initView(context);
    }
}
