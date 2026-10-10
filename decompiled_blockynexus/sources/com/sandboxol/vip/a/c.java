package com.sandboxol.vip.a;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;

/* JADX INFO: compiled from: VipTextViewBindingAdapters.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static void a(TextView textView, int i) {
        if (textView == null || textView.getContext() == null) {
            return;
        }
        textView.setText(Html.fromHtml(textView.getContext().getResources().getString(i)));
    }

    public static void a(TextView textView, int i, String str, int i2) {
        if (textView == null || textView.getContext() == null || i == 0 || TextUtils.isEmpty(str) || i2 == 0) {
            return;
        }
        String string = textView.getContext().getString(i);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            SpannableString spannableString = new SpannableString(string + "  " + str);
            Drawable drawable = textView.getContext().getResources().getDrawable(i2);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableString.setSpan(new ImageSpan(drawable), (r5.length() - str.length()) - 2, (r5.length() - str.length()) - 1, 33);
            textView.setText(spannableString);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
