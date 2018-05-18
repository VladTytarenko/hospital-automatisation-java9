module dao {

    requires entities;
    requires spring.context;
    requires spring.beans;
    requires spring.jdbc;
    requires java.sql;

    exports com.tytarenko.dao.interfaces;

}