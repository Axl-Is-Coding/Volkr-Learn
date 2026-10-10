package com.disabngo.blockynexus.e.b.B;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupChatViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9119a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f9122d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f9120b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.B.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9110a.f();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f9121c = new f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f9123e = new ObservableField<>();

    public i(Context context) {
        this.f9119a = context;
        this.f9123e.set(false);
        this.f9122d = new h(context, R.string.no_data, this.f9123e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt(StringConstant.TYPE_LIST_GROUP, 0);
        Context context = this.f9119a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.F.f.class, context.getString(R.string.start_group_chat), bundle);
    }
}
