package com.sandbox.login.f.a.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandbox.login.f.a.f.q;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.RegisterInfo;

/* JADX INFO: compiled from: MakeRoleModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: compiled from: MakeRoleModel.java */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public static void a(final Context context, s sVar, final RegisterInfo registerInfo, final ObservableField<Boolean> observableField, final a aVar) {
        if (TextUtils.isEmpty(registerInfo.getNickName())) {
            aVar.onError(context.getString(R.string.login_account_nick_name_empty));
            ReportDataAdapter.onEvent(context, EventConstant.BUILDWIN_CLICK_CONFIRM, "nickname empty");
            return;
        }
        if (registerInfo.getNickName().length() < 6) {
            aVar.onError(context.getString(R.string.login_account_nickname_less_6));
            ReportDataAdapter.onEvent(context, EventConstant.BUILDWIN_CLICK_CONFIRM, "less than 6 bit");
            return;
        }
        if (registerInfo.getSex() == 0) {
            aVar.onError(context.getString(R.string.login_account_sex_empty));
            ReportDataAdapter.onEvent(context, EventConstant.BUILDWIN_CLICK_CONFIRM, "choose gender");
            return;
        }
        if (SharedUtils.getBoolean(context, StringConstant.KEY_IS_OPEN_EMULATOR, false)) {
            registerInfo.setInviteCode("");
        }
        observableField.set(true);
        if (sVar.g() != null) {
            new com.sandbox.login.f.a.f.q().a(context, sVar.g(), observableField, new q.b() { // from class: com.sandbox.login.f.a.d.a
                @Override // com.sandbox.login.f.a.f.q.b
                public final void a(SetPasswordForm setPasswordForm) {
                    v.a(context, registerInfo, (ObservableField<Boolean>) observableField, setPasswordForm, aVar);
                }
            });
        } else {
            a(context, registerInfo, observableField, (SetPasswordForm) null, aVar);
        }
    }

    public static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return context.getString(R.string.login_account_nick_name_empty);
        }
        if (str.length() < 6) {
            return context.getString(R.string.login_account_nickname_less_6);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, RegisterInfo registerInfo, ObservableField<Boolean> observableField, SetPasswordForm setPasswordForm, a aVar) {
        UserApi.userRegister(context, registerInfo, new u(context, setPasswordForm, aVar, observableField));
    }
}
