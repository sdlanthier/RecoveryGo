package ca.recoverygo.recoverygo;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<String> mName;
    ArrayList<String> mStreet;
    ArrayList<String> mCity;
    ArrayList<String> mProv;
    ArrayList<String> mPcode;
    ArrayList<String> mPhone1;
    ArrayList<String> mPhone2;
    ArrayList<String> mType;
    ArrayList<String> mAccess;
    ArrayList<String> mBeds;
    ArrayList<String> mEmail;
    ArrayList<String> mWebsite;
    ArrayList<String> mLogo;

    // public RecyclerAdapter(ArrayList<String>name,ArrayList<String>street) {
    // mName       = name;
    // mStreet     = street;
    // }

    /* ------------------------------------------------------------ */
    //private String[] titles = mName.toArray(new String[0]);
    private String[] titles = {"Chapter One",
            "Chapter Two",
            "Chapter Three",
            "Chapter Four",
            "Chapter Five",
            "Chapter Six",
            "Chapter Seven",
            "Chapter Eight"};

    private String[] details = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item five details",
            "Item six details", "Item seven details",
            "Item eight details"};

    private int[] images = {
            R.drawable.img_1,
            R.drawable.android_image_2,
            R.drawable.android_image_3,
            R.drawable.android_image_4,
            R.drawable.android_image_5,
            R.drawable.android_image_6,
            R.drawable.android_image_7,
            R.drawable.android_image_8};
    /* ------------------------------------------------------------ */

    class ViewHolder extends RecyclerView.ViewHolder {

        ArrayList<String> name;
        ImageView itemImage;
        TextView itemTitle;
        private TextView itemDetail;


        ViewHolder(View itemView) {
            super(itemView);
            itemImage  = itemView.findViewById(R.id.item_image);
            itemTitle  = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {int position = getAdapterPosition();
                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show(); }});
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

}