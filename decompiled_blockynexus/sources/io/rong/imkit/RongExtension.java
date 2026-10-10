package io.rong.imkit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import com.umeng.analytics.pro.b;
import io.rong.common.RLog;
import io.rong.imkit.InputBar;
import io.rong.imkit.actions.IClickActions;
import io.rong.imkit.actions.IMoreClickAdapter;
import io.rong.imkit.actions.MoreClickAdapter;
import io.rong.imkit.emoticon.AndroidEmoji;
import io.rong.imkit.emoticon.EmoticonTabAdapter;
import io.rong.imkit.emoticon.IEmoticonClickListener;
import io.rong.imkit.emoticon.IEmoticonSettingClickListener;
import io.rong.imkit.emoticon.IEmoticonTab;
import io.rong.imkit.menu.ISubMenuItemClickListener;
import io.rong.imkit.menu.InputSubMenu;
import io.rong.imkit.phrases.CommonphrasesAdapter;
import io.rong.imkit.phrases.IPhrasesClickListener;
import io.rong.imkit.plugin.CombineLocationPlugin;
import io.rong.imkit.plugin.DefaultLocationPlugin;
import io.rong.imkit.plugin.IPluginClickListener;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.plugin.IPluginRequestPermissionResultCallback;
import io.rong.imkit.plugin.ImagePlugin;
import io.rong.imkit.plugin.LocationConst;
import io.rong.imkit.plugin.PluginAdapter;
import io.rong.imkit.utilities.ExtensionHistoryUtil;
import io.rong.imkit.utilities.KitCommonDefine;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.common.SharedPreferencesUtils;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.CustomServiceMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RongExtension extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    private static final String TAG = "RongExtension";
    public static final int TRIGGER_MODE_SYSTEM = 1;
    public static final int TRIGGER_MODE_TOUCH = 2;
    boolean collapsed;
    private boolean hasEverDrawn;
    private boolean isBurnMode;
    private boolean isKeyBoardActive;
    private boolean isRobotFirst;
    private VisibilityState lastState;
    private ViewGroup mContainerLayout;
    private Conversation.ConversationType mConversationType;
    private View mDivider;
    private EditText mEditText;
    private View mEditTextLayout;
    private ImageView mEmoticonToggle;
    private EmoticonTabAdapter mEmotionTabAdapter;
    private ViewGroup mExtensionBar;
    private IExtensionClickListener mExtensionClickListener;
    private List<IExtensionModule> mExtensionModuleList;
    private IRongExtensionState mFireState;
    private Fragment mFragment;
    private List<InputMenu> mInputMenuList;
    private LinearLayout mMainBar;
    private ViewGroup mMenuContainer;
    private IRongExtensionState mNormalState;
    private View mPSDivider;
    private ImageView mPSMenu;
    private CommonphrasesAdapter mPhrasesAdapter;
    private List<String> mPhrasesList;
    private TextView mPhraseseToggle;
    private PluginAdapter mPluginAdapter;
    private ViewGroup mPluginLayout;
    private ImageView mPluginToggle;
    private FrameLayout mSendToggle;
    private InputBar.Style mStyle;
    private ViewGroup mSwitchLayout;
    private String mTargetId;
    private String mUserId;
    private Button mVoiceInputToggle;
    private ImageView mVoiceToggle;
    private IMoreClickAdapter moreClickAdapter;
    int originalBottom;
    int originalTop;
    private int triggerMode;

    /* JADX INFO: renamed from: io.rong.imkit.RongExtension$16, reason: invalid class name */
    static /* synthetic */ class AnonymousClass16 {
        static final /* synthetic */ int[] $SwitchMap$io$rong$imkit$InputBar$Style;
        static final /* synthetic */ int[] $SwitchMap$io$rong$imlib$model$CustomServiceMode = new int[CustomServiceMode.values().length];

        static {
            try {
                $SwitchMap$io$rong$imlib$model$CustomServiceMode[CustomServiceMode.CUSTOM_SERVICE_MODE_NO_SERVICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$CustomServiceMode[CustomServiceMode.CUSTOM_SERVICE_MODE_ROBOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$CustomServiceMode[CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$CustomServiceMode[CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN_FIRST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$CustomServiceMode[CustomServiceMode.CUSTOM_SERVICE_MODE_ROBOT_FIRST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $SwitchMap$io$rong$imkit$InputBar$Style = new int[InputBar.Style.values().length];
            try {
                $SwitchMap$io$rong$imkit$InputBar$Style[InputBar.Style.STYLE_SWITCH_CONTAINER_EXTENSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$rong$imkit$InputBar$Style[InputBar.Style.STYLE_CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$rong$imkit$InputBar$Style[InputBar.Style.STYLE_CONTAINER_EXTENSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$rong$imkit$InputBar$Style[InputBar.Style.STYLE_EXTENSION_CONTAINER.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$rong$imkit$InputBar$Style[InputBar.Style.STYLE_SWITCH_CONTAINER.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    enum VisibilityState {
        EXTENSION_VISIBLE,
        MENUCONTAINER_VISIBLE
    }

    public RongExtension(Context context) {
        super(context);
        this.isRobotFirst = false;
        this.lastState = VisibilityState.EXTENSION_VISIBLE;
        this.hasEverDrawn = false;
        this.triggerMode = 1;
        this.isKeyBoardActive = false;
        this.collapsed = true;
        this.originalTop = 0;
        this.originalBottom = 0;
        initView();
        initData();
    }

    private void initData() {
        this.mPhrasesList = RongExtensionManager.getInstance().getPhrasesList();
        this.mPhrasesAdapter = new CommonphrasesAdapter();
        this.mPhrasesAdapter.setOnPhrasesClickListener(new IPhrasesClickListener() { // from class: io.rong.imkit.RongExtension.4
            @Override // io.rong.imkit.phrases.IPhrasesClickListener
            public void onClick(String str, int i) {
                if (RongExtension.this.mExtensionClickListener != null) {
                    RongExtension.this.mExtensionClickListener.onPhrasesClicked(str, i);
                }
            }
        });
        this.mExtensionModuleList = RongExtensionManager.getInstance().getExtensionModules();
        this.mPluginAdapter = new PluginAdapter();
        this.mPluginAdapter.setOnPluginClickListener(new IPluginClickListener() { // from class: io.rong.imkit.RongExtension.5
            @Override // io.rong.imkit.plugin.IPluginClickListener
            public void onClick(IPluginModule iPluginModule, int i) {
                if (RongExtension.this.mExtensionClickListener != null) {
                    RongExtension.this.mExtensionClickListener.onPluginClicked(iPluginModule, i);
                }
                iPluginModule.onClick(RongExtension.this.mFragment, RongExtension.this);
            }
        });
        this.mEmotionTabAdapter = new EmoticonTabAdapter();
        this.moreClickAdapter = new MoreClickAdapter();
        this.mUserId = RongIMClient.getInstance().getCurrentUserId();
        try {
            ExtensionHistoryUtil.setEnableHistory(getResources().getBoolean(getResources().getIdentifier("rc_extension_history", "bool", getContext().getPackageName())));
            ExtensionHistoryUtil.addExceptConversationType(Conversation.ConversationType.CUSTOMER_SERVICE);
        } catch (Resources.NotFoundException unused) {
            RLog.i(TAG, "rc_extension_history not configure in rc_configuration.xml");
        }
    }

    private void initEmoticons() {
        IExtensionProxy extensionProxy = RongExtensionManager.getExtensionProxy();
        for (IExtensionModule iExtensionModule : this.mExtensionModuleList) {
            if (extensionProxy == null) {
                this.mEmotionTabAdapter.initTabs(iExtensionModule.getEmoticonTabs(), iExtensionModule.getClass().getCanonicalName());
            } else if (extensionProxy.onPreLoadEmoticons(this.mConversationType, this.mTargetId, iExtensionModule) != null) {
                this.mEmotionTabAdapter.initTabs(iExtensionModule.getEmoticonTabs(), iExtensionModule.getClass().getCanonicalName());
            }
        }
    }

    private void initPanelStyle() {
        if (ExtensionHistoryUtil.getExtensionBarState(getContext(), DeviceUtils.ShortMD5(0, this.mUserId, this.mTargetId, this.mConversationType.getName()), this.mConversationType) == ExtensionHistoryUtil.ExtensionBarState.NORMAL) {
            this.mVoiceToggle.setImageResource(R.drawable.rc_voice_toggle_selector);
            this.mEditTextLayout.setVisibility(0);
            this.mVoiceInputToggle.setVisibility(8);
        } else {
            this.mVoiceToggle.setImageResource(R.drawable.rc_keyboard_selector);
            this.mEditTextLayout.setVisibility(8);
            this.mVoiceInputToggle.setVisibility(0);
            this.mSendToggle.setVisibility(8);
            this.mPluginLayout.setVisibility(0);
        }
    }

    private void initPhrases() {
        List<String> list = this.mPhrasesList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mPhrasesAdapter.addPhrases(this.mPhrasesList);
    }

    private void initPlugins() {
        PluginAdapter pluginAdapter;
        PluginAdapter pluginAdapter2;
        Iterator<IExtensionModule> it = this.mExtensionModuleList.iterator();
        while (it.hasNext()) {
            List<IPluginModule> pluginModules = it.next().getPluginModules(this.mConversationType);
            if (pluginModules != null && (pluginAdapter2 = this.mPluginAdapter) != null) {
                pluginAdapter2.addPlugins(pluginModules);
            }
        }
        IExtensionProxy extensionProxy = RongExtensionManager.getExtensionProxy();
        if (extensionProxy == null || (pluginAdapter = this.mPluginAdapter) == null) {
            return;
        }
        extensionProxy.onPreLoadPlugins(this.mConversationType, this.mTargetId, pluginAdapter.getPluginModules());
    }

    private void initView() {
        setOrientation(1);
        setBackgroundColor(getContext().getResources().getColor(R.color.rc_extension_normal));
        this.mExtensionBar = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.rc_ext_extension_bar, (ViewGroup) null);
        this.mMainBar = (LinearLayout) this.mExtensionBar.findViewById(R.id.ext_main_bar);
        this.mSwitchLayout = (ViewGroup) this.mExtensionBar.findViewById(R.id.rc_switch_layout);
        this.mContainerLayout = (ViewGroup) this.mExtensionBar.findViewById(R.id.rc_container_layout);
        this.mPluginLayout = (ViewGroup) this.mExtensionBar.findViewById(R.id.rc_plugin_layout);
        this.mEditTextLayout = LayoutInflater.from(getContext()).inflate(R.layout.rc_ext_input_edit_text, (ViewGroup) null);
        this.mEditTextLayout.setVisibility(0);
        this.mContainerLayout.addView(this.mEditTextLayout);
        LayoutInflater.from(getContext()).inflate(R.layout.rc_ext_voice_input, this.mContainerLayout, true);
        this.mVoiceInputToggle = (Button) this.mContainerLayout.findViewById(R.id.rc_audio_input_toggle);
        this.mVoiceInputToggle.setVisibility(8);
        this.mEditText = (EditText) this.mExtensionBar.findViewById(R.id.rc_edit_text);
        this.mSendToggle = (FrameLayout) this.mExtensionBar.findViewById(R.id.rc_send_toggle);
        this.mPluginToggle = (ImageView) this.mExtensionBar.findViewById(R.id.rc_plugin_toggle);
        this.mPhraseseToggle = (TextView) this.mExtensionBar.findViewById(R.id.ext_common_phrases);
        this.mDivider = this.mExtensionBar.findViewById(R.id.rc_divider);
        this.mEditText.setOnTouchListener(this);
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.rong.imkit.RongExtension.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z && !TextUtils.isEmpty(RongExtension.this.mEditText.getText()) && RongExtension.this.mEditTextLayout.getVisibility() == 0) {
                    RongExtension.this.mSendToggle.setVisibility(0);
                    RongExtension.this.mPluginLayout.setVisibility(8);
                }
            }
        });
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: io.rong.imkit.RongExtension.7
            private int count;
            private int start;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i = this.start;
                if (AndroidEmoji.isEmoji(editable.subSequence(i, this.count + i).toString())) {
                    RongExtension.this.mEditText.removeTextChangedListener(this);
                    RongExtension.this.mEditText.setText(AndroidEmoji.ensure(AndroidEmoji.replaceEmojiWithText(editable.toString())), TextView.BufferType.SPANNABLE);
                    RongExtension.this.mEditText.setSelection(RongExtension.this.mEditText.getText().length());
                    RongExtension.this.mEditText.addTextChangedListener(this);
                }
                if (RongExtension.this.mExtensionClickListener != null) {
                    RongExtension.this.mExtensionClickListener.afterTextChanged(editable);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (RongExtension.this.mExtensionClickListener != null) {
                    RongExtension.this.mExtensionClickListener.beforeTextChanged(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.start = i;
                this.count = i3;
                if (RongExtension.this.mExtensionClickListener != null) {
                    RongExtension.this.mExtensionClickListener.onTextChanged(charSequence, i, i2, i3);
                }
                if (RongExtension.this.mVoiceInputToggle.getVisibility() == 0) {
                    RongExtension.this.mSendToggle.setVisibility(8);
                    RongExtension.this.mPluginLayout.setVisibility(0);
                } else if (charSequence == null || charSequence.length() == 0) {
                    RongExtension.this.mSendToggle.setVisibility(8);
                    RongExtension.this.mPluginLayout.setVisibility(0);
                } else {
                    RongExtension.this.mSendToggle.setVisibility(0);
                    RongExtension.this.mPluginLayout.setVisibility(8);
                }
            }
        });
        this.mEditText.setOnKeyListener(new View.OnKeyListener() { // from class: io.rong.imkit.RongExtension.8
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return RongExtension.this.mExtensionClickListener != null && RongExtension.this.mExtensionClickListener.onKey(RongExtension.this.mEditText, i, keyEvent);
            }
        });
        this.mEditText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: io.rong.imkit.RongExtension.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (RongExtension.this.mEditText.getText().length() <= 0 || !RongExtension.this.mEditText.isFocused() || RongExtension.this.hasEverDrawn) {
                    return;
                }
                Rect rect = new Rect();
                RongExtension.this.mEditText.getWindowVisibleDisplayFrame(rect);
                if (RongExtension.this.mEditText.getRootView().getHeight() - rect.bottom > ((int) RongExtension.this.mEditText.getContext().getResources().getDimension(R.dimen.rc_extension_bar_min_height)) * 2) {
                    RongExtension.this.hasEverDrawn = true;
                }
                if (RongExtension.this.mExtensionClickListener != null) {
                    RongExtension.this.mExtensionClickListener.onEditTextClick(RongExtension.this.mEditText);
                }
                RongExtension.this.showInputKeyBoard();
                RongExtension.this.mContainerLayout.setSelected(true);
                RongExtension.this.hidePluginBoard();
                RongExtension.this.hideEmoticonBoard();
                RongExtension.this.hidePhrasesBoard();
            }
        });
        this.mVoiceToggle = (ImageView) this.mExtensionBar.findViewById(R.id.rc_voice_toggle);
        this.mVoiceToggle.setOnClickListener(this);
        this.mVoiceInputToggle.setOnTouchListener(new View.OnTouchListener() { // from class: io.rong.imkit.RongExtension.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (RongExtension.this.mExtensionClickListener == null) {
                    return false;
                }
                RongExtension.this.mExtensionClickListener.onVoiceInputToggleTouch(view, motionEvent);
                return false;
            }
        });
        this.mSendToggle.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.RongExtension.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String string = RongExtension.this.mEditText.getText().toString();
                RongExtension.this.mEditText.setText("");
                if (RongExtension.this.mExtensionClickListener != null) {
                    RongExtension.this.mExtensionClickListener.onSendToggleClick(view, string);
                }
            }
        });
        this.mPluginToggle.setOnClickListener(this);
        this.mPhraseseToggle.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.RongExtension.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RongExtension.this.setPhrasesBoard();
            }
        });
        this.mEmoticonToggle = (ImageView) this.mExtensionBar.findViewById(R.id.rc_emoticon_toggle);
        this.mEmoticonToggle.setOnClickListener(this);
        this.mPSMenu = (ImageView) this.mExtensionBar.findViewById(R.id.rc_switch_to_menu);
        this.mPSMenu.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.RongExtension.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RongExtension.this.setExtensionBarVisibility(8);
                RongExtension rongExtension = RongExtension.this;
                rongExtension.setMenuVisibility(0, rongExtension.mInputMenuList);
            }
        });
        this.mPSDivider = this.mExtensionBar.findViewById(R.id.rc_switch_divider);
        addView(this.mExtensionBar);
    }

    private void refreshBurnMode() {
        getRongExtensionState().changeView(this);
    }

    private void setC() {
        this.mMainBar.removeAllViews();
        this.mMainBar.addView(this.mContainerLayout);
    }

    private void setCE() {
        if (this.mSendToggle.getVisibility() == 0) {
            this.mPluginLayout.setVisibility(8);
        } else {
            this.mPluginLayout.setVisibility(0);
        }
        this.mMainBar.removeAllViews();
        this.mMainBar.addView(this.mContainerLayout);
        this.mMainBar.addView(this.mPluginLayout);
    }

    private void setEC() {
        if (this.mSendToggle.getVisibility() == 0) {
            this.mPluginLayout.setVisibility(8);
        } else {
            this.mPluginLayout.setVisibility(0);
        }
        this.mMainBar.removeAllViews();
        this.mMainBar.addView(this.mPluginLayout);
        this.mMainBar.addView(this.mContainerLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtensionBarVisibility(int i) {
        if (i == 8) {
            hideEmoticonBoard();
            hidePluginBoard();
            hidePhrasesBoard();
            hideInputKeyBoard();
        }
        this.mExtensionBar.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMenuVisibility(int i, List<InputMenu> list) {
        if (this.mMenuContainer == null) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            this.mMenuContainer = (ViewGroup) layoutInflaterFrom.inflate(R.layout.rc_ext_menu_container, (ViewGroup) null);
            this.mMenuContainer.findViewById(R.id.rc_switch_to_keyboard).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.RongExtension.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RongExtension.this.setExtensionBarVisibility(0);
                    RongExtension.this.mMenuContainer.setVisibility(8);
                }
            });
            for (final int i2 = 0; i2 < list.size(); i2++) {
                final InputMenu inputMenu = list.get(i2);
                LinearLayout linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.rc_ext_root_menu_item, (ViewGroup) null);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
                ((TextView) linearLayout.findViewById(R.id.rc_menu_title)).setText(inputMenu.title);
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.rc_menu_icon);
                List<String> list2 = inputMenu.subMenuList;
                if (list2 != null && list2.size() > 0) {
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.drawable.rc_menu_trangle);
                }
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.RongExtension.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        List<String> list3 = inputMenu.subMenuList;
                        if (list3 == null || list3.size() <= 0) {
                            if (RongExtension.this.mExtensionClickListener != null) {
                                RongExtension.this.mExtensionClickListener.onMenuClick(i2, -1);
                            }
                        } else {
                            InputSubMenu inputSubMenu = new InputSubMenu(RongExtension.this.getContext(), list3);
                            inputSubMenu.setOnItemClickListener(new ISubMenuItemClickListener() { // from class: io.rong.imkit.RongExtension.2.1
                                @Override // io.rong.imkit.menu.ISubMenuItemClickListener
                                public void onClick(int i3) {
                                    if (RongExtension.this.mExtensionClickListener != null) {
                                        RongExtension.this.mExtensionClickListener.onMenuClick(i2, i3);
                                    }
                                }
                            });
                            inputSubMenu.showAtLocation(view);
                        }
                    }
                });
                ((ViewGroup) this.mMenuContainer.findViewById(R.id.rc_menu_bar)).addView(linearLayout);
            }
            addView(this.mMenuContainer);
        }
        if (i == 8) {
            this.mMenuContainer.setVisibility(8);
        } else {
            this.mMenuContainer.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhrasesBoard() {
        if (!this.mPhrasesAdapter.isInitialized()) {
            this.mEmoticonToggle.setImageResource(R.drawable.rc_emotion_toggle_selector);
            this.mPhrasesAdapter.bindView(this);
            this.mPhrasesAdapter.setVisibility(0);
            this.mContainerLayout.setSelected(false);
            hideInputKeyBoard();
            hideEmoticonBoard();
            hidePluginBoard();
        } else if (this.mPhrasesAdapter.getVisibility() == 0) {
            this.mPhrasesAdapter.setVisibility(8);
            this.mContainerLayout.setSelected(true);
        } else {
            this.mEmoticonToggle.setImageResource(R.drawable.rc_emotion_toggle_selector);
            if (isKeyBoardActive()) {
                getHandler().postDelayed(new Runnable() { // from class: io.rong.imkit.RongExtension.15
                    @Override // java.lang.Runnable
                    public void run() {
                        RongExtension.this.mPhrasesAdapter.setVisibility(0);
                    }
                }, 200L);
            } else {
                this.mPhrasesAdapter.setVisibility(0);
            }
            hideInputKeyBoard();
            hideEmoticonBoard();
            hidePluginBoard();
            this.mContainerLayout.setSelected(false);
        }
        hideVoiceInputToggle();
        this.mEditTextLayout.setVisibility(0);
    }

    private void setSC() {
        this.mSwitchLayout.setVisibility(0);
        this.mMainBar.removeAllViews();
        this.mMainBar.addView(this.mSwitchLayout);
        this.mMainBar.addView(this.mContainerLayout);
    }

    private void setSCE() {
        this.mSwitchLayout.setVisibility(0);
        if (this.mSendToggle.getVisibility() == 0) {
            this.mPluginLayout.setVisibility(8);
        } else {
            this.mPluginLayout.setVisibility(0);
        }
        this.mMainBar.removeAllViews();
        this.mMainBar.addView(this.mSwitchLayout);
        this.mMainBar.addView(this.mContainerLayout);
        this.mMainBar.addView(this.mPluginLayout);
    }

    public void addEmoticonExtraTab(Context context, Drawable drawable, View.OnClickListener onClickListener) {
        EmoticonTabAdapter emoticonTabAdapter = this.mEmotionTabAdapter;
        if (emoticonTabAdapter != null) {
            emoticonTabAdapter.addExtraTab(context, drawable, onClickListener);
        }
    }

    public boolean addEmoticonTab(int i, IEmoticonTab iEmoticonTab, String str) {
        if (this.mEmotionTabAdapter != null && iEmoticonTab != null && !TextUtils.isEmpty(str)) {
            return this.mEmotionTabAdapter.addTab(i, iEmoticonTab, str);
        }
        RLog.e(TAG, "addEmoticonTab Failure");
        return false;
    }

    public void addPlugin(IPluginModule iPluginModule) {
        if (iPluginModule != null) {
            this.mPluginAdapter.addPlugin(iPluginModule);
        }
    }

    public void addPluginPager(View view) {
        PluginAdapter pluginAdapter = this.mPluginAdapter;
        if (pluginAdapter != null) {
            pluginAdapter.addPager(view);
        }
    }

    void clickVoice(boolean z, RongExtension rongExtension, View view, int i) {
        if (rongExtension.getExtensionClickListener() != null) {
            rongExtension.getExtensionClickListener().onSwitchToggleClick(view, rongExtension.getContainerLayout());
        }
        if (z) {
            return;
        }
        if (rongExtension.getVoiceInputToggle().getVisibility() == 8) {
            rongExtension.getEditTextLayout().setVisibility(8);
            rongExtension.getSendToggle().setVisibility(8);
            rongExtension.getPluginLayout().setVisibility(0);
            rongExtension.hideInputKeyBoard();
            rongExtension.showVoiceInputToggle();
            rongExtension.getContainerLayout().setClickable(true);
            rongExtension.getContainerLayout().setSelected(false);
        } else {
            rongExtension.getEditTextLayout().setVisibility(0);
            rongExtension.hideVoiceInputToggle();
            rongExtension.getEmoticonToggle().setImageResource(i);
            if (rongExtension.getEditText().getText().length() > 0) {
                rongExtension.getSendToggle().setVisibility(0);
                rongExtension.getPluginLayout().setVisibility(8);
            } else {
                rongExtension.getSendToggle().setVisibility(8);
                rongExtension.getPluginLayout().setVisibility(0);
            }
            rongExtension.showInputKeyBoard();
            rongExtension.getContainerLayout().setSelected(true);
        }
        rongExtension.hidePluginBoard();
        rongExtension.hideEmoticonBoard();
        rongExtension.hidePhrasesBoard();
    }

    public void collapseExtension() {
        hidePluginBoard();
        hideEmoticonBoard();
        hidePhrasesBoard();
        hideInputKeyBoard();
    }

    public void enterBurnMode() {
        this.isBurnMode = true;
        SharedPreferencesUtils.get(getContext(), KitCommonDefine.RONG_KIT_SP_CONFIG, 0).edit().putBoolean(KitCommonDefine.BURN_PREFIX + getTargetId(), true).apply();
        hidePluginBoard();
        refreshBurnMode();
    }

    public void exitBurnMode() {
        SharedPreferencesUtils.get(getContext(), KitCommonDefine.RONG_KIT_SP_CONFIG, 0).edit().remove(KitCommonDefine.BURN_PREFIX + getTargetId()).apply();
        this.isBurnMode = false;
        refreshBurnMode();
    }

    ViewGroup getContainerLayout() {
        return this.mContainerLayout;
    }

    public Conversation.ConversationType getConversationType() {
        return this.mConversationType;
    }

    EditText getEditText() {
        return this.mEditText;
    }

    View getEditTextLayout() {
        return this.mEditTextLayout;
    }

    public int getEmoticonTabIndex(String str) {
        if (this.mEmotionTabAdapter == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        return this.mEmotionTabAdapter.getTagTabIndex(str);
    }

    public List<IEmoticonTab> getEmoticonTabs(String str) {
        if (this.mEmotionTabAdapter == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mEmotionTabAdapter.getTagTabs(str);
    }

    ImageView getEmoticonToggle() {
        return this.mEmoticonToggle;
    }

    IExtensionClickListener getExtensionClickListener() {
        return this.mExtensionClickListener;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }

    public EditText getInputEditText() {
        return this.mEditText;
    }

    public int getMenuVisibility() {
        ViewGroup viewGroup = this.mMenuContainer;
        if (viewGroup != null) {
            return viewGroup.getVisibility();
        }
        return 8;
    }

    ViewGroup getPluginLayout() {
        return this.mPluginLayout;
    }

    public List<IPluginModule> getPluginModules() {
        return this.mPluginAdapter.getPluginModules();
    }

    ImageView getPluginToggle() {
        return this.mPluginToggle;
    }

    public IRongExtensionState getRongExtensionState() {
        if (this.isBurnMode) {
            if (this.mFireState == null) {
                this.mFireState = new DestructState();
            }
            return this.mFireState;
        }
        if (this.mNormalState == null) {
            this.mNormalState = new NormalState();
        }
        return this.mNormalState;
    }

    FrameLayout getSendToggle() {
        return this.mSendToggle;
    }

    public String getTargetId() {
        return this.mTargetId;
    }

    public int getTriggerMode() {
        return this.triggerMode;
    }

    Button getVoiceInputToggle() {
        return this.mVoiceInputToggle;
    }

    ImageView getVoiceToggle() {
        return this.mVoiceToggle;
    }

    void hideEmoticonBoard() {
        getRongExtensionState().hideEmoticonBoard(this.mEmoticonToggle, this.mEmotionTabAdapter);
    }

    void hideInputKeyBoard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mEditText.getWindowToken(), 0);
        }
        this.mEditText.clearFocus();
        this.isKeyBoardActive = false;
    }

    public void hideMoreActionLayout() {
        if ((!getConversationType().equals(Conversation.ConversationType.APP_PUBLIC_SERVICE) && !getConversationType().equals(Conversation.ConversationType.PUBLIC_SERVICE)) || this.mInputMenuList == null) {
            setExtensionBarVisibility(0);
        } else if (this.lastState == VisibilityState.MENUCONTAINER_VISIBLE) {
            setExtensionBarVisibility(8);
            setMenuVisibility(0);
        } else {
            setExtensionBarVisibility(0);
            this.mPSMenu.setVisibility(0);
            this.mPSDivider.setVisibility(0);
        }
        this.moreClickAdapter.hideMoreActionLayout();
    }

    void hidePhrasesBoard() {
        CommonphrasesAdapter commonphrasesAdapter = this.mPhrasesAdapter;
        if (commonphrasesAdapter != null) {
            commonphrasesAdapter.setVisibility(8);
        }
    }

    void hidePluginBoard() {
        PluginAdapter pluginAdapter = this.mPluginAdapter;
        if (pluginAdapter != null) {
            pluginAdapter.setVisibility(8);
            this.mPluginAdapter.removePager(this.mPluginAdapter.getPager());
        }
    }

    void hideVoiceInputToggle() {
        this.mVoiceToggle.setImageResource(this.isBurnMode ? R.drawable.rc_destruct_voice_toggle_selector : R.drawable.rc_voice_toggle_selector);
        this.mVoiceInputToggle.setVisibility(8);
        ExtensionHistoryUtil.setExtensionBarState(getContext(), DeviceUtils.ShortMD5(0, this.mUserId, this.mTargetId, this.mConversationType.getName()), this.mConversationType, ExtensionHistoryUtil.ExtensionBarState.NORMAL);
    }

    public boolean isExtensionExpanded() {
        EmoticonTabAdapter emoticonTabAdapter;
        CommonphrasesAdapter commonphrasesAdapter;
        PluginAdapter pluginAdapter = this.mPluginAdapter;
        return (pluginAdapter != null && pluginAdapter.getVisibility() == 0) || ((emoticonTabAdapter = this.mEmotionTabAdapter) != null && emoticonTabAdapter.getVisibility() == 0) || ((commonphrasesAdapter = this.mPhrasesAdapter) != null && commonphrasesAdapter.getVisibility() == 0);
    }

    public boolean isFireStatus() {
        return this.isBurnMode;
    }

    boolean isKeyBoardActive() {
        return this.isKeyBoardActive;
    }

    public boolean isMoreActionShown() {
        return this.moreClickAdapter.isMoreActionShown();
    }

    boolean isRobotFirst() {
        return this.isRobotFirst;
    }

    public void onActivityPluginResult(int i, int i2, Intent intent) {
        int i3 = (i >> 8) - 1;
        int i4 = i & 255;
        IPluginModule pluginModule = this.mPluginAdapter.getPluginModule(i3);
        if (pluginModule != null) {
            if (this.mExtensionClickListener != null && i2 == -1) {
                if (pluginModule instanceof ImagePlugin) {
                    this.mExtensionClickListener.onImageResult((LinkedHashMap) new j().a(intent.getStringExtra("android.intent.extra.RETURN_RESULT"), new TypeToken<LinkedHashMap<String, Integer>>() { // from class: io.rong.imkit.RongExtension.3
                    }.getType()), intent.getBooleanExtra("sendOrigin", false));
                } else if ((pluginModule instanceof DefaultLocationPlugin) || (pluginModule instanceof CombineLocationPlugin)) {
                    this.mExtensionClickListener.onLocationResult(intent.getDoubleExtra(b.B, 0.0d), intent.getDoubleExtra(b.C, 0.0d), intent.getStringExtra(LocationConst.POI), Uri.parse(intent.getStringExtra("thumb")));
                }
            }
            pluginModule.onActivityResult(i4, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rc_plugin_toggle || id == R.id.rc_emoticon_toggle || id == R.id.rc_voice_toggle) {
            getRongExtensionState().onClick(this, view);
        }
    }

    public void onDestroy() {
        RLog.d(TAG, "onDestroy");
        Iterator<IExtensionModule> it = this.mExtensionModuleList.iterator();
        while (it.hasNext()) {
            it.next().onDetachedFromExtension();
        }
        this.mExtensionClickListener = null;
        hideInputKeyBoard();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IExtensionClickListener iExtensionClickListener;
        IExtensionClickListener iExtensionClickListener2;
        IExtensionClickListener iExtensionClickListener3;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.originalTop;
        if (i5 != 0) {
            if (i5 > i2) {
                int i6 = this.originalBottom;
                if (i6 > i4 && (iExtensionClickListener3 = this.mExtensionClickListener) != null && this.collapsed) {
                    this.collapsed = false;
                    iExtensionClickListener3.onExtensionExpanded(i6 - i2);
                } else if (this.collapsed && (iExtensionClickListener2 = this.mExtensionClickListener) != null) {
                    this.collapsed = false;
                    iExtensionClickListener2.onExtensionExpanded(i4 - i2);
                }
            } else if (!this.collapsed && (iExtensionClickListener = this.mExtensionClickListener) != null) {
                this.collapsed = true;
                iExtensionClickListener.onExtensionCollapsed();
            }
        }
        if (this.originalTop == 0) {
            this.originalTop = i2;
            this.originalBottom = i4;
        }
    }

    public boolean onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        int i2 = i & 255;
        IPluginModule pluginModule = this.mPluginAdapter.getPluginModule((i >> 8) - 1);
        if (pluginModule instanceof IPluginRequestPermissionResultCallback) {
            return ((IPluginRequestPermissionResultCallback) pluginModule).onRequestPermissionResult(this.mFragment, this, i2, strArr, iArr);
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.triggerMode != 2) {
            this.triggerMode = 2;
        }
        return getRongExtensionState().onEditTextTouch(this, view, motionEvent);
    }

    public void refreshEmoticonTabIcon(IEmoticonTab iEmoticonTab, Drawable drawable) {
        EmoticonTabAdapter emoticonTabAdapter;
        if (drawable == null || (emoticonTabAdapter = this.mEmotionTabAdapter) == null || iEmoticonTab == null) {
            return;
        }
        emoticonTabAdapter.refreshTabIcon(iEmoticonTab, drawable);
    }

    void refreshQuickView() {
        Conversation.ConversationType conversationType = this.mConversationType;
        if ((conversationType != Conversation.ConversationType.PRIVATE && conversationType != Conversation.ConversationType.GROUP) || this.mPhrasesList.size() <= 0 || this.isBurnMode) {
            this.mPhraseseToggle.setVisibility(8);
            this.mDivider.setVisibility(0);
            return;
        }
        this.mPhraseseToggle.setVisibility(0);
        int iDip2px = RongUtils.dip2px(6.0f);
        this.mMainBar.setPadding(iDip2px, iDip2px, iDip2px, iDip2px);
        this.mDivider.setVisibility(8);
        initPhrases();
    }

    public boolean removeEmoticonTab(IEmoticonTab iEmoticonTab, String str) {
        if (this.mEmotionTabAdapter == null || iEmoticonTab == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mEmotionTabAdapter.removeTab(iEmoticonTab, str);
    }

    public void removePlugin(IPluginModule iPluginModule) {
        if (iPluginModule != null) {
            this.mPluginAdapter.removePlugin(iPluginModule);
        }
    }

    public void removePluginPager(View view) {
        PluginAdapter pluginAdapter = this.mPluginAdapter;
        if (pluginAdapter == null || view == null) {
            return;
        }
        pluginAdapter.removePager(view);
    }

    public void requestPermissionForPluginResult(String[] strArr, int i, IPluginModule iPluginModule) {
        if ((i & (-256)) != 0) {
            throw new IllegalArgumentException("requestCode must less than 256");
        }
        PermissionCheckUtil.requestPermissions(this.mFragment, strArr, ((this.mPluginAdapter.getPluginPosition(iPluginModule) + 1) << 8) + (i & 255));
    }

    public void resetEditTextLayoutDrawnStatus() {
        this.hasEverDrawn = false;
    }

    public void setConversation(Conversation.ConversationType conversationType, String str) {
        if (this.mConversationType == null && this.mTargetId == null) {
            this.mConversationType = conversationType;
            this.mTargetId = str;
            Iterator<IExtensionModule> it = this.mExtensionModuleList.iterator();
            while (it.hasNext()) {
                it.next().onAttachedToExtension(this);
            }
            refreshQuickView();
            initPlugins();
            initEmoticons();
            initPanelStyle();
        }
        this.mConversationType = conversationType;
        this.mTargetId = str;
        if (SharedPreferencesUtils.get(getContext(), KitCommonDefine.RONG_KIT_SP_CONFIG, 0).getBoolean(KitCommonDefine.BURN_PREFIX + getTargetId(), false)) {
            enterBurnMode();
        }
    }

    public void setCurrentEmoticonTab(IEmoticonTab iEmoticonTab, String str) {
        if (this.mEmotionTabAdapter == null || iEmoticonTab == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mEmotionTabAdapter.setCurrentTab(iEmoticonTab, str);
    }

    void setEmoticonBoard() {
        if (!this.mEmotionTabAdapter.isInitialized()) {
            this.mEmotionTabAdapter.bindView(this);
            this.mEmotionTabAdapter.setVisibility(0);
            this.mContainerLayout.setSelected(true);
            this.mEmoticonToggle.setSelected(true);
            this.mEmoticonToggle.setImageResource(R.drawable.rc_keyboard_selector);
        } else if (this.mEmotionTabAdapter.getVisibility() == 0) {
            this.mEmotionTabAdapter.setVisibility(8);
            this.mEmoticonToggle.setSelected(false);
            this.mEmoticonToggle.setImageResource(R.drawable.rc_emotion_toggle_selector);
            showInputKeyBoard();
        } else {
            this.mEmotionTabAdapter.setVisibility(0);
            this.mContainerLayout.setSelected(true);
            this.mEmoticonToggle.setSelected(true);
            this.mEmoticonToggle.setImageResource(R.drawable.rc_keyboard_selector);
        }
        if (TextUtils.isEmpty(this.mEditText.getText())) {
            return;
        }
        this.mSendToggle.setVisibility(0);
        this.mPluginLayout.setVisibility(8);
    }

    public void setEmoticonTabBarAddClickListener(IEmoticonClickListener iEmoticonClickListener) {
        EmoticonTabAdapter emoticonTabAdapter = this.mEmotionTabAdapter;
        if (emoticonTabAdapter != null) {
            emoticonTabAdapter.setOnEmoticonClickListener(iEmoticonClickListener);
        }
    }

    public void setEmoticonTabBarAddEnable(boolean z) {
        EmoticonTabAdapter emoticonTabAdapter = this.mEmotionTabAdapter;
        if (emoticonTabAdapter != null) {
            emoticonTabAdapter.setAddEnable(z);
        }
    }

    public void setEmoticonTabBarEnable(boolean z) {
        EmoticonTabAdapter emoticonTabAdapter = this.mEmotionTabAdapter;
        if (emoticonTabAdapter != null) {
            emoticonTabAdapter.setTabViewEnable(z);
        }
    }

    public void setEmoticonTabBarSettingClickListener(IEmoticonSettingClickListener iEmoticonSettingClickListener) {
        EmoticonTabAdapter emoticonTabAdapter = this.mEmotionTabAdapter;
        if (emoticonTabAdapter != null) {
            emoticonTabAdapter.setOnEmoticonSettingClickListener(iEmoticonSettingClickListener);
        }
    }

    public void setEmoticonTabBarSettingEnable(boolean z) {
        EmoticonTabAdapter emoticonTabAdapter = this.mEmotionTabAdapter;
        if (emoticonTabAdapter != null) {
            emoticonTabAdapter.setSettingEnable(z);
        }
    }

    public void setExtensionBarMode(CustomServiceMode customServiceMode) {
        int i = AnonymousClass16.$SwitchMap$io$rong$imlib$model$CustomServiceMode[customServiceMode.ordinal()];
        if (i == 1 || i == 2) {
            setC();
            return;
        }
        if (i == 3 || i == 4) {
            this.isRobotFirst = false;
            InputBar.Style style = this.mStyle;
            if (style != null) {
                setInputBarStyle(style);
            }
            this.mVoiceToggle.setImageResource(R.drawable.rc_voice_toggle_selector);
            this.mVoiceToggle.setOnClickListener(this);
            return;
        }
        if (i != 5) {
            return;
        }
        this.mVoiceToggle.setImageResource(R.drawable.rc_cs_admin_selector);
        this.isRobotFirst = true;
        this.mVoiceToggle.setOnClickListener(this);
        setSC();
    }

    public void setExtensionClickListener(IExtensionClickListener iExtensionClickListener) {
        this.mExtensionClickListener = iExtensionClickListener;
    }

    public void setFragment(Fragment fragment) {
        this.mFragment = fragment;
    }

    public void setInputBarStyle(InputBar.Style style) {
        int i = AnonymousClass16.$SwitchMap$io$rong$imkit$InputBar$Style[style.ordinal()];
        if (i == 1) {
            setSCE();
            return;
        }
        if (i == 2) {
            setC();
            return;
        }
        if (i == 3) {
            setCE();
        } else if (i == 4) {
            setEC();
        } else {
            if (i != 5) {
                return;
            }
            setSC();
        }
    }

    public void setInputMenu(List<InputMenu> list, boolean z) {
        if (list == null || list.size() <= 0) {
            RLog.e(TAG, "setInputMenu no item");
            return;
        }
        this.mPSMenu.setVisibility(0);
        this.mPSDivider.setVisibility(0);
        this.mInputMenuList = list;
        if (z) {
            setExtensionBarVisibility(8);
            setMenuVisibility(0, list);
        }
    }

    void setKeyBoardActive(boolean z) {
        this.isKeyBoardActive = z;
    }

    public void setMoreActionEnable(boolean z) {
        this.moreClickAdapter.setMoreActionEnable(z);
    }

    void setPluginBoard() {
        if (!this.mPluginAdapter.isInitialized()) {
            this.mEmoticonToggle.setImageResource(R.drawable.rc_emotion_toggle_selector);
            this.mPluginAdapter.bindView(this);
            this.mPluginAdapter.setVisibility(0);
            this.mContainerLayout.setSelected(false);
            hideInputKeyBoard();
            hideEmoticonBoard();
            hidePhrasesBoard();
        } else if (this.mPluginAdapter.getVisibility() == 0) {
            View pager = this.mPluginAdapter.getPager();
            if (pager != null) {
                pager.setVisibility(pager.getVisibility() == 8 ? 0 : 8);
            } else {
                this.mPluginAdapter.setVisibility(8);
                this.mContainerLayout.setSelected(true);
                showInputKeyBoard();
            }
        } else {
            this.mEmoticonToggle.setImageResource(R.drawable.rc_emotion_toggle_selector);
            if (isKeyBoardActive()) {
                getHandler().postDelayed(new Runnable() { // from class: io.rong.imkit.RongExtension.14
                    @Override // java.lang.Runnable
                    public void run() {
                        RongExtension.this.mPluginAdapter.setVisibility(0);
                    }
                }, 200L);
            } else {
                this.mPluginAdapter.setVisibility(0);
            }
            hideInputKeyBoard();
            hideEmoticonBoard();
            hidePhrasesBoard();
            this.mContainerLayout.setSelected(false);
        }
        hideVoiceInputToggle();
        this.mEditTextLayout.setVisibility(0);
    }

    void showInputKeyBoard() {
        this.mEditText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.mEditText, 0);
        }
        this.mEmoticonToggle.setSelected(false);
        this.isKeyBoardActive = true;
    }

    public void showMoreActionLayout(List<IClickActions> list) {
        this.lastState = getMenuVisibility() == 0 ? VisibilityState.MENUCONTAINER_VISIBLE : VisibilityState.EXTENSION_VISIBLE;
        setExtensionBarVisibility(8);
        setMenuVisibility(8);
        this.moreClickAdapter.bindView(this, this.mFragment, list);
    }

    public void showRequestPermissionFailedAlter(String str) {
        PermissionCheckUtil.showRequestPermissionFailedAlter(this.mFragment.getActivity(), str);
    }

    public void showSoftInput() {
        showInputKeyBoard();
        this.mContainerLayout.setSelected(true);
    }

    void showVoiceInputToggle() {
        Resources resources;
        int i;
        this.mVoiceInputToggle.setVisibility(0);
        Button button = this.mVoiceInputToggle;
        if (this.isBurnMode) {
            resources = getContext().getResources();
            i = R.color.rc_destruct_voice_color;
        } else {
            resources = getContext().getResources();
            i = R.color.rc_text_voice;
        }
        button.setTextColor(resources.getColor(i));
        this.mVoiceToggle.setImageResource(this.isBurnMode ? R.drawable.rc_destruct_keyboard_selector : R.drawable.rc_keyboard_selector);
        ExtensionHistoryUtil.setExtensionBarState(getContext(), DeviceUtils.ShortMD5(0, this.mUserId, this.mTargetId, this.mConversationType.getName()), this.mConversationType, ExtensionHistoryUtil.ExtensionBarState.VOICE);
    }

    public void startActivityForPluginResult(Intent intent, int i, IPluginModule iPluginModule) {
        if ((i & (-256)) != 0) {
            throw new IllegalArgumentException("requestCode must less than 256.");
        }
        this.mFragment.startActivityForResult(intent, ((this.mPluginAdapter.getPluginPosition(iPluginModule) + 1) << 8) + (i & 255));
    }

    public void addEmoticonTab(IEmoticonTab iEmoticonTab, String str) {
        if (this.mEmotionTabAdapter == null || iEmoticonTab == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mEmotionTabAdapter.addTab(iEmoticonTab, str);
    }

    public RongExtension(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isRobotFirst = false;
        this.lastState = VisibilityState.EXTENSION_VISIBLE;
        this.hasEverDrawn = false;
        this.triggerMode = 1;
        this.isKeyBoardActive = false;
        this.collapsed = true;
        this.originalTop = 0;
        this.originalBottom = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RongExtension);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.RongExtension_RCStyle, 291);
        typedArrayObtainStyledAttributes.recycle();
        initView();
        initData();
        this.mStyle = InputBar.Style.getStyle(i);
        InputBar.Style style = this.mStyle;
        if (style != null) {
            setInputBarStyle(style);
        }
    }

    public void setMenuVisibility(int i) {
        ViewGroup viewGroup = this.mMenuContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
        }
    }
}
