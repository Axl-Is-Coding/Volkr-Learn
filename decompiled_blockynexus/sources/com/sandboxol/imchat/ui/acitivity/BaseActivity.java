package com.sandboxol.imchat.ui.acitivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.fragment.app.FragmentActivity;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.server.network.async.AsyncTaskManager;
import com.sandboxol.imchat.server.network.async.OnDataListener;
import com.sandboxol.imchat.server.network.http.HttpException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseActivity extends FragmentActivity implements OnDataListener {
    public AsyncTaskManager mAsyncTaskManager;
    private Drawable mBtnBackDrawable;
    protected Button mBtnLeft;
    protected Button mBtnRight;
    private ViewFlipper mContentView;
    protected Context mContext;
    protected LinearLayout mHeadLayout;
    protected TextView mHeadRightText;
    protected TextView mOutSideMsgNumText;
    protected TextView mTitle;

    public void cancelRequest() {
        AsyncTaskManager asyncTaskManager = this.mAsyncTaskManager;
        if (asyncTaskManager != null) {
            asyncTaskManager.cancelRequest();
        }
    }

    @Override // com.sandboxol.imchat.server.network.async.OnDataListener
    public Object doInBackground(int i, String str) throws HttpException {
        return null;
    }

    public Drawable getHeadBackButtonDrawable() {
        return this.mBtnBackDrawable;
    }

    public Button getHeadLeftButton() {
        return this.mBtnLeft;
    }

    public Button getHeadRightButton() {
        return this.mBtnRight;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(R.layout.layout_base);
        setVolumeControlStream(3);
        this.mContext = this;
        this.mContentView = (ViewFlipper) super.findViewById(R.id.layout_container);
        this.mHeadLayout = (LinearLayout) super.findViewById(R.id.layout_head);
        this.mHeadRightText = (TextView) findViewById(R.id.text_right);
        this.mBtnLeft = (Button) super.findViewById(R.id.btn_left);
        this.mBtnRight = (Button) super.findViewById(R.id.btn_right);
        this.mTitle = (TextView) super.findViewById(R.id.tv_title);
        this.mOutSideMsgNumText = (TextView) super.findViewById(R.id.tv_num);
        this.mBtnBackDrawable = getResources().getDrawable(R.drawable.btn_back);
        Drawable drawable = this.mBtnBackDrawable;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.mBtnBackDrawable.getMinimumHeight());
        this.mOutSideMsgNumText.setVisibility(4);
        this.mAsyncTaskManager = AsyncTaskManager.getInstance(getApplicationContext());
    }

    @Override // com.sandboxol.imchat.server.network.async.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i2 == -400) {
            ToastUtils.showShortToast(this.mContext, "当前网络不可用");
        } else {
            if (i2 != -200) {
                return;
            }
            ToastUtils.showShortToast(this.mContext, "网络问题请稍后重试");
        }
    }

    public void onHeadLeftButtonClick(View view) {
        finish();
    }

    public void onHeadRightButtonClick(View view) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.sandboxol.imchat.server.network.async.OnDataListener
    public void onSuccess(int i, Object obj) {
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (getCurrentFocus() == null || motionEvent.getAction() != 1) ? super.onTouchEvent(motionEvent) : ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    public void request(int i) {
        AsyncTaskManager asyncTaskManager = this.mAsyncTaskManager;
        if (asyncTaskManager != null) {
            asyncTaskManager.request(i, this);
        }
    }

    public void setBackButtonDrawable(Drawable drawable) {
        this.mBtnBackDrawable = drawable;
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        this.mContentView.addView(view, new LinearLayout.LayoutParams(-1, -1, 1.0f));
    }

    public void setHeadLeftButton(Button button) {
        this.mBtnLeft = button;
    }

    public void setHeadLeftButtonVisibility(int i) {
        this.mBtnLeft.setVisibility(i);
    }

    public void setHeadRightButton(Button button) {
        this.mBtnRight = button;
    }

    public void setHeadRightButtonVisibility(int i) {
        this.mBtnRight.setVisibility(i);
    }

    public void setHeadVisibility(int i) {
        this.mHeadLayout.setVisibility(i);
    }

    public void setOutsideNum(int i) {
        this.mOutSideMsgNumText.setText(i >= 99 ? StringConstant.WHEEL_BLOCK_LIMIT : String.valueOf(i));
        if (this.mOutSideMsgNumText.getVisibility() == 4) {
            this.mOutSideMsgNumText.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        setTitle(getString(i), false);
    }

    public void setTitle(int i, boolean z) {
        setTitle(getString(i), z);
    }

    public void request(String str, int i) {
        AsyncTaskManager asyncTaskManager = this.mAsyncTaskManager;
        if (asyncTaskManager != null) {
            asyncTaskManager.request(str, i, this);
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        setContentView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
    }

    public void setTitle(String str) {
        setTitle(str, false);
    }

    public void setTitle(String str, boolean z) {
        this.mTitle.setText(str);
        if (z) {
            this.mBtnLeft.setCompoundDrawables(null, null, null, null);
        } else {
            this.mBtnLeft.setCompoundDrawables(this.mBtnBackDrawable, null, null, null);
        }
    }

    public void request(int i, boolean z) {
        AsyncTaskManager asyncTaskManager = this.mAsyncTaskManager;
        if (asyncTaskManager != null) {
            asyncTaskManager.request(i, z, this);
        }
    }
}
