package tbc.techbytecare.kk.androidauthphp.Common;

import tbc.techbytecare.kk.androidauthphp.Remote.IMyAPI;
import tbc.techbytecare.kk.androidauthphp.Remote.RetrofitClient;

public class Common {

    public static final String BASE_URL = "http://10.0.2.2/myapi/";

    public static IMyAPI getAPI() {
        return RetrofitClient.getClient(BASE_URL).create(IMyAPI.class);
    }
}
