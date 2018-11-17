package com.servlets;

import com.loginsession.EntityLoginSessionManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLogoutFromPokemons" , urlPatterns = "/logout_from_pokemon")
public class ServletLogoutFromPokemons extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityLoginSessionManager.deleteLoggedUserAndData();
        EntityLoginSessionManager.addFirstUserCredentials();

        RequestDispatcher view = request.getRequestDispatcher("pokemons_list.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
