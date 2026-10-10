package com.sandboxol.halloween.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.halloween.R;
import rx.functions.Action0;

/* JADX INFO: compiled from: HalloweenRulerDialog.java */
/* JADX INFO: loaded from: classes4.dex */
public class n extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f18700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f18701b;

    public n(Context context, String str) {
        super(context);
        this.f18700a = new ObservableField<>();
        this.f18701b = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.dialog.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f18683a.dismiss();
            }
        });
        initView();
        this.f18700a.set(str);
    }

    private void initView() {
        com.sandboxol.halloween.b.e eVar = (com.sandboxol.halloween.b.e) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.halloween_dialog_ruler, (ViewGroup) null, false);
        eVar.a(this);
        setContentView(eVar.getRoot());
    }
}
