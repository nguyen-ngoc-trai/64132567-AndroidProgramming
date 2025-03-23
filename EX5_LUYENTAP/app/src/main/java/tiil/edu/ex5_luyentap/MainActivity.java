package tiil.edu.ex5_luyentap;

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
    EditText edta;
    EditText edtb;
    EditText edtkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edta = (EditText)findViewById(R.id.editA);
        edtb = (EditText)findViewById(R.id.editB);
        edtkq = (EditText)findViewById(R.id.editKQ);

        Button nutcong = findViewById(R.id.btnCong);
        Button nuttru = findViewById(R.id.btnTru);
        Button nutnhan = findViewById(R.id.btnNhan);
        Button nutchia = findViewById(R.id.btnChia);

        View.OnClickListener bolangnghecong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLiCong();
            }
        };
        nutcong.setOnClickListener(bolangnghecong);

        View.OnClickListener bolangnghetru = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLiTru();
            }
        };
        nuttru.setOnClickListener(bolangnghetru);

        View.OnClickListener bolangnghenhan = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLiNhan();
            }
        };
        nutnhan.setOnClickListener(bolangnghenhan);

        View.OnClickListener bolangnghechia = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLiChia();
            }
        };
        nutchia.setOnClickListener(bolangnghechia);

    }
    public void XuLiCong(){

        String soa = edta.getText().toString();
        String sob = edtb.getText().toString();

        int so1 = Integer.parseInt(soa);
        int so2 = Integer.parseInt(sob);

        int tong = so1+so2;
        String kq = String.valueOf(tong);

        edtkq.setText(kq);

    }
    public void XuLiTru(){

        String soa = edta.getText().toString();
        String sob = edtb.getText().toString();

        int so1 = Integer.parseInt(soa);
        int so2 = Integer.parseInt(sob);

        int tong = so1-so2;
        String kq = String.valueOf(tong);

        edtkq.setText(kq);

    }
    public void XuLiNhan(){

        String soa = edta.getText().toString();
        String sob = edtb.getText().toString();

        int so1 = Integer.parseInt(soa);
        int so2 = Integer.parseInt(sob);

        int tong = so1*so2;
        String kq = String.valueOf(tong);

        edtkq.setText(kq);

    }
    public void XuLiChia(){

        String soa = edta.getText().toString();
        String sob = edtb.getText().toString();

        int so1 = Integer.parseInt(soa);
        int so2 = Integer.parseInt(sob);

        int tong = so1/so2;
        String kq = String.valueOf(tong);

        edtkq.setText(kq);

    }

}