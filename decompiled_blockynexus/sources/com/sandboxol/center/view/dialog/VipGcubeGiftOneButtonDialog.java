package com.sandboxol.center.view.dialog;

import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.sandboxol.center.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.databinding.BaseDialogVipGcubeGiftOneButtonBinding;
import com.sandboxol.center.view.activity.FollowUpActivity;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class VipGcubeGiftOneButtonDialog extends FollowUpActivity {
    public ObservableField<String> textDetail = new ObservableField<>("");
    public ReplyCommand onCloseClick = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.q
        @Override // rx.functions.Action0
        public final void call() {
            this.f16388a.g();
        }
    });

    public /* synthetic */ void g() {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseDialogVipGcubeGiftOneButtonBinding baseDialogVipGcubeGiftOneButtonBinding = (BaseDialogVipGcubeGiftOneButtonBinding) androidx.databinding.e.a(this, R.layout.base_dialog_vip_gcube_gift_one_button);
        baseDialogVipGcubeGiftOneButtonBinding.setVipGcubeGiftOneButtonDialog(this);
        long longExtra = getIntent().getLongExtra(StringConstant.RECHARGE_MESSAGE, 0L);
        if (longExtra == 0) {
            this.textDetail.set(getString(R.string.base_buy_vip_success));
        } else {
            this.textDetail.set(getString(R.string.base_vip_get_gdiamond_gift, new Object[]{Long.valueOf(longExtra)}));
            baseDialogVipGcubeGiftOneButtonBinding.tvDetails.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_diamond_gold, 0);
        }
    }
}
