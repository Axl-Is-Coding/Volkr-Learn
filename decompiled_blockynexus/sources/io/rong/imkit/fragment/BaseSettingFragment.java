package io.rong.imkit.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imlib.model.Conversation;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseSettingFragment extends BaseFragment implements View.OnClickListener {
    CheckBox mCheckBox;
    Conversation.ConversationType mConversationType;
    RelativeLayout mSettingItem;
    String mTargetId;
    TextView mTextView;

    protected Conversation.ConversationType getConversationType() {
        return this.mConversationType;
    }

    protected boolean getSwitchBtnStatus() {
        return this.mCheckBox.isChecked();
    }

    protected String getTargetId() {
        return this.mTargetId;
    }

    protected abstract void initData();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.mTextView.setText(setTitle());
        this.mCheckBox.setEnabled(setSwitchButtonEnabled());
        if (8 == setSwitchBtnVisibility()) {
            this.mCheckBox.setVisibility(8);
        } else if (setSwitchBtnVisibility() == 0) {
            this.mCheckBox.setVisibility(0);
        }
        this.mCheckBox.setOnClickListener(this);
        this.mSettingItem.setOnClickListener(this);
        initData();
        super.onActivityCreated(bundle);
    }

    @Override // io.rong.imkit.fragment.BaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mSettingItem) {
            onSettingItemClick(view);
            return;
        }
        CheckBox checkBox = this.mCheckBox;
        if (view == checkBox) {
            toggleSwitch(checkBox.isChecked());
        }
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            Intent intent = getActivity().getIntent();
            if (intent.getData() != null) {
                String lastPathSegment = intent.getData().getLastPathSegment();
                if (lastPathSegment != null) {
                    this.mConversationType = Conversation.ConversationType.valueOf(lastPathSegment.toUpperCase(Locale.US));
                }
                this.mTargetId = intent.getData().getQueryParameter("targetId");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.rc_fragment_base_setting, viewGroup, false);
        this.mTextView = (TextView) viewInflate.findViewById(R.id.rc_title);
        this.mCheckBox = (CheckBox) viewInflate.findViewById(R.id.rc_checkbox);
        this.mSettingItem = (RelativeLayout) viewInflate.findViewById(R.id.rc_setting_item);
        return viewInflate;
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        RongContext.getInstance().getEventBus().unregister(this);
    }

    @Override // io.rong.imkit.fragment.BaseFragment
    public void onRestoreUI() {
        initData();
    }

    protected abstract void onSettingItemClick(View view);

    protected void setSwitchBtnStatus(boolean z) {
        this.mCheckBox.setChecked(z);
    }

    protected abstract int setSwitchBtnVisibility();

    protected abstract boolean setSwitchButtonEnabled();

    protected abstract String setTitle();

    protected abstract void toggleSwitch(boolean z);
}
