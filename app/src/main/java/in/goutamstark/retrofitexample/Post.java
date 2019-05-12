package in.goutamstark.retrofitexample;

import com.google.gson.annotations.SerializedName;

//http://jsonplaceholder.typicode.com/posts
public class Post {
    private int userId;

    private int id;

    private String title;

    @SerializedName("body") //if json key and variable name differs then we can use SerializeName
    protected String text;


    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
