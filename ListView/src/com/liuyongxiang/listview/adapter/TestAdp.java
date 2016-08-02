package com.liuyongxiang.listview.adapter;

import java.util.List;

import com.liuyongxiang.listview.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TestAdp extends BaseAdapter {
	private Context context;
	private int clickTemp = 0;
	List<String> docList;

	public TestAdp(Context context, List<String> docList) {
		super();
		this.context = context;
		this.docList = docList;
	}

	@Override
	public int getCount() {
		return docList != null ? docList.size() : 0;
	}

	@Override
	public Object getItem(int arg0) {
		return arg0;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 标识选择的Item
	public void setSeclection(int position) {
		clickTemp = position;
	}

	@SuppressLint({ "ResourceAsColor", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_grid_appoint_doc, null);
			holder.tv_appoint_doc_name = (TextView) convertView
					.findViewById(R.id.tv_appoint_doc_name);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_appoint_doc_name.setText(docList.get(position));
		if (position == clickTemp) { // 执行判断
			// 设置背景
			holder.tv_appoint_doc_name
					.setBackgroundResource(R.drawable.btn_gem_green);
			holder.tv_appoint_doc_name
					.setTextColor(Color.parseColor("#ffffff"));
		} else {
			holder.tv_appoint_doc_name
					.setBackgroundResource(R.drawable.btn_border_green);
			holder.tv_appoint_doc_name
					.setTextColor(Color.parseColor("#000000"));
		}
		if (clickTemp == position) {
			holder.tv_appoint_doc_name
					.setTextColor(Color.parseColor("#ffffff"));
		} else {
			holder.tv_appoint_doc_name
					.setTextColor(Color.parseColor("#000000"));
		}
		return convertView;
	}

	public static class ViewHolder {
		TextView tv_appoint_doc_name;
	}
}
