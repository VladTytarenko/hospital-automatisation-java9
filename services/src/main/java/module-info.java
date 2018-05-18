module services {

    requires entities;
    requires dao;
    requires spring.context;
    requires spring.beans;

    exports com.tytarenko.services.interfaces;

}