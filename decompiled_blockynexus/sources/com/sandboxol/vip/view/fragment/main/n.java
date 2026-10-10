package com.sandboxol.vip.view.fragment.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.router.path.RouterFragmentPath;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.vip.R;

/* JADX INFO: compiled from: PrivilegeCenterFragment.java */
/* JADX INFO: loaded from: classes4.dex */
@Route(path = RouterFragmentPath.PrivilegeModule.PAGER_MAIN)
public class n extends TemplateFragment<s, com.sandboxol.vip.b.m> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(com.sandboxol.vip.b.m mVar, s sVar) {
        mVar.a(sVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.vip_fragment_privilege_center;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public s getViewModel() {
        return new s(this.context, (com.sandboxol.vip.b.m) this.binding);
    }
}
