package edu.northsouth.krishokiot;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

import org.w3c.dom.Text;

import java.io.IOException;

import edu.northsouth.krishokiot.constants.SettingsConstant;
import edu.northsouth.krishokiot.networks.RequestPoster;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPass;
    private Button btnLogin;
    private TextView etRegister;

    private String email;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        etEmail = findViewById(R.id.et_email);
        etPass = findViewById(R.id.et_pass);
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etEmail.getText().toString();
                pass = etPass.getText().toString();
                etEmail.setText("");
                etPass.setText("");

                JsonObject requestObject = new JsonObject();
                requestObject.add("email", email);
                requestObject.add("password", pass);

                RequestPoster requestPoster = new RequestPoster();
                try {
                    System.out.println(requestObject.toString());
                    String result = requestPoster.post(SettingsConstant.BASE_URL + SettingsConstant.LOGIN_END_POINT, requestObject.toString());
                    System.out.println(result);
                    JsonObject resultObject = Json.parse(result).asObject();
                    boolean isValidUser = resultObject.getBoolean("success", false);
                    if (isValidUser) {
                        Toast.makeText(getApplicationContext(), "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid User/Pass", Toast.LENGTH_SHORT).show();
                    }
                    System.out.println(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });




    }


}
