package com.disabngo.blockynexus.e.b.L;

import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.MailInfo;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import java.io.Serializable;
import rx.functions.Action0;

/* JADX INFO: compiled from: InboxItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends ListItemViewModel<MailInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f9335a;

    public d(Context context, MailInfo mailInfo) {
        super(context, mailInfo);
        this.f9335a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.L.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9333a.f();
            }
        });
    }

    public /* synthetic */ void f() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StringConstant.INBOX_DETAIL_INFO, (Serializable) this.item);
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.view.fragment.inboxdetail.g.class, context.getString(R.string.email), bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public MailInfo getItem() {
        return (MailInfo) super.getItem();
    }
}
