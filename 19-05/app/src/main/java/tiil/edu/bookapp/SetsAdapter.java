package tiil.edu.bookapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetsAdapter extends RecyclerView.Adapter<SetsAdapter.viewHolder> implements Filterable{

    ArrayList<SetsMode>list;
    Context context;
    ArrayList<SetsMode> filteredList;

    public SetsAdapter(ArrayList<SetsMode> list, Context context){
        this.list = list;
        this.context = context;
        this.filteredList = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_set,parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final SetsMode model = filteredList.get(position);

        holder.setName.setText(model.getSetName());
        holder.description.setText(model.getDescription());
        holder.category.setText(model.getCategory());
        holder.size.setText(model.getSize());
        holder.date.setText(model.getDate());
        holder.image.setImageResource(model.getImageResId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PdfViewActivity.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });

        SharedPreferences prefs = context.getSharedPreferences("favorites", Context.MODE_PRIVATE);
        Set<String> favNames = prefs.getStringSet("favorite_list", new HashSet<>());

        boolean isFav = favNames.contains(model.getSetName());
        model.setFavorite(isFav);
        holder.favoriteIcon.setImageResource(isFav ? R.drawable.baseline_favorite_24 : R.drawable.baseline_account_box_24);

        holder.favoriteIcon.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            Set<String> updatedFavs = new HashSet<>(prefs.getStringSet("favorite_list", new HashSet<>()));

            if (model.isFavorite()) {
                updatedFavs.remove(model.getSetName());
                model.setFavorite(false);
            } else {
                updatedFavs.add(model.getSetName());
                model.setFavorite(true);
            }

            editor.putStringSet("favorite_list", updatedFavs);
            editor.apply();
            notifyItemChanged(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence keyword) {
                ArrayList<SetsMode> filtered = new ArrayList<>();

                if (keyword == null || keyword.length() == 0) {
                    filtered.addAll(list);
                } else {String filterPattern = keyword.toString().toLowerCase().trim();
                    for (SetsMode item : list) {
                        if (item.getSetName().toLowerCase().contains(filterPattern)
                                || item.getDescription().toLowerCase().contains(filterPattern)
                                || item.getCategory().toLowerCase().contains(filterPattern)) {
                            filtered.add(item);
                        }
                    }
                }

                Filter.FilterResults results = new Filter.FilterResults();
                results.values = filtered;
                return results;
            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList.clear();
                filteredList.addAll((ArrayList<SetsMode>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView setName, description, category, size, date;
        ImageView image, favoriteIcon;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            setName = itemView.findViewById(R.id.setname);
            description = itemView.findViewById(R.id.description);
            category = itemView.findViewById(R.id.catedoty);
            size = itemView.findViewById(R.id.size);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.pdf);
            favoriteIcon = itemView.findViewById(R.id.favorite_icon);
        }
    }


}
