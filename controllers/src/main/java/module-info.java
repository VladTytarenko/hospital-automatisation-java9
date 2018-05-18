module controllers {

    requires entities;
    requires services;
    requires spring.web;
    requires spring.context;
    requires spring.beans;
    requires spring.webmvc;
    requires java.sql;
    requires spring.boot;
    requires spring.boot.autoconfigure;

    exports com.tytarenko.controllers;
}