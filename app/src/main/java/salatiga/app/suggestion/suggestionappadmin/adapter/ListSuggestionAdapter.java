package salatiga.app.suggestion.suggestionappadmin.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import salatiga.app.suggestion.suggestionappadmin.R;
import salatiga.app.suggestion.suggestionappadmin.data.model.Suggestion;

/**
 * Created by adhit on 10/02/2018.
 */

public class ListSuggestionAdapter extends RecyclerView.Adapter<ListSuggestionAdapter.HomeViewHolder> {
    private Context context;
    private List<Suggestion> suggestionList;
    private OnCardViewClickListener onCardViewClickListener;

    public ListSuggestionAdapter(Context context){
        this.context = context;
    }

    public void setData(List<Suggestion> suggestionList){
        this.suggestionList = suggestionList;
        notifyDataSetChanged();
    }

    @Override
    public ListSuggestionAdapter.HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_suggestion, parent, false);
        return new ListSuggestionAdapter.HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListSuggestionAdapter.HomeViewHolder holder, int position) {
        final Suggestion suggestion = suggestionList.get(position);
        holder.tvDateTime.setText(suggestion.getDateTime());
        holder.tvSuggestionText.setText(suggestion.getSuggestionText());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCardViewClickListener.onMenuClicked(home.getNamaMenu());
//
//            }
//        });
    }


    public void setOnClickDetailListener(OnCardViewClickListener onCardViewClickListener){
        this.onCardViewClickListener = onCardViewClickListener;

    }

    @Override
    public int getItemCount() {
        if(suggestionList == null) return 0;
        return suggestionList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView tvDateTime, tvSuggestionText;

        public HomeViewHolder(View itemView) {
            super(itemView);
            tvDateTime = itemView.findViewById(R.id.tv_date_time);
            tvSuggestionText = itemView.findViewById(R.id.tv_suggestion_text);
        }
    }

    public  interface OnCardViewClickListener{
        void onMenuClicked(String string);
    }
}
