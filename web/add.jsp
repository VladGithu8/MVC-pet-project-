<%@ page import="org.json.simple.JSONArray" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    JSONArray list = new JSONArray();

    String firstNameInput = request.getParameter("FirstNameInput");
    String lastNameInput = request.getParameter("LastNameInput");
    String ageInput = request.getParameter("AgeInput");
    String phoneInput = request.getParameter("PhoneInput");
    String emailInput = request.getParameter("EmailInput");


    list.add(firstNameInput);
    list.add(lastNameInput);
    list.add(ageInput);
    list.add(phoneInput);
    list.add(emailInput);

    System.out.println(list);


%>
