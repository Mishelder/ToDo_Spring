package com.miaskor.todo_spring.filter;

import com.miaskor.todo_spring.model.Client;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static com.miaskor.todo_spring.util.URLs.getAllFeasibleURL;
import static com.miaskor.todo_spring.util.URLs.getAllPublicURL;

@Component
public class MainFilter extends HttpFilter {

    private static final Set<String> PUBLIC_PAGES = getAllPublicURL();
    private static final Set<String> ALL_FEASIBLE_PAGES = getAllFeasibleURL();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        /*req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        res.setCharacterEncoding(StandardCharsets.UTF_8.name());
        var client = (Client) req.getSession().getAttribute("client");
        var cookies = req.getCookies();
        var uri = req.getRequestURI();

        if (PUBLIC_PAGES.stream().anyMatch(uri::startsWith)) {
            chain.doFilter(req, res);
        }else if(cookies!=null && loggedIn(client, findCookieLoggedIn(cookies))
                &&ALL_FEASIBLE_PAGES.stream().anyMatch(uri::startsWith)){
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(req.getHeader("referer") == null
                    ? LOGIN :req.getHeader("referer"));
        }*/
        chain.doFilter(req,res);
    }

    private boolean findCookieLoggedIn(Cookie[] cookies) {
        Optional<Cookie> loggedInCookie = Arrays.stream(cookies)
                .filter((cookie -> cookie.getName().equals("loggedIn")))
                .findFirst();
        return loggedInCookie.map(cookie -> cookie.getValue().equals("true")).orElse(false);
    }

    private boolean loggedIn(Client client, boolean cookieLoggedIn) {
        return Objects.nonNull(client)
                && cookieLoggedIn;
    }
}
