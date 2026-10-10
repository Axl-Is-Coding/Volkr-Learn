package io.rong.imkit;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import io.rong.imkit.emoticon.EmoticonTabAdapter;

/* JADX INFO: loaded from: classes5.dex */
public class NormalState implements IRongExtensionState {
    NormalState() {
    }

    @Override // io.rong.imkit.IRongExtensionState
    public void changeView(RongExtension rongExtension) {
        rongExtension.refreshQuickView();
        ImageView voiceToggle = rongExtension.getVoiceToggle();
        if (voiceToggle != null) {
            voiceToggle.setImageResource(R.drawable.rc_voice_toggle_selector);
        }
        ImageView pluginToggle = rongExtension.getPluginToggle();
        if (pluginToggle != null) {
            pluginToggle.setImageResource(R.drawable.rc_plugin_toggle_selector);
        }
        ImageView emoticonToggle = rongExtension.getEmoticonToggle();
        if (emoticonToggle != null) {
            emoticonToggle.setImageResource(R.drawable.rc_emotion_toggle_selector);
        }
        EditText editText = rongExtension.getEditText();
        if (editText != null) {
            editText.setBackgroundResource(R.drawable.rc_edit_text_background_selector);
        }
        Button voiceInputToggle = rongExtension.getVoiceInputToggle();
        if (voiceInputToggle != null) {
            voiceInputToggle.setTextColor(rongExtension.getContext().getResources().getColor(R.color.rc_text_voice));
        }
    }

    @Override // io.rong.imkit.IRongExtensionState
    public void hideEmoticonBoard(ImageView imageView, EmoticonTabAdapter emoticonTabAdapter) {
        emoticonTabAdapter.setVisibility(8);
        imageView.setImageResource(R.drawable.rc_emotion_toggle_selector);
    }

    @Override // io.rong.imkit.IRongExtensionState
    public void onClick(final RongExtension rongExtension, View view) {
        int id = view.getId();
        if (id == R.id.rc_plugin_toggle) {
            if (rongExtension.getExtensionClickListener() != null) {
                rongExtension.getExtensionClickListener().onPluginToggleClick(view, rongExtension);
            }
            rongExtension.setPluginBoard();
        } else {
            if (id != R.id.rc_emoticon_toggle) {
                if (id == R.id.rc_voice_toggle) {
                    rongExtension.clickVoice(rongExtension.isRobotFirst(), rongExtension, view, R.drawable.rc_emotion_toggle_selector);
                    return;
                }
                return;
            }
            if (rongExtension.getExtensionClickListener() != null) {
                rongExtension.getExtensionClickListener().onEmoticonToggleClick(view, rongExtension);
            }
            if (rongExtension.isKeyBoardActive()) {
                rongExtension.hideInputKeyBoard();
                rongExtension.getHandler().postDelayed(new Runnable() { // from class: io.rong.imkit.NormalState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        rongExtension.setEmoticonBoard();
                    }
                }, 200L);
            } else {
                rongExtension.setEmoticonBoard();
            }
            rongExtension.hidePluginBoard();
            rongExtension.hidePhrasesBoard();
        }
    }

    @Override // io.rong.imkit.IRongExtensionState
    public boolean onEditTextTouch(RongExtension rongExtension, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            EditText editText = rongExtension.getEditText();
            if (rongExtension.getExtensionClickListener() != null) {
                rongExtension.getExtensionClickListener().onEditTextClick(editText);
            }
            if (Build.BRAND.toLowerCase().contains("meizu")) {
                editText.requestFocus();
                rongExtension.getEmoticonToggle().setSelected(false);
                rongExtension.setKeyBoardActive(true);
            } else {
                rongExtension.showInputKeyBoard();
            }
            rongExtension.getContainerLayout().setSelected(true);
            rongExtension.hidePluginBoard();
            rongExtension.hideEmoticonBoard();
            rongExtension.hidePhrasesBoard();
        }
        return false;
    }
}
