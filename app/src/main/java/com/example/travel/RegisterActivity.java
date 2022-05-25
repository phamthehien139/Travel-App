package com.example.travel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travel.Helpers.TravelDB;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    TravelDB db;
    EditText TextUsername;
    EditText TextPassword;
    EditText TextCnfPassword;
    Button ButtonRegister;
    TextView LoginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new TravelDB(this);
        TextUsername = (EditText)findViewById(R.id.usernameTextView);
        TextPassword = (EditText)findViewById(R.id.passwordTextView);
        TextCnfPassword = (EditText)findViewById(R.id.confpasswordTextView);
        ButtonRegister = (Button)findViewById(R.id.registerBtn);
        LoginTextView = (TextView)findViewById(R.id.loginBtn);
        LoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });




        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = TextUsername.getText().toString().trim();
                String pwd = TextPassword.getText().toString().trim();
                String cnf_pwd = TextCnfPassword.getText().toString().trim();

                // check cnf password and register

                  if(user.equals("") || pwd.equals("") || cnf_pwd.equals("")){
                      Toast.makeText(RegisterActivity.this, "Hãy điền vào mẫu", Toast.LENGTH_SHORT).show();
                  }
                  else {

                      if (pwd.equals(cnf_pwd)) {
                          long val = db.addUser(user, pwd);
                          if (val > 0) {
                              Toast.makeText(RegisterActivity.this, "\n" +
                                      "Đã đăng ký thành công", Toast.LENGTH_SHORT).show();
                              Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                              startActivity(moveToLogin);
                          } else {
                              Toast.makeText(RegisterActivity.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                          }

                      } else {
                          Toast.makeText(RegisterActivity.this, "Vui lòng nhập cùng một mật khẩu", Toast.LENGTH_SHORT).show();
                      }
                  }
            }
        });
    }
}