package com.sandboxol.videosubmit.view.activity;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.databinding.VideosubmitItemWinnerBinding;
import com.sandboxol.videosubmit.entity.Winner;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class WinnersAdapter extends RecyclerView.a<WinnerViewHolder> {
    private List<Winner> winners;

    protected static class WinnerViewHolder extends RecyclerView.w {
        public WinnerViewHolder(VideosubmitItemWinnerBinding videosubmitItemWinnerBinding) {
            super(videosubmitItemWinnerBinding.getRoot());
        }
    }

    public WinnersAdapter(List<Winner> list) {
        this.winners = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        List<Winner> list = this.winners;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(WinnerViewHolder winnerViewHolder, int i) {
        VideosubmitItemWinnerBinding videosubmitItemWinnerBinding = (VideosubmitItemWinnerBinding) androidx.databinding.e.a(winnerViewHolder.itemView);
        if (videosubmitItemWinnerBinding != null) {
            videosubmitItemWinnerBinding.setWinner(this.winners.get(i));
            videosubmitItemWinnerBinding.executePendingBindings();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public WinnerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new WinnerViewHolder((VideosubmitItemWinnerBinding) androidx.databinding.e.a(LayoutInflater.from(viewGroup.getContext()), R.layout.videosubmit_item_winner, viewGroup, false));
    }
}
