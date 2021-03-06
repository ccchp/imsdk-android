package com.qunar.im.ui.view.recentView;

import android.content.Context;
import android.view.View;

import com.qunar.im.base.module.RecentConversation;
import com.qunar.im.base.util.ProfileUtils;
import com.qunar.im.utils.QtalkStringUtils;


/**
 * Created by xinbo.wang on 2016-12-05.
 */
public class DefaultRender implements IRecentRender {
    @Override
    public void render(CommonHolderView holder, RecentConversation data, Context context) {
        holder.mLastMsgTextView.setText(data.getLastMsg());
        ProfileUtils.displayGravatarByUserId(data.getId(), holder.mImageView);
        if (data.isChan().indexOf("send") != -1) {
            ProfileUtils.loadNickName(QtalkStringUtils.parseBareJid(data.getId()),
                    holder.mNameTextView,
                    true );
            holder.mConsultImageView.setVisibility(View.GONE);
        }
    }
}
