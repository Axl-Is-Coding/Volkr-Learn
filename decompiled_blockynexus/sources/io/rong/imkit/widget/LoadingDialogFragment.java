package io.rong.imkit.widget;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import io.rong.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public class LoadingDialogFragment extends BaseDialogFragment {
    private static final String ARGS_MESSAGE = "args_message";
    private static final String ARGS_TITLE = "args_title";
    private static final String TAG = "LoadingDialogFragment";

    public static LoadingDialogFragment newInstance(String str, String str2) {
        LoadingDialogFragment loadingDialogFragment = new LoadingDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_TITLE, str);
        bundle.putString(ARGS_MESSAGE, str2);
        loadingDialogFragment.setArguments(bundle);
        return loadingDialogFragment;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e
    public Dialog onCreateDialog(Bundle bundle) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        String string = getArguments() != null ? getArguments().getString(ARGS_TITLE) : "";
        String string2 = getArguments() != null ? getArguments().getString(ARGS_MESSAGE) : "";
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(0);
        if (!TextUtils.isEmpty(string)) {
            progressDialog.setTitle(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            progressDialog.setMessage(string2);
        }
        return progressDialog;
    }

    public void show(AbstractC0336n abstractC0336n) {
        try {
            F fA = abstractC0336n.a();
            fA.d(this);
            fA.a();
            super.show(abstractC0336n, TAG);
        } catch (Exception e2) {
            RLog.e(TAG, "show", e2);
        }
    }
}
