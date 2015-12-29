package com.smallwei.day2demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.List;

/**
 * Created by smallwei on 2015/12/29.
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<ListItem> items;

    public MyAdapter(Context context, List<ListItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        if(items!=null){
            return  items.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_layout, parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ListItem item = items.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        if (item.getName() != null) {
            holder.name.setText(item.getName());
            Picasso.with(context).load(Utils.getIconURL(item.getId(), item.getIcon()))
                    .transform(new Circle())
                    .into(holder.icon);
        } else {
            holder.name.setText("匿名用户");
            holder.icon.setImageResource(R.mipmap.ic_launcher);
        }
        if (item.getImage() == null) {
            holder.image.setVisibility(View.GONE);
        } else {
            holder.image.setVisibility(View.VISIBLE);
            Picasso.with(context)
                    .load(Utils.getImageURL(item.getImage()))
                    .resize(parent.getWidth(), 0)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.image);
        }
        holder.context.setText(item.getContent());


        return convertView;
    }
    private static class ViewHolder {
        ImageView icon, image;
        TextView name, context;

        public ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.user_icon);
            name = (TextView) view.findViewById(R.id.user_name);
            context = (TextView) view.findViewById(R.id.user_content);
            image = (ImageView) view.findViewById(R.id.user_image);
        }
    }
    public void addAll(Collection<? extends ListItem> collection){
        items.addAll(collection);
        notifyDataSetChanged();
    }
}
