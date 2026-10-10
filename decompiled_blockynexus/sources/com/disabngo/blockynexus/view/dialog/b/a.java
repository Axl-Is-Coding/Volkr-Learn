package com.disabngo.blockynexus.view.dialog.b;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0761wb;
import com.disabngo.blockynexus.e.b.ua.i;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: compiled from: FirstTopUpDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f11523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f11524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AbstractC0761wb f11525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f11526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f11527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f11528f;
    public ReplyCommand g;

    private void a() {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.week_sign_dialog_exit_anim);
        animationLoadAnimation.setFillAfter(true);
        this.f11525c.f8927a.startAnimation(animationLoadAnimation);
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        a();
    }
}
