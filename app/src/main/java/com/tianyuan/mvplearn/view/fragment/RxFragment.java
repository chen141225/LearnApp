package com.tianyuan.mvplearn.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianyuan.mvplearn.R;
import com.tianyuan.mvplearn.model.EasyEvent;
import com.tianyuan.mvplearn.presenter.fragment.FragRxPresenter;
import com.tianyuan.mvplearn.view.fragment.interfaces.IFragRxView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by YouCii on 2016/12/17.
 */

public class RxFragment extends Fragment implements IFragRxView {

    @Bind(R.id.rx_text)
    TextView rxText;

    FragRxPresenter fragRxPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rx, container, false);
        ButterKnife.bind(this, view);

        fragRxPresenter = new FragRxPresenter(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        EasyEvent[] events = new EasyEvent[]{new EasyEvent(), new EasyEvent()};
        fragRxPresenter.rxTest(events);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void setText(String string) {
        rxText.setText(string);
    }

    @Override
    public String getText() {
        return rxText.getText().toString();
    }

    @Override
    public void addText(String string) {
        rxText.append(string);
    }
}
