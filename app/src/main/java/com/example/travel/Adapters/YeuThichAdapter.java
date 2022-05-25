package com.example.travel.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.travel.Details;
import com.example.travel.Models.FavItem;
import com.example.travel.R;
import com.example.travel.Helpers.TravelDB;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class YeuThichAdapter extends RecyclerView.Adapter<YeuThichAdapter.ViewHolder> {

    // Danh sách để lưu trữ tất cả các chi tiết
    private Context context;
    private List<FavItem> favItemList;
    private TravelDB travelDB;

    // Counstructor
    public YeuThichAdapter(Context context, List<FavItem> favItemList) {
        this.context = context;
        this.favItemList = favItemList;
    }


    // Vào viewHolders giúp hiển thị các mục trong
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Tăng chế độ xem bố cục bạn đã tạo cho các hàng danh sách ở đây
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item, parent, false);
        travelDB = new TravelDB(context);
        return new ViewHolder(view);
    }

    // Phương thức này được gọi khi liên kết dữ liệu với các khung nhìn đang được tạo trong RecyclerView
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.favTextView.setText(favItemList.get(position).getItem_title());   // Set the data to the views here
        holder.favImageView.setImageResource(favItemList.get(position).getItem_image());
        holder.favCountryDescView.setText(favItemList.get(position).getCountry_desc());
        holder.favCurrencyTextView.setText(favItemList.get(position).getCurrency());
        holder.favLanguageTextView.setText(favItemList.get(position).getLanguage());
        holder.favcapitalTextView.setText(favItemList.get(position).getCapital());
        holder.favotherTextView.setText(favItemList.get(position).getOther());


// đặt khi nhấp vào các quốc gia yêu thích
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("image",favItemList.get(position).getItem_image());
                intent.putExtra("titleTextView",favItemList.get(position).getItem_title());
                intent.putExtra("countryDescTextView",favItemList.get(position).getCountry_desc());
                intent.putExtra("currencyTextView",favItemList.get(position).getCurrency());
                intent.putExtra("languageTextView",favItemList.get(position).getLanguage());
                intent.putExtra("capitalTextView",favItemList.get(position).getCapital());
                intent.putExtra("otherTextView",favItemList.get(position).getOther());

                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return favItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView favTextView;
        Button favBtn;
        ImageView favImageView;
        TextView favCountryDescView;
        TextView favCurrencyTextView;
        TextView favLanguageTextView;
        TextView favcapitalTextView;
        TextView favotherTextView;
        RelativeLayout relative;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            favTextView = itemView.findViewById(R.id.favTextView);
            favBtn = itemView.findViewById(R.id.favBtn);
            favImageView = itemView.findViewById(R.id.favImageView);
            favCountryDescView =itemView.findViewById(R.id.favcountryDesctextView);
            favCurrencyTextView= itemView.findViewById(R.id.favcurrencyTextView);
            favLanguageTextView= itemView.findViewById(R.id.favlanguageTextView);
            favcapitalTextView = itemView.findViewById(R.id.favcapitalTextView);
            favotherTextView = itemView.findViewById(R.id.favotherTextView);
            relative = itemView.findViewById(R.id.relative);   //relative layout



// sau khi nhấp vào xóa khỏi mục yêu thích
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final FavItem favItem = favItemList.get(position);
                    travelDB.remove_fav(favItem.getKey_id());
                    removeItem(position);
                }
            });
        }
    }
    private void removeItem(int position) {
        favItemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,favItemList.size());
    }
}
