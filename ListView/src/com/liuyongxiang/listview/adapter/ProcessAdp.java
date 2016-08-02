package com.liuyongxiang.listview.adapter;

import java.util.List;

import com.liuyongxiang.listview.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class ProcessAdp extends BaseAdapter {
	private Context context;
	private List<String> timeList;
	private List<String> contentList;

	public ProcessAdp(Context context, List<String> timeList,
			List<String> contentList) {
		super();
		this.context = context;
		this.timeList = timeList;
		this.contentList = contentList;
	}

	@Override
	public int getCount() {
		return contentList != null ? contentList.size() : 0;
	}

	@Override
	public Object getItem(int arg0) {
		return arg0;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_order_process, null);
			holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
			holder.tv_content = (TextView) convertView
					.findViewById(R.id.tv_content);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_time.setText(timeList.get(position));
		holder.tv_content.setText(contentList.get(position));

		return convertView;
	}

	public static class ViewHolder {
		TextView tv_time, tv_content;
	}
}
