# Домашка 11
# Бутько Валерия Алексеевна

Проект реализует два сервиса Sender и Receiver для обмена сообщениями через кафка
пс: реализовала, но вообще не уверена, правильно или нет, у меня Sender и Receiver находятся в одном репозитории,
но вроде как так сделать можно

## Что имеется
- **Sender**: REST API для отправки сообщений
- **Receiver**: слушатель Kafka, принимает сообщения
- Сообщения в формате JSON 
- Конфиг Kafka через `application.properties`
- Логирование отправки и получения сообщений

## Как работает код

### Архитектура
1. **SenderApplication**:
    - **MessageController**: эндпоинт `POST /api/message` для отправки текста
    - **MessageSenderService**: формирует `MessageDto` и отправляет в Kafka
    - **KafkaProducerConfig**: настройка кафка

2. **ReceiverApplication**:
    - **MessageListener**: слушает топик Kafka, принимает `MessageDto`
    - **MessageProcessorService**: логирует принятые сообщения
    - **KafkaConsumerConfig**: настройка кафка

3. **KafkaTopicConfig**:
    - Создает топик кафка с одной партицией и репликой

4. **MessageDto**:
    - record с полями `text` и `createdAt`
