package io.rong.imkit.utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import io.rong.imkit.R;

/* JADX INFO: loaded from: classes5.dex */
public class PromptPopupDialog extends AlertDialog {
    private Context mContext;
    private int mLayoutResId;
    private String mMessage;
    private String mPositiveButton;
    private OnPromptButtonClickedListener mPromptButtonClickedListener;
    private String mTitle;

    public interface OnPromptButtonClickedListener {
        void onPositiveButtonClicked();
    }

    public PromptPopupDialog(Context context, String str, String str2, String str3) {
        this(context, str, str2);
        this.mPositiveButton = str3;
    }

    private int gePopupWidth() {
        return getScreenWidth() - (((int) this.mContext.getResources().getDimension(R.dimen.rc_popup_dialog_distance_to_edge)) * 2);
    }

    private int getScreenWidth() {
        return ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static PromptPopupDialog newInstance(Context context, String str, String str2) {
        return new PromptPopupDialog(context, str, str2);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        View viewInflate = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(this.mLayoutResId, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.popup_dialog_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.popup_dialog_message);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.popup_dialog_button_ok);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.popup_dialog_button_cancel);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.utilities.PromptPopupDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PromptPopupDialog.this.mPromptButtonClickedListener != null) {
                    PromptPopupDialog.this.mPromptButtonClickedListener.onPositiveButtonClicked();
                }
                PromptPopupDialog.this.dismiss();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.utilities.PromptPopupDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptPopupDialog.this.dismiss();
            }
        });
        if (!TextUtils.isEmpty(this.mTitle)) {
            textView.setText(this.mTitle);
            textView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.mPositiveButton)) {
            textView3.setText(this.mPositiveButton);
        }
        textView2.setText(this.mMessage);
        setContentView(viewInflate);
        if (getWindow() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = gePopupWidth();
        attributes.height = -2;
        getWindow().setAttributes(attributes);
    }

    public PromptPopupDialog setLayoutRes(int i) {
        this.mLayoutResId = i;
        return this;
    }

    public PromptPopupDialog setPromptButtonClickedListener(OnPromptButtonClickedListener onPromptButtonClickedListener) {
        this.mPromptButtonClickedListener = onPromptButtonClickedListener;
        return this;
    }

    public static PromptPopupDialog newInstance(Context context, String str) {
        return new PromptPopupDialog(context, str);
    }

    public PromptPopupDialog(Context context, String str, String str2) {
        super(context);
        this.mLayoutResId = R.layout.rc_dialog_popup_prompt;
        this.mContext = context;
        this.mTitle = str;
        this.mMessage = str2;
    }

    public static PromptPopupDialog newInstance(Context context, String str, String str2, String str3) {
        return new PromptPopupDialog(context, str, str2, str3);
    }

    public PromptPopupDialog(Context context, String str) {
        super(context);
        this.mContext = context;
        this.mMessage = str;
    }
}
