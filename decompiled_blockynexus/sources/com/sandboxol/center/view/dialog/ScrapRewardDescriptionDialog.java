package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.center.R;
import com.sandboxol.center.databinding.BaseDialogScrapRewardDescBinding;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapRewardDescriptionDialog extends FullScreenDialog {
    private BaseDialogScrapRewardDescBinding binding;
    public ObservableField<Boolean> isGameProcess;
    public ReplyCommand onCancelCommand;
    public ObservableField<String> rewardDescription;
    public ObservableField<String> rewardName;
    public ObservableField<Integer> value;

    public ScrapRewardDescriptionDialog(Context context, String str, String str2, int i, boolean z) {
        super(context);
        this.isGameProcess = new ObservableField<>(false);
        this.rewardName = new ObservableField<>();
        this.rewardDescription = new ObservableField<>();
        this.value = new ObservableField<>();
        this.onCancelCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.p
            @Override // rx.functions.Action0
            public final void call() {
                this.f16387a.a();
            }
        });
        initView();
        initData(str, str2, i, z);
    }

    private void initData(String str, String str2, int i, boolean z) {
        this.rewardName.set(str);
        this.rewardDescription.set(str2);
        this.isGameProcess.set(Boolean.valueOf(z));
        this.value.set(Integer.valueOf(i));
    }

    private void initView() {
        this.binding = (BaseDialogScrapRewardDescBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.base_dialog_scrap_reward_desc, (ViewGroup) null, false);
        this.binding.setViewModel(this);
        setContentView(this.binding.getRoot());
    }

    public /* synthetic */ void a() {
        dismiss();
    }
}
