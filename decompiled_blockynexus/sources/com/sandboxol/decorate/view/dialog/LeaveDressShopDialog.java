package com.sandboxol.decorate.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sandboxol.center.config.ActivityType;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.decorate.R;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class LeaveDressShopDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f17298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f17299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Button f17300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OnTwoButtonDialogClickListener f17301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f17302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f17303f;

    public interface OnTwoButtonDialogClickListener {
        void onClick();
    }

    public interface a {
        void onLeftClick();
    }

    public LeaveDressShopDialog(Context context, String str) {
        super(context);
        this.f17303f = str;
        initView();
        initData();
    }

    private void initData() {
        String str = this.f17303f;
        if (str == null || !a(str)) {
            setDetailText(R.string.decorate_leave_dress_shop_update_app_tip);
            setRightButtonText(R.string.decorate_sure);
        } else {
            setDetailText(R.string.decorate_leave_dress_shop_tip);
            setRightButtonText(R.string.decorate_go);
        }
    }

    public LeaveDressShopDialog a(OnTwoButtonDialogClickListener onTwoButtonDialogClickListener) {
        this.f17301d = onTwoButtonDialogClickListener;
        return this;
    }

    public void initView() {
        setContentView(R.layout.dialog_leave_dress_shop);
        this.f17298a = (TextView) findViewById(R.id.tvDetails);
        this.f17299b = (Button) findViewById(R.id.btnSure);
        this.f17300c = (Button) findViewById(R.id.btnCancel);
        this.f17300c.setOnClickListener(this);
        this.f17299b.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancel) {
            dismiss();
            a aVar = this.f17302e;
            if (aVar != null) {
                aVar.onLeftClick();
                return;
            }
            return;
        }
        if (id == R.id.btnSure) {
            dismiss();
            OnTwoButtonDialogClickListener onTwoButtonDialogClickListener = this.f17301d;
            if (onTwoButtonDialogClickListener != null) {
                onTwoButtonDialogClickListener.onClick();
                String str = this.f17303f;
                if (str == null || !a(str)) {
                    Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_IS_TO_GOOGLE_PLAY);
                } else {
                    Messenger.getDefault().send(this.f17303f, MessageToken.TOKEN_IS_TO_ACTIVITY);
                }
            }
        }
    }

    public LeaveDressShopDialog setDetailText(int i) {
        this.f17298a.setText(i);
        return this;
    }

    public LeaveDressShopDialog setRightButtonText(int i) {
        this.f17299b.setText(i);
        return this;
    }

    private boolean a(String str) {
        for (Field field : ActivityType.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (str.equals((String) field.get(ActivityType.class))) {
                    return true;
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return false;
    }
}
