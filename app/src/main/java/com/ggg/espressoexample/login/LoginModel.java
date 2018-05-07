package com.ggg.espressoexample.login;

/**
 * Created by ajea on 07/05/18.
 */

public class LoginModel implements Login.Model {

    private Login.Presenter presenter;

    public LoginModel(Login.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void validaUser(String userName) {
        if (userName.length() > 0){
            if (userName.equalsIgnoreCase("test@ggg.com")){
                presenter.usuarioValido();
            }else {
                presenter.error();
            }
        }else {
            presenter.usuarioVacio();
        }
    }
}
