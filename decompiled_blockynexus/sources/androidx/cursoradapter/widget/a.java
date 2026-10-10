package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: compiled from: CursorFilter.java */
/* JADX INFO: loaded from: classes.dex */
class a extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    InterfaceC0020a f1309a;

    /* JADX INFO: renamed from: androidx.cursoradapter.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CursorFilter.java */
    interface InterfaceC0020a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    a(InterfaceC0020a interfaceC0020a) {
        this.f1309a = interfaceC0020a;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f1309a.convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorRunQueryOnBackgroundThread = this.f1309a.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorRunQueryOnBackgroundThread != null) {
            filterResults.count = cursorRunQueryOnBackgroundThread.getCount();
            filterResults.values = cursorRunQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.f1309a.getCursor();
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        this.f1309a.changeCursor((Cursor) obj);
    }
}
