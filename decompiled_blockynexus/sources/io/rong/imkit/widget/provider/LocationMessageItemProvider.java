package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.plugin.location.AMapPreviewActivity;
import io.rong.imkit.plugin.location.AMapPreviewActivity2D;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Message;
import io.rong.message.LocationMessage;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = LocationMessage.class, showReadState = true)
public class LocationMessageItemProvider extends IContainerItemProvider.MessageProvider<LocationMessage> {
    private static final String TAG = "LocationMessageItemProvider";

    private static class ViewHolder {
        AsyncImageView img;
        FrameLayout mLayout;
        TextView title;

        private ViewHolder() {
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(LocationMessage locationMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_location_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.img = (AsyncImageView) viewInflate.findViewById(R.id.rc_img);
        viewHolder.title = (TextView) viewInflate.findViewById(R.id.rc_content);
        viewHolder.mLayout = (FrameLayout) viewInflate.findViewById(R.id.rc_layout);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, LocationMessage locationMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        Uri imgUri = locationMessage.getImgUri();
        RLog.d(TAG, "uri = " + imgUri);
        if (imgUri == null || !LibStorageUtils.FILE.equals(imgUri.getScheme())) {
            viewHolder.img.setDefaultDrawable();
        } else {
            viewHolder.img.setResource(imgUri);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewHolder.title.getLayoutParams().width, -2);
        layoutParams.gravity = 80;
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.mLayout.setBackgroundResource(R.drawable.rc_ic_bubble_no_right);
            layoutParams.leftMargin = 0;
            double d2 = view.getResources().getDisplayMetrics().density;
            Double.isNaN(d2);
            layoutParams.rightMargin = (int) (d2 * 3.5d);
            viewHolder.title.setLayoutParams(layoutParams);
        } else {
            layoutParams.leftMargin = (int) (view.getResources().getDisplayMetrics().density * 6.0f);
            layoutParams.rightMargin = 0;
            viewHolder.title.setLayoutParams(layoutParams);
            viewHolder.mLayout.setBackgroundResource(R.drawable.rc_ic_bubble_no_left);
        }
        viewHolder.title.setText(locationMessage.getPoi());
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, LocationMessage locationMessage, UIMessage uIMessage) {
        try {
            Class.forName("com.amap.api.netlocation.AMapNetworkLocationClient");
            Intent intent = view.getContext().getResources().getBoolean(R.bool.rc_location_2D) ? new Intent(view.getContext(), (Class<?>) AMapPreviewActivity2D.class) : new Intent(view.getContext(), (Class<?>) AMapPreviewActivity.class);
            intent.putExtra("location", uIMessage.getContent());
            intent.setFlags(268435456);
            view.getContext().startActivity(intent);
        } catch (Exception e2) {
            RLog.i(TAG, "Not default AMap Location");
            RLog.e(TAG, "onItemClick", e2);
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, LocationMessage locationMessage) {
        return new SpannableString(context.getResources().getString(R.string.rc_message_content_location));
    }
}
