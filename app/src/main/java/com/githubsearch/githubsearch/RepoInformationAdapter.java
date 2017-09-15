package com.githubsearch.githubsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ianarsenault on 9/15/17.
 */

public class RepoInformationAdapter extends ArrayAdapter<RepoInformation> {
    Context context;
    int layoutResourceId;
    ArrayList<RepoInformation> data = null;

    public RepoInformationAdapter(Context context, int layoutResourceId, ArrayList<RepoInformation> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemInformationHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ItemInformationHolder();
            holder.txtName = (TextView) row.findViewById(R.id.tvName);
            holder.txtDescription = (TextView)row.findViewById(R.id.tvDescription);
            holder.txtForkCount = (TextView)row.findViewById(R.id.tvNumberOfForks);
            holder.txtLastUpdate = (TextView)row.findViewById(R.id.tvLastUpdated);
            holder.txtUrl = (TextView)row.findViewById(R.id.tvRepoUrl);
            holder.txtLanguage = (TextView)row.findViewById(R.id.tvLanguage);
            row.setTag(holder);
        }
        else {
            holder = (ItemInformationHolder) row.getTag();
        }

        RepoInformation singleRepo = data.get(position);
        holder.txtName.setText(singleRepo.name);
        holder.txtDescription.setText(singleRepo.description);
        holder.txtForkCount.setText("Forks: " + String.valueOf(singleRepo.forkCount));
        holder.txtLastUpdate.setText(singleRepo.lastUpdated);
        holder.txtUrl.setText(singleRepo.url);
        holder.txtLanguage.setText(singleRepo.language);

        return row;

    }

    static class ItemInformationHolder
    {
        TextView txtName;
        TextView txtDescription;
        TextView txtUrl;
        TextView txtLastUpdate;
        TextView txtForkCount;
        TextView txtLanguage;
    }
}
