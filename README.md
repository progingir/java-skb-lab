# Домашка 5
# Бутько Валерия Алексеевна

Проект был расширен из ветки 3-di для демонстрации базовой работы сервисов и валидации данных

## Что сделано

- **Сервисы**:
    - `EmailService` и `SMSService` — реализуют интерфейс `MessageService` с логами создания и уничтожения
    - `MessageProcessor` — обрабатывает сообщения от сервисов
- **Валидация**:
    - `@ValidPhoneNumber` — кастомная аннотация для проверки номера телефона (формат `+7XXXXXXXXXX`)
    - `@ComplexMessageValidation` — составная аннотация (`@NotBlank`, `@Size`, `@ValidPhoneNumber`)
    - `MessageController` — REST-endpoint `/api/message` с валидацией и красивым выводом ошибок в JSON
- **Конфигурация**:
    - `AppConfig` — настройка бинов `EmailService` и `SMSService`

## Что происходит

- При запуске `MessageProcessor` выводит сообщения от `EmailService` и `SMSService`
- `POST /api/message` принимает JSON с полем `message`, валидирует его и возвращает результат или ошибки
