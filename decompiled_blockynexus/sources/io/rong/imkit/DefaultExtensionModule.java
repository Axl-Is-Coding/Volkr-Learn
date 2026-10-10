package io.rong.imkit;

import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.widget.EditText;
import io.rong.common.RLog;
import io.rong.imkit.emoticon.EmojiTab;
import io.rong.imkit.emoticon.IEmojiItemClickListener;
import io.rong.imkit.emoticon.IEmoticonTab;
import io.rong.imkit.manager.InternalModuleManager;
import io.rong.imkit.plugin.CombineLocationPlugin;
import io.rong.imkit.plugin.DefaultLocationPlugin;
import io.rong.imkit.plugin.DestructPlugin;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.plugin.ImagePlugin;
import io.rong.imkit.widget.provider.FilePlugin;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultExtensionModule implements IExtensionModule {
    private static final String TAG = "DefaultExtensionModule";
    private EditText mEditText;
    private Stack<EditText> stack;
    private String[] types;

    public DefaultExtensionModule(Context context) {
        this.types = null;
        Resources resources = context.getResources();
        try {
            this.types = resources.getStringArray(resources.getIdentifier("rc_realtime_support_conversation_types", "array", context.getPackageName()));
        } catch (Resources.NotFoundException unused) {
            RLog.i(TAG, "not config rc_realtime_support_conversation_types in rc_config.xml");
        }
    }

    @Override // io.rong.imkit.IExtensionModule
    public List<IEmoticonTab> getEmoticonTabs() {
        EmojiTab emojiTab = new EmojiTab();
        emojiTab.setOnItemClickListener(new IEmojiItemClickListener() { // from class: io.rong.imkit.DefaultExtensionModule.1
            @Override // io.rong.imkit.emoticon.IEmojiItemClickListener
            public void onDeleteClick() {
                EditText editText = DefaultExtensionModule.this.mEditText;
                if (editText != null) {
                    editText.dispatchKeyEvent(new KeyEvent(0, 67));
                }
            }

            @Override // io.rong.imkit.emoticon.IEmojiItemClickListener
            public void onEmojiClick(String str) {
                EditText editText = DefaultExtensionModule.this.mEditText;
                if (editText != null) {
                    editText.getText().insert(editText.getSelectionStart(), str);
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(emojiTab);
        return arrayList;
    }

    @Override // io.rong.imkit.IExtensionModule
    public List<IPluginModule> getPluginModules(Conversation.ConversationType conversationType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ImagePlugin());
        try {
            Class.forName("com.amap.api.netlocation.AMapNetworkLocationClient");
            CombineLocationPlugin combineLocationPlugin = new CombineLocationPlugin();
            DefaultLocationPlugin defaultLocationPlugin = new DefaultLocationPlugin();
            boolean z = false;
            if (this.types != null && this.types.length > 0) {
                String[] strArr = this.types;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (conversationType.getName().equals(strArr[i])) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            if (z) {
                arrayList.add(combineLocationPlugin);
            } else if (this.types == null && conversationType.equals(Conversation.ConversationType.PRIVATE)) {
                arrayList.add(combineLocationPlugin);
            } else {
                arrayList.add(defaultLocationPlugin);
            }
        } catch (Exception e2) {
            RLog.i(TAG, "Not include AMap");
            RLog.e(TAG, "getPluginModules", e2);
        }
        if (conversationType.equals(Conversation.ConversationType.GROUP) || conversationType.equals(Conversation.ConversationType.DISCUSSION) || conversationType.equals(Conversation.ConversationType.PRIVATE)) {
            arrayList.addAll(InternalModuleManager.getInstance().getInternalPlugins(conversationType));
        }
        arrayList.add(new FilePlugin());
        if (Conversation.ConversationType.PRIVATE.equals(conversationType) && RongIM.getInstance().getApplicationContext() != null && RongIM.getInstance().getApplicationContext().getResources().getBoolean(R.bool.rc_open_destruct_plugin)) {
            arrayList.add(new DestructPlugin());
        }
        return arrayList;
    }

    @Override // io.rong.imkit.IExtensionModule
    public void onAttachedToExtension(RongExtension rongExtension) {
        this.mEditText = rongExtension.getInputEditText();
        RLog.i(TAG, "attach " + this.stack.size());
        this.stack.push(this.mEditText);
    }

    @Override // io.rong.imkit.IExtensionModule
    public void onConnect(String str) {
    }

    @Override // io.rong.imkit.IExtensionModule
    public void onDetachedFromExtension() {
        RLog.i(TAG, "detach " + this.stack.size());
        if (this.stack.size() > 0) {
            this.stack.pop();
            this.mEditText = this.stack.size() > 0 ? this.stack.peek() : null;
        }
    }

    @Override // io.rong.imkit.IExtensionModule
    public void onDisconnect() {
    }

    @Override // io.rong.imkit.IExtensionModule
    public void onInit(String str) {
        this.stack = new Stack<>();
    }

    @Override // io.rong.imkit.IExtensionModule
    public void onReceivedMessage(Message message) {
    }

    public DefaultExtensionModule() {
        this.types = null;
    }
}
