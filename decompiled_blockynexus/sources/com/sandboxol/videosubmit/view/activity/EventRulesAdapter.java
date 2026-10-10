package com.sandboxol.videosubmit.view.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.databinding.VideosubmitItemEventRuleBinding;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class EventRulesAdapter extends RecyclerView.a<EventRulesViewHolder> {
    private Context context;
    private List<String> eventRules;

    protected static class EventRulesViewHolder extends RecyclerView.w {
        public EventRulesViewHolder(VideosubmitItemEventRuleBinding videosubmitItemEventRuleBinding) {
            super(videosubmitItemEventRuleBinding.getRoot());
        }
    }

    public EventRulesAdapter(Context context, List<String> list) {
        this.context = context;
        this.eventRules = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        List<String> list = this.eventRules;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(EventRulesViewHolder eventRulesViewHolder, int i) {
        VideosubmitItemEventRuleBinding videosubmitItemEventRuleBinding = (VideosubmitItemEventRuleBinding) androidx.databinding.e.a(eventRulesViewHolder.itemView);
        if (videosubmitItemEventRuleBinding != null) {
            videosubmitItemEventRuleBinding.setRule(this.eventRules.get(i));
            int i2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? 0 : R.mipmap.videosubmit_ic_rules_5 : R.mipmap.videosubmit_ic_rules_4 : R.mipmap.videosubmit_ic_rules_3 : R.mipmap.videosubmit_ic_rules_2 : R.mipmap.videosubmit_ic_rules_1;
            if (i2 != 0) {
                videosubmitItemEventRuleBinding.setDrawableStart(this.context.getResources().getDrawable(i2));
            }
            videosubmitItemEventRuleBinding.executePendingBindings();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public EventRulesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new EventRulesViewHolder((VideosubmitItemEventRuleBinding) androidx.databinding.e.a(LayoutInflater.from(viewGroup.getContext()), R.layout.videosubmit_item_event_rule, viewGroup, false));
    }
}
