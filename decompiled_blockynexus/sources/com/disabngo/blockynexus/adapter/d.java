package com.disabngo.blockynexus.adapter;

import android.widget.RadioButton;
import com.disabngo.blockynexus.view.widget.NestRadioGroup;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: NestRadioGroupAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(NestRadioGroup nestRadioGroup, final ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand, int i) {
        RadioButton radioButton;
        nestRadioGroup.setOnCheckedChangeListener(new NestRadioGroup.b() { // from class: com.disabngo.blockynexus.adapter.a
            @Override // com.disabngo.blockynexus.view.widget.NestRadioGroup.b
            public final void a(NestRadioGroup nestRadioGroup2, int i2) {
                d.a(replyCommand, nestRadioGroup2, i2);
            }
        });
        if (i == 0 || (radioButton = (RadioButton) nestRadioGroup.findViewById(i)) == null) {
            return;
        }
        radioButton.setChecked(true);
    }

    static /* synthetic */ void a(ReplyCommand replyCommand, NestRadioGroup nestRadioGroup, int i) {
        if (replyCommand != null) {
            replyCommand.execute(new RadioGroupBindingAdapters.CheckedDataWrapper((RadioButton) nestRadioGroup.findViewById(i), i));
        }
    }
}
