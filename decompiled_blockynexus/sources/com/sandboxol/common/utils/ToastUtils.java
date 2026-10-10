package com.sandboxol.common.utils;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: loaded from: classes3.dex */
public class ToastUtils {
    private static Toast toast;

    public static void showLongToast(Context context, String str) {
        try {
            if (toast != null) {
                toast.cancel();
            }
            toast = Toast.makeText(BaseApplication.getContext(), str, 1);
            toast.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void showShortToast(Context context, String str) {
        try {
            if (toast != null) {
                toast.cancel();
            }
            toast = Toast.makeText(BaseApplication.getContext(), str, 0);
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

    public static void showToast(Context context, String str) {
        Toast.makeText(BaseApplication.getContext(), str, 0).show();
    }

    public static void showToast(Context context, int i) {
        Toast.makeText(BaseApplication.getContext(), i, 0).show();
    }

    public static void showLongToast(Context context, int i) {
        try {
            if (toast != null) {
                toast.cancel();
            }
            toast = Toast.makeText(BaseApplication.getContext(), i, 0);
            toast.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void showShortToast(Context context, int i) {
        try {
            if (toast != null) {
                toast.cancel();
            }
            toast = Toast.makeText(BaseApplication.getContext(), i, 0);
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
}
