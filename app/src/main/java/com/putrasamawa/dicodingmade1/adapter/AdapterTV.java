package com.putrasamawa.dicodingmade1.adapter;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.putrasamawa.dicodingmade1.DetailActivity;
import com.putrasamawa.dicodingmade1.R;
import com.putrasamawa.dicodingmade1.model.Item;
import com.putrasamawa.dicodingmade1.model.ItemMovie;
import com.putrasamawa.dicodingmade1.model.ItemTV;

import java.util.List;

//* Satria Junanda *//

public class AdapterTV extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "AdapterMovie";
    private Context context;
    private List<ItemTV> mMovieList;


    public AdapterTV(List<ItemTV> movieList) {
        mMovieList = movieList;
    }
    public AdapterTV(Context context) {
        this.context = context;
    }

    public List<ItemTV> getmMovieList() {
        return mMovieList;
    }

    public void setmMovieList(List<ItemTV> mMovieList) {
        this.mMovieList = mMovieList;
    }
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false));


    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mMovieList != null && mMovieList.size() > 0) {
            return mMovieList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends BaseViewHolder {

        ImageView ivThumbnail;
        TextView tvTitle;
        TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.imageView);
            tvTitle = itemView.findViewById(R.id.textView);
            tvDescription = itemView.findViewById(R.id.textView2);


        }

        protected void clear() {
            ivThumbnail.setImageDrawable(null);
            tvTitle.setText("");

        }

        public void onBind(int position) {
            super.onBind(position);

            final ItemTV mTV = mMovieList.get(position);
            try {
                if (mTV.getPoster_path() != null) {
                    Glide.with(itemView.getContext())
                            .load("https://image.tmdb.org/t/p/w342/" + mTV.getPoster_path())
                            .into(ivThumbnail);
                }

                if (mTV.getOriginal_title() != null) {
                    tvTitle.setText(mTV.getOriginal_title());
                }

                if (mTV.getOverview() != null) {
                    tvDescription.setText(mTV.getOverview());
                }
            } catch (Exception e) {

            }


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Item model = new Item(mTV.getOriginal_title(),mTV.getOverview(),mTV.getPoster_path(),String.valueOf(mTV.getId()),"tv");

                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                        intent.putExtra("Model", model);
                        intent.putExtra("key","tv");
                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }
    }

}

//* Satria Junanda *//
