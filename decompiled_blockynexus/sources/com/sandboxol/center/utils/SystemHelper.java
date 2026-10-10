package com.sandboxol.center.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class SystemHelper {
    public static void hideSoftInput(Context context, EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 2);
        }
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean isUser(long j) {
        return (j & 15) == 0;
    }

    public static boolean isUser(String str) {
        return isNumeric(str) && (Long.parseLong(str) & 15) == 0;
    }
}
