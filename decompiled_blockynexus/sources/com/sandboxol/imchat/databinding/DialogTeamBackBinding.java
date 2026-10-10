package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DialogTeamBackBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final Button btnSure;
    public final TextView tvDetails;
    public final TextView tvTitle;

    protected DialogTeamBackBinding(Object obj, View view, int i, Button button, Button button2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.btnCancel = button;
        this.btnSure = button2;
        this.tvDetails = textView;
        this.tvTitle = textView2;
    }

    public static DialogTeamBackBinding bind(View view) {
        return bind(view, e.a());
    }

    public static DialogTeamBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static DialogTeamBackBinding bind(View view, Object obj) {
        return (DialogTeamBackBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_team_back);
    }

    @Deprecated
    public static DialogTeamBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogTeamBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_team_back, viewGroup, z, obj);
    }

    public static DialogTeamBackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static DialogTeamBackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogTeamBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_team_back, null, false, obj);
    }
}
