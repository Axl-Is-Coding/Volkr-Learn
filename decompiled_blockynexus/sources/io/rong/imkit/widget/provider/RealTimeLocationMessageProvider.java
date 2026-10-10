package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import io.rong.imkit.R;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.plugin.location.AMapRealTimeActivity;
import io.rong.imkit.plugin.location.AMapRealTimeActivity2D;
import io.rong.imkit.plugin.location.LocationManager;
import io.rong.imkit.plugin.location.LocationManager2D;
import io.rong.imkit.utilities.PromptPopupDialog;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.location.message.RealTimeLocationStartMessage;
import io.rong.imlib.model.Message;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = RealTimeLocationStartMessage.class)
public class RealTimeLocationMessageProvider extends IContainerItemProvider.MessageProvider<RealTimeLocationStartMessage> {

    private static class ViewHolder {
        boolean longClick;
        TextView message;

        private ViewHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void joinMap(View view, UIMessage uIMessage) {
        List<String> realTimeLocationParticipants = RongIMClient.getInstance().getRealTimeLocationParticipants(uIMessage.getConversationType(), uIMessage.getTargetId());
        int iJoinLocationSharing = view.getContext().getResources().getBoolean(R.bool.rc_location_2D) ? LocationManager2D.getInstance().joinLocationSharing() : LocationManager.getInstance().joinLocationSharing();
        if (iJoinLocationSharing == 0) {
            Intent intent = view.getContext().getResources().getBoolean(R.bool.rc_location_2D) ? new Intent(view.getContext(), (Class<?>) AMapRealTimeActivity2D.class) : new Intent(view.getContext(), (Class<?>) AMapRealTimeActivity.class);
            if (realTimeLocationParticipants != null) {
                intent.putStringArrayListExtra("participants", (ArrayList) realTimeLocationParticipants);
            }
            view.getContext().startActivity(intent);
            return;
        }
        if (iJoinLocationSharing == 1) {
            Toast.makeText(view.getContext(), R.string.rc_network_exception, 0).show();
        } else if (iJoinLocationSharing == 2) {
            Toast.makeText(view.getContext(), R.string.rc_location_sharing_exceed_max, 0).show();
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(RealTimeLocationStartMessage realTimeLocationStartMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_share_location_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.message = (TextView) viewInflate.findViewById(android.R.id.text1);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, RealTimeLocationStartMessage realTimeLocationStartMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            Drawable drawable = viewHolder.message.getResources().getDrawable(R.drawable.rc_icon_rt_message_right);
            drawable.setBounds(0, 0, 29, 41);
            viewHolder.message.setBackgroundResource(R.drawable.rc_ic_bubble_right);
            viewHolder.message.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            viewHolder.message.setText(view.getContext().getResources().getString(R.string.rc_real_time_location_sharing));
            return;
        }
        Drawable drawable2 = viewHolder.message.getResources().getDrawable(R.drawable.rc_icon_rt_message_left);
        drawable2.setBounds(0, 0, 29, 41);
        viewHolder.message.setBackgroundResource(R.drawable.rc_ic_bubble_left);
        viewHolder.message.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
        viewHolder.message.setText(view.getContext().getResources().getString(R.string.rc_real_time_location_sharing));
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(final View view, int i, RealTimeLocationStartMessage realTimeLocationStartMessage, final UIMessage uIMessage) {
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            joinMap(view, uIMessage);
            return;
        }
        PromptPopupDialog promptPopupDialogNewInstance = PromptPopupDialog.newInstance(view.getContext(), "", view.getContext().getResources().getString(R.string.rc_real_time_join_notification));
        promptPopupDialogNewInstance.setPromptButtonClickedListener(new PromptPopupDialog.OnPromptButtonClickedListener() { // from class: io.rong.imkit.widget.provider.RealTimeLocationMessageProvider.1
            @Override // io.rong.imkit.utilities.PromptPopupDialog.OnPromptButtonClickedListener
            public void onPositiveButtonClicked() {
                RealTimeLocationMessageProvider.this.joinMap(view, uIMessage);
            }
        });
        promptPopupDialogNewInstance.show();
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemLongClick(View view, int i, RealTimeLocationStartMessage realTimeLocationStartMessage, UIMessage uIMessage) {
        super.onItemLongClick(view, i, realTimeLocationStartMessage, uIMessage);
        ((ViewHolder) view.getTag()).longClick = true;
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text instanceof Spannable) {
                Selection.removeSelection((Spannable) text);
            }
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, RealTimeLocationStartMessage realTimeLocationStartMessage) {
        if (realTimeLocationStartMessage == null || realTimeLocationStartMessage.getContent() == null) {
            return null;
        }
        return new SpannableString(context.getResources().getString(R.string.rc_real_time_location_start));
    }
}
