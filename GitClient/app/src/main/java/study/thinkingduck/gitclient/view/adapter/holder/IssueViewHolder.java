package study.thinkingduck.gitclient.view.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

import butterknife.BindView;
import butterknife.ButterKnife;
import study.thinkingduck.gitclient.R;
import study.thinkingduck.gitclient.view.model.IssueViewModel;

/**
 * 이슈 목록
 * Created by thinkingduck on 2017. 3. 5..
 */
public class IssueViewHolder extends RecyclerView.ViewHolder {

    public final static int ID = R.layout.view_item_issue;

    @BindView(R.id.img_profile)
    private ImageView mImgProfile;

    @BindView(R.id.tv_title)
    private TextView mTvTitle;

    @BindView(R.id.tv_desc)
    private TextView mTvDesc;


    public IssueViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(IssueViewModel model) {

        Glide.with(itemView.getContext())
                .load(model.userProfileUrl)
                .fitCenter()
                .crossFade()
                .into(mImgProfile);

        mTvTitle.setText(model.title);

        StringBuilder builder = new StringBuilder();
        builder.append("#").append(model.number).append(" opened on ");
        builder.append(model.date).append(" by ");
        builder.append(model.userId).append(" comments ");
        builder.append(model.comments);

        mTvDesc.setText(builder.toString());

    }

}
