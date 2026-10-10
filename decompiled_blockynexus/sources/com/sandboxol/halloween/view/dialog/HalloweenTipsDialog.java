package com.sandboxol.halloween.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.halloween.R;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public class HalloweenTipsDialog extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnClickListener f18668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f18669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f18670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f18671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f18672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f18673f;

    public interface OnClickListener {
        void onClick();
    }

    public HalloweenTipsDialog(Context context, String str, String str2, String str3, OnClickListener onClickListener) {
        super(context);
        this.f18669b = new ObservableField<>();
        this.f18670c = new ObservableField<>();
        this.f18671d = new ObservableField<>();
        this.f18672e = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.dialog.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18674a.dismiss();
            }
        });
        this.f18673f = new ReplyCommand(new o(this));
        initView();
        this.f18669b.set(str);
        this.f18670c.set(str2);
        this.f18671d.set(str3);
        this.f18668a = onClickListener;
    }

    private void initView() {
        com.sandboxol.halloween.b.g gVar = (com.sandboxol.halloween.b.g) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.halloween_dialog_tips, (ViewGroup) null, false);
        gVar.a(this);
        setContentView(gVar.getRoot());
    }
}
