package tiil.edu.ex3;

import android.os.Bundle;
import android.view.View;
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
    }

    //Đây là bộ lắng nghe và xử lí xử kiện lên nút tính tổng
    public void XuLiCong(View view){
        //Tìm, tham chiếu đến đều khiển
        EditText editTextSoA = findViewById(R.id.editA);
        EditText editTextSoB = findViewById(R.id.editB);
        EditText editTexTKetQua = findViewById(R.id.editKQ);

        //Lấy dũ liệu vê
        String strA = editTextSoA.getText().toString();
        String strB = editTextSoB.getText().toString();

        //Chuyển dữ liệu sang số
        int soA = Integer.parseInt(strA);
        int soB = Integer.parseInt(strB);

        //Tính toán theo yêu cầu
        int Tong = soA + soB;
        String strTong = String.valueOf(Tong);

        //Hiện ra kết quả
        editTexTKetQua.setText(strTong);
    }
}