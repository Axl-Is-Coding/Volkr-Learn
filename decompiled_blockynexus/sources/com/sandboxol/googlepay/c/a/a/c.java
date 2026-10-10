package com.sandboxol.googlepay.c.a.a;

import android.text.TextUtils;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.googlepay.R;

/* JADX INFO: compiled from: PayFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends TemplateFragment<d, com.sandboxol.googlepay.a.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StarCodeUser f18335a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(com.sandboxol.googlepay.a.a aVar, d dVar) {
        aVar.a(dVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_pay;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        super.onBackPressed();
        StarCodeUser starCodeUser = this.f18335a;
        if ((starCodeUser == null || starCodeUser.getUserId() == 0 || TextUtils.isEmpty(this.f18335a.getStarCode())) ? false : true) {
            ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_CODEPAY_BACK);
        }
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
        StarCodeUser starCodeUser = this.f18335a;
        if ((starCodeUser == null || starCodeUser.getUserId() == 0 || TextUtils.isEmpty(this.f18335a.getStarCode())) ? false : true) {
            ReportDataAdapter.onEvent(this.context, EventConstant.STAR_PLFSHOW_CODEPAY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public d getViewModel() {
        ProductEntity productEntity = (ProductEntity) getArguments().getSerializable(StringConstant.DIAMOND_PRODUCT_INFO);
        this.f18335a = (StarCodeUser) getArguments().getParcelable(StringConstant.DIAMOND_STAR_CODE_INFO);
        return new d(this.context, productEntity, this.f18335a);
    }
}
