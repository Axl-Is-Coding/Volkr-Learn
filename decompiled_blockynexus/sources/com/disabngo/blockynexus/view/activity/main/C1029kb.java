package com.disabngo.blockynexus.view.activity.main;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.kb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1029kb implements Action1<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10922a;

    C1029kb(MainActivity mainActivity) {
        this.f10922a = mainActivity;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(final Integer num) {
        if (num.intValue() <= 2) {
            MultiProcessSharedUtils.putInt(this.f10922a, SharedConstant.PARTY_INVITE_REFUSE_COUNT, num.intValue() + 1);
        } else if (num.intValue() == 3) {
            new TwoButtonDialog(this.f10922a).setDetailText(this.f10922a.getString(R.string.party_refuse_invite_guide)).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.activity.main.b
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f10877a.a();
                }
            }).setLeftListener(new TwoButtonDialog.OnTwoButtonDialogLeftClickListener() { // from class: com.disabngo.blockynexus.view.activity.main.c
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogLeftClickListener
                public final void onLeftClick() {
                    this.f10884a.b(num);
                }
            }).show();
        }
    }

    public /* synthetic */ void b(Integer num) {
        MultiProcessSharedUtils.putInt(this.f10922a, SharedConstant.PARTY_INVITE_REFUSE_COUNT, num.intValue() + 1);
    }

    public /* synthetic */ void a() {
        MainActivity mainActivity = this.f10922a;
        TemplateUtils.startTemplate(mainActivity, com.disabngo.blockynexus.e.b.Y.f.class, mainActivity.getString(R.string.item_view_reminder));
    }
}
