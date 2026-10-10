package com.sandbox.login.f.a.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.center.web.UserApi;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: StepModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: compiled from: StepModel.java */
    public interface a {
        void a(String str);

        void b(String str);

        void c(String str);

        void onSuccess();
    }

    /* JADX INFO: compiled from: StepModel.java */
    public interface b {
        void a(SetPasswordForm setPasswordForm);
    }

    public void a(Context context, SetPasswordForm setPasswordForm, a aVar) {
        if (TextUtils.isEmpty(setPasswordForm.getPassword())) {
            aVar.b(context.getString(R.string.login_account_confirm_password_empty));
            return;
        }
        if (setPasswordForm.getPassword().length() < 6) {
            aVar.b(context.getString(R.string.login_account_password_less_6));
            return;
        }
        if (!setPasswordForm.getPassword().equals(setPasswordForm.getConfirmPassword())) {
            aVar.c(context.getString(R.string.login_account_password_not_compare));
            return;
        }
        if (TextUtils.isEmpty(setPasswordForm.getAccount())) {
            aVar.a(context.getString(R.string.login_account_account_empty));
            return;
        }
        if (setPasswordForm.getAccount().length() < 6) {
            aVar.a(context.getString(R.string.login_account_length_error));
            return;
        }
        if (Pattern.compile("[0-9]*").matcher(setPasswordForm.getAccount()).matches()) {
            aVar.a(context.getString(R.string.login_account_num_error));
        } else if (com.sandbox.login.e.e.a(setPasswordForm.getAccount())) {
            aVar.onSuccess();
        } else {
            aVar.a(context.getString(R.string.base_set_account_error));
        }
    }

    public void a(Context context, SetPasswordForm setPasswordForm, ObservableField<Boolean> observableField, b bVar) {
        UserApi.renew(context, setPasswordForm.getAccount(), new o(this, setPasswordForm, context, bVar, observableField));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, SetPasswordForm setPasswordForm, b bVar) {
        com.sandbox.login.web.b.a(context, setPasswordForm, new p(this, context, setPasswordForm, bVar));
    }
}
