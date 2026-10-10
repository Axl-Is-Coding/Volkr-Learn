package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.FollowFriendBottomDialog;
import com.sandboxol.greendao.entity.FriendFollowResponse;
import java.util.List;

/* JADX INFO: compiled from: PageFollowFriendUserAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class S extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<FriendFollowResponse> f11790b;

    /* JADX INFO: compiled from: PageFollowFriendUserAdapter.java */
    public class a extends RecyclerView.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ImageView f11791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ImageView f11792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImageView f11793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ImageView f11794d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private TextView f11795e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private TextView f11796f;
        private View g;
        private RelativeLayout h;
        private LinearLayout i;

        public a(View view) {
            super(view);
            this.h = (RelativeLayout) view.findViewById(R.id.rl_header);
            this.f11791a = (ImageView) view.findViewById(R.id.iv_header);
            this.f11794d = (ImageView) view.findViewById(R.id.iv_background);
            this.f11793c = (ImageView) view.findViewById(R.id.iv_add);
            this.f11792b = (ImageView) view.findViewById(R.id.iv_online);
            this.g = view.findViewById(R.id.v_online);
            this.f11795e = (TextView) view.findViewById(R.id.tv_nickname);
            this.f11796f = (TextView) view.findViewById(R.id.tv_game_name);
            this.i = (LinearLayout) view.findViewById(R.id.ll_game_name);
        }
    }

    public S(Context context, List<FriendFollowResponse> list) {
        this.f11789a = context;
        this.f11790b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, final int i) {
        List<FriendFollowResponse> list = this.f11790b;
        if (list == null || list.size() == 0 || this.f11790b.size() <= i || this.f11790b.get(i) == null) {
            return;
        }
        if (this.f11790b.get(i).getStatus() == 0) {
            if (!TextUtils.isEmpty(this.f11790b.get(i).getNickName())) {
                aVar.f11795e.setText(this.f11790b.get(i).getNickName());
            }
            aVar.f11794d.setAlpha(0.3f);
            aVar.f11793c.setVisibility(0);
            aVar.f11793c.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.main.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f11827a.a(view);
                }
            });
            aVar.h.setVisibility(4);
            aVar.f11791a.setVisibility(8);
            aVar.f11792b.setVisibility(8);
            aVar.g.setVisibility(8);
            aVar.i.setVisibility(8);
            return;
        }
        aVar.f11793c.setVisibility(8);
        aVar.h.setVisibility(0);
        aVar.f11791a.setVisibility(0);
        aVar.f11792b.setVisibility(0);
        aVar.g.setVisibility(0);
        aVar.i.setVisibility(0);
        aVar.f11794d.setAlpha(1.0f);
        if (TextUtils.isEmpty(this.f11790b.get(i).getPicUrl())) {
            aVar.f11791a.setImageDrawable(androidx.core.content.b.c(this.f11789a, R.mipmap.ic_head_default));
        } else {
            try {
                com.bumptech.glide.c.c(this.f11789a).mo55load(this.f11790b.get(i).getPicUrl()).into(aVar.f11791a);
            } catch (Exception unused) {
                aVar.f11791a.setImageDrawable(androidx.core.content.b.c(this.f11789a, R.mipmap.ic_head_default));
            }
        }
        aVar.g.setEnabled(this.f11790b.get(i).getStatus() != 30);
        aVar.f11792b.setVisibility(this.f11790b.get(i).getStatus() != 30 ? 0 : 8);
        if (!TextUtils.isEmpty(this.f11790b.get(i).getNickName())) {
            aVar.f11795e.setText(this.f11790b.get(i).getNickName());
        }
        if (TextUtils.isEmpty(this.f11790b.get(i).getGameName())) {
            aVar.i.setVisibility(8);
        } else {
            aVar.f11796f.setText(this.f11790b.get(i).getGameName());
            aVar.i.setVisibility(0);
        }
        aVar.f11791a.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.main.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11828a.a(i, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.f11790b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.f11789a).inflate(R.layout.item_follow_friend_header_view, (ViewGroup) null));
    }

    public /* synthetic */ void a(int i, View view) {
        if (this.f11790b.get(i) == null || this.f11790b.get(i).getFriendId() == 0) {
            return;
        }
        new FollowFriendBottomDialog(this.f11789a, this.f11790b.get(i)).show();
        com.disabngo.blockynexus.d.n.i(this.f11789a);
    }

    public /* synthetic */ void a(View view) {
        com.disabngo.blockynexus.d.D.e(this.f11789a);
        com.disabngo.blockynexus.d.n.a(this.f11789a);
    }

    public void a(List<FriendFollowResponse> list) {
        this.f11790b = list;
        notifyDataSetChanged();
    }
}
