package com.crypt.adclock.addeditalarm;

import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.crypt.adclock.R;
import com.crypt.adclock.addeditalarm.dialogs.ringtonepicker.RingtonePickerDialog;
import com.crypt.adclock.addeditalarm.dialogs.ringtonepicker.RingtonePickerPresenter;
import com.crypt.adclock.data.Alarm;
import com.crypt.adclock.data.RepeatType;

/**
 * Created by Ghito on 08-Mar-18.
 */

public class AddEditAlarmPresenter implements
        AddEditAlarmContract.Presenter {
    private Alarm mAlarm;
    private AddEditAlarmContract.View mView;
    private Context mContext;

    private RingtonePickerPresenter mRingtonePickerPresenter;

    AddEditAlarmPresenter(Context context, AddEditAlarmContract.View view) {
        mView = view;
        mContext = context;
        mView.setPresenter(this);
    }

    @Override
    public void saveAlarm() {

    }

    @Override
    public void setHours(int hours) {

    }

    @Override
    public void setMinutes(int minutes) {

    }

    @Override
    public void setRepeatType(RepeatType repeatType) {

    }

    @Override
    public void setRingtone(String ringtone) {

    }

    @Override
    public void setLabel(String label) {
        mView.updateView(mAlarm);
    }

    @Override
    public void setVibrateMode(boolean isVibrateOn) {

    }

    @Override
    public void start() {
        if (mView == null)
            return;

        mView.updateView(mAlarm);
    }

    @Override
    public void editRepeatMode() {
        mView.showRepeatSettingsDialog();
    }

    @Override
    public void pickRingtone() {
        mRingtonePickerPresenter = new RingtonePickerPresenter(
                ((AppCompatActivity) mContext).getSupportFragmentManager(),
                new RingtonePickerDialog.OnRingtoneSelectedListener() {
                    @Override
                    public void onRingtoneSelected(Uri ringtoneUri) {
                    }
                }
        );

        // TODO Implement util for tagging
        mRingtonePickerPresenter.show(getSelectedRingtoneUri(), "test_tag");
    }

    private Uri getSelectedRingtoneUri() {
        Uri selectedRingtoneUri;
        // TODO Uncomment
        // String ringtone = mAlarm.getRingtone();
        String ringtone = "";
        if (ringtone.isEmpty())
            // If ringtone is not specified, we take the default ringtone.
            selectedRingtoneUri =
                    RingtoneManager.getActualDefaultRingtoneUri(mContext,
                            RingtoneManager.TYPE_ALARM);
        else
            selectedRingtoneUri = Uri.parse(ringtone);

        return selectedRingtoneUri;
    }

    @Override
    public void editLabel() {
        // TODO Change hardcoded string to mAlarm.getLabel()
        mView.showLabelInputDialog("kek");
    }

}
