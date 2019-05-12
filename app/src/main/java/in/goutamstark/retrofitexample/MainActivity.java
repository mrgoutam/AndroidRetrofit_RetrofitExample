package in.goutamstark.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
