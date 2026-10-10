package com.disabngo.blockynexus.e.b.ua;

import android.content.Context;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0535bg;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeTaskFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends TemplateFragment<s, AbstractC0535bg> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0535bg abstractC0535bg, s sVar) {
        abstractC0535bg.a(sVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribe_task;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_ENTER_TASK);
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onRightButtonClick(View view) {
        Context context = this.context;
        TemplateUtils.startTemplate(context, g.class, context.getString(R.string.description));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public s getViewModel() {
        return new s(this.context);
    }
}
