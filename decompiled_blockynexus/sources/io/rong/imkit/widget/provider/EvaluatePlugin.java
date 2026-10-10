package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import io.rong.imkit.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.widget.CSEvaluateDialog;

/* JADX INFO: loaded from: classes5.dex */
public class EvaluatePlugin implements IPluginModule, CSEvaluateDialog.EvaluateClickListener {
    private CSEvaluateDialog mEvaluateDialog;
    private boolean mResolvedButton;

    public EvaluatePlugin(boolean z) {
        this.mResolvedButton = z;
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public Drawable obtainDrawable(Context context) {
        return b.c(context, R.drawable.rc_cs_evaluate_selector);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public String obtainTitle(Context context) {
        return context.getString(R.string.rc_cs_evaluate);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        this.mEvaluateDialog = new CSEvaluateDialog(fragment.getActivity(), rongExtension.getTargetId());
        this.mEvaluateDialog.showStarMessage(this.mResolvedButton);
        this.mEvaluateDialog.setClickListener(this);
        rongExtension.collapseExtension();
    }

    @Override // io.rong.imkit.widget.CSEvaluateDialog.EvaluateClickListener
    public void onEvaluateCanceled() {
        this.mEvaluateDialog.destroy();
        this.mEvaluateDialog = null;
    }

    @Override // io.rong.imkit.widget.CSEvaluateDialog.EvaluateClickListener
    public void onEvaluateSubmit() {
        this.mEvaluateDialog.destroy();
        this.mEvaluateDialog = null;
    }
}
