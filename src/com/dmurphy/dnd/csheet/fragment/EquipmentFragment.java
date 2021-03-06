package com.dmurphy.dnd.csheet.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dmurphy.dnd.csheet.MainActivity;
import com.dmurphy.dnd.csheet.R;

public class EquipmentFragment extends Fragment {
	private MainActivity activity;
	private Vibrator vibe;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    	
		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.equipment_fragment, container, false);
		
		activity = (MainActivity) getActivity();
		vibe = activity.getVibe();
		
		Button previous = (Button) v.findViewById(R.id.previousButton);
		Button next = (Button) v.findViewById(R.id.nextButton);
		
		TextView gold = (TextView) v.findViewById(R.id.gold);
		gold.setText(activity.getCharacter().getWealth() + "");
		
		next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				vibe.vibrate(50);		
				activity.swapFragment(new SheetFragment(), "character_sheet");
			}	
		});
		
		previous.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vibe.vibrate(50);
				getFragmentManager().popBackStack();
			}	
		});

		return v;
    }

}
