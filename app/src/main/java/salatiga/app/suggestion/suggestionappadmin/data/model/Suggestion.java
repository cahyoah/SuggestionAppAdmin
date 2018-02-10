package salatiga.app.suggestion.suggestionappadmin.data.model;

/**
 * Created by adhit on 10/02/2018.
 */

public class Suggestion {
    private String dateTime;
    private String suggestionText;

    public Suggestion(String dateTime, String suggestionText) {
        this.dateTime = dateTime;
        this.suggestionText = suggestionText;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getSuggestionText() {
        return suggestionText;
    }
}
