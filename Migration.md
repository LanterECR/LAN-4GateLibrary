Инструкция по миграции с версии 0.9.4 на версию 1.0.0 или старше
===========

1. [Описание](#Описание)
2. [Callbacks](#Callbacks)
3. [Сообщения](#Сообщения)
4. [Соединения](#Соединения)
5. [Обработчики сообщений](#Обработчики-сообщений)
6. [Менеджер библиотеки](#Менеджер-библиотеки)


Описание
--------

Необходимы были изменения в связи с неудачным изначальным интерфейсом.
Данный файл содержит инструкции по переходу на новый интерфейс

Callbacks
---------
Колбэки перенесены в отдельный пакет ```org.lanter.lan4gate.Callbacks```
Колбэк IErrorCallback удален в связи с отсутствием применения.
Все его импорты и реализации необходимо удалить.

Замена путей перечислена в таблице

|Исходный путь | Новый путь |
|:--------------:|:------------:|
|```import org.lanter.lan4gate.ICommunicationCallback;```| ```import org.lanter.lan4gate.Callbacks.ICommunicationCallback;``` |
|```import org.lanter.lan4gate.IResponseCallback;```| ```import org.lanter.lan4gate.Callbacks.IResponseCallback;``` |
|```import org.lanter.lan4gate.INotificationCallback;```| ```import org.lanter.lan4gate.Callbacks.INotificationCallback;``` |
|```import org.lanter.lan4gate.IErrorCallback;```|  Удалить все import и реализации|

Соединения
----------

Исходный интерфейс соединений удален. Изменена реализация для TCP сервера.
Метод установки порта через Lan4Gate удален. Необходимо задавать порт, как показано в [загловном файле](README.md) репозитория

Сообщения
---------
Интерфейсы сообщений перенесены в пакет ```org.lanter.lan4gate.Messages```

Замена путей перечислена в таблице

|Исходный путь | Новый путь |
|:--------------:|:------------:|
|```import org.lanter.lan4gate.IRequest;```| ```import org.lanter.lan4gate.Messages.Request.IRequest;``` |
|```import org.lanter.lan4gate.IResponse;```| ```import org.lanter.lan4gate.Messages.Response.IResponse;``` |
|```import org.lanter.lan4gate.INotification;```| ```import org.lanter.lan4gate.Messages.Notification.INotification;``` |
|```import org.lanter.lan4gate.IInteraction;```| ```import org.lanter.lan4gate.Messages.Notification.IInteraction;``` |

Обработчики сообщений
---------------------
Обработчики сообщений выделены в пакет MessageProcessor. Возможно использовать вне менеджера ILan4Gate

Менеджер библиотеки
-------------------

- Менеджер библиотеки перенесен в пакет Implementation.
- Добавлен интерфейс ILan4Gate с аналогичным интерфейсом и фабрика для него

Данный код должен быть заменен на код из следующего блока
```Java
import org.lanter.lan4gate.Lan4Gate;

//...........

int ecrNumber = 1;
Lan4Gate gate = new Lan4Gate(ecrNumber);
gate.setPort(20501);
gate.start();
```

```Java
import org.lanter.lan4gate.Lan4GateFactory;
import org.lanter.lan4gate.ILan4Gate;
import org.lanter.lan4gate.CommunicationFactory();

//...................

int ecrNumber = 1;
ICommunication communication = CommunicationFactory.getSingleTCPServer(20501);

ILan4Gate gate = Lan4GateFactory.getLan4Gate(ecrNumber, communication);
gate.start(); 


```
