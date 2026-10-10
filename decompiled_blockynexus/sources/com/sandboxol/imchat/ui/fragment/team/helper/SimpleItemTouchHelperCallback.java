package com.sandboxol.imchat.ui.fragment.team.helper;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleItemTouchHelperCallback extends ItemTouchHelper.a {
    public static final float ALPHA_FULL = 1.0f;
    private final ItemTouchHelperAdapter mAdapter;
    private RecyclerView recyclerView;
    private int sourcePosition;
    private int targetPosition;

    public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter itemTouchHelperAdapter) {
        this.mAdapter = itemTouchHelperAdapter;
    }

    private void cleatItemModify(View view, View view2) {
        if (view != null) {
            view.findViewById(R.id.ivHead).setAlpha(1.0f);
            view.findViewById(R.id.ivHead).setScaleX(1.0f);
            view.findViewById(R.id.ivHead).setScaleY(1.0f);
        }
        if (view2 != null) {
            view2.findViewById(R.id.ivHead).setAlpha(1.0f);
            view2.findViewById(R.id.ivHead).setScaleX(1.0f);
            view2.findViewById(R.id.ivHead).setScaleY(1.0f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.a
    public void clearView(RecyclerView recyclerView, RecyclerView.w wVar) {
        super.clearView(recyclerView, wVar);
        if (wVar instanceof ItemTouchHelperViewHolder) {
            ((ItemTouchHelperViewHolder) wVar).onItemClear();
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.a
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.w wVar) {
        this.recyclerView = recyclerView;
        return recyclerView.getLayoutManager() instanceof GridLayoutManager ? ItemTouchHelper.a.makeMovementFlags(15, 0) : ItemTouchHelper.a.makeMovementFlags(3, 48);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.a
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.a
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.a
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, float f2, float f3, int i, boolean z) {
        if (i == 1) {
            wVar.itemView.setAlpha(1.0f - (Math.abs(f2) / wVar.itemView.getWidth()));
            wVar.itemView.setTranslationX(f2);
        } else {
            if (Math.abs(f2) < wVar.itemView.getWidth() / 2 && Math.abs(f3) < wVar.itemView.getHeight() / 2) {
                cleatItemModify(recyclerView.getChildAt(this.sourcePosition), recyclerView.getChildAt(this.targetPosition));
                this.targetPosition = 0;
                this.sourcePosition = 0;
            }
            super.onChildDraw(canvas, recyclerView, wVar, f2, f3, i, z);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.a
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, float f2, float f3, int i, boolean z) {
        super.onChildDrawOver(canvas, recyclerView, wVar, f2, f3, i, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.a
    public boolean onMove(RecyclerView recyclerView, RecyclerView.w wVar, RecyclerView.w wVar2) {
        if (wVar.getItemViewType() != wVar2.getItemViewType()) {
            return false;
        }
        if (wVar2.getAdapterPosition() != this.targetPosition) {
            wVar2.itemView.findViewById(R.id.ivHead).setAlpha(0.5f);
            wVar2.itemView.findViewById(R.id.ivHead).setScaleX(1.3f);
            wVar2.itemView.findViewById(R.id.ivHead).setScaleY(1.3f);
            if (recyclerView.getChildAt(this.targetPosition) != null) {
                recyclerView.getChildAt(this.targetPosition).findViewById(R.id.ivHead).setAlpha(1.0f);
                recyclerView.getChildAt(this.targetPosition).findViewById(R.id.ivHead).setScaleX(1.0f);
                recyclerView.getChildAt(this.targetPosition).findViewById(R.id.ivHead).setScaleY(1.0f);
            }
        }
        this.sourcePosition = wVar.getAdapterPosition();
        this.targetPosition = wVar2.getAdapterPosition();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.a
    public void onSelectedChanged(RecyclerView.w wVar, int i) {
        if (i == 2) {
            wVar.itemView.findViewById(R.id.ivHead).setAlpha(0.7f);
            wVar.itemView.findViewById(R.id.ivHead).setScaleX(1.1f);
            wVar.itemView.findViewById(R.id.ivHead).setScaleY(1.1f);
        } else if (i == 0) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                cleatItemModify(recyclerView.getChildAt(this.sourcePosition), this.recyclerView.getChildAt(this.targetPosition));
                this.mAdapter.onItemMove(this.sourcePosition, this.targetPosition);
                this.targetPosition = 0;
                this.sourcePosition = 0;
            }
        } else if (wVar instanceof ItemTouchHelperViewHolder) {
            ((ItemTouchHelperViewHolder) wVar).onItemSelected();
        }
        super.onSelectedChanged(wVar, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.a
    public void onSwiped(RecyclerView.w wVar, int i) {
        this.mAdapter.onItemDismiss(wVar.getAdapterPosition());
    }
}
