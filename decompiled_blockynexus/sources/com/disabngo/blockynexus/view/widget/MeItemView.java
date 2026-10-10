package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.disabngo.blockynexus.R;

/* JADX INFO: loaded from: classes.dex */
public class MeItemView extends FrameLayout {
    private TextView tvNew;

    public MeItemView(Context context) {
        this(context, null);
    }

    private void hidePoint() {
        this.tvNew.setVisibility(8);
    }

    private void initView(Context context, int i, boolean z, int i2) {
        View.inflate(context, R.layout.content_me_item_view, this);
        ImageView imageView = (ImageView) findViewById(R.id.ivDrawableLeft);
        TextView textView = (TextView) findViewById(R.id.tvText);
        View viewFindViewById = findViewById(R.id.vLine);
        this.tvNew = (TextView) findViewById(R.id.tvNew);
        imageView.setImageResource(i);
        textView.setText(i2);
        viewFindViewById.setVisibility(z ? 0 : 8);
        changePoint(false);
        setClickable(true);
    }

    private void showPoint() {
        this.tvNew.setVisibility(0);
    }

    public void changePoint(boolean z) {
        if (z) {
            showPoint();
        } else {
            hidePoint();
        }
    }

    public void setBorderVisible(int i) {
        findViewById(R.id.vLine).setVisibility(i);
    }

    public MeItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MeItemView);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, R.mipmap.ic_me_help);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(2, true);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(4, R.string.finish);
        typedArrayObtainStyledAttributes.recycle();
        initView(context, resourceId, z, resourceId2);
    }
}
