package com.disabngo.blockynexus.view.dialog.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0664nc;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScrapHistoryDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f11555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f11556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11557c;

    public b(Context context) {
        super(context);
        this.f11555a = new d();
        this.f11557c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.f.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11554a.a();
            }
        });
        this.f11556b = new f(context, R.string.no_data);
        initView();
    }

    private void initView() {
        AbstractC0664nc abstractC0664nc = (AbstractC0664nc) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_scrap_history, (ViewGroup) null, false);
        abstractC0664nc.a(this);
        setContentView(abstractC0664nc.getRoot());
        setInnerViews(abstractC0664nc.f8614c, abstractC0664nc.f8612a);
    }

    public /* synthetic */ void a() {
        dismiss();
    }
}
