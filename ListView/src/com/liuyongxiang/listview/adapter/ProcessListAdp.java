package com.liuyongxiang.listview.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuyongxiang.listview.R;
import com.liuyongxiang.listview.bean.TypeBean;
import com.liuyongxiang.listview.custom.CustomGridView;
import com.liuyongxiang.listview.custom.CustomListView;

public class ProcessListAdp extends BaseAdapter {
	private Context context;
	private List<TypeBean> mTypeList;
	private LayoutInflater inflater;
	List<String> leaderList;
	List<String> timeList;
	List<String> contentList;
	List<String> eastTimeList;
	List<String> eastContentList;
	List<String> bankList;
	List<String> docList;
	List<String> cashList;
	List<String> medicalList;
	List<String> flightList;
	List<String> taskList;
	public static final int APPOINT_DOC = 0;
	public static final int INFORM_CLIENT = 1;
	public static final int REQUEST_EXPERT = 2;
	public static final int INFORM_AVIATION = 3;
	public static final int APPLY_LEADER = 4;
	public static final int PREPARE_TAKE_OFF = 5;
	public static final int ORDER_FINISH = 6;
	boolean isPay;

	class ViewHolder1 {
		TextView tv_start_doc_time, tv_title;
		CustomGridView gv_start_doc_name;
		boolean flag_start_doc;
		boolean flag_start_time;
		boolean flag_start_doc_appoint;
		boolean flag_doc_isProcessed;
		boolean flag_doc_isFinished;
		boolean flag_doc_appoint;
		Button btn_start_sure;
		LinearLayout ll_start_appoint_doc, ll_start_appoint_content;

		ViewHolder1(View view) {
			tv_start_doc_time = (TextView) view
					.findViewById(R.id.tv_start_doc_time);
			tv_title = (TextView) view.findViewById(R.id.tv_title);
			gv_start_doc_name = (CustomGridView) view
					.findViewById(R.id.gv_start_doc_name);
			ll_start_appoint_doc = (LinearLayout) view
					.findViewById(R.id.ll_start_appoint_doc);
			ll_start_appoint_content = (LinearLayout) view
					.findViewById(R.id.ll_start_appoint_content);
			btn_start_sure = (Button) view.findViewById(R.id.btn_start_sure);
		}

	}

	class ViewHolder2 {
		TextView tv_bank_card_id, tv_bank, tv_first_aid, tv_title,
				tv_start_cash_time;
		LinearLayout ll_start_inform_client, ll_inform_client_pay;
		CustomGridView gv_cash_appoint;
		Button btn_cash_appoint, btn_client_upload;
		CustomListView lv_east;
		boolean flag_inform_client;
		boolean flag_inform_do_pro;
		boolean flag_inform_do_pro_appoint;
		boolean flag_cash_isProcessed;
		boolean flag_cash_isFinished;
		boolean flag_client_insure;
		boolean flag_affirm_gathering;
		boolean flag_cash_appoint;

		ViewHolder2(View view) {
			btn_cash_appoint = (Button) view
					.findViewById(R.id.btn_cash_appoint);
			btn_client_upload = (Button) view
					.findViewById(R.id.btn_client_upload);
			gv_cash_appoint = (CustomGridView) view
					.findViewById(R.id.gv_cash_appoint);
			tv_bank_card_id = (TextView) view
					.findViewById(R.id.tv_bank_card_id);
			tv_first_aid = (TextView) view.findViewById(R.id.tv_first_aid);
			tv_start_cash_time = (TextView) view
					.findViewById(R.id.tv_start_cash_time);
			tv_bank = (TextView) view.findViewById(R.id.tv_bank);
			tv_title = (TextView) view.findViewById(R.id.tv_title);
			ll_start_inform_client = (LinearLayout) view
					.findViewById(R.id.ll_start_inform_client);
			ll_inform_client_pay = (LinearLayout) view
					.findViewById(R.id.ll_inform_client_pay);
			lv_east = (CustomListView) view.findViewById(R.id.lv_east);
		}

	}

