package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;

/* JADX INFO: renamed from: androidx.appcompat.app.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AlertController.java */
/* JADX INFO: loaded from: classes.dex */
class C0287g extends CursorAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AlertController f301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ AlertController.a f302e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0287g(AlertController.a aVar, Context context, Cursor cursor, boolean z, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, z);
        this.f302e = aVar;
        this.f300c = recycleListView;
        this.f301d = alertController;
        Cursor cursor2 = getCursor();
        this.f298a = cursor2.getColumnIndexOrThrow(this.f302e.L);
        this.f299b = cursor2.getColumnIndexOrThrow(this.f302e.M);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f298a));
        this.f300c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f299b) == 1);
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f302e.f206b.inflate(this.f301d.M, viewGroup, false);
    }
}
