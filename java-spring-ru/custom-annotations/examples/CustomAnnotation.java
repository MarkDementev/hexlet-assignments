// Аннотация задаётся описанием соответствующего интерфейса с ключевым словом @interface
// Саму аннотацию можно пометить несколькими аннотациями

// Аннотация @Target указывает, что именно можно пометить этой аннотацией.
// Аннотация @Retention указывает жизненный цикл аннотации.
// RUNTIME указывает, что она будет видна и в процессе выполнения кода.
// Это нужно для того, чтобы мы могли в процессе выполнения обращаться к классу через рефлексию.



@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// Чтобы аннотация принимала аргумент, в интерфейсе нужно определить метод с именем параметра
// Вызов этого метода вернёт значение параметра, переданного в аннотацию
public @interface CustomAnnotation {
    String value() default "debug";
}
