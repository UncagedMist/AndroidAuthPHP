package tbc.techbytecare.kk.androidauthphp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tbc.techbytecare.kk.androidauthphp.Common.Common;
import tbc.techbytecare.kk.androidauthphp.Model.APIResponse;
import tbc.techbytecare.kk.androidauthphp.Remote.IMyAPI;

public class RegisterActivity extends AppCompatActivity {

    TextView txt_login;
    EditText edt_email,edt_password,edt_name;
    Button btn_register;

    IMyAPI mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mService = Common.getAPI();

        txt_login = findViewById(R.id.txt_login);

        edt_name = findViewById(R.id.edt_name);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);

        btn_register = findViewById(R.id.btn_register);

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewUser(edt_name.getText().toString(),edt_email.getText().toString(),edt_password.getText().toString());
            }
        });
    }

    private void createNewUser(String name, String email, String password) {
        mService.registerUser(name,email,password)
                .enqueue(new Callback<APIResponse>() {
                    @Override
                    public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                        APIResponse result = response.body();

                        if (result.isError())   {
                            Toast.makeText(RegisterActivity.this, ""+result.getError_msg(), Toast.LENGTH_SHORT).show();
                        }
                        else    {
                            Toast.makeText(RegisterActivity.this, "User Created with UID : "+result.getUid(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<APIResponse> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
