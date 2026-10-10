package io.rong.imkit.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.rong.common.RLog;
import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseNoActionbarActivity;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.Event;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.CSLMessageItem;
import io.rong.imlib.model.Conversation;
import io.rong.message.InformationNotificationMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class CSLeaveMessageActivity extends RongBaseNoActionbarActivity {
    private static final String TAG = "CSLeaveMessageActivity";
    private ArrayList<EditText> mEditList = new ArrayList<>();
    private ArrayList<CSLMessageItem> mItemList;
    private String mTargetId;

    private void addItemToContainer(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams;
        if (this.mItemList == null) {
            return;
        }
        for (int i = 0; i < this.mItemList.size(); i++) {
            CSLMessageItem cSLMessageItem = this.mItemList.get(i);
            LinearLayout linearLayout2 = new LinearLayout(this);
            if (cSLMessageItem.getType().equals(ViewHierarchyConstants.TEXT_KEY)) {
                layoutParams = new LinearLayout.LayoutParams(-1, RongUtils.dip2px(45.0f));
                linearLayout2.setOrientation(0);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                linearLayout2.setOrientation(1);
            }
            if (i > 0) {
                layoutParams.setMargins(0, RongUtils.dip2px(1.0f), 0, 0);
            }
            linearLayout2.setBackgroundColor(-1);
            linearLayout2.setLayoutParams(layoutParams);
            TextView textView = new TextView(this);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, RongUtils.dip2px(45.0f));
            layoutParams2.setMargins(RongUtils.dip2px(14.0f), 0, 0, 0);
            textView.setLayoutParams(layoutParams2);
            textView.setTextColor(getResources().getColor(R.color.rc_text_color_primary));
            textView.setTextSize(16.0f);
            textView.setGravity(16);
            textView.setText(cSLMessageItem.getTitle());
            linearLayout2.addView(textView);
            EditText editText = new EditText(this);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
            editText.setHint(cSLMessageItem.getDefaultText());
            editText.setBackgroundColor(0);
            if (cSLMessageItem.getType().equals(ViewHierarchyConstants.TEXT_KEY)) {
                layoutParams3.setMargins(RongUtils.dip2px(10.0f), 0, RongUtils.dip2px(14.0f), 0);
                editText.setGravity(19);
                editText.setMaxLines(1);
                editText.setMaxEms(20);
                editText.setSingleLine();
            } else {
                layoutParams3.setMargins(0, 0, 0, 0);
                editText.setGravity(51);
                editText.setPadding(RongUtils.dip2px(14.0f), 0, 0, 0);
                editText.setInputType(131073);
                editText.setMinLines(3);
                editText.setMaxEms(cSLMessageItem.getMax());
                editText.setVerticalScrollBarEnabled(true);
                editText.setMaxLines(3);
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cSLMessageItem.getMax())});
            }
            editText.setTextSize(0, getResources().getDimension(R.dimen.rc_conversation_item_name_size));
            editText.setTextColor(getResources().getColor(R.color.rc_text_color_primary));
            editText.setTag(cSLMessageItem.getName());
            editText.setLayoutParams(layoutParams3);
            this.mEditList.add(editText);
            linearLayout2.addView(editText);
            linearLayout.addView(linearLayout2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSoftInputKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (!inputMethodManager.isActive() || getCurrentFocus() == null || getCurrentFocus().getWindowToken() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }

    private boolean isMobile(String str) {
        return Pattern.compile("^((13[0-9])|(15[0-9])|(18[0-9])|(14[7])|(17[0|6|7|8]))\\d{8}$").matcher(str).matches();
    }

    public CSLMessageItem getItemConfig(String str) {
        for (CSLMessageItem cSLMessageItem : this.mItemList) {
            if (cSLMessageItem.getName().equals(str)) {
                return cSLMessageItem;
            }
        }
        return null;
    }

    public boolean isContentValid() {
        Iterator<EditText> it = this.mEditList.iterator();
        while (true) {
            boolean zIsEmail = true;
            if (!it.hasNext()) {
                return true;
            }
            EditText next = it.next();
            String str = (String) next.getTag();
            if (str == null) {
                RLog.i(TAG, "tag is null !");
                return false;
            }
            CSLMessageItem itemConfig = getItemConfig(str);
            if (itemConfig == null) {
                RLog.i(TAG, "config is null !");
                return false;
            }
            if (itemConfig.isRequired() && TextUtils.isEmpty(next.getText().toString())) {
                Toast.makeText(getBaseContext(), itemConfig.getMessage().get(CSLMessageItem.RemindType.EMPTY.getName()), 0).show();
                return false;
            }
            if (itemConfig.getVerification() != null && next.getText().length() > 0) {
                if (itemConfig.getVerification().equals("phone")) {
                    zIsEmail = isMobile(next.getText().toString());
                } else if (itemConfig.getVerification().equals("email")) {
                    zIsEmail = isEmail(next.getText().toString());
                }
                if (!zIsEmail) {
                    Toast.makeText(getBaseContext(), itemConfig.getMessage().get(CSLMessageItem.RemindType.WRONG_FORMAT.getName()), 0).show();
                    return false;
                }
            } else if (itemConfig.getMax() > 0 && next.length() > itemConfig.getMax()) {
                Toast.makeText(getBaseContext(), itemConfig.getMessage().get(CSLMessageItem.RemindType.OVER_LENGTH.getName()), 0).show();
                return false;
            }
        }
    }

    public boolean isEmail(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_cs_leave_message);
        this.mTargetId = getIntent().getStringExtra("targetId");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mItemList = extras.getParcelableArrayList("itemList");
        }
        TextView textView = (TextView) findViewById(R.id.rc_btn_cancel);
        addItemToContainer((LinearLayout) findViewById(R.id.rc_content));
        ((TextView) findViewById(R.id.rc_submit_message)).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.activity.CSLeaveMessageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CSLeaveMessageActivity.this.isContentValid()) {
                    HashMap map = new HashMap();
                    for (EditText editText : CSLeaveMessageActivity.this.mEditList) {
                        map.put((String) editText.getTag(), editText.getText().toString());
                    }
                    RongIMClient.getInstance().leaveMessageCustomService(CSLeaveMessageActivity.this.mTargetId, map, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.activity.CSLeaveMessageActivity.1.1
                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onSuccess() {
                            RongIM.getInstance().insertIncomingMessage(Conversation.ConversationType.CUSTOMER_SERVICE, CSLeaveMessageActivity.this.mTargetId, RongIMClient.getInstance().getCurrentUserId(), null, new InformationNotificationMessage(CSLeaveMessageActivity.this.getResources().getString(R.string.rc_cs_message_submited)), null);
                            CSLeaveMessageActivity.this.finish();
                        }
                    });
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.activity.CSLeaveMessageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CSLeaveMessageActivity.this.hideSoftInputKeyboard();
                CSLeaveMessageActivity.this.finish();
            }
        });
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public final void onEventMainThread(final Event.CSTerminateEvent cSTerminateEvent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            window.setContentView(R.layout.rc_cs_alert_warning);
            ((TextView) window.findViewById(R.id.rc_cs_msg)).setText(cSTerminateEvent.getText());
            window.findViewById(R.id.rc_btn_ok).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.activity.CSLeaveMessageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    alertDialogCreate.dismiss();
                    CSLeaveMessageActivity.this.hideSoftInputKeyboard();
                    cSTerminateEvent.getActivity().finish();
                    CSLeaveMessageActivity.this.finish();
                }
            });
        }
    }
}
