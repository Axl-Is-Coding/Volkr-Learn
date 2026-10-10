package com.disabngo.blockynexus.message.provider;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.view.dialog.ScrapMakeSureDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.imchat.message.entity.ScrapAskHelpMessage;

/* JADX INFO: loaded from: classes2.dex */
class ScrapAskHelpProvider$1$1 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Integer f10427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f10428b;

    ScrapAskHelpProvider$1$1(j jVar, Integer num) {
        this.f10428b = jVar;
        this.f10427a = num;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.f10427a.intValue() == 0) {
            AppToastUtils.showShortNegativeTipToast(this.f10428b.f10472a.getContext(), R.string.app_scrap_status_tips_3);
            return;
        }
        if (TextUtils.isEmpty(this.f10428b.f10473b.getScrapId())) {
            ReportDataAdapter.onEvent(this.f10428b.f10472a.getContext(), "ScrapAskHelpProvider");
        }
        new ScrapMakeSureDialog(this.f10428b.f10472a.getContext(), ScrapAskHelpMessage.transToScrapMakeSureInfo(this.f10428b.f10473b), 1, new i(this)).show();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(androidx.core.content.b.a(this.f10428b.f10472a.getContext(), R.color.scrap_help_tips_color));
        textPaint.setUnderlineText(false);
    }
}
