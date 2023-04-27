package exercise.controllers;

import io.javalin.core.validation.JavalinValidation;
import io.javalin.core.validation.ValidationError;
import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;
import io.ebean.DB;
import java.util.List;
import java.util.Map;

import exercise.domain.User;
import exercise.domain.query.QUser;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

public class UserController implements CrudHandler {

    public void getAll(Context ctx) {
        // BEGIN
        List<User> users = new QUser().orderBy().id.asc().findList();
        String usersJson = DB.json().toJson(users);

        ctx.json(usersJson);
        // END
    };

    public void getOne(Context ctx, String id) {

        // BEGIN
        User user = new QUser().id.equalTo(Integer.parseInt(id)).findOne();
        String userJson = DB.json().toJson(user);

        ctx.json(userJson);
        // END
    };

    public void create(Context ctx) {

        // BEGIN
        User newUser = ctx
                .bodyValidator(User.class)
                .check(it -> StringUtils.isNumeric(it.getPassword()), "password должен содержать только цифры")
                .get();

        newUser.save();
        // END
    };

    public void update(Context ctx, String id) {
        // BEGIN
        String body = ctx.body();
        User inputUser = DB.json().toBean(User.class, body);

        new QUser().id.equalTo(Integer.parseInt(id)).asUpdate()
                .set("firstName", inputUser.getFirstName())
                .set("lastName", inputUser.getLastName())
                .set("email", inputUser.getEmail())
                .set("password", inputUser.getPassword())
                .update();
        // END
    };

    public void delete(Context ctx, String id) {
        // BEGIN
        new QUser().id.equalTo(Integer.parseInt(id)).delete();
        // END
    };
}
