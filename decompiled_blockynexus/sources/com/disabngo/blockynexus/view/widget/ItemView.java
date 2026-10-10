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
public class ItemView extends FrameLayout {
    private ImageView ivArrow;
    private ImageView ivLeftPoint;
    private ImageView ivPoint;
    private TextView tvLeftText;
    private TextView tvRightText;

    public ItemView(Context context) {
        this(context, null);
    }

    private void hidePoint() {
        this.ivPoint.setVisibility(8);
        this.ivArrow.setVisibility(0);
    }

    private void initView(Context context, boolean z, boolean z2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        View.inflate(context, R.layout.content_item_view, this);
        View viewFindViewById = findViewById(R.id.vLine);
        this.ivArrow = (ImageView) findViewById(R.id.ivArrow);
        this.ivPoint = (ImageView) findViewById(R.id.ivPoint);
        this.ivLeftPoint = (ImageView) findViewById(R.id.ivLeftPoint);
        this.tvRightText = (TextView) findViewById(R.id.tvRightText);
        this.tvLeftText = (TextView) findViewById(R.id.tvLeftText);
        setLeftText(charSequence);
        setText(charSequence2);
        this.tvRightText.setHint(charSequence3);
        this.ivArrow.setVisibility(z ? 0 : 8);
        viewFindViewById.setVisibility(z2 ? 0 : 8);
        this.ivPoint.setVisibility(8);
        setClickable(true);
    }

    private void showPoint() {
        this.ivPoint.setVisibility(0);
        this.ivArrow.setVisibility(8);
    }

    public void setLeftRedPoint(boolean z) {
        this.ivLeftPoint.setVisibility(z ? 0 : 8);
    }

    public void setLeftText(CharSequence charSequence) {
        this.tvLeftText.setText(charSequence);
    }

    public void setRedPoint(boolean z) {
        if (z) {
            showPoint();
        } else {
            hidePoint();
        }
    }

    public void setRightText(CharSequence charSequence) {
        this.tvRightText.setText(charSequence);
    }

    public void setText(CharSequence charSequence) {
        this.tvRightText.setText(charSequence);
    }

    public void setTvRightTextResColor(int i) {
        this.tvRightText.setTextColor(getContext().getResources().getColor(i));
    }

    public ItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ItemView);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(7, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(0, true);
        CharSequence text = typedArrayObtainStyledAttributes.getText(3);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(4);
        CharSequence text3 = typedArrayObtainStyledAttributes.getText(6);
        typedArrayObtainStyledAttributes.recycle();
        initView(context, z, z2, text, text2, text3);
    }
}
