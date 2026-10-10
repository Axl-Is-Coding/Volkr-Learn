package com.disabngo.blockynexus.view.dialog.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0795zc;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScrapRuleDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f11590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f11591b;

    public b(Context context) {
        super(context);
        this.f11591b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.h.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11589a.a();
            }
        });
        initView();
        this.f11590a = new e(context, R.string.no_data);
    }

    private void initView() {
        AbstractC0795zc abstractC0795zc = (AbstractC0795zc) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_scrap_rule, (ViewGroup) null, false);
        abstractC0795zc.a(this);
        setContentView(abstractC0795zc.getRoot());
        setInnerViews(abstractC0795zc.f9038c, abstractC0795zc.f9036a);
    }

    public /* synthetic */ void a() {
        dismiss();
    }
}
