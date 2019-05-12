package in.goutamstark.retrofitexample;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}/comments")
    Call<List<Comments>> getComments(@Path("id") int postId);


    //http://jsonplaceholder.typicode.com/posts?userId=2
    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId);


    //http://jsonplaceholder.typicode.com/posts?userId=2&_sort=id&_order=desc
    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") int userId,
            @Query("_sort") String sort,
            @Query("_order") String order);

    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

    @GET
    Call<List<Comments>> getComments(@Url String url);


}
