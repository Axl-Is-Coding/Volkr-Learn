package io.rong.imkit.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import io.rong.imkit.emoticon.AndroidEmoji;

/* JADX INFO: loaded from: classes5.dex */
public class SpannableTextView extends TextView {
    public SpannableTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence == null) {
            charSequence = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        AndroidEmoji.ensure(spannableStringBuilder, getTextSize());
        super.setText(spannableStringBuilder, bufferType);
    }

    public SpannableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SpannableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            setText("", TextView.BufferType.SPANNABLE);
        } else {
            setText(str, TextView.BufferType.SPANNABLE);
        }
    }
}
