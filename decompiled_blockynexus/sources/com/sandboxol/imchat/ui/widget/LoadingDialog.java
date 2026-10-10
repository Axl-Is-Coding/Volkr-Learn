package com.sandboxol.imchat.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.TextView;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public class LoadingDialog extends Dialog {
    private TextView mTextView;

    public LoadingDialog(Context context) {
        super(context, R.style.WinDialog);
        setContentView(R.layout.ui_dialog_loading);
        this.mTextView = (TextView) findViewById(android.R.id.message);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setText(String str) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(str);
            this.mTextView.setVisibility(0);
        }
    }

    public void setText(int i) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(i);
            this.mTextView.setVisibility(0);
        }
    }
}
