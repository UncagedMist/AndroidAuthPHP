package tbc.techbytecare.kk.androidauthphp.Remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tbc.techbytecare.kk.androidauthphp.Model.APIResponse;

public interface IMyAPI {

    @FormUrlEncoded
    @POST("login.php")
    Call<APIResponse> loginUser(@Field("email") String email,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<APIResponse> registerUser(@Field("name") String name,
                                   @Field("email") String email,
                                   @Field("password") String password);
}
