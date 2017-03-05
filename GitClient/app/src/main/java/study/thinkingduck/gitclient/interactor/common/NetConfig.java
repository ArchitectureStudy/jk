package study.thinkingduck.gitclient.interactor.common;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import study.thinkingduck.gitclient.interactor.data.Issue;

/**
 * Created by thinkingduck on 2017. 3. 4..
 */

public class NetConfig {

    private static final String BASE_URL = "https://api.github.com/";

    private static Retrofit mRetrofit;


    public static Retrofit getHttpLoader() {

        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;

    }


    public interface GitHubService {

        @GET("repos/{owner}/{repo}/issues")
        Call<List<Issue>> getIssueList(@Path("owner") String owner, @Path("repo") String repo, @Query("page") int page);

        @POST("repos/{owner}/{repo}/issues")
        Call<ResponseBody> addIssue(@Path("owner") String owner, @Path("repo") String repo, @HeaderMap Map<String, String> headers, @Body Map<String, String> body);

        @GET("repos/{owner}/{repo}/issues/{number}/comments")
        Call<ResponseBody> getIssueCommentList(@Path("owner") String owner, @Path("repo") String repo, @Path("number") int number, @Query("page") int currentPage);

        @POST("repos/{owner}/{repo}/issues/{number}/comments")
        Call<ResponseBody> addIssueComment(@Path("owner") String owner, @Path("repo") String repo, @Path("number") int number, @HeaderMap Map<String, String> headers, @Body Map<String, String> body);

        @GET("repos/{owner}/{repo}/issues/{number}")
        Call<ResponseBody> getIssueDetail(@Path("owner") String owner, @Path("repo") String repo, @Path("number") int number);

    }



}
