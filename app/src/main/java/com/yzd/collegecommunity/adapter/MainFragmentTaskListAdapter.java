package com.yzd.collegecommunity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yzd.collegecommunity.R;
import com.yzd.collegecommunity.modeal.MainTaskListInfo;
import com.yzd.collegecommunity.util.AppCenterUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.yzd.collegecommunity.R.id.tv_username;

/**
 * Created by Laiyin on 2017/3/6.
 */

public class MainFragmentTaskListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private List<MainTaskListInfo> list;
    private int layoutId;

    public MainFragmentTaskListAdapter(Context context, int layoutId, List<MainTaskListInfo> list) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(mContext);
        this.list = list;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(layoutId, null);
            viewHolder.ib_head_picture = (CircleImageView) view.findViewById(R.id.ib_head_picture);
            viewHolder.iv_task_picture = (ImageView) view.findViewById(R.id.iv_task_picture);
            viewHolder.tv_username = (TextView) view.findViewById(tv_username);
            viewHolder.tv_describe = (TextView) view.findViewById(R.id.tv_describe);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.ib_head_picture.setTag(i);
        viewHolder.tv_describe.setText(list.get(i).getIntroduce());
//        BmobFile file=new BmobFile(System.currentTimeMillis()+".png","",list.get(i).getPicUrl());
//        if (list.get(i).getPicUrl()!=null){
//            Bitmap bitmap=downloadFile(file,i);
//        }else {
//            viewHolder.mm_v1_Image.setImageResource(R.drawable.my_listview);
//        }

//        if(TextUtils.isEmpty(list.get(i).getUsername())){
//
//        }

        viewHolder.tv_username.setText(list.get(i).getUsername());
        viewHolder.tv_username.setText(list.get(i).getUsername());
        list.get(i).getPic();
        Glide.with(AppCenterUtil.getContextObject())
                .load(list.get(i).getPic())
                .into(viewHolder.ib_head_picture);

        return view;
    }

    class ViewHolder {
        CircleImageView ib_head_picture;
        ImageView iv_task_picture;     //任务列表头像
        TextView tv_describe;          //任务描述
        TextView tv_username;          //用户名
    }
}
