package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.message.PublicServiceMultiRichContentMessage;
import io.rong.message.RichContentItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(centerInHorizontal = true, messageContent = PublicServiceMultiRichContentMessage.class, showPortrait = false, showSummaryWithName = false)
public class PublicServiceMultiRichContentMessageProvider extends IContainerItemProvider.MessageProvider<PublicServiceMultiRichContentMessage> {

    private static class PublicAccountMsgAdapter extends BaseAdapter {
        LayoutInflater inflater;
        int itemCount;
        ArrayList<RichContentItem> itemList = new ArrayList<>();

        public PublicAccountMsgAdapter(Context context, ArrayList<RichContentItem> arrayList) {
            this.inflater = LayoutInflater.from(context);
            this.itemList.addAll(arrayList);
            this.itemCount = arrayList.size() - 1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.itemCount;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate = this.inflater.inflate(R.layout.rc_item_public_service_message, viewGroup, false);
            AsyncImageView asyncImageView = (AsyncImageView) viewInflate.findViewById(R.id.rc_img);
            TextView textView = (TextView) viewInflate.findViewById(R.id.rc_txt);
            View viewFindViewById = viewInflate.findViewById(R.id.rc_divider);
            if (this.itemList.size() == 0) {
                return null;
            }
            int i2 = i + 1;
            String title = this.itemList.get(i2).getTitle();
            if (title != null) {
                textView.setText(title);
            }
            asyncImageView.setResource(this.itemList.get(i2).getImageUrl(), 0);
            if (i == getCount() - 1) {
                viewFindViewById.setVisibility(8);
            } else {
                viewFindViewById.setVisibility(0);
            }
            return viewInflate;
        }

        @Override // android.widget.Adapter
        public RichContentItem getItem(int i) {
            if (this.itemList.size() == 0) {
                return null;
            }
            return this.itemList.get(i + 1);
        }
    }

    protected static class ViewHolder {
        public View divider;
        public int height;
        public AsyncImageView iv;
        public ListView lv;
        public TextView tv;

        protected ViewHolder() {
        }
    }

    private int getListViewHeight(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        int i = 0;
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            i += adapter.getView(i2, null, listView).getLayoutParams().height;
        }
        return i;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(PublicServiceMultiRichContentMessage publicServiceMultiRichContentMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_public_service_multi_rich_content_message, (ViewGroup) null);
        viewHolder.lv = (ListView) viewInflate.findViewById(R.id.rc_list);
        viewHolder.iv = (AsyncImageView) viewInflate.findViewById(R.id.rc_img);
        viewHolder.tv = (TextView) viewInflate.findViewById(R.id.rc_txt);
        viewInflate.measure(0, 0);
        viewHolder.height = viewInflate.getMeasuredHeight();
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(final View view, int i, PublicServiceMultiRichContentMessage publicServiceMultiRichContentMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        final ArrayList<RichContentItem> messages = publicServiceMultiRichContentMessage.getMessages();
        if (messages.size() > 0) {
            viewHolder.tv.setText(messages.get(0).getTitle());
            viewHolder.iv.setResource(messages.get(0).getImageUrl(), 0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        viewHolder.lv.setAdapter((ListAdapter) new PublicAccountMsgAdapter(view.getContext(), messages));
        viewHolder.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.widget.provider.PublicServiceMultiRichContentMessageProvider.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j) {
                String url = ((RichContentItem) messages.get(i2 + 1)).getUrl();
                Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_WEBVIEW);
                intent.setPackage(view.getContext().getPackageName());
                intent.putExtra("url", url);
                view.getContext().startActivity(intent);
            }
        });
        layoutParams.height = getListViewHeight(viewHolder.lv) + viewHolder.height;
        layoutParams.width = RongUtils.getScreenWidth() - RongUtils.dip2px(32.0f);
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, PublicServiceMultiRichContentMessage publicServiceMultiRichContentMessage, UIMessage uIMessage) {
        if (publicServiceMultiRichContentMessage.getMessages().size() == 0) {
            return;
        }
        String url = publicServiceMultiRichContentMessage.getMessages().get(0).getUrl();
        Context context = view.getContext();
        Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_WEBVIEW);
        intent.setPackage(context.getPackageName());
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, PublicServiceMultiRichContentMessage publicServiceMultiRichContentMessage) {
        if (publicServiceMultiRichContentMessage.getMessages().size() > 0) {
            return new SpannableString(publicServiceMultiRichContentMessage.getMessages().get(0).getTitle());
        }
        return null;
    }
}
