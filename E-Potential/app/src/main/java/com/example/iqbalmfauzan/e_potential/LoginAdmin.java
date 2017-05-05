package com.example.iqbalmfauzan.e_potential;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAdmin extends AppCompatActivity implements View.OnClickListener{


    EditText etUsernameadm;
    EditText etPasswordadm;
    Button bLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        etUsernameadm = (EditText) findViewById(R.id.etUsernameadm);
        etPasswordadm = (EditText) findViewById(R.id.etPasswordadm);
        bLogin = (Button) findViewById(R.id.bLogin);


        bLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.bLogin:
                EditText user = (EditText) findViewById(R.id.etUsernameadm);
                EditText pass = (EditText) findViewById(R.id.etPasswordadm);
                if (user.getText().toString().equals(""))
                {
                    Toast t = Toast.makeText(LoginAdmin.this, "Username is blank" , Toast.LENGTH_SHORT);
                    t.show();

                }
                    else if (pass.getText().toString().equals("")){
                        Toast p = Toast.makeText(LoginAdmin.this, "Password is blank", Toast.LENGTH_SHORT);
                        p.show();
                    }


                else
                {
                    if (user.getText().toString().equals("admin"))
                    {
                        if (pass.getText().toString().equals("admin"))
                        {
                            Intent Login = new Intent(getApplicationContext(), AfterAdmin.class);

                            startActivity(Login);
                            finish();
                        }
                        else{
                            Toast wrongpass = Toast.makeText(LoginAdmin.this, "Wrong Password", Toast.LENGTH_SHORT);
                            wrongpass.show();
                        }
                    }
                    else{
                        Toast login = Toast.makeText(LoginAdmin.this, "Wrong Username and Password", Toast.LENGTH_SHORT);
                        login.show();
                    }



                }


                break;



        }
    }
}
