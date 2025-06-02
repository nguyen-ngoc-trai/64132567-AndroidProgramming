package tiil.edu.bookapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        Button favo = findViewById(R.id.favo);
        ImageButton back = findViewById(R.id.btnback);
        Button updateButton = findViewById(R.id.btnupdate);
        EditText emailField = findViewById(R.id.email);
        EditText passwordField = findViewById(R.id.pass);
        EditText nameField = findViewById(R.id.name);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEmail = emailField.getText().toString();
                String newPassword = passwordField.getText().toString();
                String newName = nameField.getText().toString(); // nếu muốn lưu tên luôn

                // Lưu thông tin
                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", newEmail);
                editor.putString("password", newPassword);
                editor.putString("name", newName);
                editor.apply();

                Toast.makeText(ProfileActivity.this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        favo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, FavoriteMainActivity.class);
                startActivity(intent);
            }
        });




    }
}