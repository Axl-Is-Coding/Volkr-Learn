package com.disabngo.blockynexus.view.fragment.inboxdetail;

import androidx.fragment.app.FragmentActivity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0797ze;
import com.disabngo.blockynexus.entity.MailInfo;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: InboxDetailFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends TemplateFragment<k, AbstractC0797ze> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0797ze abstractC0797ze, k kVar) {
        abstractC0797ze.a(kVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_inbox_detail;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onEvent(this.context, EventConstant.OPEN_MAIL);
        ReportDataAdapter.onResume(this.context);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public k getViewModel() {
        FragmentActivity activity;
        MailInfo mailInfo = getArguments() != null ? (MailInfo) getArguments().getSerializable(StringConstant.INBOX_DETAIL_INFO) : null;
        if (mailInfo != null && mailInfo.getExtra() != null && mailInfo.getType() == 2 && (activity = getActivity()) != null) {
            new LoadingDialog(activity).show();
        }
        return new k(this.context, mailInfo, (AbstractC0797ze) this.binding);
    }
}
