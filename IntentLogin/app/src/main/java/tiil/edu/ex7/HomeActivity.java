package tiil.edu.ex7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        //Lấy Intent về
        Intent intentTuLogin = getIntent();
        //Loc lấy dữ liệu
        String tenĐN_NhậnĐược = intentTuLogin.getStringExtra("ten_đang_nhap");
        //Gán vào đk
        TextView tvTenĐN = (TextView)findViewById(R.id.tvUsername);
        tvTenĐN.setText(tenĐN_NhậnĐược);
    }
}