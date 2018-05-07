package com.ggg.espressoexample.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by ajea on 07/05/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginModelTest {

    @Mock
    private Login.Presenter presenter;

    private LoginModel model;

    @Before
    public void setUp() throws Exception{
        model = new LoginModel(presenter);
    }

    @Test
    public void succesWithValidUser() throws Exception{
        model.validaUser("test@ggg.com");
        //Se verifica si es llamado el método
        verify(presenter).usuarioValido();
    }

    @Test
    public void notSuccessWithUser() throws Exception{
        model.validaUser("notValidUser@ggg.com");
        verify(presenter).error();
    }
}