Реализация кассового протокола LAN-4Gate
===========================================

[![badge](https://img.shields.io/badge/document-javadoc-blue)](https://LanterECR.github.io/LAN-4GateLibrary/javadoc/index.html)

[![Release](https://img.shields.io/badge/release-v1.1.0-blue.svg?style=flat)](https://github.com/LanterECR/LAN-4GateLibrary/releases/tag/v1.1.0)

## !!!ВНИМАНИЕ: Текущая версия библиотеки несовместима с версией 0.9.4 и ниже!!!
### Для миграции прочтите [файл](Migration.md)


Содержание
----------
1. [Описание](#Описание)
2. [Требования](#Требования)
3. [Зависимости](#Зависимости)
4. [Подключение к проекту](#Подключение-к-проекту)
5. [Использование](#Использование)

Описание
--------
Библиотека реализует протокол кассового взаимодействия LAN-4Gate компании ЛАНТЕР.

Подробная документация сгенерирована [Javadoc](https://docs.oracle.com/javase/8/docs/technotes/guides/javadoc/index.html). Доступна по [ссылке](https://LanterECR.github.io/LAN-4GateLibrary/javadoc/index.html) и в шапке файла

**Библиотека находится в процессе миграции на Android SDK**


Требования
----------

- Java 1.8
- Gradle 6.1.1

Зависимости
-----------

- [JSON-java](https://github.com/stleary/JSON-java).


Подключение к проекту
---------------------

#### Для подключения библиотеки необходимо:
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
    implementation 'com.github.LanterECR:LAN-4GateLibrary:v1.1.0'
}
```

Использование
-------------
Ниже приведены фрагменты кода в качестве примера.

1. Реализовать интерфейсы колбэков:
- ICommunicationCallback
```java
import org.lanter.lan4gate.Callbacks.ICommunicationCallback;

class CommunicationCallback implements ICommunicationCallback {
    public void communicationStarted(ILan4Gate initiator) {
        //Реакция на событие запуска соединения
    }

    public void communicationStopped(ILan4Gate initiator) {
        //Реакция на событие остановки соединения
    }

    public void connected(ILan4Gate initiator) {
        //Реакция на подключение к терминалу
    }

    public void disconnected(ILan4Gate initiator) {
        //Реакция на отключение от терминала
    }
} 
```

- IResponseCallback
```java
import org.lanter.lan4gate.Callbacks.IResponseCallback;

class ResponseCallback implements IResponseCallback {
    public void newResponseMessage(IResponse response, ILan4Gate initiator) {
        //Реакция на получение ответа от терминала
    }
} 
```

- INotificationCallback
```java
import org.lanter.lan4gate.Callbacks.INotificationCallback;

class NotificationCallback implements INotificationCallback {
    public void newNotificationMessage(INotification notification, ILan4Gate initiator) {
        //Реакция на получение уведомления
    }
} 
```

2. Создать соединение
- TCP сервер, обслуживающий одно соединение по заданному порту 20500.
  Без указания параметра, будет использован порт по умолчанию - 20501.
  Порт взаимодействия согласуется при интеграции. Необходима возможность задавать вручную.
```java
import org.lanter.lan4gate.Communication.CommunicationFactory;
import org.lanter.lan4gate.Communication.ICommunication;

ICommunication communication = CommunicationFactory.getSingleTCPServer(20500);
```

- TCP клиент на с портом и адресом по умолчанию.
  Без указания параметров, будет использован порт и адрес по умолчанию - 127.0.0.1:20501.
  Порт и адрес взаимодействия согласуется при интеграции. Необходима возможность задавать вручную.
```java
import org.lanter.lan4gate.Communication.CommunicationFactory;
import org.lanter.lan4gate.Communication.ICommunication;

ICommunication communication = CommunicationFactory.getTCPClient();
```

- Декоратор, обслуживающий TCP сервер предыдущего пункта.
  Используется для определения длины сообщений. Использование данного параметра согласуется при интеграции
```java
import org.lanter.lan4gate.Communication.CommunicationFactory;
import org.lanter.lan4gate.Communication.ICommunication;

ICommunication control = CommunicationFactory.getSizeControlDecorator(communication);

```

3. Создать менеджер библиотеки ILan4Gate
```java
import org.lanter.lan4gate.Lan4GateFactory;
import org.lanter.lan4gate.ILan4Gate;

int ecrNumber = 1;

ILan4Gate gate = Lan4GateFactory.getLan4Gate(ecrNumber, control);
```

4. Привязать колбэки к менеджеру
```java
gate.addCommunicationCallback(new CommunicationCallback());
gate.addResponseCallback(new ResponseCallback());
gate.addNotificationCallback(new NotificationCallback());
```
5. Запустить менеджер
```java
gate.start();
```
5. Остановить менеджер.
```java
gate.stop();
gate = null;
```
