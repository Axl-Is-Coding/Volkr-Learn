package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes2.dex */
public class BottomDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f11266a;

    public interface OnClickListener {
        void onClick(BottomDialog bottomDialog);
    }

    public BottomDialog(Context context) {
        super(context);
        initView();
    }

    public BottomDialog a(String str, final OnClickListener onClickListener) {
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_item_bottom_menu, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        textView.setText(str);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11543a.a(onClickListener, view);
            }
        });
        this.f11266a.addView(viewInflate);
        return this;
    }

    public void initView() {
        setContentView(R.layout.dialog_new_bottom_menu);
        this.f11266a = (LinearLayout) findViewById(R.id.ll_dialog);
        findViewById(R.id.vClick).setOnClickListener(this);
        slideToUp(this.f11266a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.vClick) {
            return;
        }
        cancel();
    }

    public /* synthetic */ void a(OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }
}
