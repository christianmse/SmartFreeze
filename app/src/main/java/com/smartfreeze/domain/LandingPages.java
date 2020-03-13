package com.smartfreeze.domain;


import com.smartfreeze.R;

public enum LandingPages {


    FIRST(R.string.bienvenido, R.string.first_title, R.layout.page_on_boarding, R.drawable.ic_ajustes),
    SECOND(R.string.consulta, R.string.second_title, R.layout.page_on_boarding2, R.drawable.ic_ajustes),
    THIRST(R.string.accede, R.string.thirst_title, R.layout.page_on_boarding3, R.drawable.ic_ajustes),
    FOUR(R.string.concoce, R.string.four_title, R.layout.page_on_boarding4, R.drawable.ic_ajustes),
    FIVE(R.string.acreditate, R.string.five_title, R.layout.page_on_boarding5, R.drawable.ic_ajustes);

    private int mTitleResId;
    private int mBodyResId;
    private int mLayoutResId;
    private int mIvResId;

    LandingPages(int titleResId, int bodyResId, int layoutResId, int ivResId) {
        mTitleResId = titleResId;
        mBodyResId = bodyResId;
        mLayoutResId = layoutResId;
        mIvResId = ivResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() { return mLayoutResId; }

    public int getmBodyResId() {
        return mBodyResId;
    }

    public int getmIvResId() {
        return mIvResId;
    }
}
