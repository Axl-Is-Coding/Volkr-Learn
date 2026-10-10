package com.disabngo.blockynexus.e.b.ka;

import android.content.Context;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Ef;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeContributionFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends TemplateFragment<p, Ef> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Ef ef, p pVar) {
        ef.a(pVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribe_contribution;
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
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_ENTER_DONATION);
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onRightButtonClick(View view) {
        Context context = this.context;
        TemplateUtils.startTemplate(context, f.class, context.getString(R.string.description));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public p getViewModel() {
        return new p(this.context);
    }
}
