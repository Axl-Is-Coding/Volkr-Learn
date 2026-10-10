package com.disabngo.blockynexus.e.b.B;

import android.os.Bundle;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.databinding.AbstractC0579fe;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: GroupChatFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends TemplateFragment<i, AbstractC0579fe> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0579fe abstractC0579fe, i iVar) {
        abstractC0579fe.a(iVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_chat;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onRightButtonClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(StringConstant.TYPE_LIST_GROUP, 0);
        TemplateUtils.startTemplate(this.context, com.disabngo.blockynexus.e.b.F.f.class, getString(R.string.start_group_chat), bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public i getViewModel() {
        if (getArguments() != null) {
            boolean z = getArguments().getBoolean(StringConstant.TYPE_GROUP_CARD);
            boolean z2 = getArguments().getBoolean(StringConstant.TYPE_GROUP_CARD_PRIVATE_FLAG);
            String string = getArguments().getString("targetId");
            y.b().a(z);
            y.b().b(string);
            y.b().c(z2);
        }
        return new i(this.context);
    }
}
