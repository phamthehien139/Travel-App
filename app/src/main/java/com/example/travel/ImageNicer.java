package com.example.travel;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageNicer {
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Chiều cao và chiều rộng  của hình ảnh
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            //Tính giá trị inSampleSize lớn nhất là lũy thừa của 2 và giữ nguyên cả hai
            //chiều cao và chiều rộng lớn hơn chiều cao và chiều rộng được yêu cầu
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }




    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {


        //Giải mã đầu tiên với inJustDecodeBounds = true để kiểm tra kích thước
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Tính kích thước inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        //Giải mã bitmap với bộ inSampleSize
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }





}
