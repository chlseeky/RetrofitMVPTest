package com.study.lyds.retrofitmvptest;

import android.os.Bundle;
import android.widget.TextView;

import com.study.lyds.retrofitmvptest.base.BaseMvpActivity;
import com.study.lyds.retrofitmvptest.model.ArticleReq;
import com.study.lyds.retrofitmvptest.model.ArticleRsp;
import com.study.lyds.retrofitmvptest.persenter.MainPresenter;
import com.study.lyds.retrofitmvptest.view.MainView;

public class MainActivity extends BaseMvpActivity<MainView,MainPresenter> implements MainView{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =  findViewById(R.id.text);

        ArticleReq articleReq = new ArticleReq();
        articleReq.setCategoryId(1);
        articleReq.setPage(1);
        articleReq.setRows(10);
        articleReq.setCategoryId(1);
        presenter.getArticleList(articleReq);
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void getArticleSuccess(ArticleRsp articleRsp) {
        textView.setText(articleRsp.getResult().toString());
    }

    @Override
    public void onFinish() {

    }

}
