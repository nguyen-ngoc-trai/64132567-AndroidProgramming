package tiil.edu.ex3_luyentap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button nutcong = findViewById(R.id.btncong);
        nutcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLiCong();
            }
        });
    }
    public void XuLiCong(){
        EditText edta = findViewById(R.id.editA);
        EditText edtb = findViewById(R.id.editB);
        EditText edtkq = findViewById(R.id.editKQ);

        String soa = edta.getText().toString();
        String sob = edtb.getText().toString();

        int so1 = Integer.parseInt(soa);
        int so2 = Integer.parseInt(sob);

        int tong = so1+so2;
        String kq = String.valueOf(tong);

        edtkq.setText(kq);

    }
}