	class ViewHolder3 {
		TextView tv_start_expert_time, tv_title;
		LinearLayout ll_start_request_expert, ll_start_request_expert_content;
		boolean flag_request_expert;
		boolean flag_request_expert_appoint;
		boolean flag_expert_isProcessed;
		boolean flag_expert_isFinished;
		Button btn_expert_appoint;
		CustomGridView gv_start_request_name;
		boolean flag_expert_appoint;

		ViewHolder3(View view) {
			ll_start_request_expert = (LinearLayout) view
					.findViewById(R.id.ll_start_request_expert);
			btn_expert_appoint = (Button) view
					.findViewById(R.id.btn_expert_appoint);
			tv_title = (TextView) view.findViewById(R.id.tv_title);
			tv_start_expert_time = (TextView) view
					.findViewById(R.id.tv_start_expert_time);
			ll_start_request_expert_content = (LinearLayout) view
					.findViewById(R.id.ll_start_request_expert_content);
			gv_start_request_name = (CustomGridView) view
					.findViewById(R.id.gv_start_request_name);
		}

	}

	class ViewHolder4 {
		LinearLayout ll_start_inform_aviation,
				ll_start_inform_aviation_content;
		boolean flag_inform_aviation;
		boolean flag_inform_aviation_appoint;
		boolean flag_aviation_isProcessed;
		boolean flag_aviation_isFinished;
		Button btn_aviation_appoint;
		CustomListView lv_start_aoc;
		TextView tv_title, tv_start_aviation_time;
		boolean flag_aviation_appoint;

		ViewHolder4(View view) {
			ll_start_inform_aviation = (LinearLayout) view
					.findViewById(R.id.ll_start_inform_aviation);
			btn_aviation_appoint = (Button) view
					.findViewById(R.id.btn_aviation_appoint);
			ll_start_inform_aviation_content = (LinearLayout) view
					.findViewById(R.id.ll_start_inform_aviation_content);
			lv_start_aoc = (CustomListView) view
					.findViewById(R.id.lv_start_aoc);
			tv_title = (TextView) view.findViewById(R.id.tv_title);
			tv_start_aviation_time = (TextView) view
					.findViewById(R.id.tv_start_aviation_time);
		}

	}

	class ViewHolder5 {
		TextView tv_apply_note, tv_apply_phone, tv_start_apply_leader_time;
		LinearLayout ll_start_apply_leader, ll_apply_leader_content;
		boolean flag_apply_leader;

		ViewHolder5(View view) {
			ll_start_apply_leader = (LinearLayout) view
					.findViewById(R.id.ll_start_apply_leader);
			ll_apply_leader_content = (LinearLayout) view
					.findViewById(R.id.ll_apply_leader_content);
			tv_apply_note = (TextView) view.findViewById(R.id.tv_apply_note);
			tv_apply_phone = (TextView) view.findViewById(R.id.tv_apply_phone);
			tv_start_apply_leader_time = (TextView) view
					.findViewById(R.id.tv_start_apply_leader_time);
		}

	}

	class ViewHolder6 {
		TextView tv_start_doc_time, tv_sure_take_off, tv_sure_take_off_time;
		LinearLayout ll_sure_take_off;
		boolean flag_take_off;

		ViewHolder6(View view) {
			tv_sure_take_off_time = (TextView) view
					.findViewById(R.id.tv_sure_take_off_time);
			tv_sure_take_off = (TextView) view
					.findViewById(R.id.tv_sure_take_off);
			ll_sure_take_off = (LinearLayout) view
					.findViewById(R.id.ll_sure_take_off);
		}

	}

	class ViewHolder7 {
		TextView tv_order_finish;

		ViewHolder7(View view) {
			tv_order_finish = (TextView) view
					.findViewById(R.id.tv_order_finish);
		}

	}

