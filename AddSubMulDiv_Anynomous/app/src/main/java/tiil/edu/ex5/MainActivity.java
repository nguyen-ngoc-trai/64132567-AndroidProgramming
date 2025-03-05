package tiil.edu.ex5;

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
    EditText editSo1;
    EditText editSo2;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;
    void TimĐieuKhien() {
        editSo1 = (EditText) findViewById(R.id.editSo1);
        editSo2 = (EditText) findViewById(R.id.editSo2);
        editTextKQ = (EditText) findViewById(R.id.editKQ);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimĐieuKhien();
        //Gắn bộ lắng nghe sự kiện và xử lí từng nút
        View.OnClickListener bolangngheCong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //b1: Lấy dữ liệu 2 số
                //b1.1: Tìm EdiText 2 số 1 và 2
                //b1.2: Lấy dữ liệu từ 2 đk đó
                String Sothu1 = editSo1.getText().toString();
                String Sothu2 = editSo2.getText().toString();
                //b1.3: Chuyển dữ liệu từ chuỗi sang số
                float So1 = Float.parseFloat(Sothu1);
                float So2 = Float.parseFloat(Sothu2);
                //b2: Tính Toán
                float Tong = So1 + So2;
                //b3: Hiện kết quả
                //b3.1:
                //b3.2: Chuẩn bị dữ liệu xuất
                String chuoiKQ = String.valueOf(Tong);
                //b3.3: Gắn KQ lên đk
                editTextKQ.setText(chuoiKQ);
            }
        };
        nutCong.setOnClickListener(bolangngheCong);

        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sothu1 = editSo1.getText().toString();
                String Sothu2 = editSo2.getText().toString();
                float So1 = Float.parseFloat(Sothu1);
                float So2 = Float.parseFloat(Sothu2);
                float Tru = So1 - So2;
                String chuoiKQ = String.valueOf(Tru);
                editTextKQ.setText(chuoiKQ);
            }
        });

        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sothu1 = editSo1.getText().toString();
                String Sothu2 = editSo2.getText().toString();
                float So1 = Float.parseFloat(Sothu1);
                float So2 = Float.parseFloat(Sothu2);
                float Nhan = So1 * So2;
                String chuoiKQ = String.valueOf(Nhan);
                editTextKQ.setText(chuoiKQ);
            }
        });

        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sothu1 = editSo1.getText().toString();
                String Sothu2 = editSo2.getText().toString();
                float So1 = Float.parseFloat(Sothu1);
                float So2 = Float.parseFloat(Sothu2);
                float Chia = So1 / So2;
                String chuoiKQ = String.valueOf(Chia);
                editTextKQ.setText(chuoiKQ);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}