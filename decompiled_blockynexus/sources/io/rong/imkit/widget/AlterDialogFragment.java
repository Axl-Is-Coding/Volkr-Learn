package io.rong.imkit.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.AbstractC0336n;

/* JADX INFO: loaded from: classes5.dex */
public class AlterDialogFragment extends BaseDialogFragment {
    private static final String ARGS_CANCEL_BTN_TXT = "args_cancel_button_text";
    private static final String ARGS_MESSAGE = "args_message";
    private static final String ARGS_OK_BTN_TXT = "args_ok_button_text";
    private static final String ARGS_TITLE = "args_title";
    private AlterDialogBtnListener mAlterDialogBtnListener;

    public interface AlterDialogBtnListener {
        void onDialogNegativeClick(AlterDialogFragment alterDialogFragment);

        void onDialogPositiveClick(AlterDialogFragment alterDialogFragment);
    }

    public static AlterDialogFragment newInstance(String str, String str2, String str3, String str4) {
        AlterDialogFragment alterDialogFragment = new AlterDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_TITLE, str);
        bundle.putString(ARGS_MESSAGE, str2);
        bundle.putString(ARGS_CANCEL_BTN_TXT, str3);
        bundle.putString(ARGS_OK_BTN_TXT, str4);
        alterDialogFragment.setArguments(bundle);
        return alterDialogFragment;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (getArguments() == null) {
            return builder.create();
        }
        String string = getArguments().getString(ARGS_TITLE);
        String string2 = getArguments().getString(ARGS_MESSAGE);
        String string3 = getArguments().getString(ARGS_CANCEL_BTN_TXT);
        String string4 = getArguments().getString(ARGS_OK_BTN_TXT);
        if (!TextUtils.isEmpty(string)) {
            builder.setTitle(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            builder.setMessage(string2);
        }
        if (!TextUtils.isEmpty(string4)) {
            builder.setPositiveButton(string4, new DialogInterface.OnClickListener() { // from class: io.rong.imkit.widget.AlterDialogFragment.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (AlterDialogFragment.this.mAlterDialogBtnListener != null) {
                        AlterDialogFragment.this.mAlterDialogBtnListener.onDialogPositiveClick(AlterDialogFragment.this);
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(string3)) {
            builder.setNegativeButton(string3, new DialogInterface.OnClickListener() { // from class: io.rong.imkit.widget.AlterDialogFragment.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (AlterDialogFragment.this.mAlterDialogBtnListener != null) {
                        AlterDialogFragment.this.mAlterDialogBtnListener.onDialogNegativeClick(AlterDialogFragment.this);
                    }
                }
            });
        }
        return builder.create();
    }

    public void setOnAlterDialogBtnListener(AlterDialogBtnListener alterDialogBtnListener) {
        this.mAlterDialogBtnListener = alterDialogBtnListener;
    }

    public void show(AbstractC0336n abstractC0336n) {
        show(abstractC0336n, "AlterDialogFragment");
    }
}
