package io.github.naotou.remark.View.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import butterknife.InjectView;
import butterknife.Optional;
import io.github.naotou.remark.R;

/**
 * Create by Android Studio
 * User: FuQiang(fuqiang@uniqueway.com)
 * Date: 2015-11-02
 * Time: 17-28
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Optional
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Optional
    @InjectView(R.id.ivLogo)
    ImageView logo;

    private MenuItem menuItem;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initToolBar();
        initViews();
        initEvents();
    }

    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected abstract void initEvents();

    private void initToolBar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        }
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menuItem = menu.findItem(R.id.action_inbox);
        return true;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public ImageView getLogo() {
        return logo;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
}
