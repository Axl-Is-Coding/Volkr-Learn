package com.sandboxol.common.utils;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sandboxol.common.R;

/* JADX INFO: loaded from: classes3.dex */
public class AppToastUtils {
    private static final boolean NEGATIVE = false;
    private static final boolean POSITIVE = true;

    public static void showLongNegativeTipToast(Context context, int i) {
        showTipToast(context, context.getString(i), false, 1);
    }

    public static void showLongPositiveTipToast(Context context, int i) {
        showTipToast(context, context.getString(i), true, 1);
    }

    public static void showShortNegativeTipToast(Context context, int i) {
        showTipToast(context, context.getString(i), false, 0);
    }

    public static void showShortPositiveTipToast(Context context, int i) {
        showTipToast(context, context.getString(i), true, 0);
    }

    public static void showTipToast(Context context, String str, boolean z, int i) {
        try {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.toast_tip, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_tip_type);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_tip_content);
            if (z) {
                imageView.setImageResource(R.mipmap.ic_tip_positive);
            } else {
                imageView.setImageResource(R.mipmap.ic_tip_negative);
            }
            Toast toast = new Toast(context);
            toast.setView(viewInflate);
            toast.setGravity(81, 0, (int) SizeUtil.dp2px(context, 58.0f));
            textView.setText(str);
            toast.setDuration(i);
            if (Build.VERSION.SDK_INT == 25) {
                SafeToastUtil.hook(toast);
            }
            if (Build.VERSION.SDK_INT >= 28 && toast.getView().isShown()) {
                toast.cancel();
            }
            toast.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void showLongNegativeTipToast(Context context, String str) {
        showTipToast(context, str, false, 1);
    }

    public static void showLongPositiveTipToast(Context context, String str) {
        showTipToast(context, str, true, 1);
    }

    public static void showShortNegativeTipToast(Context context, String str) {
        showTipToast(context, str, false, 0);
    }

    public static void showShortPositiveTipToast(Context context, String str) {
        showTipToast(context, str, true, 0);
    }
}
