package com.udylity.easyphone;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.Contacts.Phones;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Phonecontacts extends ListActivity {
	private ListAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Cursor c = getContentResolver().query(People.CONTENT_URI, null, null,
				null, null);
		startManagingCursor(c);

		String[] columns = new String[] { People.NAME };
		int[] names = new int[] { R.id.row_entry };

		mAdapter = new SimpleCursorAdapter(this, R.layout.phonecontacts, c, columns,
				names);
		setListAdapter(mAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent callfromcontactsIntent = new Intent(Intent.ACTION_CALL);

		Cursor c = (Cursor) mAdapter.getItem(position);
			
		String phoneId = c.getString(c.getColumnIndex(People.PRIMARY_PHONE_ID));
		
		callfromcontactsIntent.setData(Uri.withAppendedPath(Phones.CONTENT_URI, phoneId));
		startActivity(callfromcontactsIntent);
		
	}

}
