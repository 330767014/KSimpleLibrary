package com.kot32.ksimpleframeworklibrary.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.kot32.ksimpleframeworklibrary.R;
import com.kot32.ksimpleframeworklibrary.model.Student;
import com.kot32.ksimplelibrary.util.common.adapter.SimpleBaseAdapter;

import java.util.List;

/**
 * Created by kot32 on 15/12/13.
 */
public class TestListAdapter extends SimpleBaseAdapter<Student> {
    public TestListAdapter(Context context, List<Student> data) {
        super(context, data);
    }

    @Override
    public int getItemResource() {
        return R.layout.test_list_item;
    }

    @Override
    public View getItemView(int position, View convertView, ViewHolder holder) {
        TextView textView = holder.getView(R.id.item_text);
        textView.setText("" + ((Student) getItem(position)).getUsername());
        return convertView;
    }

}