	// 返回 代表某一个样式 的 数值
	public ProcessListAdp(Context context, List<TypeBean> mTypeList,
			List<String> leaderList, List<String> bankList,
			List<String> docList, List<String> cashList,
			List<String> medicalList, List<String> flightList,
			List<String> taskList, List<String> timeList,
			List<String> contentList, List<String> eastTimeList,
			List<String> eastContentList) {
		super();
		this.context = context;
		this.mTypeList = mTypeList;
		inflater = LayoutInflater.from(context);
		this.leaderList = leaderList;
		this.bankList = bankList;
		this.docList = docList;
		this.cashList = cashList;
		this.medicalList = medicalList;
		this.flightList = flightList;
		this.taskList = taskList;
		this.timeList = timeList;
		this.contentList = contentList;
		this.eastTimeList = eastTimeList;
		this.eastContentList = eastContentList;
	}

	@Override
	public int getCount() {
		return mTypeList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public int getItemViewType(int position) {
		return mTypeList.get(position).type;
	}

	@Override
	public int getViewTypeCount() {
		return mTypeList.size();
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		int type = getItemViewType(position);
		final ViewHolder1 holder1;
		final ViewHolder2 holder2;
		final ViewHolder3 holder3;
		final ViewHolder4 holder4;
		final ViewHolder5 holder5;
		final ViewHolder6 holder6;
		final ViewHolder7 holder7;
		if (convertView == null) {
			// 选择某一个样式。。
			switch (type) {
			case APPOINT_DOC:
				convertView = inflater.inflate(R.layout.item_start_appoint_doc,
						null);
				holder1 = new ViewHolder1(convertView);
				holder1.flag_start_doc = true;
				holder1.flag_start_time = true;
				holder1.flag_start_doc_appoint = true;
				holder1.flag_doc_appoint = true;
				holder1.ll_start_appoint_doc
						.setBackgroundResource(R.drawable.right_blue);
				holder1.ll_start_appoint_doc
						.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View view) {
								if (holder1.flag_start_doc) {
									holder1.flag_start_doc = false;
									holder1.ll_start_appoint_content
											.setVisibility(View.VISIBLE);
									holder1.ll_start_appoint_doc
											.setBackgroundResource(R.drawable.down_blue);
								} else {
									holder1.flag_start_doc = true;
									holder1.ll_start_appoint_content
											.setVisibility(View.GONE);
									holder1.ll_start_appoint_doc
											.setBackgroundResource(R.drawable.right_blue);
								}
							}
						});
				final TestAdp testAdp = new TestAdp(
						context, docList);
				holder1.gv_start_doc_name.setAdapter(testAdp);
				holder1.gv_start_doc_name
						.setOnItemClickListener(new Gallery.OnItemClickListener() {
							@SuppressLint("ResourceAsColor")
							@Override
							public void onItemClick(AdapterView<?> parent,
									View view, int position, long arg3) {
								holder1.flag_doc_appoint = false;
								for (int i = 0; i < parent.getCount(); i++) {
									View v = parent.getChildAt(i);
									if (position == i) {// 当前选中的Item改变背景颜色
										view.setBackgroundResource(R.drawable.btn_gem_green);
										testAdp
												.setSeclection(position);
										testAdp.notifyDataSetChanged();
									} else {
										v.setBackgroundResource(R.drawable.btn_border_green);
									}
								}
							}
						});
				holder1.btn_start_sure
						.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View arg0) {
							}
						});
				convertView.setTag(holder1);
				break;
			case INFORM_CLIENT:
				convertView = inflater.inflate(
						R.layout.item_start_inform_client, null);
				holder2 = new ViewHolder2(convertView);
				holder2.flag_inform_client = true;
				holder2.flag_inform_do_pro = true;
				holder2.flag_cash_appoint = true;
				holder2.flag_inform_do_pro_appoint = true;
				isPay = false;
				final ProcessAdp eastAdp = new ProcessAdp(context, eastTimeList,
						eastContentList);
				holder2.lv_east.setAdapter(eastAdp);
				eastAdp.notifyDataSetChanged();
				holder2.ll_start_inform_client
						.setBackgroundResource(R.drawable.right_blue);
				holder2.ll_start_inform_client
						.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View arg0) {
								if (holder2.flag_inform_client) {
									holder2.flag_inform_client = false;
									holder2.ll_inform_client_pay
											.setVisibility(View.VISIBLE);
									holder2.ll_start_inform_client
											.setBackgroundResource(R.drawable.down_blue);
								} else {
									holder2.flag_inform_client = true;
									holder2.ll_inform_client_pay
											.setVisibility(View.GONE);
									holder2.ll_start_inform_client
											.setBackgroundResource(R.drawable.right_blue);
								}
							}
						});
				final TestAdp cashAdp = new TestAdp(context,
						cashList);
				holder2.gv_cash_appoint.setAdapter(cashAdp);
				holder2.btn_client_upload
						.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View arg0) {
							}
						});
				holder2.gv_cash_appoint
						.setOnItemClickListener(new Gallery.OnItemClickListener() {
							@SuppressLint("ResourceAsColor")
							@Override
							public void onItemClick(AdapterView<?> parent,
									View view, int position, long arg3) {
								holder2.flag_cash_appoint = false;
								for (int i = 0; i < parent.getCount(); i++) {
									View v = parent.getChildAt(i);
									if (position == i) {// 当前选中的Item改变背景颜色
										view.setBackgroundResource(R.drawable.btn_gem_green);
										cashAdp
												.setSeclection(position);
										cashAdp.notifyDataSetChanged();
									} else {
										v.setBackgroundResource(R.drawable.btn_border_green);
									}
								}
							}
						});
				holder2.btn_cash_appoint
						.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View view) {
							}
						});
				holder2.flag_client_insure = true;
				holder2.flag_affirm_gathering = true;
				convertView.setTag(holder2);
				break;
			case REQUEST_EXPERT:
				convertView = inflater.inflate(
						R.layout.item_start_request_expert, null);
				holder3 = new ViewHolder3(convertView);
				holder3.flag_request_expert = true;
				holder3.flag_request_expert_appoint = true;
				holder3.flag_expert_appoint = true;
				holder3.ll_start_request_expert
						.setBackgroundResource(R.drawable.right_blue);
				holder3.ll_start_request_expert
						.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View arg0) {
								if (holder3.flag_request_expert) {
									holder3.flag_request_expert = false;
									holder3.ll_start_request_expert_content
											.setVisibility(View.VISIBLE);
									holder3.ll_start_request_expert
											.setBackgroundResource(R.drawable.down_blue);
								} else {
									holder3.flag_request_expert = true;
									holder3.ll_start_request_expert_content
											.setVisibility(View.GONE);
									holder3.ll_start_request_expert
											.setBackgroundResource(R.drawable.right_blue);
								}

							}
						});

				final TestAdp expertAdp = new TestAdp(
						context, medicalList);

				holder3.gv_start_request_name.setAdapter(expertAdp);
				holder3.gv_start_request_name
						.setOnItemClickListener(new Gallery.OnItemClickListener() {
							@SuppressLint("ResourceAsColor")
							@Override
							public void onItemClick(AdapterView<?> parent,
									View view, int position, long arg3) {
								holder3.flag_expert_appoint = false;
								for (int i = 0; i < parent.getCount(); i++) {
									View v = parent.getChildAt(i);
									if (position == i) {// 当前选中的Item改变背景颜色
										view.setBackgroundResource(R.drawable.btn_gem_green);
										expertAdp
												.setSeclection(position);
										expertAdp.notifyDataSetChanged();
									} else {
										v.setBackgroundResource(R.drawable.btn_border_green);
									}
								}
							}
						});
				holder3.btn_expert_appoint
						.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View view) {
								holder3.ll_start_request_expert
										.setBackgroundResource(R.drawable.btn_red);
							}
						});
				convertView.setTag(holder3);
				break;
			case INFORM_AVIATION:
				convertView = inflater.inflate(
						R.layout.item_start_inform_aviation, null);
				holder4 = new ViewHolder4(convertView);
				holder4.flag_inform_aviation = true;
				holder4.flag_inform_aviation_appoint = true;
				holder4.flag_aviation_appoint = true;
				final ProcessAdp adp = new ProcessAdp(context, timeList,
						contentList);
				holder4.lv_start_aoc.setAdapter(adp);
				adp.notifyDataSetChanged();
				holder4.ll_start_inform_aviation
						.setBackgroundResource(R.drawable.right_blue);
				holder4.ll_start_inform_aviation
						.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View arg0) {

								if (holder4.flag_inform_aviation) {
									holder4.flag_inform_aviation = false;
									holder4.ll_start_inform_aviation_content
											.setVisibility(View.VISIBLE);
									holder4.ll_start_inform_aviation
											.setBackgroundResource(R.drawable.down_blue);
								} else {
									holder4.flag_inform_aviation = true;
									holder4.ll_start_inform_aviation_content
											.setVisibility(View.GONE);
									holder4.ll_start_inform_aviation
											.setBackgroundResource(R.drawable.right_blue);
								}
							}
						});
				holder4.btn_aviation_appoint
						.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View view) {

							}
						});
				convertView.setTag(holder4);
				break;
			case APPLY_LEADER:
				convertView = inflater.inflate(
						R.layout.item_start_apply_leader, null);
				holder5 = new ViewHolder5(convertView);
				holder5.flag_apply_leader = true;
				holder5.ll_start_apply_leader
						.setBackgroundResource(R.drawable.right_purplre);
				final String leaderPhone = leaderList.get(0);
				holder5.ll_start_apply_leader
						.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View arg0) {
								if (holder5.flag_apply_leader) {
									holder5.flag_apply_leader = false;
									holder5.ll_apply_leader_content
											.setVisibility(View.VISIBLE);
									holder5.ll_start_apply_leader
											.setBackgroundResource(R.drawable.down_purplre);
								} else {
									holder5.flag_apply_leader = true;
									holder5.ll_apply_leader_content
											.setVisibility(View.GONE);
									holder5.ll_start_apply_leader
											.setBackgroundResource(R.drawable.right_purplre);
								}
							}
						});
				holder5.tv_apply_note.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						Intent intent = new Intent();
						// 系统默认的action，用来打开默认的短信界面
						intent.setAction(Intent.ACTION_SENDTO);
						// 需要发短息的号码
						intent.setData(Uri.parse("smsto:" + leaderPhone));
						context.startActivity(intent);

					}
				});
				holder5.tv_apply_phone
						.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View arg0) {
							}
						});
				convertView.setTag(holder5);
				break;
			case PREPARE_TAKE_OFF:
				convertView = inflater.inflate(
						R.layout.item_start_prepare_take_off, null);
				holder6 = new ViewHolder6(convertView);
					holder6.tv_sure_take_off
							.setBackgroundResource(R.color.bg_red);
				convertView.setTag(holder6);
				break;
			case ORDER_FINISH:
				convertView = inflater.inflate(
						R.layout.item_start_order_finish, null);
				holder7 = new ViewHolder7(convertView);
					holder7.tv_order_finish
							.setBackgroundResource(R.color.bg_gem_green);
				convertView.setTag(holder7);
				break;
			}
		} else {
			switch (type) {
			case APPOINT_DOC:
				holder1 = (ViewHolder1) convertView.getTag();
				break;
			case INFORM_CLIENT:
				holder2 = (ViewHolder2) convertView.getTag();
				break;
			case REQUEST_EXPERT:
				holder3 = (ViewHolder3) convertView.getTag();
				break;
			case INFORM_AVIATION:
				holder4 = (ViewHolder4) convertView.getTag();
				break;
			case APPLY_LEADER:
				holder5 = (ViewHolder5) convertView.getTag();
				break;
			case PREPARE_TAKE_OFF:
				holder6 = (ViewHolder6) convertView.getTag();
				break;
			case ORDER_FINISH:
				holder7 = (ViewHolder7) convertView.getTag();
				break;
			}
		}
		return convertView;
	}
}
