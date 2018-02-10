package salatiga.app.suggestion.suggestionappadmin.ui;

import java.util.List;

import salatiga.app.suggestion.suggestionappadmin.data.model.Suggestion;

/**
 * Created by adhit on 10/02/2018.
 */

public interface ListSuggestionView {
    void onSuccessGetAllSuggestion(List<Suggestion> suggestionList);

    void onFailedGetAllSuggestion(String message);
}
