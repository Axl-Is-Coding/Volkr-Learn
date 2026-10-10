package io.rong.imkit.actions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import io.rong.imkit.R;

/* JADX INFO: loaded from: classes5.dex */
public class ClickImageView extends RelativeLayout {
    private ImageView imageView;

    public ClickImageView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        this.imageView = new ImageView(context);
        this.imageView.setLayoutParams(new ViewGroup.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.rc_ext_more_imgage_width), context.getResources().getDimensionPixelOffset(R.dimen.rc_ext_more_imgage_height)));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.imageView, layoutParams);
    }

    public void setEnable(boolean z) {
        this.imageView.setEnabled(z);
    }

    public void setImageDrawable(Drawable drawable) {
        this.imageView.setImageDrawable(drawable);
    }

    public ClickImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }
}
