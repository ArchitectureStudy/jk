package study.thinkingduck.gitclient.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import study.thinkingduck.gitclient.view.adapter.holder.IssueViewHolder;
import study.thinkingduck.gitclient.view.model.IssueViewModel;

/**
 * 이슈 목록 어뎁터
 * Created by thinkingduck on 2017. 3. 5..
 */
public class IssueListAdapter extends RecyclerView.Adapter<IssueViewHolder> {

    private ArrayList<IssueViewModel> mDatas;

    public IssueListAdapter() {
        this.mDatas = new ArrayList<>();
    }

    public void addDatas(List<IssueViewModel> datas) {

//        for (IssueViewModel data : datas) {
//            mDatas.add(data);
//        }

        mDatas.addAll(datas);
        notifyDataSetChanged();
    }


    @Override
    public IssueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(IssueViewHolder.ID, parent);
        return new IssueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IssueViewHolder holder, int position) {
        holder.setData(mDatas.get(position));

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

}
