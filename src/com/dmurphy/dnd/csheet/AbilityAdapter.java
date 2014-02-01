package com.dmurphy.dnd.csheet;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dmurphy.dnd.csheet.character.Power;

public class AbilityAdapter extends BaseAdapter {

	/** Remember our context so we can use it when constructing views. */
	private Context mContext;

	/**
	 * Hold onto a copy of the entire Contact List.
	 */
	private List<Power> mItems = new ArrayList<Power>();

	public AbilityAdapter(Context context, ArrayList<Power> items) {
		mContext = context;
		mItems = items;
	}

	public int getCount() {
		return mItems.size();
	}

	public Object getItem(int position) {
		return mItems.get(position);
	}

	/** Use the array index as a unique id. */
	public long getItemId(int position) {
		return position;
	}

	/**
	 * @param convertView
	 *            The old view to overwrite, if one is passed
	 * @returns a ContactEntryView that holds wraps around an ContactEntry
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		AbilityView v;
		if (convertView == null) {
			v = new AbilityView(mContext, mItems.get(position));
		} else {
			v = (AbilityView) convertView;
			String name = mItems.get(position).getName();
			v.getName().setText(name);
		}
		return v;
	}
}