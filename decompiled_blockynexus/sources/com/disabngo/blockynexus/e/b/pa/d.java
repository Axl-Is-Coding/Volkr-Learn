package com.disabngo.blockynexus.e.b.pa;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.A;
import com.disabngo.blockynexus.databinding.Qf;
import com.disabngo.blockynexus.view.activity.main.MainActivity;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeMessageFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends TemplateFragment<k, Qf> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Qf qf, k kVar) {
        qf.a(kVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribe_message;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        super.onBackPressed();
        if (A.a(this.context, "MainActivity")) {
            return;
        }
        Context context = this.context;
        context.startActivity(new Intent(context, (Class<?>) MainActivity.class).putExtra(StringConstant.RONGCLOUD_PUSH_SELECT_TYPE, StringConstant.RONGCLOUD_PUSH_SELECT_AGREE_JOIN_CLAN).addFlags(268435456));
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onLeftButtonClick(View view) {
        super.onLeftButtonClick(view);
        onBackPressed();
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume(this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public k getViewModel() {
        return new k(this.context);
    }
}
