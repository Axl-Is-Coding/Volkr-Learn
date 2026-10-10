package com.sandboxol.decorate.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sandboxol.decorate.R;

/* JADX INFO: loaded from: classes3.dex */
public class DressLoadingView extends FrameLayout {
    private AnimationDrawable animationDrawable;

    public DressLoadingView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.view_dress_loading, this);
        this.animationDrawable = (AnimationDrawable) ((ImageView) findViewById(R.id.ivLoading)).getBackground();
        startAnimate();
    }

    public void startAnimate() {
        if (this.animationDrawable.isRunning()) {
            return;
        }
        this.animationDrawable.start();
    }

    public void stopAnimate() {
        if (this.animationDrawable.isRunning()) {
            this.animationDrawable.stop();
        }
    }

    public DressLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DressLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
