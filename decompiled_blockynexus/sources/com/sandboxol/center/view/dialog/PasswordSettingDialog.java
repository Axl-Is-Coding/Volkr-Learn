package com.sandboxol.center.view.dialog;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableField;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.databinding.BaseDialogPasswordSettingBinding;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.c.va;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class PasswordSettingDialog extends AppCompatActivity {
    private BaseDialogPasswordSettingBinding binding;
    public ReplyCommand onConfirmCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.l
        @Override // rx.functions.Action0
        public final void call() {
            this.f16383a.onConfirm();
        }
    });
    public ReplyCommand onCancelCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f16378a.finish();
        }
    });
    public ObservableField<Boolean> isSHowCheckTip = new ObservableField<>(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfirm() {
        ReportDataAdapter.onEvent(this, EventConstant.UNSET_PASSWORD_CLICK_GO);
        if (this.binding.cbTip.isChecked()) {
            va.newInstance().c(AccountCenter.newInstance().userId.get().longValue(), true);
        }
        LoginManager.onSetPassword(this, getString(R.string.base_password_setting_confirm));
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (BaseDialogPasswordSettingBinding) androidx.databinding.e.a(this, R.layout.base_dialog_password_setting);
        this.binding.setPasswordSettingDialog(this);
        boolean booleanExtra = getIntent().getBooleanExtra(StringConstant.IS_FORCE_SHOW_PASSWORD_SETTING, false);
        this.isSHowCheckTip.set(Boolean.valueOf(booleanExtra));
        if (!booleanExtra) {
            SharedUtils.putLong(this, SharedConstant.KEY_PASSWORD_SETTING_TIME, System.currentTimeMillis());
        }
        va.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ReportDataAdapter.onEvent(this, EventConstant.UNSET_PASSWORD_POPUP);
    }
}
