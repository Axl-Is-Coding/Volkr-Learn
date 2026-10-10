package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.disabngo.blockynexus.R;

/* JADX INFO: loaded from: classes.dex */
public class SignInItemView extends FrameLayout {
    private static final int TYPE_DIAMOND = 2;
    private static final int TYPE_GOLD = 1;
    private Button btnGet;
    private Context context;
    private ImageView ivPic;
    private TextView tvNum;
    private TextView tvWeek;
    private int type;

    public SignInItemView(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.item_sign_in, this);
        this.tvWeek = (TextView) findViewById(R.id.tvWeek);
        this.tvNum = (TextView) findViewById(R.id.tvNum);
        this.ivPic = (ImageView) findViewById(R.id.ivPic);
        this.btnGet = (Button) findViewById(R.id.btnGet);
        this.btnGet.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.widget.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12103a.a(view);
            }
        });
    }

    private void signIn() {
        new com.disabngo.blockynexus.view.dialog.i.b().a(this.context, this.type, new t(this));
    }

    public /* synthetic */ void a(View view) {
        signIn();
    }

    public void setGiftCount(int i) {
        this.tvNum.setText(String.valueOf(i));
    }

    public void setState(int i) {
        int i2 = R.mipmap.ic_sign_in_gold_nor;
        if (i == 0) {
            this.btnGet.setEnabled(true);
            this.btnGet.setText(R.string.sign_in_get);
            this.btnGet.setBackgroundResource(R.drawable.bg_sign_in_item_btn_selector);
            ImageView imageView = this.ivPic;
            if (this.type != 1) {
                i2 = R.mipmap.ic_sign_in_diamond_nor;
            }
            imageView.setImageResource(i2);
            return;
        }
        if (i == 1) {
            this.btnGet.setEnabled(false);
            this.btnGet.setText(R.string.sign_in_has_get);
            this.btnGet.setBackgroundResource(R.drawable.bg_sign_in_item_finished);
            this.ivPic.setImageResource(this.type == 1 ? R.mipmap.ic_sign_in_gold_has_get : R.mipmap.ic_sign_in_diamond_has_get);
            return;
        }
        if (i == 2) {
            this.btnGet.setEnabled(false);
            this.btnGet.setText(R.string.sign_in_get);
            this.btnGet.setBackgroundResource(R.drawable.bg_sign_in_item_btn_selector);
            this.ivPic.setImageResource(this.type == 1 ? R.mipmap.ic_sign_in_gold_overdue : R.mipmap.ic_sign_in_diamond_overdue);
            return;
        }
        if (i != 3) {
            return;
        }
        this.btnGet.setEnabled(false);
        this.btnGet.setText(R.string.sign_in_get);
        this.btnGet.setBackgroundResource(R.drawable.bg_sign_in_item_btn_selector);
        ImageView imageView2 = this.ivPic;
        if (this.type != 1) {
            i2 = R.mipmap.ic_sign_in_diamond_nor;
        }
        imageView2.setImageResource(i2);
    }

    public void setTitleText(int i) {
        this.tvWeek.setText(i);
    }

    public void setType(int i) {
        this.type = i;
    }

    public SignInItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView(context);
    }
}
