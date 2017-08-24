package com.master.gradualchangetoolbar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class TextAdapter extends RecyclerView.Adapter<TextAdapter.Holder> {
    private Context mContext;
    private List<Object> mTexts;
    private Boolean isLong = true;


    public TextAdapter(Context context, List<Object> mTexts) {
        mContext = context;
        this.mTexts = mTexts;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tv.setText((String) mTexts.get(position));
    }

    @Override
    public int getItemCount() {
        return mTexts.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private final TextView tv;

        Holder(View itemView) {
            super(itemView);
            View main = itemView.findViewById(R.id.main);
            main.setOnClickListener(this);
            main.setOnLongClickListener(this);
            tv = (TextView) itemView.findViewById(R.id.tvset);
            View bt = itemView.findViewById(R.id.btset);
            tv.setOnClickListener(this);
            bt.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tvset:
                    Toast.makeText(v.getContext(), "点击了文字，位置为：" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.main:
                    if (!isLong) {
                        isLong = true;

                    } else {

                        Toast.makeText(v.getContext(), "点击了条目布局，位置为：" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }

        @Override
        public boolean onLongClick(View v) {
            switch (v.getId()) {
                case R.id.main:
                    Toast.makeText(v.getContext(), "长按了条目布局，位置为：" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    isLong = false;
                    break;
            }
            return false;
        }
    }
}
