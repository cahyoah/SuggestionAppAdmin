package salatiga.app.suggestion.suggestionappadmin.presenter;

import java.util.ArrayList;
import java.util.List;

import salatiga.app.suggestion.suggestionappadmin.data.model.Suggestion;
import salatiga.app.suggestion.suggestionappadmin.ui.ListSuggestionView;

/**
 * Created by adhit on 10/02/2018.
 */

public class ListSuggestionPresenter {
    private ListSuggestionView listSuggestionView;
    private DatabaseReference databaseReference;

    public ListSuggestionPresenter(ListSuggestionView listSuggestionView){
        this.listSuggestionView = listSuggestionView;
    }

    public void getSuggestion(){
        databaseReference  = FirebaseDatabase.getInstance().getReference().child("suggestion");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<Suggestion> suggestionList = new ArrayList<>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Suggestion suggestion = postSnapshot.getValue(Suggestion.class);
                    suggestionList.add(suggestion);
                }
                listSuggestionView.onSuccessGetAllSuggestion(suggestionList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listSuggestionView.onFailedGetAllSuggestion(databaseError.getMessage());
            }
        });

    }


}
