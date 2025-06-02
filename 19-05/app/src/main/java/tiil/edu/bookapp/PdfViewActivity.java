package tiil.edu.bookapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pdf_view);

        ImageButton back = findViewById(R.id.backbtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PdfViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        pdfView = findViewById(R.id.pdfView);

        int pos = getIntent().getIntExtra("position",0);

        if (pos==0){
            pdfView.fromAsset("_hoa-hong-som-mai.pdf").load();
        }

        else if (pos==1) {
            pdfView.fromAsset("_thien-nga-den.pdf").load();
        }

        else if (pos==2) {
            pdfView.fromAsset("_lap-trinh-can-ban.pdf").load();
        }

        else if (pos==3) {
            pdfView.fromAsset("_binh-phap-ton-tu.pdf").load();
        }

        else if (pos==4) {
            pdfView.fromAsset("_thao-tung-tam-ly-nhan-dien-thuc-tinh-va-chua-lanh-nhung-ton-thuong-tiem-an.pdf").load();
        }

        else if (pos==5) {
            pdfView.fromAsset("_lam-giau-tu-chan-nuoi.pdf").load();
        }

        else if (pos==6) {
            pdfView.fromAsset("_putin-logic-cua-quyen-luc.pdf").load();
        }

        else if (pos==7) {
            pdfView.fromAsset("_su-nghiep-ca-cuoc-doi.pdf").load();
        }

        else if (pos==8) {
            pdfView.fromAsset("_nhung-cuoc-phieu-luu-trong-kinh-doanh.pdf").load();
        }

        else if (pos==9) {
            pdfView.fromAsset("_499-dieu-cam-ky-trong-phong-thuy.pdf").load();
        }

        else if (pos==10) {
            pdfView.fromAsset("_trang-quynh.pdf").load();
        }

    }
}