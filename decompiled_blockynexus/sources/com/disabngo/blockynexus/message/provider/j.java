package com.disabngo.blockynexus.message.provider;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.message.entity.ScrapAskHelpMessage;

/* JADX INFO: compiled from: ScrapAskHelpProvider.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextView f10472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScrapAskHelpMessage f10473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ k f10474c;

    j(k kVar, TextView textView, ScrapAskHelpMessage scrapAskHelpMessage) {
        this.f10474c = kVar;
        this.f10472a = textView;
        this.f10473b = scrapAskHelpMessage;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ScrapOnError.showErrorTip(this.f10472a.getContext(), i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10472a.getContext(), i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Integer num) {
        String string = this.f10472a.getContext().getString(R.string.scrap_ask_help_template, this.f10473b.getUserName(), this.f10473b.getScrapName(), String.valueOf(num));
        String string2 = this.f10472a.getContext().getString(R.string.scrap_ask_help_tips);
        String str = string + string2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int iLastIndexOf = str.lastIndexOf("[");
        spannableStringBuilder.setSpan(new ScrapAskHelpProvider$1$1(this, num), iLastIndexOf, string2.length() + iLastIndexOf, 0);
        this.f10472a.setMovementMethod(LinkMovementMethod.getInstance());
        this.f10472a.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        TextView textView = this.f10472a;
        textView.setHighlightColor(androidx.core.content.b.a(textView.getContext(), R.color.rc_popup_dialog_prompt_clear_color));
    }
}
