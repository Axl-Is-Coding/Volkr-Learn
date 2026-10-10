package io.rong.imkit;

import android.net.Uri;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import io.rong.imkit.plugin.IPluginModule;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes5.dex */
public interface IExtensionClickListener extends TextWatcher {
    void onEditTextClick(EditText editText);

    void onEmoticonToggleClick(View view, ViewGroup viewGroup);

    void onExtensionCollapsed();

    void onExtensionExpanded(int i);

    void onImageResult(LinkedHashMap<String, Integer> linkedHashMap, boolean z);

    boolean onKey(View view, int i, KeyEvent keyEvent);

    void onLocationResult(double d2, double d3, String str, Uri uri);

    void onMenuClick(int i, int i2);

    void onPhrasesClicked(String str, int i);

    void onPluginClicked(IPluginModule iPluginModule, int i);

    void onPluginToggleClick(View view, ViewGroup viewGroup);

    void onSendToggleClick(View view, String str);

    void onSwitchToggleClick(View view, ViewGroup viewGroup);

    void onVoiceInputToggleTouch(View view, MotionEvent motionEvent);
}
