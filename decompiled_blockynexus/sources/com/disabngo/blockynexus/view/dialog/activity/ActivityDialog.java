package com.disabngo.blockynexus.view.dialog.activity;

import android.os.Build;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.La;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityDialog extends BaseActivity<A, La> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(La la, A a2) {
        la.a(a2);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.dialog_activity;
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        ReportDataAdapter.onEvent(this, EventConstant.ACTIVE_TIME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public A getViewModel() {
        try {
            return new A(this, (List) new com.google.gson.j().a(getIntent().getStringExtra(StringConstant.ACTIVITY_TASK_TITLE), new l(this).getType()), (La) this.binding);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new A(this, new ArrayList(), (La) this.binding);
        }
    }
}
