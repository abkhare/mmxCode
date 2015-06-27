package com.example.testing;

import java.util.List;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;


abstract public class BaseListFragment<T> extends Fragment
{
	private ListView mListView;
	private int mrowLayout;
	private List<T> mList;
	
	abstract protected void initListRowItem(View row, T data);
	
	public void setup(ListView listView, int rowLayout, List<T> list)
	{
		mListView = listView;
		mrowLayout = rowLayout;
		mList = list;
	}
	
	class Adapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			return mList.size();
		}

		@Override
		public Object getItem(int position) {
			return mList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View retView;
			if(convertView == null)
			{
				LayoutInflater inflater = getLayoutInflater(null);
				retView = inflater.inflate(mrowLayout, parent);
			}
			else
			{
				retView = convertView;
			}
			initListRowItem(retView, mList.get(position));
			
			return retView;
		}
		
	}
}
