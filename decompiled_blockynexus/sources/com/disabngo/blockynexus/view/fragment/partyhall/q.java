package com.disabngo.blockynexus.view.fragment.partyhall;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMember;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: compiled from: PartyHallHeaderListAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<TeamMember> f11933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PartyItem f11934c;

    /* JADX INFO: compiled from: PartyHallHeaderListAdapter.java */
    public class a extends RecyclerView.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ImageView f11935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ImageView f11936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f11937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private View f11938d;

        public a(View view) {
            super(view);
            this.f11935a = (ImageView) view.findViewById(R.id.iv_header);
            this.f11936b = (ImageView) view.findViewById(R.id.iv_sex);
            this.f11938d = view.findViewById(R.id.v_captain);
            this.f11937c = (TextView) view.findViewById(R.id.tv_nickname);
        }
    }

    public q(Context context, PartyItem partyItem) {
        this.f11932a = context;
        this.f11934c = partyItem;
        this.f11933b = partyItem.getTeamMembersList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.f11934c.getMax();
    }

    public void a(PartyItem partyItem) {
        this.f11934c = partyItem;
        this.f11933b = partyItem.getTeamMembersList();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.f11932a).inflate(R.layout.item_party_hall_header, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, final int i) {
        Context context;
        int i2;
        List<TeamMember> list = this.f11933b;
        if (list == null || list.size() == 0 || this.f11933b.size() <= i || this.f11933b.get(i) == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f11933b.get(i).getPicurl())) {
            try {
                com.bumptech.glide.c.c(this.f11932a).mo55load(this.f11933b.get(i).getPicurl()).into(aVar.f11935a);
            } catch (Exception unused) {
                aVar.f11935a.setImageDrawable(androidx.core.content.b.c(this.f11932a, R.mipmap.ic_head_default));
            }
        } else {
            aVar.f11935a.setImageDrawable(androidx.core.content.b.c(this.f11932a, R.mipmap.ic_head_default));
        }
        ImageView imageView = aVar.f11936b;
        if (this.f11933b.get(i).getSex() == 1) {
            context = this.f11932a;
            i2 = R.mipmap.ic_male;
        } else {
            context = this.f11932a;
            i2 = R.mipmap.ic_female;
        }
        imageView.setImageDrawable(androidx.core.content.b.c(context, i2));
        aVar.f11937c.setGravity(17);
        if (this.f11933b.get(i).getUsername() != null) {
            aVar.f11937c.setText(this.f11933b.get(i).getUsername());
            aVar.f11938d.setVisibility(TextUtils.equals(this.f11933b.get(i).getUsername(), this.f11934c.getCaptainName()) ? 0 : 8);
        }
        aVar.f11935a.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.PartyHallHeaderListAdapter$1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (((TeamMember) this.f11903b.f11933b.get(i)).getUserid() != AccountCenter.newInstance().userId.get().longValue()) {
                    J.a(this.f11903b.f11932a, (Friend) null, new FriendActivityIntentInfo(((TeamMember) this.f11903b.f11933b.get(i)).getUserid(), 2));
                }
            }
        });
    }
}
