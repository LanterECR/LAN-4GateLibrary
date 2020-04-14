###  Библиотека, реализующая протокол кассового взаимодействия LAN-4Gate компании "ЛАНТЕР"

#### Для получения более подробной информации сгенерируйте Javadoc для данного проекта

####Для подключения библиотеки необходимо:
1.  добавить в репозитории репозиторий jitpack
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
2. Добавить библиотеку в зависимости проекта.
```gradle
dependencies {
    implementation 'com.github.LanterECR:LAN-4GateLibrary:tag'
}
```
Список тегов можно посмотреть в списке Branch -> Tags на главной странице репозитория. Необходимо использовать последний доступный тег

#### Пример взаимодействия с библиотекой:
1. Реализовать интерфейс ```IResponseCallback```
```java
class ResponseListener implements IResponseCallback {
    @Override
    public void newResponseMessage(IResponse response) {
        for (ResponseFieldsList field : response.getCurrentFieldsList()) {
            // Код для обработки каждого поля
        }
    }
}
```
2. Реализовать интерфейс ```ICommunicationCallback```
```java
class CommunicationListener implements ICommunicationCallback {
    @Override
    public void communicationStarted() {
        //код для обработки запуска соединения
    }

    @Override
    public void communicationStopped() {
        //код для обработки остановки соединения
    }

    @Override
    public void connected() {
        //Код для обработки подключения. После данного события можно отправлять запросы
    }

    @Override
    public void disconnected() {
        // код для обработки отключения
    }
}
```
3. Настроить и запустить обертку протокола:
```java
    //Создание слушателя для ответов терминала
    ResponseListener responseListener = new ResponseListener();
    //Создание слушателя для состояния сетевого взаимодействия
    CommunicationListener communicationListener = new CommunicationListener();
        
    int ecrNumber = 1;
    Lan4Gate gate = new Lan4Gate(ecrNumber);
    //Добавление обратных вызовов в список слушателей
    gate.addResponseCallback(responseListener);
    gate.addCommunicationCallback(communicationListener);
    //Установка порта взаимодействия
    gate.setPort(20501);
    //Запуск взаимодействия.
    gate.start();
```
##### Замечание: Метод start не блокирующий. Предполагается использование в цикле приложения.
##### Замечание: Для отправки уведомления генерируется новый поток. Желательно, чтобы получатели уведомлений не блокировали дальнейшее выполнение кода.
