package exercise.controllers;

import io.javalin.http.Handler;
import java.util.List;
import java.util.Map;
import io.javalin.core.validation.Validator;
import io.javalin.core.validation.ValidationError;
import io.javalin.core.validation.JavalinValidation;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

import exercise.domain.User;
import exercise.domain.query.QUser;

public final class UserController {

    public static Handler listUsers = ctx -> {

        List<User> users = new QUser()
            .orderBy()
                .id.asc()
            .findList();

        ctx.attribute("users", users);
        ctx.render("users/index.html");
    };

    public static Handler showUser = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        User user = new QUser()
            .id.equalTo(id)
            .findOne();

        ctx.attribute("user", user);
        ctx.render("users/show.html");
    };

    public static Handler newUser = ctx -> {

        ctx.attribute("errors", Map.of());
        ctx.attribute("user", Map.of());
        ctx.render("users/new.html");
    };

    public static Handler createUser = ctx -> {
        // BEGIN
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        Validator<String> firstNameValidator = ctx.formParamAsClass("firstName", String.class)
                .check(it -> !it.isEmpty(), "firstName не должно быть пустым");

        Validator<String> lastNameValidator = ctx.formParamAsClass("lastName", String.class)
                .check(it -> !it.isEmpty(), "lastName не должно быть пустым");

        EmailValidator emailValidatorInstance = EmailValidator.getInstance();
        Validator<String> emailValidator = ctx.formParamAsClass("email", String.class)
                .check(it -> emailValidatorInstance.isValid(email), "строка email должна быть валидным email");

        Validator<String> passwordValidator = ctx.formParamAsClass("password", String.class)
                .check(it -> StringUtils.isNumeric(it), "password должен содержать только цифры")
                .check(it -> it.length() >= 4, "password должен быть не короче 4 символов");

        Map<String, List<ValidationError<? extends Object>>> errors = JavalinValidation.collectErrors(
                firstNameValidator,
                lastNameValidator,
                emailValidator,
                passwordValidator);

        if (!errors.isEmpty()) {
            ctx.status(422);
            User invalidUser = new User(firstName, lastName, email, password);
            ctx.attribute("errors", errors);
            ctx.attribute("user", invalidUser);
            ctx.render("users/new.html");
            return;
        }

        User newUser = new User(firstName, lastName, email, password);
        newUser.save();

        ctx.sessionAttribute("flash", "Пользователь успешно создан!");
        ctx.redirect("/users");
        // END
    };
}
