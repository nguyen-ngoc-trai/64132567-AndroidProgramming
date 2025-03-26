package tiil.edu.usingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LandScapeAdapter extends RecyclerView.Adapter< LandScapeAdapter.ImtemLandHolder>{
    Context context;
    ArrayList<LandScape> listdata;

    public LandScapeAdapter(Context context, ArrayList<LandScape> listdata) {
        this.context = context;
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ImtemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vitem= cai_bom.inflate(R.layout.item_land,parent, false);
        ImtemLandHolder viewholderCreated = new ImtemLandHolder(vitem);
        return viewholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ImtemLandHolder holder, int position) {
        //lấy đối tượng hiển thị
        LandScape landScapehienthi = listdata.get(position);
        //Trích thông tin
        String caption  =landScapehienthi.getLandCation();
        String tenanh = landScapehienthi.getLandImageFileName();
        //Đặt vào các trường thông tin của holder
        holder.tvCaption.setText(caption);
        //đặt ảnh
        String packagetnam = holder.itemView.getContext().getPackageName();
        int  imageID = holder.itemView.getResources().getIdentifier(tenanh,"mipmap", packagetnam);
        holder.ivLandScape.setImageResource(imageID);
    }

    @Override
    public int getItemCount()
    {
        return listdata.size();
    }

    class ImtemLandHolder extends RecyclerView.ViewHolder{
        TextView tvCaption;
        ImageView ivLandScape;
        public ImtemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCation);
            ivLandScape = itemView.findViewById(R.id.imageViewLand);
        }
    }
}
