package com.sandboxol.common.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class SafeToastUtil {
    private static Field sField_TN;
    private static Field sField_TN_Handler;

    private static class SafelyHandlerWarpper extends Handler {
        private Handler impl;

        public SafelyHandlerWarpper(Handler handler) {
            this.impl = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception unused) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.impl.handleMessage(message);
        }
    }

    static {
        try {
            sField_TN = Toast.class.getDeclaredField("mTN");
            sField_TN.setAccessible(true);
            sField_TN_Handler = sField_TN.getType().getDeclaredField("mHandler");
            sField_TN_Handler.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    public static void hook(Toast toast) {
        try {
            Object obj = sField_TN.get(toast);
            sField_TN_Handler.set(obj, new SafelyHandlerWarpper((Handler) sField_TN_Handler.get(obj)));
        } catch (Exception unused) {
        }
    }

    public static void showToast(Context context, CharSequence charSequence, int i) {
        Toast toastMakeText = Toast.makeText(context, charSequence, i);
        hook(toastMakeText);
        toastMakeText.show();
    }
}
