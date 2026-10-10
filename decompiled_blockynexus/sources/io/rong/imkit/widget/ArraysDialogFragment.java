package io.rong.imkit.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.rong.imkit.utilities.OptionsPopupDialog;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ArraysDialogFragment extends BaseDialogFragment {
    private static final String ARGS_ARRAYS = "args_arrays";
    private int count;
    private OnArraysDialogItemListener mItemListener;

    public interface OnArraysDialogItemListener {
        void OnArraysDialogItemClick(DialogInterface dialogInterface, int i);
    }

    public static ArraysDialogFragment newInstance(String str, String[] strArr) {
        ArraysDialogFragment arraysDialogFragment = new ArraysDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray(ARGS_ARRAYS, strArr);
        arraysDialogFragment.setArguments(bundle);
        return arraysDialogFragment;
    }

    public int getCount() {
        return this.count;
    }

    public ArraysDialogFragment setArraysDialogItemListener(OnArraysDialogItemListener onArraysDialogItemListener) {
        this.mItemListener = onArraysDialogItemListener;
        return this;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void show(AbstractC0336n abstractC0336n) {
        Fragment fragment;
        FragmentActivity activity;
        String[] stringArray = getArguments() != null ? getArguments().getStringArray(ARGS_ARRAYS) : new String[0];
        setCount(stringArray != null ? stringArray.length : 0);
        List<Fragment> listE = abstractC0336n.e();
        if (listE == null || (fragment = listE.get(0)) == null || (activity = fragment.getActivity()) == null) {
            return;
        }
        OptionsPopupDialog.newInstance(activity, stringArray).setOptionsPopupDialogListener(new OptionsPopupDialog.OnOptionsItemClickedListener() { // from class: io.rong.imkit.widget.ArraysDialogFragment.1
            @Override // io.rong.imkit.utilities.OptionsPopupDialog.OnOptionsItemClickedListener
            public void onOptionsItemClicked(int i) {
                ArraysDialogFragment.this.mItemListener.OnArraysDialogItemClick(null, i);
            }
        }).show();
    }
}
