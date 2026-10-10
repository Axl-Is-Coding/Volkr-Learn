package com.disabngo.blockynexus.binding.adapter;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.app.BaseApplication;
import com.umeng.umcrash.UMCustomLogInfoBuilder;

/* JADX INFO: compiled from: SelectableTextViewBindAdapters.java */
/* JADX INFO: loaded from: classes.dex */
public class q {
    public static void a(TextView textView, int i, int i2) {
        String string = textView.getText().toString();
        String[] strArrSplit = string.split(UMCustomLogInfoBuilder.LINE_SEP);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new AbsoluteSizeSpan(i, true), 0, strArrSplit[0].length(), 18);
        spannableString.setSpan(new AbsoluteSizeSpan(i2, true), strArrSplit[0].length(), string.length(), 18);
        spannableString.setSpan(new StyleSpan(1), 0, strArrSplit[0].length(), 18);
        spannableString.setSpan(new ForegroundColorSpan(BaseApplication.getContext().getResources().getColor(R.color.FriendInfoIdTextColor)), strArrSplit[0].length(), string.length(), 18);
        textView.setText(spannableString);
    }
}
