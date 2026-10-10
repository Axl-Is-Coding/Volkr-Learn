package com.sandboxol.common.binding.adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class TextViewBindingAdapters {
    public static void editTextCommand(TextView textView, final ReplyCommand<EditTextBindingAdapters.TextChangeDataWrapper> replyCommand, final ReplyCommand<EditTextBindingAdapters.TextChangeDataWrapper> replyCommand2, final ReplyCommand<String> replyCommand3) {
        textView.addTextChangedListener(new TextWatcher() { // from class: com.sandboxol.common.binding.adapter.TextViewBindingAdapters.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ReplyCommand replyCommand4 = replyCommand3;
                if (replyCommand4 != null) {
                    replyCommand4.execute(editable.toString());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ReplyCommand replyCommand4 = replyCommand;
                if (replyCommand4 != null) {
                    replyCommand4.execute(new EditTextBindingAdapters.TextChangeDataWrapper(charSequence, i, i2, i2));
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ReplyCommand replyCommand4 = replyCommand2;
                if (replyCommand4 != null) {
                    replyCommand4.execute(new EditTextBindingAdapters.TextChangeDataWrapper(charSequence, i, i2, i3));
                }
            }
        });
    }

    public static void isEnable(TextView textView, boolean z) {
        textView.setEnabled(z);
    }

    public static void onColorTextCommand(TextView textView, String str, int i, int i2, int i3) {
        if (str == null) {
            str = "";
        }
        if (i == 0) {
            i = -16777216;
        }
        try {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i), i2, i3, 33);
            textView.setText(spannableString);
        } catch (Exception e2) {
            e2.printStackTrace();
            textView.setText(str);
        }
    }

    public static void onLoadMoreCommand(TextView textView, boolean z) {
        if (z) {
            textView.getPaint().setFlags(17);
        }
    }

    public static void onSelect(TextView textView, boolean z) {
        textView.setSelected(z);
    }

    public static void setBackground(TextView textView, Drawable drawable) {
        textView.setBackground(drawable);
    }

    public static void setLeftDrawable(TextView textView, Drawable drawable) {
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public static void setMovementMethod(TextView textView, boolean z) {
        if (z) {
            textView.setVerticalScrollBarEnabled(true);
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
    }

    public static void setRoundBackground(TextView textView, int i, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i);
        if (!TextUtils.isEmpty(str)) {
            gradientDrawable.setColor(Color.parseColor(str));
        }
        textView.setBackground(gradientDrawable);
    }
}
