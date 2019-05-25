package in.goutamstark.retrofitexample;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    @POST("posts")
    Call<Post2> createPost (@Body Post2 post2);

    @FormUrlEncoded  //like .../userId=23&title=New20%Title&body=New20%Text
    @POST("posts")
    Call<Post2> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String body
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post2> createPost(@FieldMap Map<String , String> fields);

    //PUT: this is used for updating the whole row using id
    @PUT("posts/{id}")
    Call<Post2> putPost(@Path("id") int id, @Body Post2 post2);

    //PATCH: this is used for updating the specific column using id
    @PATCH("posts/{id}")
    Call<Post2> patchPost(@Path("id") int id, @Body Post2 post2);


    //HEADER
    @Headers({"Static-Header1:123","Static-Header2:456"})
    @PUT("posts/{id}")
    Call<Post2> createHeaderPost(
            @Header("Dynamic-Header") String header,
            @Path("id") int id,
            @Body Post2 post2);

}
