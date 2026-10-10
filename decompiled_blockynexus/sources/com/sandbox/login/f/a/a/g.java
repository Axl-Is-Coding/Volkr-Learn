package com.sandbox.login.f.a.a;

import android.content.Context;
import android.os.Build;
import androidx.databinding.ObservableField;
import com.google.android.material.textfield.TextInputLayout;
import com.sandbox.login.R;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SetAccountModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static void a(Context context, String str, TextInputLayout textInputLayout) {
        if (str.length() < 6) {
            if (Build.VERSION.SDK_INT >= 23) {
                textInputLayout.setHelperTextColor(context.getColorStateList(R.color.login_tips_color_1));
            }
            textInputLayout.setHelperText(context.getString(R.string.login_account_length_error));
        } else if (Pattern.compile("[0-9]*").matcher(str).matches()) {
            if (Build.VERSION.SDK_INT >= 23) {
                textInputLayout.setHelperTextColor(context.getColorStateList(R.color.login_tips_color_1));
            }
            textInputLayout.setHelperText(context.getString(R.string.login_account_num_error));
        } else {
            if (com.sandbox.login.e.e.a(str)) {
                textInputLayout.setHelperText("");
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                textInputLayout.setHelperTextColor(context.getColorStateList(R.color.login_tips_color_1));
            }
            textInputLayout.setHelperText(context.getString(R.string.base_set_account_error));
        }
    }

    public static void a(Context context, String str, ObservableField<Boolean> observableField) {
        observableField.set(true);
        com.sandbox.login.web.b.a(context, str, new f(observableField, str, context));
    }
}
