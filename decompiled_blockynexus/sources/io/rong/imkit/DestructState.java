package io.rong.imkit;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import io.rong.imkit.dialog.ImageVideoDialogFragment;
import io.rong.imkit.emoticon.EmoticonTabAdapter;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.plugin.ImagePlugin;

/* JADX INFO: loaded from: classes5.dex */
public class DestructState implements IRongExtensionState {
    private ImageVideoDialogFragment imageVideoDialog;

    DestructState() {
    }

    @Override // io.rong.imkit.IRongExtensionState
    public void changeView(RongExtension rongExtension) {
        rongExtension.refreshQuickView();
        ImageView voiceToggle = rongExtension.getVoiceToggle();
        if (voiceToggle != null) {
            voiceToggle.setImageResource(R.drawable.rc_destruct_voice_toggle_selector);
        }
        ImageView pluginToggle = rongExtension.getPluginToggle();
        if (pluginToggle != null) {
            pluginToggle.setImageResource(R.drawable.rc_destruct_plugin_toggle_selector);
        }
        ImageView emoticonToggle = rongExtension.getEmoticonToggle();
        if (emoticonToggle != null) {
            emoticonToggle.setImageResource(R.drawable.rc_destruct_emotion_toggle_selector);
        }
        EditText editText = rongExtension.getEditText();
        if (editText != null) {
            editText.setBackgroundResource(R.drawable.rc_destruct_edit_text_background_selector);
        }
        Button voiceInputToggle = rongExtension.getVoiceInputToggle();
        if (voiceInputToggle != null) {
            voiceInputToggle.setTextColor(rongExtension.getContext().getResources().getColor(R.color.rc_destruct_voice_color));
        }
    }

    @Override // io.rong.imkit.IRongExtensionState
    public void hideEmoticonBoard(ImageView imageView, EmoticonTabAdapter emoticonTabAdapter) {
        emoticonTabAdapter.setVisibility(8);
    }

    @Override // io.rong.imkit.IRongExtensionState
    public void onClick(final RongExtension rongExtension, View view) {
        int id = view.getId();
        if (id == R.id.rc_plugin_toggle) {
            rongExtension.exitBurnMode();
            return;
        }
        if (id != R.id.rc_emoticon_toggle) {
            if (id == R.id.rc_voice_toggle) {
                rongExtension.clickVoice(rongExtension.isRobotFirst(), rongExtension, view, R.drawable.rc_destruct_emotion_toggle_selector);
                return;
            }
            return;
        }
        if (this.imageVideoDialog == null) {
            boolean z = false;
            final IPluginModule iPluginModule = null;
            final IPluginModule iPluginModule2 = null;
            boolean z2 = false;
            for (IPluginModule iPluginModule3 : rongExtension.getPluginModules()) {
                if (iPluginModule3 instanceof ImagePlugin) {
                    iPluginModule2 = iPluginModule3;
                    z = true;
                } else if (iPluginModule3.getClass().getName().equals("io.rong.sight.SightPlugin")) {
                    iPluginModule = iPluginModule3;
                    z2 = true;
                }
            }
            this.imageVideoDialog = new ImageVideoDialogFragment();
            this.imageVideoDialog.setHasImage(z);
            this.imageVideoDialog.setHasSight(z2);
            this.imageVideoDialog.setImageVideoDialogListener(new ImageVideoDialogFragment.ImageVideoDialogListener() { // from class: io.rong.imkit.DestructState.1
                @Override // io.rong.imkit.dialog.ImageVideoDialogFragment.ImageVideoDialogListener
                public void onImageClick(View view2) {
                    IPluginModule iPluginModule4 = iPluginModule2;
                    if (iPluginModule4 != null) {
                        iPluginModule4.onClick(rongExtension.getFragment(), rongExtension);
                    }
                }

                @Override // io.rong.imkit.dialog.ImageVideoDialogFragment.ImageVideoDialogListener
                public void onSightClick(View view2) {
                    IPluginModule iPluginModule4 = iPluginModule;
                    if (iPluginModule4 != null) {
                        iPluginModule4.onClick(rongExtension.getFragment(), rongExtension);
                    }
                }
            });
        }
        this.imageVideoDialog.show(rongExtension.getFragment().getFragmentManager());
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
