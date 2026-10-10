package com.disabngo.blockynexus.e.b.p;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Ve;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: CheckUpdateFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends TemplateFragment<o, Ve> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Ve ve, o oVar) {
        ve.a(oVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_refresh_data;
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
        ReportDataAdapter.onEvent(this.context, EventConstant.ENTER_UPDATE_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public o getViewModel() {
        return new o((Activity) this.context, (Ve) this.binding);
    }
}
