package com.example.travel.Adapters;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.travel.ThanhPhoDetails;
import com.example.travel.Models.CityItem;
import com.example.travel.ImageNicer;
import com.example.travel.R;
import com.example.travel.Helpers.TravelDB;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ThanhPhoAdapter extends RecyclerView.Adapter<ThanhPhoAdapter.ViewHolder>  {

    // Danh sách để lưu trữ tất cả các chi tiết
        private ArrayList<CityItem> cityItems;
        private Context context;
        private TravelDB travelDB;

        public ThanhPhoAdapter(ArrayList<CityItem> cityItems, Context context){
            this.cityItems = cityItems;
            this.context = context;
        }

    // Vào viewHolders giúp hiển thị các mục trong
        @NonNull
        @Override
        public ThanhPhoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            travelDB = new TravelDB(context);
            //Create table first
            SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
            boolean firstStart = prefs.getBoolean("firstStart",true);
            if(firstStart){
                createTableOnFirstStart();
            }


            // Tăng chế độ xem bố cục đã tạo cho các hàng danh sách ở đây
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_thanhphoitem,
                    parent,false);
            return new ThanhPhoAdapter.ViewHolder(view);
        }
    // Phương thức này được gọi khi liên kết dữ liệu với các khung nhìn đang được tạo trong RecyclerView
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final CityItem cityItem= cityItems.get(position);

            readCursorData(cityItem,holder);
            // Đặt dữ liệu thành các chế độ xem ở đây
            // Sự cố pixel hình ảnh đã được giải quyết
            holder.imageView1.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(context.getResources(),cityItems.get(position).getImageResourse1(),100,100));
            holder.title1TextView.setText(cityItem.getTitle1());
            holder.countryNameTextView.setText(cityItem.getCountryname());
            holder.populationTextView.setText(cityItem.getPopulation());
            holder.citydescTextView.setText(cityItem.getCitydesc());
            holder.airportTextView.setText(cityItem.getAirport());


            // đặt trình nghe nhấp chuột thành các mục trực quan trong trình xem
            holder.relative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {   //set on click for cities list
                    Intent intent = new Intent(context, ThanhPhoDetails.class);
                    intent.putExtra("image1",cityItem.getImageResourse1());
                    intent.putExtra("title1TextView",cityItem.getTitle1());
                    intent.putExtra("countryNameTextView",cityItem.getCountryname());
                    intent.putExtra("populationTextView",cityItem.getPopulation());
                    intent.putExtra("citydescTextView",cityItem.getCitydesc());
                    intent.putExtra("airportTextView",cityItem.getAirport());
                    context.startActivity(intent);
                }
            });
        }



        @Override
        public int getItemCount() {
            return cityItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView1;
            TextView title1TextView;
            TextView countryNameTextView;
            TextView populationTextView;
            TextView citydescTextView;
            TextView airportTextView;
            RelativeLayout relative;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView1 = itemView.findViewById(R.id.imageView1);
                title1TextView= itemView.findViewById(R.id.title1TextView);
                countryNameTextView = itemView.findViewById(R.id.countryNameTextView);
                populationTextView=itemView.findViewById(R.id.populationTextView);
                citydescTextView = itemView.findViewById(R.id.citydescTextView);
                airportTextView = itemView.findViewById(R.id.airportTextView);
                relative = itemView.findViewById(R.id.relative);


            }
        }

        private void createTableOnFirstStart(){
            travelDB.insertEmpty();

            SharedPreferences prefs= context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart",false);
            editor.apply();
        }
        private void readCursorData(CityItem cityItem, ThanhPhoAdapter.ViewHolder viewHolder) {
            Cursor cursor = travelDB.read_all_city_data(cityItem.getKey_id1());
            SQLiteDatabase db = travelDB.getReadableDatabase();

            }



    }
