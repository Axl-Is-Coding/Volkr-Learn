package com.sandboxol.imchat.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.bumptech.glide.request.f;
import com.sandboxol.imchat.R;
import java.util.ArrayList;
import me.iwf.photopicker.f;
import me.iwf.photopicker.utils.a;

/* JADX INFO: loaded from: classes4.dex */
public class GroupNoticeAdapter extends RecyclerView.a<ViewHolder> {
    private Context context;
    private ArrayList<String> pics;

    protected class ViewHolder extends RecyclerView.w {
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.image);
        }
    }

    public GroupNoticeAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.pics = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.pics.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        ArrayList<String> arrayList = this.pics;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (a.a(viewHolder.imageView.getContext())) {
            f fVar = new f();
            fVar.centerCrop();
            try {
                c.c(this.context).mo55load(this.pics.get(i)).apply((com.bumptech.glide.request.a<?>) fVar).thumbnail(0.1f).into(viewHolder.imageView);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.adapter.GroupNoticeAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.a aVarA = me.iwf.photopicker.f.a();
                aVarA.a(GroupNoticeAdapter.this.pics);
                aVarA.a(i);
                aVarA.a(false);
                aVarA.a((Activity) GroupNoticeAdapter.this.context);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_notice, (ViewGroup) null));
    }
}
