package io.rong.imkit.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imkit.R;

/* JADX INFO: loaded from: classes5.dex */
public class AutoLinkTextView extends TextView {
    private int mMaxWidth;

    public static class URLSpanNoUnderline extends URLSpan {
        public URLSpanNoUnderline(String str) {
            super(str);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public AutoLinkTextView(Context context) {
        super(context);
    }

    private void initWidth(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoLinkTextView);
        this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoLinkTextView_RCMaxWidth, 0);
        setMaxWidth(this.mMaxWidth);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Layout layout = getLayout();
        float fMax = WheelView.DividerConfig.FILL;
        for (int i3 = 0; i3 < layout.getLineCount(); i3++) {
            fMax = Math.max(fMax, layout.getLineWidth(i3));
        }
        float compoundPaddingLeft = fMax + getCompoundPaddingLeft() + getCompoundPaddingRight();
        if (getBackground() != null) {
            compoundPaddingLeft = Math.max(compoundPaddingLeft, getBackground().getIntrinsicWidth());
        }
        int i4 = this.mMaxWidth;
        if (i4 != 0) {
            compoundPaddingLeft = Math.min(compoundPaddingLeft, i4);
        }
        setMeasuredDimension((int) Math.ceil(compoundPaddingLeft), getMeasuredHeight());
    }

    public void stripUnderlines() {
        if (getText() instanceof Spannable) {
            Spannable spannable = (Spannable) getText();
            for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
                int spanStart = spannable.getSpanStart(uRLSpan);
                int spanEnd = spannable.getSpanEnd(uRLSpan);
                spannable.removeSpan(uRLSpan);
                spannable.setSpan(new URLSpanNoUnderline(uRLSpan.getURL()), spanStart, spanEnd, 0);
            }
        }
    }

    public AutoLinkTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initWidth(context, attributeSet);
        setAutoLinkMask(7);
    }

    public AutoLinkTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initWidth(context, attributeSet);
        setAutoLinkMask(7);
    }

    @TargetApi(21)
    public AutoLinkTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initWidth(context, attributeSet);
        setAutoLinkMask(7);
    }
}
