package in.goutamstark.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //getPosts();
        //getComments();
        //getPostsByPostData();
        //getPostsByMultiplePostData();
        //getPostsByMap();
        getCommentsByUrl();
    }


    private void getPosts() {
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                String data = "";
                for (Post post : posts) {
                    data += "ID: " + post.getId() + "\n";
                    data += "ID: " + post.getUserId() + "\n";
                    data += "ID: " + post.getTitle() + "\n";
                    data += "ID: " + post.getText() + "\n\n";
                }

                textViewResult.append(data);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    //https://www.youtube.com/watch?v=TyJEDhauUeQ&list=PLrnPJCHvNZuCPNCW2xdriIUgxmo9-QcFi&index=2
    private void getComments() {
        Call<List<Comments>> call = jsonPlaceHolderApi.getComments(3);

        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Comments> comments = response.body();

                String data = "";
                for (Comments comment : comments) {
                    data += "ID: " + comment.getId() + "\n";
                    data += "Name: " + comment.getName() + "\n";
                    data += "Email: " + comment.getEmail() + "\n";
                    data += "Post ID: " + comment.getPostId() + "\n";
                    data += "Body: " + comment.getText() + "\n\n";
                }

                textViewResult.append(data);
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

    //https://www.youtube.com/watch?v=TyJEDhauUeQ&list=PLrnPJCHvNZuCPNCW2xdriIUgxmo9-QcFi&index=2
    private void getPostsByPostData() {
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(2);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                String data = "";
                for (Post post : posts) {
                    data += "ID: " + post.getId() + "\n";
                    data += "ID: " + post.getUserId() + "\n";
                    data += "ID: " + post.getTitle() + "\n";
                    data += "ID: " + post.getText() + "\n\n";
                }

                textViewResult.append(data);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    //https://www.youtube.com/watch?v=TyJEDhauUeQ&list=PLrnPJCHvNZuCPNCW2xdriIUgxmo9-QcFi&index=2
    private void getPostsByMultiplePostData() {
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(2,"id","desc");
        //Call<List<Post>> call = jsonPlaceHolderApi.getPosts(2,null,null);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                String data = "";
                for (Post post : posts) {
                    data += "ID: " + post.getId() + "\n";
                    data += "ID: " + post.getUserId() + "\n";
                    data += "ID: " + post.getTitle() + "\n";
                    data += "ID: " + post.getText() + "\n\n";
                }

                textViewResult.append(data);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getPostsByMap() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId","2");
        parameters.put("_sort","id");
        parameters.put("_order","desc");

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(parameters);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                String data = "";
                for (Post post : posts) {
                    data += "ID: " + post.getId() + "\n";
                    data += "ID: " + post.getUserId() + "\n";
                    data += "ID: " + post.getTitle() + "\n";
                    data += "ID: " + post.getText() + "\n\n";
                }

                textViewResult.append(data);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getCommentsByUrl() {
        Call<List<Comments>> call = jsonPlaceHolderApi.getComments("posts/3/comments");

        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Comments> comments = response.body();

                String data = "";
                for (Comments comment : comments) {
                    data += "ID: " + comment.getId() + "\n";
                    data += "Name: " + comment.getName() + "\n";
                    data += "Email: " + comment.getEmail() + "\n";
                    data += "Post ID: " + comment.getPostId() + "\n";
                    data += "Body: " + comment.getText() + "\n\n";
                }

                textViewResult.append(data);
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }
}
