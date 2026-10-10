package com.sandboxol.googlepay.view.fragment.recharge;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.path.RouterFragmentPath;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.googlepay.R;

/* JADX INFO: compiled from: RechargeFragment.java */
/* JADX INFO: loaded from: classes3.dex */
@Route(path = RouterFragmentPath.RechargeModule.PAGER_RECHARGE)
public class k extends TemplateFragment<w, com.sandboxol.googlepay.a.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w f18374a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(com.sandboxol.googlepay.a.c cVar, w wVar) {
        this.f18374a = wVar;
        cVar.a(wVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_recharge;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        super.onBackPressed();
        if (this.f18374a.h.get() == null || this.f18374a.h.get().getUserId() == 0 || TextUtils.isEmpty(this.f18374a.h.get().getStarCode())) {
            return;
        }
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_PLFGT_BACK);
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
        ReportDataAdapter.onEvent(this.context, EventConstant.ENTER_RECHARGE_PAGE);
        FirebaseUtils.onEvent(this.context, EventConstant.ENTER_RECHARGE_PAGE);
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onRightButtonClick(View view) {
        super.onRightButtonClick(view);
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.sandboxol.googlepay.c.a.c.b.class, context.getString(R.string.googleplay_recharge_history));
        ReportDataAdapter.onEvent(this.context, EventConstant.TOPUP_INFO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public w getViewModel() {
        Boolean boolValueOf;
        Boolean boolValueOf2;
        String str;
        String string;
        String string2;
        if (getArguments() != null) {
            boolValueOf = Boolean.valueOf(getArguments().getBoolean(StringConstant.PAY_SIGNATURE_ERROR));
            if (!boolValueOf.booleanValue()) {
                String string3 = getArguments().getString(StringConstant.PAY_STATE);
                string = getArguments().getString(StringConstant.PAY_PRODUCT_ID);
                str = string3;
                string2 = getArguments().getString(StringConstant.PAY_PM_ID);
                boolValueOf2 = Boolean.valueOf(getArguments().getBoolean(StringConstant.IS_FIRST_TOP));
                return new w(this.context, (com.sandboxol.googlepay.a.c) this.binding, boolValueOf.booleanValue(), str, string, string2, boolValueOf2);
            }
            boolValueOf2 = false;
        } else {
            boolValueOf = false;
            boolValueOf2 = null;
        }
        str = null;
        string = null;
        string2 = null;
        return new w(this.context, (com.sandboxol.googlepay.a.c) this.binding, boolValueOf.booleanValue(), str, string, string2, boolValueOf2);
    }
}
