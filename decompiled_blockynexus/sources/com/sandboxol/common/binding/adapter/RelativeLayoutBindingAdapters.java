package com.sandboxol.common.binding.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class RelativeLayoutBindingAdapters {
    public static void LongClick(RelativeLayout relativeLayout, final ReplyCommand replyCommand) {
        relativeLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sandboxol.common.binding.adapter.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return RelativeLayoutBindingAdapters.a(replyCommand, view);
            }
        });
    }

    static /* synthetic */ boolean a(ReplyCommand replyCommand, View view) {
        replyCommand.execute();
        return true;
    }
}
