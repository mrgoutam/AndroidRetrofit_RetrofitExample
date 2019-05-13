package in.goutamstark.retrofitexample;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

public class Post2 {
    private int userId;

    private String title;

    @SerializedName("body") //if json key and variable name differs then we can use SerializeName
    protected String text;

    public Post2(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }


    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
