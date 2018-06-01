package com.ardenolgundemir.template.root;



import com.ardenolgundemir.template.controller.BaseActivity;

import dagger.Component;

/**
 * Created by ardenolgundemir on 01/06/2017.
 */
@ScopeContext
@Component(modules ={ApiModule.class}, dependencies = App.IMAppComponent.class)
public interface ApplicationComponent {
    void inject(BaseActivity splashActivity);
}
