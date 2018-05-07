package com.ggg.espressoexample.login;

/**
 * Created by ajea on 07/05/18.
 */

public class LoginPresenter implements Login.Presenter{

    private Login.View view;
    private Login.Model model;

    public LoginPresenter(Login.View view) {
        this.view = view;
        this.model = new LoginModel(this);
    }

    @Override
    public void validaUser(String userName) {
        if (view != null)
            model.validaUser(userName);
    }

    @Override
    public void usuarioValido() {
        if (view != null)
            view.usuarioValido();
    }

    @Override
    public void usuarioVacio() {
        if (view != null)
            view.usuarioVacio();
    }

    @Override
    public void error() {
        if (view != null)
            view.error();
    }
}
