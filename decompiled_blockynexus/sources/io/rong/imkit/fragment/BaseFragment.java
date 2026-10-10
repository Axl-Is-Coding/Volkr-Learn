package io.rong.imkit.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import io.rong.imkit.R;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseFragment extends Fragment implements Handler.Callback {
    public static final int UI_RESTORE = 1;
    private Handler mHandler;

    private View obtainView(LayoutInflater layoutInflater, int i, Drawable drawable, CharSequence charSequence) {
        View viewInflate = layoutInflater.inflate(R.layout.rc_wi_notice, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(android.R.id.message)).setText(charSequence);
        ((ImageView) viewInflate.findViewById(android.R.id.icon)).setImageDrawable(drawable);
        if (i > 0) {
            viewInflate.setBackgroundColor(i);
        }
        return viewInflate;
    }

    protected <T extends View> T findViewById(View view, int i) {
        return (T) view.findViewById(i);
    }

    protected Handler getHandler() {
        return this.mHandler;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            onRestoreUI();
        }
        return true;
    }

    public abstract boolean onBackPressed();

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public abstract void onRestoreUI();

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    private View obtainView(LayoutInflater layoutInflater, int i, int i2, CharSequence charSequence) {
        View viewInflate = layoutInflater.inflate(R.layout.rc_wi_notice, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(android.R.id.message)).setText(charSequence);
        ((ImageView) viewInflate.findViewById(android.R.id.icon)).setImageResource(i2);
        viewInflate.setBackgroundColor(i);
        return viewInflate;
    }
}
