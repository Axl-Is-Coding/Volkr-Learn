package com.sandboxol.imchat.module;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.view.dialog.scrap.ScrapBagDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.imchat.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes4.dex */
public class ScrapCardPlugin implements IPluginModule {
    @Override // io.rong.imkit.plugin.IPluginModule
    public Drawable obtainDrawable(Context context) {
        return b.c(context, R.drawable.rc_scrap_selector);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public String obtainTitle(Context context) {
        return context.getString(io.rong.imkit.R.string.rc_card_send_scrap);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        ReportDataAdapter.onEvent(fragment.getContext(), EventConstant.CLICK_CHAT_GIVE_PART);
        new ScrapBagDialog(fragment.getContext(), false, Long.valueOf(rongExtension.getTargetId()).longValue(), rongExtension.getConversationType() == Conversation.ConversationType.PRIVATE).show();
    }
}
