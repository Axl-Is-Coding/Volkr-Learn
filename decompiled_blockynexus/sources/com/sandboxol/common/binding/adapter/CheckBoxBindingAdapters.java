package com.sandboxol.common.binding.adapter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class CheckBoxBindingAdapters {
    static /* synthetic */ void a(boolean z, ReplyCommand replyCommand, CompoundButton compoundButton, boolean z2) {
        if (!z) {
            if (replyCommand != null) {
                replyCommand.execute(Boolean.valueOf(z2));
            }
        } else {
            if (replyCommand == null || !compoundButton.isPressed()) {
                return;
            }
            replyCommand.execute(Boolean.valueOf(z2));
        }
    }

    public static void onCheckedChangeListener(CheckBox checkBox, final ReplyCommand<Boolean> replyCommand, final boolean z) {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sandboxol.common.binding.adapter.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                CheckBoxBindingAdapters.a(z, replyCommand, compoundButton, z2);
            }
        });
    }
}
