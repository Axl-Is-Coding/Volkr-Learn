package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Jc;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.listener.OnViewClickListener;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeContributionGetDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class Sa extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f11369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f11370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnViewClickListener f11371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f11372d;

    public Sa(Context context) {
        super(context);
        this.f11369a = new ObservableField<>();
        this.f11370b = new ObservableField<>();
        this.f11372d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.x
            @Override // rx.functions.Action0
            public final void call() {
                this.f11712a.cancel();
            }
        });
    }

    public Sa a(int i, int i2) {
        this.f11369a.set(String.valueOf(i));
        this.f11370b.set(String.valueOf(i2));
        return this;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        OnViewClickListener onViewClickListener = this.f11371c;
        if (onViewClickListener != null) {
            onViewClickListener.onClick();
        }
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(Context context) {
        super.init(context);
        Jc jc = (Jc) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.dialog_tribe_get_contribution, (ViewGroup) null, false);
        jc.a(this);
        setContentView(jc.getRoot());
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        cancel();
    }

    public Sa a(String str, String str2) {
        this.f11369a.set(str);
        this.f11370b.set(str2);
        return this;
    }

    public Sa a(OnViewClickListener onViewClickListener) {
        this.f11371c = onViewClickListener;
        return this;
    }
}
