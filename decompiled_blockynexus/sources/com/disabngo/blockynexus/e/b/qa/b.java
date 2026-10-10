package com.disabngo.blockynexus.e.b.qa;

import android.app.Activity;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Uf;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeNoticeFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends TemplateFragment<d, Uf> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f10095a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Uf uf, d dVar) {
        uf.a(dVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribe_notice;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause((Activity) this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume((Activity) this.context);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_ENTER_NOTICE);
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onRightButtonClick(View view) {
        super.onRightButtonClick(view);
        this.f10095a.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public d getViewModel() {
        this.f10095a = new d(getActivity());
        return this.f10095a;
    }
}
