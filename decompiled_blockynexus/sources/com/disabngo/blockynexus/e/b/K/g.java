package com.disabngo.blockynexus.e.b.K;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.HelpDetailInfo;
import com.disabngo.blockynexus.view.dialog.Ba;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: HelpDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f9331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f9332c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.K.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9324a.f();
        }
    });

    public g(Context context, List<HelpDetailInfo> list) {
        this.f9330a = context;
        this.f9331b = new f(context, R.string.no_data, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        new Ba(this.f9330a, true).show();
    }
}
