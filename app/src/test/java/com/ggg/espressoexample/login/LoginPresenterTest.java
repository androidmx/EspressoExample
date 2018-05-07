package com.ggg.espressoexample.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ajea on 07/05/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private Login.View view;
    @Mock
    private Login.Model model;

    private Login.Presenter presenter;

    @Before
    public void setUp(){
        presenter = new LoginPresenter(view);
    }

    @Test
    public void showErrorMessageWhenWrongUser() throws Exception{
        when(view.getUserName()).thenReturn("gigigo");
        presenter.validaUser(view.getUserName());
        verify(view).error();
    }

    @Test
    public void showErrorMessageWhenEmptyUser() throws Exception{
        when(view.getUserName()).thenReturn("");
        presenter.validaUser(view.getUserName());
        verify(view).usuarioVacio();
    }

    @Test
    public void showErrorMessageWhenValidUser() throws Exception{
        when(view.getUserName()).thenReturn("test@ggg.com");
        presenter.validaUser(view.getUserName());
        verify(view).usuarioValido();
    }
}