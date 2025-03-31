# Домашка 5
# Бутько Валерия Алексеевна

Проект был расширен из ветки 3-di
В нем есть работа с профилями, условными бинами и валидацией данных

## Исходная версия из 3-di

Код включал следующее:

- Главный класс `DemoApplication` с запуском приложения и закрытием контекста через `context.close()`
- Класс `AppConfig` с двумя бинами: `EmailService` и `SMSService`
- Интерфейс `MessageService` с методом `getMessage()`
- Классы `EmailService` и `SMSService`, реализующие интерфейс, с логами создания и уничтожения через `@PostConstruct` и `@PreDestroy`
- Класс `MessageProcessor` для обработки сообщений от сервисов с внедрением зависимостей через конструктор
- Минимальный набор для работы Spring Boot и логирования через Lombok

## Что изменилось и добавилось

Вот ключевые изменения:

### 1. Условные бины
- Новый класс `ConditionalConfig` с тремя бинами:
    - `TestProfileBean` — создается только в профиле `test` (аннотация `@Profile("test")`)
    - `DependentBean` — создается только в профиле `test` и зависит от `TestProfileBean` (использует `@DependsOn` и `@Profile("test")`)
    - `EnvironmentBean` — создается, если свойство `example.test` не равно `default` (через `@Value("${example.test:default}")`)

### 2. Валидация
- Добавлен пакет `com.example.demo.validation`:
    - Кастомная аннотация `@ValidRussianName` с валидатором `RussianNameValidator` для проверки русских имен (заглавная буква и только русские символы)
    - Составная аннотация `@ComplexNameValidation`, объединяющая `@NotBlank`, `@Size` и `@ValidRussianName`
- Новый DTO-класс `UserInput` с полем `name`, валидируемым через `@ComplexNameValidation`
- Добавлен `ValidationController` с REST-endpoint'ом `/api/validate` для проверки валидации и обработки ошибок с красивым JSON-ответом

### 3. Зависимости
- Обновлен `build.gradle` для поддержки новых функций:
    - Добавлен `spring-boot-starter-validation` для валидации
    - Добавлен Lombok как `implementation` и `annotationProcessor`