package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0542cb;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: UnbindingPhoneDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class Va extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View.OnClickListener f11433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View.OnClickListener f11434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View.OnClickListener f11435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.disabngo.blockynexus.interfaces.b f11436d;

    public Va(Context context, com.disabngo.blockynexus.interfaces.b bVar, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        super(context);
        this.f11436d = bVar;
        this.f11433a = onClickListener;
        this.f11434b = onClickListener2;
        this.f11435c = onClickListener3;
    }

    public /* synthetic */ void b(View view) {
        View.OnClickListener onClickListener = this.f11433a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(final Context context) {
        super.init(context);
        final AbstractC0542cb abstractC0542cb = (AbstractC0542cb) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.dialog_app_unbind_phone, (ViewGroup) null, false);
        setContentView(abstractC0542cb.getRoot());
        abstractC0542cb.f8222e.setText(context.getString(R.string.bind_phone_phone_num, AccountCenter.newInstance().telephone.get()));
        abstractC0542cb.f8221d.addTextChangedListener(new Ua(this));
        abstractC0542cb.f8218a.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.fa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11562a.a(view);
            }
        });
        abstractC0542cb.f8220c.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.ea
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11549a.a(abstractC0542cb, context, view);
            }
        });
        abstractC0542cb.f8219b.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.ga
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11587a.b(view);
            }
        });
    }

    public /* synthetic */ void a(View view) {
        View.OnClickListener onClickListener = this.f11434b;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dismiss();
    }

    public /* synthetic */ void a(AbstractC0542cb abstractC0542cb, Context context, View view) {
        if (this.f11435c != null) {
            if (abstractC0542cb.f8221d.getText() != null) {
                this.f11435c.onClick(view);
                dismiss();
                return;
            } else {
                AppToastUtils.showShortNegativeTipToast(context, R.string.bind_phone_code_is_empty);
                return;
            }
        }
        dismiss();
    }
}
