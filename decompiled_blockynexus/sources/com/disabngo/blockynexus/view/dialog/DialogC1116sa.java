package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0696qb;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.sa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiskGameListCleanDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class DialogC1116sa extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Long> f11681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Long> f11682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f11683c;

    public DialogC1116sa(Context context, ObservableField<Long> observableField, ObservableField<Long> observableField2, ObservableField<Boolean> observableField3) {
        super(context);
        this.f11681a = observableField;
        this.f11682b = observableField2;
        this.f11683c = observableField3;
        initView();
    }

    private void initView() {
        AbstractC0696qb abstractC0696qb = (AbstractC0696qb) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_disk_game_clean, (ViewGroup) null, false);
        abstractC0696qb.a(this);
        setContentView(abstractC0696qb.getRoot());
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.f11683c.get().booleanValue()) {
            dismiss();
        } else {
            AppToastUtils.showShortPositiveTipToast(this.context, R.string.app_disk_game_manage_clean);
        }
    }
}
