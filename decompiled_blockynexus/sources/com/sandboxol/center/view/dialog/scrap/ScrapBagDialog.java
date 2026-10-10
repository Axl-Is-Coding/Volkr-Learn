package com.sandboxol.center.view.dialog.scrap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sandboxol.center.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.databinding.BaseDialogScrapBagBinding;
import com.sandboxol.center.view.dialog.scrap.ScrapBagViewModel;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapBagDialog extends FullScreenDialog {
    public ScrapBagDialog(Context context, boolean z, long j, boolean z2) {
        super(context);
        initView(context, z, j, z2);
        initMessenger();
    }

    private void initMessenger() {
        MessagerClient.getIns().registerMsg0(ScrapBagDialog.class, MessageToken.TOKEN_SCRAP_CLOSE_BAG, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.center.view.dialog.scrap.b
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f16390a.a();
            }
        });
    }

    private void initView(Context context, boolean z, long j, boolean z2) {
        BaseDialogScrapBagBinding baseDialogScrapBagBinding = (BaseDialogScrapBagBinding) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.base_dialog_scrap_bag, (ViewGroup) null, false);
        baseDialogScrapBagBinding.setViewModel(new ScrapBagViewModel(context, z, baseDialogScrapBagBinding, j, z2, new ScrapBagViewModel.OnCloseListener() { // from class: com.sandboxol.center.view.dialog.scrap.a
            @Override // com.sandboxol.center.view.dialog.scrap.ScrapBagViewModel.OnCloseListener
            public final void onClose() {
                this.f16389a.b();
            }
        }));
        setContentView(baseDialogScrapBagBinding.getRoot());
        baseDialogScrapBagBinding.tlTab.setupWithViewPager(baseDialogScrapBagBinding.vpContent);
        setInnerViews(baseDialogScrapBagBinding.v, baseDialogScrapBagBinding.ivClose);
    }

    public /* synthetic */ void a() {
        dismiss();
    }

    public /* synthetic */ void b() {
        dismiss();
    }
}
