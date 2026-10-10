package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SearchManager f595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SearchView f596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SearchableInfo f597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f600f;
    private boolean g;
    private int h;
    private ColorStateList i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f604d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f605e;

        public a(View view) {
            this.f601a = (TextView) view.findViewById(R.id.text1);
            this.f602b = (TextView) view.findViewById(R.id.text2);
            this.f603c = (ImageView) view.findViewById(R.id.icon1);
            this.f604d = (ImageView) view.findViewById(R.id.icon2);
            this.f605e = (ImageView) view.findViewById(androidx.appcompat.R.id.edit_query);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.g = false;
        this.h = 1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.f595a = (SearchManager) this.mContext.getSystemService("search");
        this.f596b = searchView;
        this.f597c = searchableInfo;
        this.f600f = searchView.getSuggestionCommitIconResId();
        this.f598d = context;
        this.f599e = weakHashMap;
    }

    private Drawable b(Cursor cursor) {
        int i = this.m;
        if (i == -1) {
            return null;
        }
        Drawable drawableB = b(cursor.getString(i));
        return drawableB != null ? drawableB : a(cursor);
    }

    private Drawable c(Cursor cursor) {
        int i = this.n;
        if (i == -1) {
            return null;
        }
        return b(cursor.getString(i));
    }

    private void d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    public void a(int i) {
        this.h = i;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i = this.o;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (aVar.f601a != null) {
            a(aVar.f601a, a(cursor, this.j));
        }
        if (aVar.f602b != null) {
            String strA = a(cursor, this.l);
            CharSequence charSequenceA = strA != null ? a((CharSequence) strA) : a(cursor, this.k);
            if (TextUtils.isEmpty(charSequenceA)) {
                TextView textView = aVar.f601a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f601a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f601a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f601a.setMaxLines(1);
                }
            }
            a(aVar.f602b, charSequenceA);
        }
        ImageView imageView = aVar.f603c;
        if (imageView != null) {
            a(imageView, b(cursor), 4);
        }
        ImageView imageView2 = aVar.f604d;
        if (imageView2 != null) {
            a(imageView2, c(cursor), 8);
        }
        int i3 = this.h;
        if (i3 != 2 && (i3 != 1 || (i2 & 1) == 0)) {
            aVar.f605e.setVisibility(8);
            return;
        }
        aVar.f605e.setVisibility(0);
        aVar.f605e.setTag(aVar.f601a.getText());
        aVar.f605e.setOnClickListener(this);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.a.InterfaceC0020a
    public void changeCursor(Cursor cursor) {
        if (this.g) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.j = cursor.getColumnIndex("suggest_text_1");
                this.k = cursor.getColumnIndex("suggest_text_2");
                this.l = cursor.getColumnIndex("suggest_text_2_url");
                this.m = cursor.getColumnIndex("suggest_icon_1");
                this.n = cursor.getColumnIndex("suggest_icon_2");
                this.o = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.a.InterfaceC0020a
    public CharSequence convertToString(Cursor cursor) {
        String strA;
        String strA2;
        if (cursor == null) {
            return null;
        }
        String strA3 = a(cursor, "suggest_intent_query");
        if (strA3 != null) {
            return strA3;
        }
        if (this.f597c.shouldRewriteQueryFromData() && (strA2 = a(cursor, "suggest_intent_data")) != null) {
            return strA2;
        }
        if (!this.f597c.shouldRewriteQueryFromText() || (strA = a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strA;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View viewNewDropDownView = newDropDownView(this.mContext, this.mCursor, viewGroup);
            if (viewNewDropDownView != null) {
                ((a) viewNewDropDownView.getTag()).f601a.setText(e2.toString());
            }
            return viewNewDropDownView;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View viewNewView = newView(this.mContext, this.mCursor, viewGroup);
            if (viewNewView != null) {
                ((a) viewNewView.getTag()).f601a.setText(e2.toString());
            }
            return viewNewView;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewNewView = super.newView(context, cursor, viewGroup);
        viewNewView.setTag(new a(viewNewView));
        ((ImageView) viewNewView.findViewById(androidx.appcompat.R.id.edit_query)).setImageResource(this.f600f);
        return viewNewView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        d(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        d(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f596b.onQueryRefine((CharSequence) tag);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.a.InterfaceC0020a
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f596b.getVisibility() == 0 && this.f596b.getWindowVisibility() == 0) {
            try {
                Cursor cursorA = a(this.f597c, string, 50);
                if (cursorA != null) {
                    cursorA.getCount();
                    return cursorA;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    private CharSequence a(CharSequence charSequence) {
        if (this.i == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(androidx.appcompat.R.attr.textColorSearchUrl, typedValue, true);
            this.i = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.i, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable b(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f598d.getPackageName() + "/" + i;
            Drawable drawableA = a(str2);
            if (drawableA != null) {
                return drawableA;
            }
            Drawable drawableC = androidx.core.content.b.c(this.f598d, i);
            a(str2, drawableC);
            return drawableC;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableA2 = a(str);
            if (drawableA2 != null) {
                return drawableA2;
            }
            Drawable drawableB = b(Uri.parse(str));
            a(str, drawableB);
            return drawableB;
        }
    }

    private void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private Drawable b(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return a(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f598d.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                try {
                    return Drawable.createFromStream(inputStreamOpenInputStream, null);
                } finally {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e2) {
                        Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                    }
                }
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    private Drawable a(String str) {
        Drawable.ConstantState constantState = this.f599e.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f599e.put(str, drawable.getConstantState());
        }
    }

    private Drawable a(Cursor cursor) {
        Drawable drawableB = b(this.f597c.getSearchActivity());
        return drawableB != null ? drawableB : this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable a(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    private Drawable b(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (this.f599e.containsKey(strFlattenToShortString)) {
            Drawable.ConstantState constantState = this.f599e.get(strFlattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.f598d.getResources());
        }
        Drawable drawableA = a(componentName);
        this.f599e.put(strFlattenToShortString, drawableA != null ? drawableA.getConstantState() : null);
        return drawableA;
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static String a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    Drawable a(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            identifier = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (identifier != 0) {
                        return resourcesForApplication.getDrawable(identifier);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    Cursor a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.mContext.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }
}
