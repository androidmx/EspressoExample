package com.ggg.espressoexample.login;

/**
 * Created by ajea on 07/05/18.
 */

public interface Login {

    interface View {
        void usuarioValido();
        void error();
        void usuarioVacio();
        String getUserName();
    }

    interface Presenter {
        void validaUser(String userName);
        void usuarioValido();
        void usuarioVacio();
        void error();
    }

    interface Model{
        void validaUser(String userName);
    }
}
