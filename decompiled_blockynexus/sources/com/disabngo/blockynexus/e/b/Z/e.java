package com.disabngo.blockynexus.e.b.Z;

import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Ze;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: ReportFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends TemplateFragment<f, Ze> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Ze ze, f fVar) {
        ze.a(fVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_report;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public f getViewModel() {
        Bundle arguments = getArguments();
        return new f(this.context, arguments != null ? arguments.getLong(StringConstant.REPORT_USER_ID) : 0L);
    }
}
