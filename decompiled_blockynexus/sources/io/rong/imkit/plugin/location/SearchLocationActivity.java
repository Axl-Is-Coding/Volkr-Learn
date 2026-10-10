package io.rong.imkit.plugin.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import io.rong.imkit.R;
import io.rong.imkit.plugin.LocationConst;
import io.rong.imkit.utilities.LangUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SearchLocationActivity extends Activity {
    private String filterString;
    private EditText mSearchEditText;
    private SearchListAdapter searchListAdapter;
    private ListView searchListView;
    private TextView searchNoResult;
    private final int PAGE_COUNT = 20;
    private int currentPage = 1;
    private String cityCode = "";
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: io.rong.imkit.plugin.location.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 || i + i2 != i3 || (childAt = SearchLocationActivity.this.searchListView.getChildAt(SearchLocationActivity.this.searchListView.getChildCount() - 1)) == null || childAt.getBottom() != SearchLocationActivity.this.searchListView.getHeight()) {
                return;
            }
            SearchLocationActivity searchLocationActivity = SearchLocationActivity.this;
            searchLocationActivity.searchNextPageByKeyword(searchLocationActivity.filterString);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    };

    private class SearchListAdapter extends BaseAdapter {
        private Context context;
        private String keyword;
        private List<SearchLocationInfo> searchList;

        class SearchViewHolder {
            TextView tvAddress;
            TextView tvName;

            SearchViewHolder() {
            }
        }

        public SearchListAdapter(Context context, List<SearchLocationInfo> list, String str) {
            this.searchList = new ArrayList();
            this.context = context;
            this.searchList = list;
            this.keyword = str;
        }

        public void addItems(List<SearchLocationInfo> list) {
            List<SearchLocationInfo> list2 = this.searchList;
            if (list2 != null) {
                list2.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (TextUtils.isEmpty(SearchLocationActivity.this.filterString)) {
                return 0;
            }
            return this.searchList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            List<SearchLocationInfo> list = this.searchList;
            if (list == null || list.size() <= 0) {
                return null;
            }
            return this.searchList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            SearchViewHolder searchViewHolder;
            SearchLocationInfo searchLocationInfo = this.searchList.get(i);
            if (view == null) {
                searchViewHolder = new SearchViewHolder();
                viewInflate = View.inflate(this.context, R.layout.rc_location_search_item, null);
                searchViewHolder.tvName = (TextView) viewInflate.findViewById(R.id.rc_search_name);
                searchViewHolder.tvAddress = (TextView) viewInflate.findViewById(R.id.rc_search_address);
                viewInflate.setTag(searchViewHolder);
            } else {
                viewInflate = view;
                searchViewHolder = (SearchViewHolder) view.getTag();
            }
            SearchLocationActivity.this.setLocationTitle(searchViewHolder.tvName, searchLocationInfo.getName(), this.keyword);
            SearchLocationActivity.this.setLocationAddress(searchViewHolder.tvAddress, searchLocationInfo.getAddress(), this.keyword);
            return viewInflate;
        }
    }

    private class SearchLocationInfo {
        String address;
        double latitude;
        double longitude;
        String name;
        String poi;

        public SearchLocationInfo(String str, String str2) {
            this.name = str;
            this.address = str2;
        }

        public String getAddress() {
            return this.address;
        }

        public double getLatitude() {
            return this.latitude;
        }

        public double getLongitude() {
            return this.longitude;
        }

        public String getName() {
            return this.name;
        }

        public String getPoi() {
            return this.poi;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setLatitude(double d2) {
            this.latitude = d2;
        }

        public void setLongitude(double d2) {
            this.longitude = d2;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPoi(String str) {
            this.poi = str;
        }
    }

    private void initView() {
        this.mSearchEditText = (EditText) findViewById(R.id.rc_et_search);
        ImageView imageView = (ImageView) findViewById(R.id.rc_iv_press_back);
        this.searchListView = (ListView) findViewById(R.id.rc_filtered_location_list);
        this.searchNoResult = (TextView) findViewById(R.id.rc_tv_search_no_results);
        this.mSearchEditText.addTextChangedListener(new TextWatcher() { // from class: io.rong.imkit.plugin.location.SearchLocationActivity.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                SearchLocationActivity.this.filterString = editable.toString();
                SearchLocationActivity searchLocationActivity = SearchLocationActivity.this;
                searchLocationActivity.searchLocationByKeyword(searchLocationActivity.filterString);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mSearchEditText.setOnTouchListener(new View.OnTouchListener() { // from class: io.rong.imkit.plugin.location.SearchLocationActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1 || motionEvent.getRawX() < SearchLocationActivity.this.mSearchEditText.getRight() - (SearchLocationActivity.this.mSearchEditText.getCompoundDrawables()[2].getBounds().width() * 2)) {
                    return false;
                }
                SearchLocationActivity.this.mSearchEditText.setText("");
                SearchLocationActivity.this.mSearchEditText.clearFocus();
                return true;
            }
        });
        this.searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.plugin.location.SearchLocationActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SearchLocationInfo searchLocationInfo = (SearchLocationInfo) SearchLocationActivity.this.searchListAdapter.getItem(i);
                Intent intent = new Intent();
                intent.putExtra(LocationConst.LONGITUDE, searchLocationInfo.getLongitude());
                intent.putExtra(LocationConst.LATITUDE, searchLocationInfo.getLatitude());
                intent.putExtra(LocationConst.POI, searchLocationInfo.getPoi());
                SearchLocationActivity.this.setResult(-1, intent);
                SearchLocationActivity.this.finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.location.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchLocationActivity.this.finish();
            }
        });
        this.searchListView.setOnScrollListener(this.onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchLocationByKeyword(final String str) {
        String str2 = this.cityCode;
        if (TextUtils.isEmpty(str2)) {
            str2 = LocationConst.DEFAULT_CITY_CODE;
        }
        PoiSearch.Query query = new PoiSearch.Query(str, "", str2);
        query.setPageSize(20);
        this.currentPage = 1;
        query.setPageNum(this.currentPage);
        PoiSearch poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() { // from class: io.rong.imkit.plugin.location.SearchLocationActivity.6
            public void onPoiItemSearched(PoiItem poiItem, int i) {
            }

            public void onPoiSearched(PoiResult poiResult, int i) {
                if (poiResult == null || poiResult.getPois().size() <= 0) {
                    if (SearchLocationActivity.this.filterString.equals("")) {
                        SearchLocationActivity.this.searchNoResult.setVisibility(8);
                    } else {
                        SearchLocationActivity.this.searchNoResult.setVisibility(0);
                        SearchLocationActivity.this.searchNoResult.setText(SearchLocationActivity.this.getResources().getString(R.string.rc_ext_search_no_result));
                    }
                    SearchLocationActivity.this.searchListView.setVisibility(8);
                    return;
                }
                ArrayList pois = poiResult.getPois();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < pois.size(); i2++) {
                    PoiItem poiItem = (PoiItem) pois.get(i2);
                    SearchLocationInfo searchLocationInfo = SearchLocationActivity.this.new SearchLocationInfo(poiItem.getTitle(), poiItem.getSnippet());
                    searchLocationInfo.setLongitude(poiItem.getLatLonPoint().getLongitude());
                    searchLocationInfo.setLatitude(poiItem.getLatLonPoint().getLatitude());
                    searchLocationInfo.setPoi(poiItem.getTitle());
                    arrayList.add(searchLocationInfo);
                }
                SearchLocationActivity.this.searchNoResult.setVisibility(8);
                SearchLocationActivity.this.searchListView.setVisibility(0);
                SearchLocationActivity searchLocationActivity = SearchLocationActivity.this;
                searchLocationActivity.searchListAdapter = searchLocationActivity.new SearchListAdapter(searchLocationActivity, arrayList, str);
                SearchLocationActivity.this.searchListView.setAdapter((ListAdapter) SearchLocationActivity.this.searchListAdapter);
            }
        });
        poiSearch.searchPOIAsyn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchNextPageByKeyword(String str) {
        String str2 = this.cityCode;
        if (TextUtils.isEmpty(str2)) {
            str2 = LocationConst.DEFAULT_CITY_CODE;
        }
        PoiSearch.Query query = new PoiSearch.Query(str, "", str2);
        query.setPageSize(20);
        int i = this.currentPage + 1;
        this.currentPage = i;
        query.setPageNum(i);
        PoiSearch poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() { // from class: io.rong.imkit.plugin.location.SearchLocationActivity.7
            public void onPoiItemSearched(PoiItem poiItem, int i2) {
            }

            public void onPoiSearched(PoiResult poiResult, int i2) {
                if (poiResult == null || poiResult.getPois().size() <= 0) {
                    return;
                }
                ArrayList pois = poiResult.getPois();
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < pois.size(); i3++) {
                    PoiItem poiItem = (PoiItem) pois.get(i3);
                    SearchLocationInfo searchLocationInfo = SearchLocationActivity.this.new SearchLocationInfo(poiItem.getTitle(), poiItem.getSnippet());
                    searchLocationInfo.setLongitude(poiItem.getLatLonPoint().getLongitude());
                    searchLocationInfo.setLatitude(poiItem.getLatLonPoint().getLatitude());
                    searchLocationInfo.setPoi(poiItem.getTitle());
                    arrayList.add(searchLocationInfo);
                }
                SearchLocationActivity.this.searchListAdapter.addItems(arrayList);
                SearchLocationActivity.this.searchListAdapter.notifyDataSetChanged();
            }
        });
        poiSearch.searchPOIAsyn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocationAddress(TextView textView, String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
        int iIndexOf = str.toLowerCase().indexOf(str2.toLowerCase());
        if (iIndexOf < 0) {
            textView.setText(str);
            return;
        }
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.rc_map_search_highlight_color)), iIndexOf, str2.length() + iIndexOf, 17);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        textView.setText(spannableStringBuilder);
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocationTitle(TextView textView, String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
        int iIndexOf = str.toLowerCase().indexOf(str2.toLowerCase());
        if (iIndexOf < 0) {
            textView.setText(str);
            return;
        }
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.rc_map_search_highlight_color)), iIndexOf, str2.length() + iIndexOf, 17);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        textView.setText(spannableStringBuilder);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LangUtils.getConfigurationContext(context));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_location_search_activity);
        this.cityCode = getIntent().getStringExtra(LocationConst.CITY_CODE);
        initView();
    }

    @Override // android.app.Activity
    protected void onPause() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mSearchEditText.getWindowToken(), 0);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.mSearchEditText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.mSearchEditText, 0);
        }
        super.onResume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        return (getCurrentFocus() == null || motionEvent.getAction() != 1 || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) ? super.onTouchEvent(motionEvent) : inputMethodManager.hideSoftInputFromWindow(this.mSearchEditText.getWindowToken(), 0);
    }
}
