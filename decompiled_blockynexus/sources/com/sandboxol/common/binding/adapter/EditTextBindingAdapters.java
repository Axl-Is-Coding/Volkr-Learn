package com.sandboxol.common.binding.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class EditTextBindingAdapters {

    public static class TextChangeDataWrapper {
        public int before;
        public int count;
        public CharSequence s;
        public int start;

        public TextChangeDataWrapper(CharSequence charSequence, int i, int i2, int i3) {
            this.s = charSequence;
            this.start = i;
            this.before = i2;
            this.count = i3;
        }
    }

    static /* synthetic */ boolean a(ReplyCommand replyCommand, View view, int i, KeyEvent keyEvent) {
        if (i != 66) {
            return false;
        }
        replyCommand.execute();
        return true;
    }

    public static void editTextCommand(EditText editText, final ReplyCommand<TextChangeDataWrapper> replyCommand, final ReplyCommand<TextChangeDataWrapper> replyCommand2, final ReplyCommand<String> replyCommand3) {
        editText.addTextChangedListener(new TextWatcher() { // from class: com.sandboxol.common.binding.adapter.EditTextBindingAdapters.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ReplyCommand replyCommand4 = replyCommand3;
                if (replyCommand4 != null) {
                    replyCommand4.execute(editable.toString());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ReplyCommand replyCommand4 = replyCommand;
                if (replyCommand4 != null) {
                    replyCommand4.execute(new TextChangeDataWrapper(charSequence, i, i2, i2));
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ReplyCommand replyCommand4 = replyCommand2;
                if (replyCommand4 != null) {
                    replyCommand4.execute(new TextChangeDataWrapper(charSequence, i, i2, i3));
                }
            }
        });
    }

    public static void onSoftKeySearchCommand(EditText editText, final ReplyCommand replyCommand) {
        editText.setImeOptions(3);
        editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.sandboxol.common.binding.adapter.b
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return EditTextBindingAdapters.a(replyCommand, view, i, keyEvent);
            }
        });
    }

    public static void requestFocusCommand(EditText editText, Boolean bool) {
        if (!bool.booleanValue()) {
            editText.setEnabled(false);
            editText.setEnabled(true);
        } else {
            editText.setFocusableInTouchMode(true);
            editText.setSelection(editText.getText().length());
            editText.requestFocus();
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 1);
        }
    }
}
