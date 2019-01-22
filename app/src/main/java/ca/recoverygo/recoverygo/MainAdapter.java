package ca.recoverygo.recoverygo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

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

    public MainAdapter(ArrayList<String>name,
                       ArrayList<String>street,
                       ArrayList<String>city,
                       ArrayList<String>prov,
                       ArrayList<String>pcode,
                       ArrayList<String>phone1,
                       ArrayList<String>phone2,
                       ArrayList<String>type,
                       ArrayList<String>access,
                       ArrayList<String>capacity,
                       ArrayList<String>email,
                       ArrayList<String>website,
                       ArrayList<String>logo) {

        mName       = name;
        mStreet     = street;
        mCity       = city;
        mProv       = prov;
        mPcode      = pcode;
        mPhone1     = phone1;
        mPhone2     = phone2;
        mType       = type;
        mAccess     = access;
        mBeds       = capacity;
        mEmail      = email;
        mWebsite    = website;
        mLogo       = logo;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        TextView mStreet;
        TextView mCity;
        TextView mProv;
        TextView mPcode;
        TextView mPhone1;
        TextView mPhone2;
        TextView mType;
        TextView mAccess;
        TextView mBeds;
        TextView mEmail;
        TextView mWebsite;
        ImageView mLogo;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.full_name);
            mStreet = itemView.findViewById(R.id.street);
            mCity = itemView.findViewById(R.id.city);
            mProv = itemView.findViewById(R.id.prov);
            mPcode = itemView.findViewById(R.id.pcode);
            mPhone1 = itemView.findViewById(R.id.phone1);
            mPhone2 = itemView.findViewById(R.id.phone2);
            mType = itemView.findViewById(R.id.type);
            mAccess = itemView.findViewById(R.id.access);
            mBeds = itemView.findViewById(R.id.capacity);
            mEmail = itemView.findViewById(R.id.email);
            mWebsite = itemView.findViewById(R.id.website);
            mLogo = itemView.findViewById(R.id.logo_img);
        }
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mName.setText(mName.get(position));
        holder.mStreet.setText(mStreet.get(position));
        holder.mCity.setText(mCity.get(position));
        holder.mProv.setText(mProv.get(position));
        holder.mPcode.setText(mPcode.get(position));
        holder.mPhone1.setText(mPhone1.get(position));
        holder.mPhone2.setText(mPhone2.get(position));
        holder.mType.setText(mType.get(position));
        holder.mAccess.setText(mAccess.get(position));
        holder.mBeds.setText(mBeds.get(position));
        holder.mEmail.setText(mEmail.get(position));
        holder.mWebsite.setText(mWebsite.get(position));
        holder.mLogo.setImageResource(Integer.parseInt(String.valueOf(mLogo.get(position))));
        // holder.mLogo.setImageResource(mLogo[position])
    }

    @Override
    public int getItemCount() {
        return mName.size();
    }
}


