package com.servlets;

import com.loginsession.EntityLoginSessionManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletRedirectToPokemons", urlPatterns = "/redirect_to_pokemons_list")
public class ServletRedirectToPokemons extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher view = request.getRequestDispatcher("pokemons_list.jsp");
        view.forward(request, response);
//
//        if (EntityLoginSessionManager.getIsLogged().equalsIgnoreCase("No")) {
//            RequestDispatcher view = request.getRequestDispatcher("pokemons_list.jsp");
//            view.forward(request, response);
//        } else {
//
//            RequestDispatcher view = request.getRequestDispatcher("pokemons_list.jsp");
//            view.forward(request, response);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
