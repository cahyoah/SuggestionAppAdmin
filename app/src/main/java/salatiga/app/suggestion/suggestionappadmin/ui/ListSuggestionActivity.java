package salatiga.app.suggestion.suggestionappadmin.ui;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import salatiga.app.suggestion.suggestionappadmin.R;
import salatiga.app.suggestion.suggestionappadmin.adapter.ListSuggestionAdapter;
import salatiga.app.suggestion.suggestionappadmin.data.model.Suggestion;
import salatiga.app.suggestion.suggestionappadmin.presenter.ListSuggestionPresenter;

public class ListSuggestionActivity extends AppCompatActivity implements ListSuggestionView {
    private RecyclerView rvSuggestion;
    private TextView tvError;
    private ProgressBar pbLoading;
    private SwipeRefreshLayout srlSuggestion;
    private ListSuggestionPresenter listSuggestionPresenter;
    private ListSuggestionAdapter listSuggestionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_suggestion);
        getSupportActionBar().setTitle("Admin SDM");
        initView();
        initPresenter();
    }

    private void initPresenter() {
        listSuggestionPresenter = new ListSuggestionPresenter(this);
        listSuggestionPresenter.getSuggestion();
    }

    private void initView() {
        tvError = findViewById(R.id.tv_error);
        pbLoading = findViewById(R.id.pb_loading);
        listSuggestionAdapter = new ListSuggestionAdapter(this);
        rvSuggestion = findViewById(R.id.rv_suggestion);
        rvSuggestion.setLayoutManager(new LinearLayoutManager(this));
        rvSuggestion.setAdapter(listSuggestionAdapter);
        srlSuggestion = findViewById(R.id.srl_suggestion);
        srlSuggestion.setOnRefreshListener(() -> {
            tvError.setText("");
            pbLoading.setVisibility(View.VISIBLE);
            rvSuggestion.setVisibility(View.GONE);
            listSuggestionPresenter.getSuggestion();
            srlSuggestion.setRefreshing(false);  });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.delete:
                listSuggestionPresenter.deleteSuggestion();
                listSuggestionPresenter.getSuggestion();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSuccessGetAllSuggestion(List<Suggestion> suggestionList) {
        rvSuggestion.setVisibility(View.VISIBLE);
        pbLoading.setVisibility(View.GONE);
        listSuggestionAdapter.setData(suggestionList);
        //x
    }

    @Override
    public void onFailedGetAllSuggestion(String message) {
        rvSuggestion.setVisibility(View.GONE);
        pbLoading.setVisibility(View.GONE);
        tvError.setVisibility(View.VISIBLE);
        tvError.setText(message);
    }
}
