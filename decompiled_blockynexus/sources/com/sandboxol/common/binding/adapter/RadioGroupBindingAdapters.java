package com.sandboxol.common.binding.adapter;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class RadioGroupBindingAdapters {

    public static class CheckedDataWrapper {
        private RadioButton checkButton;
        private int checkedId;

        public CheckedDataWrapper(RadioButton radioButton, int i) {
            this.checkButton = radioButton;
            this.checkedId = i;
        }

        public RadioButton getCheckButton() {
            return this.checkButton;
        }

        public int getCheckedId() {
            return this.checkedId;
        }
    }

    static /* synthetic */ void a(ReplyCommand replyCommand, RadioGroup radioGroup, int i) {
        if (replyCommand != null) {
            replyCommand.execute(new CheckedDataWrapper((RadioButton) radioGroup.findViewById(i), i));
        }
    }

    public static void onCheckedChangeListener(RadioGroup radioGroup, final ReplyCommand<CheckedDataWrapper> replyCommand, int i) {
        RadioButton radioButton;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.sandboxol.common.binding.adapter.f
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i2) {
                RadioGroupBindingAdapters.a(replyCommand, radioGroup2, i2);
            }
        });
        if (i == 0 || (radioButton = (RadioButton) radioGroup.findViewById(i)) == null) {
            return;
        }
        radioButton.setChecked(true);
    }
}
