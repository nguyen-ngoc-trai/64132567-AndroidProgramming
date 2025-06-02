package tiil.edu.bookapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class LogActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log);

        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        loginButton = findViewById(R.id.btnlog);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                String savedEmail = prefs.getString("email", "trai@gmail.com");
                String savedPassword = prefs.getString("password", "1234");

                String inputEmail = email.getText().toString();
                String inputPassword = password.getText().toString();

                if (inputEmail.equals(savedEmail) && inputPassword.equals(savedPassword)) {
                    Toast.makeText(LogActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LogActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LogActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}