package com.example.interceptor2.interceptors;

import com.example.interceptor2.entities.Month;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public static List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1,"January", "Gennaio", "Januar"),
            new Month(2,"February", "Febbraio", "Februar"),
            new Month(3,"March", "Marzo", "Marz"),
            new Month(4,"April", "Aprile", "April"),
            new Month(5,"May", "Maggio", "Mai"),
            new Month(6,"July", "Giugno", "Juni")
    ));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberString = request.getHeader("monthNumber");
        if (monthNumberString == null) {
            response.sendError(HttpStatus.BAD_REQUEST.value(),"bad request put in header monthNumber -> value from 1 to 6");
            return true;
        }
        int monthNumber = Integer.parseInt(monthNumberString);
        Optional<Month> month = months.stream().filter(singlemonth -> {
            return singlemonth.getMonthNumber() == monthNumber;
        }).findFirst();
        if (month.isPresent()) {
            request.setAttribute("month", month.get());
        }
        if (!month.isPresent()) {
            Month monthEmpty = new Month(0, "nope", "nope", "nope");
            request.setAttribute("month", monthEmpty);
        } else {
            response.setStatus(200);
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,@Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,@Nullable Exception ex) throws Exception {

    }

}
