package com.sandboxol.gamedetail.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.listener.OnViewClickListener;
import com.sandboxol.gamedetail.R;
import com.sandboxol.gamedetail.a.AbstractC2680i;
import com.sandboxol.gamedetail.c.a.a.ba;
import rx.functions.Action0;

/* JADX INFO: compiled from: EnterGameGuideDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnViewClickListener f18136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ba f18137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f18138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Integer> f18139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f18140e;

    public d(Context context, boolean z, int i, ba baVar) {
        super(context);
        this.f18138c = new ObservableField<>(false);
        this.f18139d = new ObservableField<>(0);
        this.f18140e = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.view.dialog.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18115a.a();
            }
        });
        this.f18138c.set(Boolean.valueOf(z));
        this.f18139d.set(Integer.valueOf(i));
        this.f18137b = baVar;
        a(context);
    }

    private void a(Context context) {
        AbstractC2680i abstractC2680i = (AbstractC2680i) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.dialog_enter_game_guide, (ViewGroup) null, false);
        abstractC2680i.a(this);
        abstractC2680i.a(this.f18137b);
        setContentView(abstractC2680i.getRoot());
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog
    public void show() {
        super.show();
        ReportDataAdapter.onEvent(this.context, EventConstant.GAME_GUIDE_TIME);
    }

    public d a(OnViewClickListener onViewClickListener) {
        this.f18136a = onViewClickListener;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        OnViewClickListener onViewClickListener = this.f18136a;
        if (onViewClickListener != null) {
            onViewClickListener.onClick();
        }
        if (isShowing()) {
            dismiss();
        }
    }
}
