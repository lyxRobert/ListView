package com.liuyongxiang.listview.activities;

import java.util.ArrayList;
import java.util.List;

import com.liuyongxiang.listview.R;
import com.liuyongxiang.listview.adapter.ProcessListAdp;
import com.liuyongxiang.listview.bean.TypeBean;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
	private List<TypeBean> typeList;
	private List<String> titleList = new ArrayList<String>();
	private ListView lv_process;
	private ProcessListAdp adapter;
	private List<String> mParasList = new ArrayList<String>();
	private List<String> mBankList = new ArrayList<String>();
	private List<String> mDocList = new ArrayList<String>();
	private List<String> mCashList;
	private List<String> mMedicalList = new ArrayList<String>();
	private List<String> mFlightList = new ArrayList<String>();
	private List<String> mTimeList = new ArrayList<String>();
	private List<String> mContentList = new ArrayList<String>();
	List<String> mEastTimeList = new ArrayList<String>();
	List<String> mEastContentList = new ArrayList<String>();
	List<String> mTaskList = new ArrayList<String>();
	List<String> mStateList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initDatas();
	}

	public List<TypeBean> getListData() {
		// 标题
		titleList.add("希望此demo对您有帮助");
		titleList.add("欢迎下载");
		titleList.add("请提出更好的建议");
		titleList.add("如果有更好的请更新到github上面");
		titleList.add("欢迎前去本人的csdn技术博客");
		titleList.add("欢迎前去本人的github");
		titleList.add("谢谢您的配合！！");
		typeList = new ArrayList<TypeBean>();
		for (int i = 0; i < titleList.size(); i++) {
			TypeBean bean = new TypeBean();
			if (i == 0) {
				bean.type = 0;
			} else if (i == 1) {
				bean.type = 1;
			} else if (i == 2) {
				bean.type = 2;
			} else if (i == 3) {
				bean.type = 3;
			} else if (i == 4) {
				bean.type = 4;
			} else if (i == 5) {
				bean.type = 5;
			} else if (i == 6) {
				bean.type = 6;
			} else if (i == 7) {
				bean.type = 7;
			}
			typeList.add(bean);
		}
		return typeList;
	}

	private void initDatas() {
		// 标题时间
		mCashList = new ArrayList<String>();
		mCashList.add("刘秀");
		mCashList.add("刘庄");
		mCashList.add("刘炟");
		mCashList.add("刘肇");
		mCashList.add("刘隆");
		mCashList.add("刘祜");
		mCashList.add("刘懿");
		mCashList.add("刘保");
		mCashList.add("刘炳");
		mCashList.add("刘缵");
		mCashList.add("刘志");
		mCashList.add("刘宏");
		mCashList.add("刘辩");
		mCashList.add("刘协");

		mMedicalList.add("李渊");
		mMedicalList.add("李世民");
		mMedicalList.add("李治");
		mMedicalList.add("李显");
		mMedicalList.add("李旦");
		mMedicalList.add("李隆基");
		mMedicalList.add("李亨");
		mMedicalList.add("李豫");
		mMedicalList.add("李适");
		mMedicalList.add("李诵");
		mMedicalList.add("李纯");
		mMedicalList.add("李恒");
		mMedicalList.add("李湛");
		mMedicalList.add("李昂");
		mMedicalList.add("李炎");
		mMedicalList.add("李忱");
		mMedicalList.add("李漼");
		mMedicalList.add("李儇");
		mMedicalList.add("李晔");
		mMedicalList.add("李柷");

		mContentList.add("希望此demo对您有帮助");
		mContentList.add("欢迎下载");
		mContentList.add("请提出更好的建议");
		mContentList.add("如果能够修改更好的请更新到github上面");
		mContentList.add("欢迎前去本人的csdn技术博客");
		mContentList.add("欢迎前去本人的github");
		mContentList.add("谢谢您的配合！！");

		mTimeList.add("2016-07-18 09:23:14");
		mTimeList.add("2016-07-19 09:23:14");
		mTimeList.add("2016-07-20 09:23:14");
		mTimeList.add("2016-07-21 09:23:14");
		mTimeList.add("2016-07-22 09:23:14");
		mTimeList.add("2016-07-23 09:23:14");
		mTimeList.add("2016-07-25 09:23:14");

		mEastTimeList.add("2016-07-18 09:23:14");
		mEastTimeList.add("2016-07-18 09:23:14");
		mEastTimeList.add("2016-07-18 09:23:14");
		mEastTimeList.add("2016-07-18 09:23:14");

		mEastContentList.add("如果能够修改更好的请更新到github上面");
		mEastContentList.add("欢迎前去本人的csdn技术博客");
		mEastContentList.add("欢迎前去本人的github");
		mEastContentList.add("谢谢您的配合！！");
		
		mDocList.add("刘邦");
		mDocList.add("刘盈");
		mDocList.add("刘恭");
		mDocList.add("刘弘");
		mDocList.add("刘恒");
		mDocList.add("刘启");
		mDocList.add("刘彻");
		mDocList.add("刘弗陵");
		mDocList.add("刘贺");
		mDocList.add("刘询");
		mDocList.add("刘奭");
		mDocList.add("刘骜");
		mDocList.add("刘欣");
		mDocList.add("刘箕子");
		mDocList.add("刘婴");

		mParasList.add("15312345678");
		mParasList.add("15312345678");

		adapter = new ProcessListAdp(MainActivity.this, getListData(),
				mParasList, mBankList, mDocList, mCashList, mMedicalList,
				mFlightList, mTaskList, mTimeList, mContentList, mEastTimeList,
				mEastContentList);
		lv_process.setAdapter(adapter);
	}

	private void initView() {
		lv_process = (ListView) findViewById(R.id.lv_process);

	}

}
